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
		g.setColor(Color.black);
		g.drawOval(getPosX(), getPosY(), getObjectWidth(), getObjectHeight());
		//System.out.println(getPosX()+" "+getPosY()+" "+ getObjectWidth()+" "+getObjectHeight());
		
		
	}
}
