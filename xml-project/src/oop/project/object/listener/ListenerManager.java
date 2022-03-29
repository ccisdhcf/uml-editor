package oop.project.object.listener;

import java.util.EventListener;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.Arrays;

public class ListenerManager {
	public static void removeAllMouseEvent(JComponent comp) {
		List<EventListener> removeListenerList = new ArrayList<EventListener>();
		removeListenerList.addAll(Arrays.asList(comp.getMouseListeners()));
		removeListenerList.addAll(Arrays.asList(comp.getMouseMotionListeners()));
		removeListenerList.addAll(Arrays.asList(comp.getMouseWheelListeners()));
		for (EventListener listener : removeListenerList) {
			comp.removeMouseListener((MouseListener) listener);
			comp.removeMouseMotionListener((MouseMotionListener) listener);
			comp.removeMouseWheelListener((MouseWheelListener) listener);
		}
	}
	public static void removeAllMouseEvent(List<JComponent> comps) {
		for (JComponent comp : comps)
			removeAllMouseEvent(comp);
	}
	public static void addAllMouseEvent(JComponent comp, MouseAdapter mouseAdapter) {
		comp.addMouseListener(mouseAdapter);
		comp.addMouseMotionListener(mouseAdapter);
		comp.addMouseWheelListener(mouseAdapter);
	}
	public static void addAllMouseEvent(List<JComponent> comps, MouseAdapter mouseAdapter) {
		for (JComponent comp : comps)
			addAllMouseEvent(comp, mouseAdapter);
	}
//	private 
//	public void removeAllListener() {
//		
//	}
}
