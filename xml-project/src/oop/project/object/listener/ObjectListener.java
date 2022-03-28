package oop.project.object.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.eclipse.swt.events.MouseAdapter;

import oop.project.SharedObject;
import oop.project.object.ClassObject;
import oop.project.object.ObjectBase;
import oop.project.object.UseCaseObject;

public class ObjectListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getPoint();
		System.out.println(e.getX() + " " + e.getY());
		String name = JOptionPane.showInputDialog(SharedObject.getDrawPanel(), "enter name", "name", 3);
		System.out.println(e.getX() + " " + e.getY() + " " + name + " " + SharedObject.buttonModeSelected);
		ObjectBase newObject = null;
		if (SharedObject.buttonModeSelected == SharedObject.buttonModeEnum.classMode) {

			newObject = new ClassObject(e.getX(), e.getY(), 50, 50, false, name);
		} else if (SharedObject.buttonModeSelected == SharedObject.buttonModeEnum.useCaseMode) {
			newObject = new UseCaseObject(e.getX(), e.getY(), 50, 30, false, name);
		}
		SharedObject.shapes.add(newObject);
		SharedObject.getDrawPanel().repaint();
		// SharedObject.getDrawPanel().repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
