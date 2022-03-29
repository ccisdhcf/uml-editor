package oop.project.object.listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import oop.project.SharedObject;
import oop.project.object.ObjectBase;
import oop.project.object.ObjectBase.port;
import oop.project.object.line.LineBase;

public class SelectListener extends MouseAdapter {
//	private String objectUUID;
//
//	public SelectListener(String _obUUID) {
//		objectUUID = _obUUID;
//		System.out.println(objectUUID);
//	}
	private Point shapeShift;
	private Point dragPoint;
	private Point BeforeDragPoint;
	private ObjectBase objectBase;

	public SelectListener() {

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
			SharedObject.resetSelected();

			for (ObjectBase ob : SharedObject.shapes) {
				if (ob.checkBorder(e.getX(), e.getY())) {
					ob.setSelected(true);
					objectBase = ob;
					shapeShift = e.getPoint();
					BeforeDragPoint=new Point(ob.getPosX(),ob.getPosY());
					

					System.out.println("select click " + e.getX() + " " + e.getY() + " " + shapeShift);
					break;
				}
			}
		}

		SharedObject.getDrawPanel().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		objectBase=null;
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

			dragPoint = e.getPoint();
			int _x = dragPoint.x - shapeShift.x;
			int _y = dragPoint.y - shapeShift.y;
			//BeforeDragPoint=new Point(objectBase.getPosX(),objectBase.getPosY());
			objectBase.setPosition(BeforeDragPoint.x + _x, BeforeDragPoint.y + _y);
		
			System.out.println("select drag " + dragPoint.x + " " + dragPoint.y + " " + shapeShift.x + " "
					+ shapeShift.y + " " + objectBase.getPosX() + " " + objectBase.getPosY() + " ");
			for(LineBase lb:SharedObject.lines) {
				lb.getPos(lb.getSrcUUID(), lb.getDesUUID(), lb.getSrcPort(),lb.getDesPort());
			}
			SharedObject.getDrawPanel().repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
