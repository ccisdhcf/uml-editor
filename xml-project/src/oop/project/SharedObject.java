package oop.project;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JPanel;

import oop.project.object.ObjectBase;
import oop.project.object.SelectAreaObject;
import oop.project.object.line.LineBase;

public class SharedObject {
	public static ArrayList<JButton> buttomList=new ArrayList<>();
	public static ArrayList<ObjectBase> shapes=new ArrayList<>();
	public static ArrayList<LineBase> lines=new ArrayList<>();

	// new mode ->add before null mode
	public enum buttonModeEnum {
		selectMode, associationLineMode, generalizationLineMode, compositionLineMode, classMode, useCaseMode, nullMode
	}

	static JPanel frameJPanel;
	static DrawPanel drawPanel;
	public static buttonModeEnum buttonMode;

	static public void init() {
//		buttomList = new ArrayList<>();
//		shapes = new ArrayList<>();
//		lines = new ArrayList<>();
		buttonMode = buttonModeEnum.nullMode;

	}
	static public SelectAreaObject sao=new SelectAreaObject();
	static public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	static public JPanel getFrameJPanel() {
		return frameJPanel;
	}

	static public void setDrawPanel(DrawPanel _dp) {
		drawPanel = _dp;

	}

	static public void setFrameJPanel(JPanel _frame) {
		frameJPanel = _frame;
	}

	static public void resetSelected() {
		for (ObjectBase shape : shapes) {
			shape.setSelected(false);
		}
	}

}
