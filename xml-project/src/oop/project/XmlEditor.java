package oop.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import oop.project.object;

public class XmlEditor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XmlEditor window = new XmlEditor();
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
	public XmlEditor() {
		
		initialize();
		for (JButton buttonSelected:object.buttonList) {
			buttonSelected.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for (JButton jbutton:object.buttonList) {
						jbutton.setBackground(Color.white);
						jbutton.setForeground(Color.black);
					}
					buttonSelected.setBackground(Color.BLACK);
					buttonSelected.setForeground(Color.white);
				}
			});
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		object.buttonList=new ArrayList<>();
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
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileButton = new JMenu("file");
		menuBar.add(fileButton);
		
		JMenu editButton = new JMenu("edit");
		menuBar.add(editButton);
		
		JMenuItem groupUngroupButton = new JMenuItem("group/ungroup");
		editButton.add(groupUngroupButton);
		
		JMenuItem changeNameButton = new JMenuItem("change name");
		editButton.add(changeNameButton);
		
		object.buttonList.add(selectButton);
		object.buttonList.add(associationLineButton);
		object.buttonList.add(generalizationLineButton);
		object.buttonList.add(compositionLineButton);
		object.buttonList.add(classButton);
		object.buttonList.add(useCaseButton);
	}

}
