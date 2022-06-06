package oop.project.object.line;

import java.awt.Graphics;

import oop.project.object.button.ButtonMode;
import oop.project.object.ObjectBase;

public class CompositionLine extends LineBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3612946413810587827L;
	private static final int arrowLen = 10;
	private static final int arrowDegree = 20;

	public CompositionLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompositionLine(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY,
			boolean _selected, ButtonMode.buttonModeEnum _type) {
		super(_srcPositionX, _srcPositionY, _desPositionX, _desPositionY, _selected, _type);
	}

	public CompositionLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, ButtonMode.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}

	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub
		double tan = (double) (getSrcPos().getY() - getDesPos().getY()) / (getSrcPos().getX() - getDesPos().getX());
		double arctan = Math.atan(tan);
		// System.out.println(tan+" "+arctan);
		int sign = getDesPos().getX() > getSrcPos().getX() ? -1 : 1;
		int arrowX = (int) (arrowLen * Math.cos(arctan + Math.toRadians(arrowDegree)));
		int arrowY = (int) (arrowLen * Math.sin(arctan + Math.toRadians(arrowDegree)));
		int arrowX2 = (int) (arrowLen * Math.cos(arctan - Math.toRadians(arrowDegree)));
		int arrowY2 = (int) (arrowLen * Math.sin(arctan - Math.toRadians(arrowDegree)));
		g.drawLine((int) getSrcPos().getX(), (int) getSrcPos().getY(),
				(int) (getDesPos().getX() + sign * (arrowX + arrowX2)),
				(int) (getDesPos().getY() + sign * (arrowY + arrowY2)));
		g.drawLine((int) (getDesPos().getX() + sign * (arrowX + arrowX2)),
				(int) (getDesPos().getY() + sign * (arrowY + arrowY2)), (int) (getDesPos().getX() + sign * arrowX),
				(int) (getDesPos().getY() + sign * arrowY));
		g.drawLine((int) (getDesPos().getX() + sign * (arrowX + arrowX2)),
				(int) (getDesPos().getY() + sign * (arrowY + arrowY2)), (int) (getDesPos().getX() + sign * arrowX2),
				(int) (getDesPos().getY() + sign * arrowY2));

		g.drawLine((int) getDesPos().getX(), (int) getDesPos().getY(), (int) (getDesPos().getX() + sign * arrowX),
				(int) (getDesPos().getY() + sign * arrowY));
		g.drawLine((int) getDesPos().getX(), (int) getDesPos().getY(), (int) (getDesPos().getX() + sign * arrowX2),
				(int) (getDesPos().getY() + sign * arrowY2));

	}

}
