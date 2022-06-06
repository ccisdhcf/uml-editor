package oop.project.object.button;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonBase extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5685964380797188013L;

	public ButtonBase() {
		super();

		// TODO Auto-generated constructor stub
	}

	public ButtonBase(ButtonMode.buttonModeEnum _buttonMode) {
		super();

		String buttonName = "";
		Icon icon = null;

		switch (_buttonMode) {
		case selectMode: {
			icon = new ImageIcon(".\\src\\Resources\\SelectIcon.png");
			buttonName = "select";
			break;
		}
		case associationLineMode: {
			icon = new ImageIcon(".\\src\\Resources\\AssociationLineIcon.png");
			buttonName = "association line";
			break;
		}
		case generalizationLineMode: {
			icon = new ImageIcon(".\\src\\Resources\\GenerationLineIcon.png");
			buttonName = "generalization line";
			break;
		}
		case compositionLineMode: {
			icon = new ImageIcon(".\\src\\Resources\\CompositionLineIcon.png");
			buttonName = "composition line";
			break;
		}
		case classMode: {
			icon = new ImageIcon(".\\src\\Resources\\ClassIcon.png");
			buttonName = "class";
			break;
		}
		case useCaseMode: {
			icon = new ImageIcon(".\\src\\Resources\\UseCaseIcon.png");
			buttonName = "use case";
			break;
		}
		default:
			break;
		}
		setIcon(icon);
		setText(buttonName);
		setBackground(Color.LIGHT_GRAY);

	}

}
