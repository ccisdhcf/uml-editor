package oop.project.object.listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import oop.project.SharedObject;
import oop.project.object.ObjectBase;
import oop.project.object.line.LineBase;

public class SelectListener extends MouseAdapter {
//	private String objectUUID;
//
//	public SelectListener(String _obUUID) {
//		objectUUID = _obUUID;
//		System.out.println(objectUUID);
//	}
	private Point shapeShift;
	private Point objBeforeDragPoint;
	private ObjectBase objectBase;
	private boolean IsPressPointAObj;
	private Point selectAreaSrc;
	private Point selectAreaDes;

	public SelectListener() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		IsPressPointAObj = false;
		if (SharedObject.buttonMode == SharedObject.buttonModeEnum.selectMode) {
			SharedObject.resetSelected();

			for (ObjectBase ob : SharedObject.shapes) {
				if (ob.checkBorder(e.getX(), e.getY())) {
					SharedObject.sao.setSrc(new Point(0, 0));
					SharedObject.sao.setDes(new Point(0, 0));
					ob.setSelected(true);
					objectBase = ob;
					shapeShift = e.getPoint();
					objBeforeDragPoint = new Point(ob.getPosX(), ob.getPosY());
//					System.out.println("select click " + e.getX() + " " + e.getY() + " " + shapeShift);

					IsPressPointAObj = true;
					break;
				}

			}
			if (!IsPressPointAObj) {
				selectAreaSrc = new Point(e.getPoint());

				SharedObject.sao.setSrc(e.getPoint());
				SharedObject.sao.setDes(e.getPoint());
				System.out.println(
						" " + SharedObject.sao.getSrc().x + " " + SharedObject.sao.getSrc().y + " " + shapeShift);
			}
		}

		SharedObject.getDrawPanel().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (SharedObject.buttonMode == SharedObject.buttonModeEnum.selectMode && !IsPressPointAObj) {
			selectAreaDes = new Point(e.getPoint());
			for (ObjectBase ob : SharedObject.shapes) {
				if (ob.inArea(selectAreaSrc, selectAreaDes)) {
					ob.setSelected(true);
				}
			}
			for (LineBase lb : SharedObject.lines) {
				if (lb.inArea(selectAreaSrc, selectAreaDes)) {
					lb.setSelected(true);
				}
			}
			SharedObject.getDrawPanel().repaint();
		}
		objectBase = null;
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
			if (shapeShift != null && objectBase != null) {
//				for (ObjectBase ob : SharedObject.shapes) {
//				if (ob.checkBorder(e.getX(), e.getY())) {
//					ob.setPosition(e.getX(), e.getY());
//					break;
//				}
//
//			}

				int _x = e.getPoint().x - shapeShift.x;
				int _y = e.getPoint().y - shapeShift.y;
				// BeforeDragPoint=new Point(objectBase.getPosX(),objectBase.getPosY());
				objectBase.setPosition(objBeforeDragPoint.x + _x, objBeforeDragPoint.y + _y);
				//objectBase.shiftObject(_x, _y);

//			System.out.println("select drag " + e.getPoint().x + " " + e.getPoint().y + " " + shapeShift.x + " "
//					+ shapeShift.y + " " + objectBase.getPosX() + " " + objectBase.getPosY() + " ");
				for (LineBase lb : SharedObject.lines) {
					lb.getPosFromUUID(lb.getSrcUUID(), lb.getDesUUID(), lb.getSrcPort(), lb.getDesPort(),SharedObject.shapes);
				}
				SharedObject.getDrawPanel().repaint();
			} else if (!IsPressPointAObj) {
//				selectAreaDes=e.getPoint();
				SharedObject.sao.setDes(e.getPoint());
				SharedObject.getDrawPanel().repaint();
			}

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
