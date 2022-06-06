package oop.project.object.line;

import java.awt.Graphics;

import layout.ButtonModeEnum;
import oop.project.SharedObject;
import oop.project.object.ObjectBase;

public class AssociationLine extends LineBase {

	/**
	 * 
	 */
	private static final int arrowLen = 15;
	private static final int arrowDegree = 25;
	private static final long serialVersionUID = -5783769642621656668L;

	public AssociationLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssociationLine(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY,
			boolean _selected, ButtonModeEnum.buttonModeEnum _type) {
		super(_srcPositionX, _srcPositionY, _desPositionX, _desPositionY, _selected, _type);
	}

	public AssociationLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, ButtonModeEnum.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}

	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(getSrcPosX(), getSrcPosY(), getDesPosX(), getDesPosY());
		double tan = (double) (getSrcPosY() - getDesPosY()) / (getSrcPosX() - getDesPosX());
		double arctan = Math.toDegrees(Math.atan(tan));
		//System.out.println("line: " + arctan + " " + tan);
		int sign = getDesPosX() > getSrcPosX() ? -1 : 1;
		int arrowX = (int) (arrowLen * Math.cos(Math.toRadians(arctan + arrowDegree)));
		int arrowY = (int) (arrowLen * Math.sin(Math.toRadians(arctan + arrowDegree)));
		g.drawLine(getDesPosX(), getDesPosY(), getDesPosX() + sign * arrowX, getDesPosY() + sign * arrowY);
		arrowX = (int) (arrowLen * Math.cos(Math.toRadians(arctan - arrowDegree)));
		arrowY = (int) (arrowLen * Math.sin(Math.toRadians(arctan - arrowDegree)));
		g.drawLine(getDesPosX(), getDesPosY(), getDesPosX() + sign * arrowX, getDesPosY() + sign * arrowY);
	}

}
