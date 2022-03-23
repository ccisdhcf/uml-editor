package oop.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.project.SharedObject.buttonModeEnum;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


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
		
		JMenuItem groupUngroupButton = new JMenuItem("group/ungroup");
		editButton.add(groupUngroupButton);
		
		JMenuItem changeNameButton = new JMenuItem("change name");
		editButton.add(changeNameButton);
		
		SharedObject.buttonList.add(selectButton);
		SharedObject.buttonList.add(associationLineButton);
		SharedObject.buttonList.add(generalizationLineButton);
		SharedObject.buttonList.add(compositionLineButton);
		SharedObject.buttonList.add(classButton);
		SharedObject.buttonList.add(useCaseButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		for (JButton buttonSelected:SharedObject.buttonList) {
			buttonSelected.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for (JButton jbutton:SharedObject.buttonList) {
						jbutton.setBackground(Color.white);
						jbutton.setForeground(Color.black);
					}
					buttonSelected.setBackground(Color.black);
					buttonSelected.setForeground(Color.white);
					SharedObject.buttonModeSelected=buttonModeEnum.values()[SharedObject.buttonList.indexOf(buttonSelected)];
					System.out.println(SharedObject.buttonModeSelected.name());
				}
			});
			
		}
		
	}

}
