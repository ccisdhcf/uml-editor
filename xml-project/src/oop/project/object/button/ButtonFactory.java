package oop.project.object.button;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import oop.project.SharedObject;
import oop.project.object.button.ButtonMode.buttonModeEnum;

public class ButtonFactory {
	private JPanel panel;

	public ButtonFactory(JPanel _JPanel) {
		setPanel(_JPanel);
		// gridLayout 6->total button number
		_JPanel.setLayout(new GridLayout(6, 0, 0, 0));
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	// add button to panel,then add to list
	public void addButton(ButtonMode.buttonModeEnum _mode) {
		ButtonBase _ButtonBase;
		switch (_mode) {
		case selectMode: {
			_ButtonBase = new ButtonBase(ButtonMode.buttonModeEnum.selectMode);
			break;
		}
		case associationLineMode: {
			_ButtonBase = new ButtonBase(ButtonMode.buttonModeEnum.associationLineMode);
			break;
		}
		case generalizationLineMode: {
			_ButtonBase = new ButtonBase(ButtonMode.buttonModeEnum.generalizationLineMode);
			break;
		}
		case compositionLineMode: {
			_ButtonBase = new ButtonBase(ButtonMode.buttonModeEnum.compositionLineMode);
			break;
		}
		case classMode: {
			_ButtonBase = new ButtonBase(ButtonMode.buttonModeEnum.classMode);
			break;
		}
		case useCaseMode: {
			_ButtonBase = new ButtonBase(ButtonMode.buttonModeEnum.useCaseMode);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + _mode);
		}
		panel.add(_ButtonBase);
		SharedObject.getInstance().buttomList.add(_ButtonBase);
	}

	// add listener to all button in list
	public void addButtonListener() {
		for (JButton buttonSelected : SharedObject.getInstance().buttomList) {
			buttonSelected.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					SharedObject.getInstance().resetSelected();
					for (JButton jbutton : SharedObject.getInstance().buttomList) {
						jbutton.setBackground(Color.lightGray);
						jbutton.setForeground(Color.black);
					}
					buttonSelected.setBackground(Color.black);
					buttonSelected.setForeground(Color.white);
					ButtonMode.getInstance().setMode(
							buttonModeEnum.values()[SharedObject.getInstance().buttomList.indexOf(buttonSelected)]);
					// debug
					System.out.println(ButtonMode.getInstance().getMode().name());
				}
			});

		}
	}
}
