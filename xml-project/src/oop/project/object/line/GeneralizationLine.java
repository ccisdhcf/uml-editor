package oop.project.object.line;

import java.awt.Graphics;

import oop.project.object.button.ButtonMode;
import oop.project.object.ObjectBase;

public class GeneralizationLine extends LineBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5041532512403620798L;

	private static final int arrowLen = 15;
	private static final int arrowDegree = 25;

	public GeneralizationLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneralizationLine(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY,
			boolean _selected, ButtonMode.buttonModeEnum _type) {
		super(_srcPositionX, _srcPositionY, _desPositionX, _desPositionY, _selected, _type);
	}

	public GeneralizationLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, ButtonMode.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}

	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub
		double tan = (double) (getSrcPos().getY() - getDesPos().getY()) / (getSrcPos().getX() - getDesPos().getX());
		double arctan = Math.atan(tan);
		// System.out.println(tan+" "+arctan);
		int arrowX = (int) (arrowLen * Math.cos(arctan + Math.toRadians(arrowDegree)));
		int arrowY = (int) (arrowLen * Math.sin(arctan + Math.toRadians(arrowDegree)));
		int arrowX2 = (int) (arrowLen * Math.cos(arctan - Math.toRadians(arrowDegree)));
		int arrowY2 = (int) (arrowLen * Math.sin(arctan - Math.toRadians(arrowDegree)));
		int sign = getDesPos().getX() > getSrcPos().getX() ? -1 : 1;
		g.drawLine((int) getSrcPos().getX(), (int) getSrcPos().getY(),
				(int) (getDesPos().getX() + sign * (arrowX + arrowX2) / 2),
				(int) (getDesPos().getY() + sign * (arrowY + arrowY2) / 2));

		g.drawLine((int) getDesPos().getX(), (int) getDesPos().getY(), (int) (getDesPos().getX() + sign * arrowX),
				(int) (getDesPos().getY() + sign * arrowY));

		g.drawLine((int) getDesPos().getX(), (int) getDesPos().getY(), (int) (getDesPos().getX() + sign * arrowX2),
				(int) (getDesPos().getY() + sign * arrowY2));
		g.drawLine((int) (getDesPos().getX() + sign * arrowX), (int) (getDesPos().getY() + sign * arrowY),
				(int) (getDesPos().getX() + sign * arrowX2), (int) (getDesPos().getY() + sign * arrowY2));

	}

}
