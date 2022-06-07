package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.UUID;
import javax.swing.JComponent;

public abstract class ObjectBase extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7051581027378411528L;

	public enum port {
		up, down, left, right, nullMode
	};

//	private int positionX;
//	private int positionY;
	private Point position;
	private int width;
	private int height;
	private boolean selected;
	private String name;
	private int borderGap = 5;
	private int connectionPortSize = 10;
	private String uuid;
	private boolean isGroup = false;
	/*
	 * *port?????
	 */

	public ObjectBase() {
		position = new Point(0, 0);
		;

		width = 0;
		height = 0;
		selected = false;
		name = null;
		uuid = setUUID();

	}

	public ObjectBase(int _positionX, int _positionY, int _width, int _height, boolean _selected, String _name) {
//		positionX = _positionX;
//		positionY = _positionY;
		position = new Point(_positionX, _positionY);
		width = _width;
		height = _height;
		selected = _selected;
		name = _name;
		uuid = setUUID();
	}

	public void setPosition(int x, int y) {
//		positionX = x;
//		positionY = y;
		position.setLocation(x, y);
	}

	public void setIsGroup(boolean _isGroup) {
		isGroup = _isGroup;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setSelected(boolean b) {
		selected = b;
	}

	public void setWidth(int _width) {
		width = _width;
	}

	public void setHeight(int _height) {
		height = _height;
	}

	private String setUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public String getUUID() {
		return uuid;
	}

	public boolean getIsGroup() {
		return isGroup;
	}

	public String getName() {
		return name;
	}

	public boolean getSelectedStatic() {
		return selected;
	}

	public int getPosX() {
		return (int) position.getX();
	}

	public int getPosY() {
		return (int) position.getY();
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
		if (minPoint.x < position.getX() && minPoint.y < position.getY() && maxPoint.x > (position.getX() + width)
				&& maxPoint.y > (position.getY() + height)) {
			return true;
		} else {
			return false;
		}
	}
//	public void shiftObject(int x,int y) {
//		positionX=positionX+x;
//		positionY=positionY+y;
//	}

	public boolean checkBorder(int x, int y) {
		if (position.getX() < x && x < position.getX() + width && position.getY() < y && y < position.getY() + height) {
			return true;
		}
		return false;
	}

	public port getNearestPort(int x, int y) {
		// 2 diagonal
		int d1 = (int) (height * (x - position.getX()) - width * (y - position.getY()));
		int d2 = (int) (height * (x - position.getX()) + width * (y - position.getY() - height));
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

	public Point getPortPos(port p) {
		Point point = new Point();
		switch (p) {
		case up: {
			point.setLocation(position.getX() + width / 2, position.getY());
			break;
		}
		case down: {
			point.setLocation(position.getX() + width / 2, position.getY() + height);
			break;
		}
		case left: {
			point.setLocation(position.getX(), position.getY() + height / 2);
			break;
		}
		case right: {
			point.setLocation(position.getX() + width, position.getY() + height / 2);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + p);
		}
		return point;
	}
//	public int getPortPosX(port p) {
//		switch (p) {
//		case up: {
//			return positionX + width / 2;
//		}
//		case down: {
//			return positionX + width / 2;
//		}
//		case left: {
//			return positionX;
//		}
//		case right: {
//			return positionX + width;
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + p);
//		}
//
//	}
//
//	public int getPortPosY(port p) {
//		switch (p) {
//		case up: {
//			return positionY;
//		}
//		case down: {
//			return positionY + height;
//		}
//		case left: {
//			return positionY + height / 2;
//		}
//		case right: {
//			return positionY + height / 2;
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + p);
//		}
//	}

//	public void draw(Graphics g) {
//		printComponent(g);
//
//	}

	public abstract void paintObject(Graphics g);

	public abstract void paintName(Graphics g);

	public void paintBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect((int) position.getX() - borderGap, (int) position.getY() - borderGap, width + 2 * borderGap,
				height + 2 * borderGap);
	}

	public void paintConnectionPort(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval((int) position.getX() + width / 2 - connectionPortSize / 2,
				(int) position.getY() - connectionPortSize / 2, connectionPortSize, connectionPortSize);
		g.fillOval((int) position.getX() + width / 2 - connectionPortSize / 2,
				(int) position.getY() + height - connectionPortSize / 2, connectionPortSize, connectionPortSize);
		g.fillOval((int) position.getX() - connectionPortSize / 2,
				(int) position.getY() + height / 2 - connectionPortSize / 2, connectionPortSize, connectionPortSize);
		g.fillOval((int) position.getX() + width - connectionPortSize / 2,
				(int) position.getY() + height / 2 - connectionPortSize / 2, connectionPortSize, connectionPortSize);
		g.setColor(Color.BLACK);
		g.drawOval((int) position.getX() + width / 2 - connectionPortSize / 2,
				(int) position.getY() - connectionPortSize / 2, connectionPortSize, connectionPortSize);

		g.drawOval((int) position.getX() + width / 2 - connectionPortSize / 2,
				(int) position.getY() + height - connectionPortSize / 2, connectionPortSize, connectionPortSize);
		g.drawOval((int) position.getX() - connectionPortSize / 2,
				(int) position.getY() + height / 2 - connectionPortSize / 2, connectionPortSize, connectionPortSize);
		g.drawOval((int) position.getX() + width - connectionPortSize / 2,
				(int) position.getY() + height / 2 - connectionPortSize / 2, connectionPortSize, connectionPortSize);
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
	
	// Percolating 	up
	public abstract void ungroup();
}
