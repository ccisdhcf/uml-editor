package oop.project.object.line;

import java.awt.Graphics;

import layout.ButtonModeEnum;
import oop.project.SharedObject;
import oop.project.object.ObjectBase;

public class CompositionLine extends LineBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3612946413810587827L;
	private static final int arrowLen=10;
	private static final int arrowDegree=20;
	public CompositionLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompositionLine(int _srcPositionX, int _srcPositionY, int _desPositionX, int _desPositionY, boolean _selected,
			ButtonModeEnum.buttonModeEnum _type) {
		super(_srcPositionX,_srcPositionY,_desPositionX,_desPositionY,_selected,_type);	
	}
	public CompositionLine(String _srcUUID, String _desUUID, ObjectBase.port _srcPort, ObjectBase.port _desPort,
			boolean _selected, ButtonModeEnum.buttonModeEnum _type) {
		super(_srcUUID, _desUUID, _srcPort, _desPort, _selected, _type);
	}
	@Override
	public void printObject(Graphics g) {
		// TODO Auto-generated method stub
	    double tan=(double)(getSrcPosY()-getDesPosY())/(getSrcPosX()-getDesPosX());
	    double arctan=Math.atan(tan);
	    // System.out.println(tan+" "+arctan);
	    int sign = getDesPosX() > getSrcPosX() ? -1 : 1;
	    int arrowX=(int) (arrowLen*Math.cos(arctan+Math.toRadians(arrowDegree)));
	    int arrowY=(int) (arrowLen*Math.sin(arctan+Math.toRadians(arrowDegree)));
	    int arrowX2=(int) (arrowLen*Math.cos(arctan-Math.toRadians(arrowDegree)));
	    int arrowY2=(int) (arrowLen*Math.sin(arctan-Math.toRadians(arrowDegree)));
	    g.drawLine(getSrcPosX(), getSrcPosY(), getDesPosX()+sign*(arrowX+arrowX2), getDesPosY()+sign*(arrowY+arrowY2));
	    g.drawLine(getDesPosX()+sign*(arrowX+arrowX2), getDesPosY()+sign*(arrowY+arrowY2), getDesPosX()+sign*arrowX, getDesPosY()+sign*arrowY);
	    g.drawLine(getDesPosX()+sign*(arrowX+arrowX2), getDesPosY()+sign*(arrowY+arrowY2), getDesPosX()+sign*arrowX2, getDesPosY()+sign*arrowY2);
	    
	    g.drawLine(getDesPosX(),getDesPosY(), getDesPosX()+sign*arrowX, getDesPosY()+sign*arrowY);
	    g.drawLine(getDesPosX(),getDesPosY(), getDesPosX()+sign*arrowX2, getDesPosY()+sign*arrowY2);
		
	}

}
