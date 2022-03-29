package oop.project.object.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
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
		if (SharedObject.buttonMode == SharedObject.buttonModeEnum.classMode
				|| SharedObject.buttonMode == SharedObject.buttonModeEnum.useCaseMode) {
			String name = JOptionPane.showInputDialog(SharedObject.getDrawPanel(), "enter name", "name", 3);
//			System.out.println(e.getX() + " " + e.getY() + " " + name + " " + SharedObject.buttonModeSelected);
			ObjectBase newObject = null;
			if (SharedObject.buttonMode == SharedObject.buttonModeEnum.classMode) {
				newObject = new ClassObject(e.getX(), e.getY(), 50, 50, false, name);
			} else if (SharedObject.buttonMode == SharedObject.buttonModeEnum.useCaseMode) {
				newObject = new UseCaseObject(e.getX(), e.getY(), 50, 30, false, name);
			}
//			newObject.addMouseListener(new SelectListener());
//			System.out.println("eeeee");
//			MouseListener[] mls = newObject.getListeners(MouseListener.class);
//			for (MouseListener a : mls) {
//				System.out.println("ssss");
//			}
//			ObjectSelectListener osl=new ObjectSelectListener();
//			newObject.addMouseListener(osl);
//			newObject.addMouseMotionListener(osl);
			SharedObject.shapes.add(newObject);
//			ListenerManager.removeAllMouseEvent(new ArrayList<JComponent>(SharedObject.shapes));
//			ListenerManager.addAllMouseEvent(new ArrayList<JComponent>(SharedObject.shapes), new Ob );
			SharedObject.getDrawPanel().repaint();
		}

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
