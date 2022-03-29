package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.UUID;

import javax.swing.JComponent;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.eclipse.jface.viewers.ColorCellEditor;

public abstract class ObjectBase extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7051581027378411528L;

	public enum port {
		up, down, left, right, nullMode
	};

	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean selected;
	private String name;
	private int borderGap = 5;
	private int connectionPortSize = 10;
	private String uuid;
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
		uuid = setUUID();

	}

	public ObjectBase(int _positionX, int _positionY, int _width, int _height, boolean _selected, String _name) {
		positionX = _positionX;
		positionY = _positionY;
		width = _width;
		height = _height;
		selected = _selected;
		name = _name;
		uuid = setUUID();
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

	private String setUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public String getUUID() {
		return uuid;
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

	public boolean inArea(Point src, Point des) {
		Point minPoint = new Point(src.x < des.x ? src.x : des.x, src.y < des.y ? src.y : des.y);
		Point maxPoint = new Point(src.x > des.x ? src.x : des.x, src.y > des.y ? src.y : des.y);
		if (minPoint.x < positionX && minPoint.y < positionY && maxPoint.x > (positionX + width)
				&& maxPoint.y > (positionY + height)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkBorder(int x, int y) {
		if (positionX < x && x < positionX + width && positionY < y && y < positionY + height) {
			return true;
		}
		return false;
	}

	public port getNearestPort(int x, int y) {
		// 2 diagonal
		int d1 = height * (x - positionX) - width * (y - positionY);
		int d2 = height * (x - positionX) + width * (y - positionY - height);
		if (d1 >= 0) {
			if (d2 >= 0) {
				return port.right;
			} else { // d2<0
				return port.up;
			}
		} else { // d1<0
			if (d2 >= 0) {
				return port.down;
			} else { // d2<0
				return port.left;
			}
		}
	}

	public int getPortPosX(port p) {
		switch (p) {
		case up: {
			return positionX + width / 2;
		}
		case down: {
			return positionX + width / 2;
		}
		case left: {
			return positionX;
		}
		case right: {
			return positionX + width;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + p);
		}

	}

	public int getPortPosY(port p) {
		switch (p) {
		case up: {
			return positionY;
		}
		case down: {
			return positionY + height;
		}
		case left: {
			return positionY + height / 2;
		}
		case right: {
			return positionY + height / 2;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + p);
		}
	}

//	public void draw(Graphics g) {
//		printComponent(g);
//
//	}

	public abstract void paintObject(Graphics g);

	public abstract void paintName(Graphics g);

	public void paintBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(positionX - borderGap, positionY - borderGap, width + 2 * borderGap, height + 2 * borderGap);
	}

	public void paintConnectionPort(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(positionX + width / 2 - connectionPortSize / 2, positionY - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.fillOval(positionX + width / 2 - connectionPortSize / 2, positionY + height - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.fillOval(positionX - connectionPortSize / 2, positionY + height / 2 - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.fillOval(positionX + width - connectionPortSize / 2, positionY + height / 2 - connectionPortSize / 2,
				connectionPortSize, connectionPortSize);
		g.setColor(Color.BLACK);
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
		paintName(g);
		if (selected) {
			paintBorder(g);
			paintConnectionPort(g);

		}

	}
}
