package oop.project.object.line;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JComponent;

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
	private SharedObject.buttonModeEnum type;

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
		type = SharedObject.buttonModeEnum.nullMode;
	}

	public LineBase(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY, boolean _selected,
			SharedObject.buttonModeEnum _type) {
		srcPositionX = _srcPositionX;
		srcPositionY = _srcPositionY;
		desPositionX = _desPositionX;
		desPositionY = _desPositionY;
		type = _type;
		selected = _selected;
	}	
	public LineBase(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort, boolean _selected,
			SharedObject.buttonModeEnum _type) {
		srcUUID=_srcUUID;
		desUUID=_desUUID;
		srcPort=_srcPort;
		desPort=_desPort;
		getPos(srcUUID, desUUID, srcPort, desPort);
		type = _type;
		selected = _selected;
	}
	public void getPos(String _srcUUID,String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort) {
		for (ObjectBase ob:SharedObject.shapes) {
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

	public void setType(SharedObject.buttonModeEnum _type) {
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
	public SharedObject.buttonModeEnum getType() {
		return type;
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
		if (selected) {
			paintBorder(g);
		}
	}
}
