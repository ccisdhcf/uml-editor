package oop.project.object.line;

import java.awt.Graphics;

import oop.project.SharedObject;
import oop.project.object.ObjectBase;

public class CompositionLine extends LineBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3612946413810587827L;
	private static final int arrowLen=15;
	private static final int arrowDegree=35;
	public CompositionLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompositionLine(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY, boolean _selected,
			SharedObject.buttonModeEnum _type) {
		super(_srcPositionX,_srcPositionY,_desPositionX,_desPositionY,_selected,_type);	
	}
	public CompositionLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, SharedObject.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}
	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub
		double tan=(getSrcPosY()-getDesPosY())/(getSrcPosX()-getDesPosX());
		double arctan=Math.atan(tan);
		// System.out.println(tan+" "+arctan);
		int arrowX=(int) (arrowLen*Math.sin(arctan+Math.toRadians(arrowDegree)));
		int arrowY=(int) (arrowLen*Math.cos(arctan+Math.toRadians(arrowDegree)));
		int arrowX2=(int) (arrowLen*Math.sin(arctan-Math.toRadians(arrowDegree)));
		int arrowY2=(int) (arrowLen*Math.cos(arctan-Math.toRadians(arrowDegree)));
		g.drawLine(getSrcPosX(), getSrcPosY(), getDesPosX()-(arrowX+arrowX2), getDesPosY()-(arrowY+arrowY2));
		g.drawLine(getDesPosX()-(arrowX+arrowX2), getDesPosY()-(arrowY+arrowY2), getDesPosX()-arrowX, getDesPosY()-arrowY);
		g.drawLine(getDesPosX()-(arrowX+arrowX2), getDesPosY()-(arrowY+arrowY2), getDesPosX()-arrowX2, getDesPosY()-arrowY2);
		
		g.drawLine(getDesPosX(),getDesPosY(), getDesPosX()-arrowX, getDesPosY()-arrowY);
		g.drawLine(getDesPosX(),getDesPosY(), getDesPosX()-arrowX2, getDesPosY()-arrowY2);
		//g.drawLine(getDesPosX()-arrowX, getDesPosY()-arrowY,  getDesPosX()-arrowX2, getDesPosY()-arrowY2);
		
	}

}
