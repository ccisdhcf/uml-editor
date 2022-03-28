package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;


public class ClassObject extends ObjectBase  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6659519195610387187L;

	private int paintSlice = 3;

	public ClassObject(int _positionX, int _positionY, int _width, int _height, boolean _selected, String _name) {
		super(_positionX, _positionY, _width, _height, _selected, _name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintObject(Graphics g) {
		g.setColor(Color.black);
		for (int t = 0; t < paintSlice; t++) {
			g.drawRect(getPosX(), getPosY() + ((t * getObjectHeight()) / paintSlice), getObjectWidth(),
					getObjectHeight() / paintSlice);
		}
	}

	@Override
	public void paintName(Graphics g) {
		g.drawString(getName(), getPosX() + getObjectWidth() / 6, getPosY() + getObjectHeight() / 5);
	}
}
