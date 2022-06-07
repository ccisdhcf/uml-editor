package oop.project;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import oop.project.object.ObjectBase;
import oop.project.object.SelectAreaObject;
import oop.project.object.line.LineBase;

public class SharedObject {
	// singleton
	private static SharedObject instance;

	private SharedObject() {
	}

	public static SharedObject getInstance() {
		if (instance == null) {
			instance = new SharedObject();
		}
		return instance;
	}

	public ArrayList<JButton> buttomList = new ArrayList<>();
	public ArrayList<ObjectBase> shapes = new ArrayList<>();
	public ArrayList<LineBase> lines = new ArrayList<>();

	private static JPanel frameJPanel;
	private static DrawPanel drawPanel;

	static public void init() {
	}

	public SelectAreaObject sao = new SelectAreaObject();

	public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public JPanel getFrameJPanel() {
		return frameJPanel;
	}

	public void setDrawPanel(DrawPanel _dp) {
		drawPanel = _dp;

	}

	public void setFrameJPanel(JPanel _frame) {
		frameJPanel = _frame;
	}

	public void resetSelected() {
		for (ObjectBase shape : shapes) {
			shape.setSelected(false);
		}
	}

	public SelectAreaObject getSao() {
		return sao;
	}

	public void setSao(SelectAreaObject sao) {
		this.sao = sao;
	}

}
