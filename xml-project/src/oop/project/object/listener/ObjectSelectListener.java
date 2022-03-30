package oop.project.object.listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import oop.project.SharedObject;
import oop.project.object.ObjectBase;

public class ObjectSelectListener extends MouseAdapter {
	@SuppressWarnings("unused")
	private Point shapeShift;
	@SuppressWarnings("unused")
	private Point dragPoint;
	@SuppressWarnings("unused")
	private ObjectBase objectBase;

	public ObjectSelectListener() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("select click " + e.getX() + " " + e.getY());
		if (SharedObject.buttonMode == SharedObject.buttonModeEnum.selectMode) {
//			SharedObject.resetSelected();
//			objectBase = (ObjectBase) e.getSource();
//			objectBase.setSelected(true);
//			shapeShift = e.getPoint();
//			SharedObject.getDrawPanel().repaint();
//			for (ObjectBase ob : SharedObject.shapes) {
//				if (ob.checkBorder(e.getX(), e.getY())) {
//					ob.setSelected(true);
//
//					shapeShift=e.getPoint();
//					
//					System.out.println("select click " + e.getX() + " " + e.getY() + " " + shapeShift);
//					break;
//				}
//			}
		}

		
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		if (SharedObject.buttonMode == SharedObject.buttonModeEnum.selectMode) {
//			for (ObjectBase ob : SharedObject.shapes) {
//				if (ob.checkBorder(e.getX(), e.getY())) {
//					ob.setPosition(e.getX(), e.getY());
//					break;
//				}
//
//			}
//			dragPoint = e.getPoint();
//			int _x = dragPoint.x - shapeShift.x;
//			int _y = dragPoint.x - shapeShift.y;
//			objectBase.setPosition(objectBase.getPosX() + _x, objectBase.getPosY() + _y);
//			SharedObject.getDrawPanel().repaint();
//			for (ObjectBase ob : SharedObject.shapes) {
//				if (ob.checkBorder(e.getX(), e.getY())) {
//					dragPoint = e.getPoint();
//					int _x = dragPoint.x - shapeShift.x;
//					int _y = dragPoint.x - shapeShift.y;
//					ob.setPosition(ob.getPosX() + _x, ob.getPosY() + _y);
//					SharedObject.getDrawPanel().repaint();
//					System.out.println("select drag " + e.getX() + " " + e.getY() + " " + shapeShift.x + " "
//							+ shapeShift.y + " " + ob.getPosX() + " " + ob.getPosY() + " ");
//					break;
//				}
//			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
