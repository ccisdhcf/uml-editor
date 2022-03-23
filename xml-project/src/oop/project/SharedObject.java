package oop.project;
import java.util.ArrayList;
import javax.swing.JButton;

import oop.project.object.LineBase;
import oop.project.object.ObjectBase;

public abstract class SharedObject {
	static ArrayList<JButton> buttomList=new ArrayList<JButton>();;
	static ArrayList<ObjectBase> shapes = new ArrayList<ObjectBase>();
	static ArrayList<LineBase> lines = new ArrayList<LineBase>();
	//new mode ->add before null mode
	static enum buttonModeEnum{
		selectMode,associationLineMode,generalizationLineMode,compositionLineMode,classMode,useCaseMode,nullMode
	}
	public static buttonModeEnum buttonModeSelected;
	public static void init() {
//		buttomList=new ArrayList<>();
//		shapes=new ArrayList<>();
//		lines=new ArrayList<>();
		buttonModeSelected=buttonModeEnum.nullMode;
		
	}
}

