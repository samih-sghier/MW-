package drawer6;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import drawer6.tool.Tool;

/**
 * This class acts as listeners for clicks to the buttons in the toolbar and for
 * clicks in the canvas. It causes a rectangle, square, or ellipse, depending on
 * the last clicked button, to be drawn centered at the click.
 * 
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class CanvasEditor implements MouseListener, MouseMotionListener {
	/*
	 * This class uses the State pattern. It passes all the listening
	 * responsibilities to the currentTool.
	 */

	private Tool currentTool;

	public CanvasEditor(Tool initialTool) {
		this.currentTool = initialTool;
	}

	public void setCurrentTool(Tool newTool) {
		currentTool = newTool;
	}

	public void mouseClicked(MouseEvent e) {
		currentTool.mouseClicked(e);
	}

	public void mousePressed(MouseEvent e) {
		currentTool.mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		currentTool.mouseReleased(e);
	}

	public void mouseEntered(MouseEvent e) {
		currentTool.mouseEntered(e);
	}

	public void mouseExited(MouseEvent e) {
		currentTool.mouseExited(e);
	}

	public void mouseDragged(MouseEvent e) {
		currentTool.mouseDragged(e);
	}

	public void mouseMoved(MouseEvent e) {
		currentTool.mouseMoved(e);
	}
}
