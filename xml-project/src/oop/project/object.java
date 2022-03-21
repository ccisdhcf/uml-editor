package oop.project;
import java.util.ArrayList;
import javax.swing.JButton;

public abstract class object {
	static ArrayList<JButton> buttonList;
	//new mode ->add before null mode
	static enum buttonModeEnum{
		selectMode,associationLineMode,generalizationLineMode,compositionLineMode,classMode,useCaseMode,nullMode
	}
	public static buttonModeEnum buttonModeSelected;
	public static void init() {
		buttonList=new ArrayList<>();
		buttonModeSelected=buttonModeEnum.nullMode;
		
	}
}

