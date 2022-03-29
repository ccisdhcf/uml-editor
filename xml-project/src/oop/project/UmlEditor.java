package oop.project;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import layout.ButtonBase;
import oop.project.SharedObject.buttonModeEnum;
import oop.project.object.ClassObject;
import oop.project.object.UseCaseObject;
import oop.project.object.line.AssociationLine;
import oop.project.object.line.CompositionLine;
import oop.project.object.line.GeneralizationLine;
import oop.project.object.listener.LineListener;
import oop.project.object.listener.ObjectListener;
import oop.project.object.listener.SelectListener;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLayeredPane;

public class UmlEditor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UmlEditor window = new UmlEditor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UmlEditor() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SharedObject.init();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(6, 0, 0, 0));


		ButtonBase selectButton = new ButtonBase("select", SharedObject.buttonModeEnum.selectMode);
		panel.add(selectButton);

		
		ButtonBase associationLineButton = new ButtonBase("association line", SharedObject.buttonModeEnum.associationLineMode);
		panel.add(associationLineButton);
		
		ButtonBase generalizationLineButton = new ButtonBase("generalization line", SharedObject.buttonModeEnum.generalizationLineMode);
		panel.add(generalizationLineButton);
		
		ButtonBase compositionLineButton = new ButtonBase("composition line", SharedObject.buttonModeEnum.compositionLineMode);
		panel.add(compositionLineButton);
		
		ButtonBase classButton = new ButtonBase("class", SharedObject.buttonModeEnum.classMode);
		panel.add(classButton);
		
		ButtonBase useCaseButton = new ButtonBase("use case", SharedObject.buttonModeEnum.useCaseMode);
		panel.add(useCaseButton);
		

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu fileButton = new JMenu("file");
		menuBar.add(fileButton);

		JMenu editButton = new JMenu("edit");
		menuBar.add(editButton);

		JMenuItem groupButton = new JMenuItem("group");
		editButton.add(groupButton);

		JMenuItem ungroupButton = new JMenuItem("ungroup");
		editButton.add(ungroupButton);

		JMenuItem changeNameButton = new JMenuItem("change name");
		editButton.add(changeNameButton);

	

		DrawPanel layeredPane = new DrawPanel();
		
		
//		UseCaseObject test=new UseCaseObject(50, 52, 70,50, true, "sadawd");
//		SharedObject.shapes.add(test);
//		ClassObject test2=new ClassObject(400, 400, 70, 70, false, "asdasdac");
//		SharedObject.shapes.add(test2);
//		CompositionLine test3 = new CompositionLine(50, 50, 500, 500, true, SharedObject.lineModeEnum.associationLine);
//		SharedObject.lines.add(test3);
//		test.setBackground(Color.BLACK);
//		layeredPane.add(test);
//		layeredPane.add(test2);
//		SharedObject.shapes.add(test2);
//		test2.setBackground(Color.BLACK);
//		layeredPane.add(test2);
//		SharedObject.lines.add(test3);

		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		SharedObject.buttomList.add(selectButton);
		SharedObject.buttomList.add(associationLineButton);
		SharedObject.buttomList.add(generalizationLineButton);
		SharedObject.buttomList.add(compositionLineButton);
		SharedObject.buttomList.add(classButton);
		SharedObject.buttomList.add(useCaseButton);
		for (JButton buttonSelected : SharedObject.buttomList) {
			buttonSelected.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					SharedObject.resetSelected();
					// TODO Auto-generated method stub
					for (JButton jbutton : SharedObject.buttomList) {
						jbutton.setBackground(Color.lightGray);
						jbutton.setForeground(Color.black);
					}
					buttonSelected.setBackground(Color.black);
					buttonSelected.setForeground(Color.white);
					SharedObject.buttonMode = buttonModeEnum.values()[SharedObject.buttomList
							.indexOf(buttonSelected)];
					// debug
					System.out.println(SharedObject.buttonMode.name());
				}
			});

		}
		layeredPane.addMouseListener(new ObjectListener());
		layeredPane.addMouseListener(new LineListener());
		SelectListener SL=new SelectListener();
		layeredPane.addMouseListener( SL);
		layeredPane.addMouseMotionListener(SL);
		
		
		
		SharedObject.setFrameJPanel(panel);
		SharedObject.setDrawPanel(layeredPane);

	}

}
