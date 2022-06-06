package oop.project.object.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;

import layout.ButtonModeEnum;
import oop.project.SharedObject;
import oop.project.object.ObjectBase;
import oop.project.object.ObjectBase.port;

public abstract class LineBase extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2552195740745654751L;

	private int srcPositionX;
	private int srcPositionY;
	private int desPositionX;
	private int desPositionY;
	private String srcUUID;
	private String desUUID;
	private ObjectBase.port srcPort;
	private ObjectBase.port desPort;
	private boolean selected;
	private ButtonModeEnum.buttonModeEnum type;

	public LineBase() {
		srcPositionX = 0;
		srcPositionY = 0;
		desPositionX = 0;
		desPositionY = 0;
		srcUUID=null;
		desUUID=null;
		srcPort=port.nullMode;
		desPort=port.nullMode;
		selected = false;
		type = ButtonModeEnum.buttonModeEnum.nullMode;
	}

	public LineBase(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY, boolean _selected,
			ButtonModeEnum.buttonModeEnum _type) {
		srcPositionX = _srcPositionX;
		srcPositionY = _srcPositionY;
		desPositionX = _desPositionX;
		desPositionY = _desPositionY;
		type = _type;
		selected = _selected;
	}	
	public LineBase(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort, boolean _selected,
			ButtonModeEnum.buttonModeEnum _type) {
		srcUUID=_srcUUID;
		desUUID=_desUUID;
		srcPort=_srcPort;
		desPort=_desPort;
		getPosFromUUID(srcUUID, desUUID, srcPort, desPort,SharedObject.getInstance().shapes);
		type = _type;
		selected = _selected;
	}
//	public void getPosFromUUID(String _srcUUID,String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort) {
//		for (ObjectBase ob:SharedObject.shapes) {
//			if (ob.getUUID().equals(_srcUUID)) {
//				srcPositionX=ob.getPortPosX(_srcPort);
//				srcPositionY=ob.getPortPosY(_srcPort);
//			}
//			else if (ob.getUUID().equals(_desUUID)) {
//				desPositionX=ob.getPortPosX(_desPort);
//				desPositionY=ob.getPortPosY(_desPort);
//			}
//		}
//	}
	public void getPosFromUUID(String _srcUUID,String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,ArrayList<ObjectBase> _obList) {
		for (ObjectBase ob:_obList) {
			if (ob.getUUID().equals(_srcUUID)) {
				srcPositionX=ob.getPortPosX(_srcPort);
				srcPositionY=ob.getPortPosY(_srcPort);
			}
			else if (ob.getUUID().equals(_desUUID)) {
				desPositionX=ob.getPortPosX(_desPort);
				desPositionY=ob.getPortPosY(_desPort);
			}
		}
	}
	public void setSrcPosition(int _srcX, int _srcY) {
		srcPositionX = _srcX;
		srcPositionY = _srcY;
	}

	public void SetDesPosition(int _desX, int _desY) {
		desPositionX = _desX;
		desPositionY = _desY;
	}

	public void setSelected(boolean _selected) {
		selected = _selected;
	}

	public void setType(ButtonModeEnum.buttonModeEnum _type) {
		type = _type;
	}

	public boolean getSelected() {
		return selected;
	}

	public int getSrcPosX() {
		return srcPositionX;
	}

	public int getSrcPosY() {
		return srcPositionY;
	}

	public int getDesPosX() {
		return desPositionX;
	}

	public int getDesPosY() {
		return desPositionY;
	}
	public String getSrcUUID() {
		return srcUUID;
	}
	public String getDesUUID() {
		return desUUID;
	}
	public ObjectBase.port getSrcPort() {
		return srcPort;
	}
	public ObjectBase.port getDesPort() {
		return desPort;
	}
	public ButtonModeEnum.buttonModeEnum getType() {
		return type;
	}

	public boolean inArea(Point src, Point des) {
		Point minPoint = new Point(src.x < des.x ? src.x : des.x, src.y < des.y ? src.y : des.y);
		Point maxPoint = new Point(src.x > des.x ? src.x : des.x, src.y > des.y ? src.y : des.y);
		if (minPoint.x < srcPositionX && minPoint.y < srcPositionY && maxPoint.x > desPositionX
				&& maxPoint.y > desPositionY) {
			return true;
		} else {
			return false;
		}
	}
	public abstract void printObject(Graphics g);
	public void paintBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(srcPositionX, srcPositionY, desPositionX-srcPositionX, desPositionY-srcPositionY);
	}

	@Override
	public void printComponent(Graphics g) {
		super.printComponent(g);
		printObject(g);
//		if (selected) {
//			paintBorder(g);
//		}
	}
}
