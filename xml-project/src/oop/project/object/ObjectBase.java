package oop.project.object;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class ObjectBase extends JComponent {
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean selected;
	private String name;
	/*
	 * *port?????
	 */
	
	ObjectBase() {
		positionY = 0;
		positionY = 0;
		width = 0;
		height = 0;
		selected = false;
		name = null;
	}
	ObjectBase(int _positionX, int _positionY, int _width, int _height, boolean _selected, String _name) {
		positionY = _positionX;
		positionY = _positionY;
		width = _width;
		height = _height;
		selected = _selected;
		name = _name;
	}

	public void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
	}

	public void setName(String newName) {
		name = newName;
	}
	public void setSelected(boolean b) {
		selected=b;
	}
	public String getName() {
		return name;
	}
	public boolean getSelectedStatic() {
		return selected;
	}
	public abstract void printObject(Graphics g);;
	public void printBorder(Graphics g) {
		g.drawRect(positionX-10, positionY-10, width+20, height+20);
	}
	@Override
	protected void printComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.printComponent(g);
		printObject(g);
		if (selected) {
			printBorder(g);
		}
		
	}
}
