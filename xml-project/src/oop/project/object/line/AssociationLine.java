package oop.project.object.line;

import java.awt.Graphics;

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
			boolean _selected, SharedObject.buttonModeEnum _type) {
		super(_srcPositionX, _srcPositionY, _desPositionX, _desPositionY, _selected, _type);
	}

	public AssociationLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, SharedObject.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}

	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(getSrcPosX(), getSrcPosY(), getDesPosX(), getDesPosY());
		double tan = (getSrcPosY() - getDesPosY()) / (getSrcPosX() - getDesPosX());
		double arctan = Math.atan(tan);
		int arrowX = (int) (arrowLen * Math.sin(arctan + Math.toRadians(arrowDegree)));
		int arrowY = (int) (arrowLen * Math.cos(arctan + Math.toRadians(arrowDegree)));
		g.drawLine(getDesPosX(), getDesPosY(), getDesPosX() - arrowX, getDesPosY() - arrowY);
		arrowX = (int) (arrowLen * Math.sin(arctan - Math.toRadians(arrowDegree)));
		arrowY = (int) (arrowLen * Math.cos(arctan - Math.toRadians(arrowDegree)));
		g.drawLine(getDesPosX(), getDesPosY(), getDesPosX() - arrowX, getDesPosY() - arrowY);
		System.out.println(tan + " " + arctan);
	}

}
