package layout;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

import oop.project.object.UseCaseObject;

public class DrawPanel extends JLayeredPane {
	public DrawPanel() {
		super();
		this.setLayout(null);;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		UseCaseObject test=new UseCaseObject(500, 500, 500,300, true, null);
		test.setBackground(Color.BLACK);
		this.add(test);	
	}
}
