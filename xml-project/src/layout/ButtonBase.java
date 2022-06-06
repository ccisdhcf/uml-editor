package layout;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;



public class ButtonBase extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5685964380797188013L;
	
	@SuppressWarnings("unused")
	private ButtonModeEnum.buttonModeEnum buttonMode;

	public ButtonBase() {
		super();
		buttonMode = ButtonModeEnum.buttonModeEnum.nullMode;

		// TODO Auto-generated constructor stub
	}

	public ButtonBase(String _ButtonName, ButtonModeEnum.buttonModeEnum _buttonMode) {
		super();
		buttonMode = _buttonMode;

		Icon icon = null;

		switch (_buttonMode) {
		case selectMode: {
			icon = new ImageIcon(".\\src\\Resources\\SelectIcon.png");
			break;
		}
		case associationLineMode: {
			icon = new ImageIcon(".\\src\\Resources\\AssociationLineIcon.png");
			break;
		}
		case generalizationLineMode: {
			icon = new ImageIcon(".\\src\\Resources\\GenerationLineIcon.png");
			break;
		}
		case compositionLineMode: {
			icon = new ImageIcon(".\\src\\Resources\\CompositionLineIcon.png");
			break;
		}
		case classMode: {
			icon = new ImageIcon(".\\src\\Resources\\ClassIcon.png");
			break;
		}
		case useCaseMode: {
			icon = new ImageIcon(".\\src\\Resources\\UseCaseIcon.png");
			break;
		}
		default:
			break;
		}
		setIcon(icon);
		setText(_ButtonName);
		setBackground(Color.LIGHT_GRAY);

	}

}
