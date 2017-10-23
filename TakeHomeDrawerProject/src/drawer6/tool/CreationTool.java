package drawer6.tool;
import java.awt.event.MouseEvent;

import drawer6.DrawingCanvas;
import drawer6.UndoRedoHandler;
import drawer6.figure.Figure;

/**
 * This class represents tools that listen for mouse clicks in a drawing canvas.
 * When such a click is detected, a new figure is drawn on the drawing canvas.
 * The CreationTool draws the figure passed to its constructor as a parameter.
 * 
 * 
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class CreationTool extends Tool {
	private Figure myFigure;

	public CreationTool(Figure s, UndoRedoHandler handler) {
		super(handler);
		myFigure = s;
	}

	public void mouseClicked(MouseEvent e) {
		Figure newFigure = (Figure) myFigure.clone();
		newFigure.moveTo(e.getX() - newFigure.getBoundingRect().width / 2, e
				.getY()
				- newFigure.getBoundingRect().height / 2);
		DrawingCanvas canvas = (DrawingCanvas) e.getSource();
		canvas.addFigure(newFigure);
		canvas.unselectAll();
		canvas.selectFigure(newFigure);
		saveState();
	}
}
