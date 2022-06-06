package oop.project.object.listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import layout.ButtonModeEnum;
import layout.ButtonModeEnum.buttonModeEnum;
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
		if (ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.selectMode) {
			SharedObject.getInstance().resetSelected();

			for (ObjectBase ob : SharedObject.getInstance().shapes) {
				if (ob.checkBorder(e.getX(), e.getY())) {
					SharedObject.getInstance().getSao().setSrc(new Point(0, 0));
					SharedObject.getInstance().getSao().setDes(new Point(0, 0));
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

				SharedObject.getInstance().getSao().setSrc(e.getPoint());
				SharedObject.getInstance().getSao().setDes(e.getPoint());
				System.out.println(
						" " + SharedObject.getInstance().getSao().getSrc().x + " " + SharedObject.getInstance().getSao().getSrc().y + " " + shapeShift);
			}
		}

		SharedObject.getInstance().getDrawPanel().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.selectMode && !IsPressPointAObj) {
			selectAreaDes = new Point(e.getPoint());
			for (ObjectBase ob : SharedObject.getInstance().shapes) {
				if (ob.inArea(selectAreaSrc, selectAreaDes)) {
					ob.setSelected(true);
				}
			}
			for (LineBase lb : SharedObject.getInstance().lines) {
				if (lb.inArea(selectAreaSrc, selectAreaDes)) {
					lb.setSelected(true);
				}
			}
			SharedObject.getInstance().getDrawPanel().repaint();
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

		if (ButtonModeEnum.getInstance().getMode()== ButtonModeEnum.buttonModeEnum.selectMode) {
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
				for (LineBase lb : SharedObject.getInstance().lines) {
					lb.getPosFromUUID(lb.getSrcUUID(), lb.getDesUUID(), lb.getSrcPort(), lb.getDesPort(),SharedObject.getInstance().shapes);
				}
				SharedObject.getInstance().getDrawPanel().repaint();
			} else if (!IsPressPointAObj) {
//				selectAreaDes=e.getPoint();
				SharedObject.getInstance().getSao().setDes(e.getPoint());
				SharedObject.getInstance().getDrawPanel().repaint();
			}

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
