package oop.project;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

import oop.project.object.ObjectBase;
import oop.project.object.line.LineBase;

public class SharedObject {
	public static ArrayList<JButton> buttomList;
	public static ArrayList<ObjectBase> shapes;
	public static ArrayList<LineBase> lines;

	// new mode ->add before null mode
	public enum buttonModeEnum {
		selectMode, associationLineMode, generalizationLineMode, compositionLineMode, classMode, useCaseMode, nullMode
	}

	static JPanel frameJPanel;
	static DrawPanel drawPanel;
	public static buttonModeEnum buttonModeSelected;

	static public void init() {
		buttomList = new ArrayList<>();
		shapes = new ArrayList<>();
		lines = new ArrayList<>();
		buttonModeSelected = buttonModeEnum.nullMode;

	}

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

}
