package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;

public class UseCaseObject extends ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8518328400145177749L;

	public UseCaseObject(int _positionX, int _positionY, int _width, int _height, boolean _selected, String _name) {
		super(_positionX, _positionY, _width, _height, _selected, _name);
		// TODO Auto-generated constructor stub
	}

//	public void draw(Graphics g) {
//		paintObject(g);
//
//	}

	@Override
	public void paintObject(Graphics g) {
		int inset=2;
		g.setColor(Color.black);
		g.drawOval(getPosX(), getPosY(), getObjectWidth(), getObjectHeight());
		g.setColor(Color.white);
		g.fillOval(getX()+inset, getY()+inset, getWidth()-inset*2, getHeight()-inset*2);
		// System.out.println(getPosX()+" "+getPosY()+" "+ getObjectWidth()+"
		// "+getObjectHeight());

	}

	@Override
	public void paintName(Graphics g) {
		g.setColor(Color.black);
		g.drawString(getName(), getPosX() + getObjectWidth() / 8, getPosY() + getObjectHeight() / 2);
	}
}
