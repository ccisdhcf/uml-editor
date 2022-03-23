package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class ObjectBase extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7051581027378411528L;

	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean selected;
	private String name;
	private int borderGap = 5;
	private int connectionPortSize = 10;
	/*
	 * *port?????
	 */

	public ObjectBase() {
		positionX = 0;
		positionY = 0;
		width = 0;
		height = 0;
		selected = false;
		name = null;
	}

	public ObjectBase(int _positionX, int _positionY, int _width, int _height, boolean _selected, String _name) {
		positionX = _positionX;
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
		selected = b;
	}

	public String getName() {
		return name;
	}

	public boolean getSelectedStatic() {
		return selected;
	}

	public int getPosX() {
		return positionX;
	}

	public int getPosY() {
		return positionY;
	}

	public int getObjectWidth() {
		return width;
	}

	public int getObjectHeight() {
		return height;
	}

	public boolean borderCheck(int x, int y) {
		if (positionX < x && x < positionX + width && positionY < y && y < positionY + height) {
			return true;
		}
		return false;
	}

//	public void draw(Graphics g) {
//		printComponent(g);
//
//	}

	public abstract void paintObject(Graphics g);;

	public void paintBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(positionX - borderGap, positionY - borderGap, width + 2 * borderGap, height + 2 * borderGap);
	}

	public void paintConnectionPort(Graphics g) {
		g.drawOval(positionX + width / 2 - connectionPortSize / 2, positionY - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.drawOval(positionX + width / 2 - connectionPortSize / 2, positionY + height - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.drawOval(positionX - connectionPortSize / 2, positionY + height / 2 - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.drawOval(positionX + width - connectionPortSize / 2, positionY + height / 2 - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
	}

	@Override
	public void printComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.printComponent(g);
		paintObject(g);
		if (selected) {
			System.out.println("enter?!!");
			paintBorder(g);
			paintConnectionPort(g);

		}

	}
}
