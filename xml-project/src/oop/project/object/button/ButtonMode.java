package oop.project.object.button;

public class ButtonMode {
	// singleton
	// save all button type
	// save current clicked type
	private static ButtonMode instance;

	public static ButtonMode getInstance() {
		if (instance == null) {
			instance = new ButtonMode();
		}
		return instance;
	}

	public enum buttonModeEnum {
		selectMode, associationLineMode, generalizationLineMode, compositionLineMode, classMode, useCaseMode, nullMode
	}

	private buttonModeEnum buttonMode = buttonModeEnum.nullMode;

	public buttonModeEnum getMode() {
		return buttonMode;
	}

	public void setMode(buttonModeEnum _mode) {
		buttonMode = _mode;
	}
}
