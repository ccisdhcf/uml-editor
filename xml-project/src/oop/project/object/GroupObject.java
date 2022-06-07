package oop.project.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import oop.project.SharedObject;
import oop.project.object.line.LineBase;

public class GroupObject extends ObjectBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8545686183717297656L;

	private ArrayList<ObjectBase> allObjects = new ArrayList<ObjectBase>();
	private ArrayList<Point> allObjectShift = new ArrayList<Point>();
//	private ArrayList<LineBase> allLines = new ArrayList<LineBase>();
	private Point objPoint = new Point();
//	private ArrayList<GroupObject> allGroupedObjects = new ArrayList<GroupObject>();

	public GroupObject() {
		// TODO Auto-generated constructor stub
//		allGroupedObjects = null;
//		allLines = null;
		allObjects = null;
	}

	public GroupObject(String _name /*
									 * ArrayList<LineBase> _allLines, ArrayList<ObjectBase> _allObjects
									 * ,ArrayList<GroupObject> _allGroupedObjects
									 */) {
		super(); // object Init constructor,only have uuid

		Point minPos = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Point maxPos = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
//		for (LineBase lb : _allLines) {
//			if (lb.getSelected()) {
//				allLines.add(lb);
//			}
//		}
//		for (LineBase lb : allLines) {
//			SharedObject.lines.remove(lb);
//		}
		for (ObjectBase ob : SharedObject.getInstance().shapes) {
			if (ob.getSelectedStatic()) {
				ob.setSelected(false);
				allObjects.add(ob);

				if (ob.getPosX() < minPos.x) {
					minPos.setLocation(ob.getPosX(), minPos.y);
				}
				if ((ob.getPosX() + ob.getObjectWidth()) > maxPos.x) {
					maxPos.setLocation((ob.getPosX() + ob.getObjectWidth()), maxPos.y);
				}
				if (ob.getPosY() < minPos.y) {
					minPos.setLocation(minPos.x, ob.getPosY());
				}
				if ((ob.getPosY() + ob.getObjectHeight()) > maxPos.y) {
					maxPos.setLocation(maxPos.x, (ob.getPosY() + ob.getObjectHeight()));
				}

			}
		}
//		for (ObjectBase ob : allObjects) {
//			SharedObject.shapes.remove(ob);
//		}
//		for(GroupObject go:_allGroupedObjects) {
//			if (go.getSelectedStatic()) {
//				allGroupedObjects.add(go);
//				_allGroupedObjects.remove(go);
//				if (go.getPosX()<minPos.x) {
//					minPos.setLocation(go.getPosX(),minPos.y);
//				}
//				if((go.getPosX()+go.getWidth())>maxPos.x) {
//					maxPos.setLocation(go.getPosX()+go.getWidth(), maxPos.y);
//				}
//				if (go.getPosY()<minPos.y) {
//					minPos.setLocation(minPos.x, go.getPosY());
//				}
//				if ((go.getPosY()+go.getHeight())>maxPos.y) {
//					maxPos.setLocation(maxPos.x, go.getPosY()+go.getHeight());
//				}
//			}
//		}

		setName(_name);
		objPoint.setLocation(minPos);
		for (ObjectBase ob : allObjects) {
			System.out.println("ob: " + ob.getName());
			allObjectShift.add(new Point(ob.getPosX() - objPoint.x, ob.getPosY() - objPoint.y));
		}
		setPosition(minPos.x, minPos.y);
		setWidth(maxPos.x - minPos.x);
		setHeight(maxPos.y - minPos.y);
		setIsGroup(true);

		SharedObject.getInstance().getDrawPanel().repaint();

	}

	public void ungroup() {
//		for (ObjectBase ob : allObjects) {
//			ob.setSelected(true);
//			SharedObject.shapes.add(ob);
//			
//		}
//		for (LineBase lb : allLines) {
//			SharedObject.lines.add(lb);
//		}
		SharedObject.getInstance().shapes.remove(this);
		SharedObject.getInstance().getDrawPanel().repaint();
	}

	@Override
	public void setPosition(int x, int y) {

		super.setPosition(x, y);
		for (ObjectBase ob : allObjects) {
			int index = allObjects.indexOf(ob);
			ob.setPosition(x + allObjectShift.get(index).x, y + allObjectShift.get(index).y);
		}
//		for (ObjectBase ob : allObjects) {
//			System.out.println("index: " + allObjects.indexOf(ob)+" "+allObjects.size());
//			ob.setPosition(allObjectShift.get(allObjects.indexOf(ob)).x + x,
//					allObjectShift.get(allObjects.indexOf(ob)).y + y);
//			// ob.setPosition(ob.getPosX()-objPoint.x+ x,ob.getPosY()-objPoint.y+ y );
//			System.out.println("x: " + ob.getPosX() + " " + super.getPosX() + " " + x);
//			System.out.println("y: " + ob.getPosY() + " " + super.getPosY() + " " + y);
//		}
		for (LineBase lb : SharedObject.getInstance().lines) {
			lb.getPosFromUUID(lb.getSrcUUID(), lb.getDesUUID(), lb.getSrcPort(), lb.getDesPort(), allObjects);
		}
	}

//	@Override
//	public void shiftObject(int x, int y) {
//		super.setPosition(x, y);
//		for(ObjectBase ob:allObjects) {
//			ob.shiftObject(x, y);
//		}
//		for(LineBase lb:allLines) {
//			lb.getPosFromUUID(lb.getSrcUUID(), lb.getDesUUID(), lb.getSrcPort(), lb.getDesPort(),allObjects);
//		}
//	}
	@Override
	public void paintObject(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(Color.black);
//		for (ObjectBase ob : allObjects) {
//			ob.printComponent(g);
//			
//		}
//		for (LineBase lb : allLines) {
//			lb.printComponent(g);
//		}
//		g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());

	}

	@Override
	public void paintName(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.drawString(getName(), getPosX() + getObjectWidth() / 8, getPosY() + getObjectHeight() / 2);
	}

}
