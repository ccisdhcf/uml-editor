package oop.project.object.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import oop.project.object.button.ButtonMode;
import oop.project.SharedObject;
import oop.project.object.ClassObject;
import oop.project.object.ObjectBase;
import oop.project.object.UseCaseObject;

public class ObjectListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (ButtonMode.getInstance().getMode()== ButtonMode.buttonModeEnum.classMode
				|| ButtonMode.getInstance().getMode() == ButtonMode.buttonModeEnum.useCaseMode) {
			String name = JOptionPane.showInputDialog(SharedObject.getInstance().getDrawPanel(), "enter name", "name", 3);
//			System.out.println(e.getX() + " " + e.getY() + " " + name + " " + SharedObject.buttonModeSelected);
			ObjectBase newObject = null;
			if (ButtonMode.getInstance().getMode()== ButtonMode.buttonModeEnum.classMode) {
				newObject = new ClassObject(e.getX(), e.getY(), 50, 50, false, name);
			} else if (ButtonMode.getInstance().getMode() == ButtonMode.buttonModeEnum.useCaseMode) {
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
			SharedObject.getInstance().shapes.add(newObject);
//			ListenerManager.removeAllMouseEvent(new ArrayList<JComponent>(SharedObject.shapes));
//			ListenerManager.addAllMouseEvent(new ArrayList<JComponent>(SharedObject.shapes), new Ob );
			SharedObject.getInstance().getDrawPanel().repaint();
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
