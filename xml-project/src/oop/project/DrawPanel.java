package oop.project;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

import oop.project.object.ObjectBase;

@SuppressWarnings("serial")
public class DrawPanel extends JLayeredPane {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (ObjectBase a:SharedObject.shapes) {
			a.printComponent(g);
		}
//		g.drawLine(100, 100, 1500, 1000);	
//		g.setColor(Color.black);
//		int paintSlice=3;
//		for (int t = 0; t < paintSlice; t++) {
//			g.drawRect(100, 100 + ((t * 500) / paintSlice), 500, 500 / paintSlice);
//		}
//		
//		g.drawOval(100, 100, 500, 500);
	}
//	@Override
//	public void drawComponent 
}
