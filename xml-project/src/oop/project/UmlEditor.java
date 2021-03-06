package oop.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import oop.project.object.button.ButtonFactory;
import oop.project.object.button.ButtonMode.buttonModeEnum;
import oop.project.object.listener.LineListener;
import oop.project.object.listener.ManuBarListener;
import oop.project.object.listener.ObjectListener;
import oop.project.object.listener.SelectListener;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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

		ButtonFactory bFactory = new ButtonFactory(panel);
		bFactory.addButton(buttonModeEnum.selectMode);
		bFactory.addButton(buttonModeEnum.associationLineMode);
		bFactory.addButton(buttonModeEnum.generalizationLineMode);
		bFactory.addButton(buttonModeEnum.compositionLineMode);
		bFactory.addButton(buttonModeEnum.classMode);
		bFactory.addButton(buttonModeEnum.useCaseMode);
		bFactory.addButtonListener();

//		ButtonBase selectButton = new ButtonBase(ButtonMode.buttonModeEnum.selectMode);
//		panel.add(selectButton);
//
//		ButtonBase associationLineButton = new ButtonBase(ButtonMode.buttonModeEnum.associationLineMode);
//		panel.add(associationLineButton);
//
//		ButtonBase generalizationLineButton = new ButtonBase(ButtonMode.buttonModeEnum.generalizationLineMode);
//		panel.add(generalizationLineButton);
//
//		ButtonBase compositionLineButton = new ButtonBase(ButtonMode.buttonModeEnum.compositionLineMode);
//		panel.add(compositionLineButton);
//
//		ButtonBase classButton = new ButtonBase(ButtonMode.buttonModeEnum.classMode);
//		panel.add(classButton);
//
//		ButtonBase useCaseButton = new ButtonBase(ButtonMode.buttonModeEnum.useCaseMode);
//		panel.add(useCaseButton);
//		SharedObject.getInstance().buttomList.add(selectButton);
//		SharedObject.getInstance().buttomList.add(associationLineButton);
//		SharedObject.getInstance().buttomList.add(generalizationLineButton);
//		SharedObject.getInstance().buttomList.add(compositionLineButton);
//		SharedObject.getInstance().buttomList.add(classButton);
//		SharedObject.getInstance().buttomList.add(useCaseButton);
//		for (JButton buttonSelected : SharedObject.getInstance().buttomList) {
//			buttonSelected.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					SharedObject.getInstance().resetSelected();
//					for (JButton jbutton : SharedObject.getInstance().buttomList) {
//						jbutton.setBackground(Color.lightGray);
//						jbutton.setForeground(Color.black);
//					}
//					buttonSelected.setBackground(Color.black);
//					buttonSelected.setForeground(Color.white);
//					ButtonMode.getInstance().setMode(
//							buttonModeEnum.values()[SharedObject.getInstance().buttomList.indexOf(buttonSelected)]);
//					// debug
//					System.out.println(ButtonMode.getInstance().getMode().name());
//				}
//			});
//
//		}

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu fileButton = new JMenu("file");
		menuBar.add(fileButton);

		JMenu editButton = new JMenu("edit");
		menuBar.add(editButton);

		ManuBarListener mbl = new ManuBarListener();

		JMenuItem groupButton = new JMenuItem("group");
		groupButton.addActionListener(mbl);
		editButton.add(groupButton);

		JMenuItem ungroupButton = new JMenuItem("ungroup");
		ungroupButton.addActionListener(mbl);
		editButton.add(ungroupButton);

		JMenuItem changeNameButton = new JMenuItem("change name");
		changeNameButton.addActionListener(mbl);
		editButton.add(changeNameButton);

		DrawPanel layeredPanel = new DrawPanel();

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

		frame.getContentPane().add(layeredPanel, BorderLayout.CENTER);

		layeredPanel.addMouseListener(new ObjectListener());
		layeredPanel.addMouseListener(new LineListener());
		SelectListener SL = new SelectListener();
		layeredPanel.addMouseListener(SL);
		layeredPanel.addMouseMotionListener(SL);

		SharedObject.getInstance().setFrameJPanel(panel);
		SharedObject.getInstance().setDrawPanel(layeredPanel);

	}

}
