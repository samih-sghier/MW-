package drawer6.tool;
import java.awt.*;
import java.awt.event.MouseEvent;

import drawer6.DrawingCanvas;
import drawer6.UndoRedoHandler;
import drawer6.figure.Figure;

/**
 * This class represents tools that listen for mouse events in a drawing canvas.
 * When such an event is detected, figures in the canvas are selected,
 * unselected, or dragged, depending on where the initial mouse press occurred
 * and what figures in the canvas are selected.
 * 
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class SelectionTool extends Tool {
	/**
	 * the location of the latest mouse press or click
	 */
	private Point origin;
	/**
	 * pressInFigure is true if the mouse press or click was inside a figure
	 */
	private boolean pressedInFigure;

	public SelectionTool(UndoRedoHandler handler) {
		super(handler);
		origin = new Point(0, 0);
		pressedInFigure = false;
	}

	public void mouseClicked(MouseEvent e) {
		DrawingCanvas canvas = (DrawingCanvas) e.getSource();
		Figure figure = canvas.getFigureContaining(e.getX(), e.getY());
		pressedInFigure = (figure != null);
		if (!pressedInFigure)
			canvas.unselectAll();
		if (pressedInFigure && !figure.isSelected())
			canvas.unselectAll();
		if (pressedInFigure)
			figure.setSelected(true);
		origin.x = e.getX();
		origin.y = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		mouseClicked(e);
	}

	public void mouseReleased(MouseEvent e) {
		DrawingCanvas canvas = (DrawingCanvas) e.getSource();
		canvas.shrinkSelectionRect();
		saveState();
	}

	public void mouseDragged(MouseEvent e) {
		if (pressedInFigure)
			updateDraggingFigures(e);
		else
			updateSelectionRect(e);
	}

	/**
	 * Drags the selected figures as the mouse is dragged
	 * 
	 * @param e
	 *            the MouseEvent giving the new position of the mouse
	 */
	private void updateDraggingFigures(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		DrawingCanvas canvas = (DrawingCanvas) e.getSource();
		canvas.moveSelectedFigures(x - origin.x, y - origin.y);
		origin.x = x;
		origin.y = y;
	}

	/**
	 * Extends the selection rectangle to the point where the mouse is dragged
	 * 
	 * @param e
	 *            the MouseEvent giving the new position of the mouse
	 */
	private void updateSelectionRect(MouseEvent e) {
		DrawingCanvas canvas = (DrawingCanvas) e.getSource();
		canvas.setSelectionRect(origin, e.getPoint());
		canvas.selectFiguresIntersectingRect();
	}

}
