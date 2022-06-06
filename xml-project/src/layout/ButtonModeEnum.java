package layout;

import oop.project.SharedObject;

public class ButtonModeEnum {
	private static ButtonModeEnum instance;
	public static ButtonModeEnum getInstance() {
		if (instance == null) {
			instance = new ButtonModeEnum();
		}
		return instance;
	}
	public enum buttonModeEnum {
		selectMode, associationLineMode, generalizationLineMode, compositionLineMode, classMode, useCaseMode, nullMode
	}
	private buttonModeEnum buttonMode=buttonModeEnum.nullMode;
	public buttonModeEnum getMode() {
		return buttonMode;
	}
	public void setMode(buttonModeEnum _mode) {
		buttonMode=_mode;
	}
}
