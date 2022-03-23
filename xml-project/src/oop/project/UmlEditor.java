package oop.project;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.project.SharedObject.buttonModeEnum;
import oop.project.object.ClassObject;
import oop.project.object.UseCaseObject;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
		
		JButton selectButton = new JButton("select");
		panel.add(selectButton);
		
		
		JButton associationLineButton = new JButton("association line");
		panel.add(associationLineButton);
		
		JButton generalizationLineButton = new JButton("generalization line ");
		panel.add(generalizationLineButton);
		
		JButton compositionLineButton = new JButton("composition line");
		panel.add(compositionLineButton);
		
		JButton classButton = new JButton("class");
		panel.add(classButton);
		
		JButton useCaseButton = new JButton("use case");
		panel.add(useCaseButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileButton = new JMenu("file");
		menuBar.add(fileButton);
		
		JMenu editButton = new JMenu("edit");
		menuBar.add(editButton);
		
		JMenuItem groupButton = new JMenuItem("group");
		editButton.add(groupButton);
		
		JCheckBoxMenuItem ungroupButton = new JCheckBoxMenuItem("ungroup");
		editButton.add(ungroupButton);
		
		JMenuItem changeNameButton = new JMenuItem("change name");
		editButton.add(changeNameButton);
		
		SharedObject.buttomList.add(selectButton);
		SharedObject.buttomList.add(associationLineButton);
		SharedObject.buttomList.add(generalizationLineButton);
		SharedObject.buttomList.add(compositionLineButton);
		SharedObject.buttomList.add(classButton);
		SharedObject.buttomList.add(useCaseButton);
		
		DrawPanel layeredPane = new DrawPanel();
		UseCaseObject test=new UseCaseObject(50, 52, 500,300, true, null);
		System.out.println(test.getSelectedStatic());
		//test.setBackground(Color.BLACK);
//		layeredPane.add(test);
		SharedObject.shapes.add(test);
		ClassObject test2=new ClassObject(400, 400, 500, 500, true, null);
		System.out.println(test2.getSelectedStatic());
		//layeredPane.add(test2);
		//SharedObject.shapes.add(test2);
		//test2.setBackground(Color.BLACK);
		//layeredPane.add(test2);
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		for (JButton buttonSelected:SharedObject.buttomList) {
			buttonSelected.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for (JButton jbutton:SharedObject.buttomList) {
						jbutton.setBackground(Color.white);
						jbutton.setForeground(Color.black);
					}
					buttonSelected.setBackground(Color.black);
					buttonSelected.setForeground(Color.white);
					SharedObject.buttonModeSelected=buttonModeEnum.values()[SharedObject.buttomList.indexOf(buttonSelected)];
					System.out.println(SharedObject.buttonModeSelected.name());
				}
			});
			
		}
		
	}

}
