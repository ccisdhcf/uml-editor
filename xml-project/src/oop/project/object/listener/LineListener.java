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

		SharedObject.getDrawPanel().repaint();
		// SharedObject.getDrawPanel().repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		srcX = e.getX();
		srcY = e.getY();
		for (ObjectBase ob : SharedObject.shapes) {
			if (ob.checkBorder(srcX, srcY)) {
				srcUUID = ob.getUUID();
				srcPort = ob.getNearestPort(srcX, srcY);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		desX = e.getX();
		desY = e.getY();
		for (ObjectBase ob : SharedObject.shapes) {
			if (ob.checkBorder(desX, desY)) {
				desUUID = ob.getUUID();
				desPort = ob.getNearestPort(desX, desY);
			}
		}
		LineBase newLine;
		switch (SharedObject.buttonModeSelected) {
		case associationLineMode: {
			newLine = new AssociationLine(srcUUID, desUUID, srcPort, desPort, false, SharedObject.buttonModeSelected);
			break;
		}
		case generalizationLineMode: {
			newLine = new GeneralizationLine(srcUUID, desUUID, srcPort, desPort, false,
					SharedObject.buttonModeSelected);
			break;
		}
		case compositionLineMode: {
			newLine = new CompositionLine(srcUUID, desUUID, srcPort, desPort, false, SharedObject.buttonModeSelected);
			break;
		}
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + SharedObject.buttonModeSelected);
		}
		SharedObject.lines.add(newLine);
		SharedObject.getDrawPanel().repaint();

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