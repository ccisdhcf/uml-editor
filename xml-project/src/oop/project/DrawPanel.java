package oop.project;

import java.awt.Graphics;

import javax.swing.JLayeredPane;

import oop.project.object.ObjectBase;
import oop.project.object.line.LineBase;

@SuppressWarnings("serial")
public class DrawPanel extends JLayeredPane {
	public DrawPanel() {
		super();
		this.setLayout(null);
		;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (ObjectBase shape : SharedObject.getInstance().shapes) {
			shape.printComponent(g);
		}
		for (LineBase line : SharedObject.getInstance().lines) {
			line.printComponent(g);
		}
		SharedObject.getInstance().getSao().printComponent(g);
//		g.drawLine(100, 100, 1500, 1000);	
//		g.setColor(Color.black);
//		int paintSlice=3;
//		for (int t = 0; t < paintSlice; t++) {
//			g.drawRect(100, 100 + ((t * 500) / paintSlice), 500, 500 / paintSlice);
//		}
//		
//		g.drawOval(100, 100, 500, 500);
	}
//	public void addObject(ObjectBase _add) {
//		SharedObject.shapes.add(_add);
//	}
//	public void addLine (LineBase _add) {
//		SharedObject.lines.add(_add);
//	}

}
