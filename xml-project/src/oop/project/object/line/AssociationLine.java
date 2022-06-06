package oop.project.object.line;

import java.awt.Graphics;

import oop.project.object.button.ButtonMode;
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
			boolean _selected, ButtonMode.buttonModeEnum _type) {
		super(_srcPositionX, _srcPositionY, _desPositionX, _desPositionY, _selected, _type);
	}

	public AssociationLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, ButtonMode.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}

	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub

		g.drawLine((int) getSrcPos().getX(), (int) getSrcPos().getY(), (int) getDesPos().getX(),
				(int) getDesPos().getY());
		double tan = (double) (getSrcPos().getY() - getDesPos().getY()) / (getSrcPos().getX() - getDesPos().getX());
		double arctan = Math.toDegrees(Math.atan(tan));
		// System.out.println("line: " + arctan + " " + tan);
		int sign = getDesPos().getX() > getSrcPos().getX() ? -1 : 1;
		int arrowX = (int) (arrowLen * Math.cos(Math.toRadians(arctan + arrowDegree)));
		int arrowY = (int) (arrowLen * Math.sin(Math.toRadians(arctan + arrowDegree)));
		g.drawLine((int) getDesPos().getX(), (int) getDesPos().getY(), (int) (getDesPos().getX() + sign * arrowX),
				(int) (getDesPos().getY() + sign * arrowY));
		arrowX = (int) (arrowLen * Math.cos(Math.toRadians(arctan - arrowDegree)));
		arrowY = (int) (arrowLen * Math.sin(Math.toRadians(arctan - arrowDegree)));
		g.drawLine((int) getDesPos().getX(), (int) getDesPos().getY(), (int) (getDesPos().getX() + sign * arrowX),
				(int) (getDesPos().getY() + sign * arrowY));
	}

}
