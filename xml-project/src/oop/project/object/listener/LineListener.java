package oop.project.object.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import layout.ButtonModeEnum;
import oop.project.SharedObject;
import oop.project.object.ObjectBase;
import oop.project.object.line.AssociationLine;
import oop.project.object.line.CompositionLine;
import oop.project.object.line.GeneralizationLine;
import oop.project.object.line.LineBase;

public class LineListener implements MouseListener {
	private int srcX;
	private int srcY;
	private int desX;
	private int desY;
	private String srcUUID;
	private String desUUID;
	private ObjectBase.port srcPort;
	private ObjectBase.port desPort;
	private boolean isSrcGroup;
	private boolean isDesGroup;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		e.getPoint();
//		System.out.println(e.getX() + " " + e.getY());
//		String name = JOptionPane.showInputDialog(SharedObject.getDrawPanel(), "enter name", "name", 3);
//		System.out.println(e.getX() + " " + e.getY() + " " + name + " " + SharedObject.buttonModeSelected);
//		LineBase newObject = null;
//		if (SharedObject.buttonModeSelected == SharedObject.buttonModeEnum.associationLineMode) {
//
//		} else if (SharedObject.buttonModeSelected == SharedObject.buttonModeEnum.compositionLineMode) {
//
//		} else if (SharedObject.buttonModeSelected == SharedObject.buttonModeEnum.generalizationLineMode) {
//
//		}

		// SharedObject.getDrawPanel().repaint();
		// SharedObject.getDrawPanel().repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed " + e.getX() + " " + e.getY());
		// TODO Auto-generated method stub
		if (ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.associationLineMode
				|| ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.compositionLineMode
				|| ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.generalizationLineMode) {
			srcX = e.getX();
			srcY = e.getY();
			for (ObjectBase ob : SharedObject.getInstance().shapes) {
				if (ob.checkBorder(srcX, srcY)) {
					srcUUID = ob.getUUID();
					srcPort = ob.getNearestPort(srcX, srcY);
					isSrcGroup=ob.getIsGroup();
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased " + e.getX() + " " + e.getY());
		if (ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.associationLineMode
				|| ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.compositionLineMode
				|| ButtonModeEnum.getInstance().getMode() == ButtonModeEnum.buttonModeEnum.generalizationLineMode) {
			desX = e.getX();
			desY = e.getY();
			desUUID="";
			for (ObjectBase ob : SharedObject.getInstance().shapes) {
				if (ob.checkBorder(desX, desY)) {
					desUUID = ob.getUUID();
					desPort = ob.getNearestPort(desX, desY);
					isDesGroup=ob.getIsGroup();
				}
			}
			LineBase newLine;
			if (srcUUID!=desUUID&&!isSrcGroup&&!isDesGroup&&desUUID!="") {
				switch (ButtonModeEnum.getInstance().getMode()) {
				case associationLineMode: {
					newLine = new AssociationLine(srcUUID, desUUID, srcPort, desPort, false,
							ButtonModeEnum.getInstance().getMode());
					break;
				}
				case generalizationLineMode: {
					newLine = new GeneralizationLine(srcUUID, desUUID, srcPort, desPort, false,
							ButtonModeEnum.getInstance().getMode());
					break;
				}
				case compositionLineMode: {
					newLine = new CompositionLine(srcUUID, desUUID, srcPort, desPort, false,
							ButtonModeEnum.getInstance().getMode());
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + ButtonModeEnum.getInstance().getMode());
				}
				SharedObject.getInstance().lines.add(newLine);
				SharedObject.getInstance().getDrawPanel().repaint();
			}
		
		}
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
