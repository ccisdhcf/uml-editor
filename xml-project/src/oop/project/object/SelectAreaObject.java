package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class SelectAreaObject extends JComponent{
	private Point src;
	private Point des;
	public SelectAreaObject() {
		src=new Point(0,0);
		des=new Point(0,0);
	}
	public void setSrc(Point _src) {
		src=_src;
	}
	public void setDes(Point _des) {
		des=_des;
	}
	public Point getSrc() {
		return src;
	}
	public Point getDes() {
		return des;
	}
	
	@Override
	public void printComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.printComponent(g);
		Point minPoint = new Point(src.x < des.x ? src.x : des.x, src.y < des.y ? src.y : des.y);
		Point maxPoint = new Point(src.x > des.x ? src.x : des.x, src.y > des.y ? src.y : des.y);
		g.setColor(Color.green);
		g.drawRect(minPoint.x, minPoint.y, maxPoint.x-minPoint.x, maxPoint.y-minPoint.y);
		

		}

	}

	
