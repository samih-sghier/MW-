package drawer6;
import java.util.Stack;

/**
 * This class is responsible for all the information needed in order to undo or
 * redo an action in the drawing canvas.
 * 
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class UndoRedoHandler {
	private Stack<DrawingCanvas.State> undoStack, redoStack;
	// invariant: The top state of the undoStack always is a copy of the
	// current state of the canvas.
	private DrawingCanvas canvas;

	/**
	 * constructor
	 * 
	 * @param canvas
	 *            the DrawingCanvas whose changes are saved for later
	 *            restoration.
	 */
	public UndoRedoHandler(DrawingCanvas canvas) {
		undoStack = new Stack<DrawingCanvas.State>();
		redoStack = new Stack<DrawingCanvas.State>();
		this.canvas = canvas;
		// store the initial state of the canvas on the undo stack
		undoStack.push(canvas.createMemento());
	}

	/**
	 * saves the current state of the drawing canvas for later restoration
	 */
	public void saveState() {
		DrawingCanvas.State canvasState = canvas.createMemento();
		undoStack.push(canvasState);
		redoStack.clear();
	}

	/**
	 * restores the state of the drawing canvas to what it was before the last
	 * change. Nothing happens if there is no previous state (for example, when
	 * the application first starts up or when you've already undone all actions
	 * since the startup state).
	 */
	public void undo() {
		if (undoStack.size() == 1) // only the current state is on the stack
			return;

		DrawingCanvas.State canvasState = undoStack.pop();
		redoStack.push(canvasState);
		canvas.restoreState(undoStack.peek());
	}

	/**
	 * restores the state of the drawing canvas to what it was before the last
	 * undo action was performed. If some change was made to the state of the
	 * canvas since the last undo, then this method does nothing.
	 */
	public void redo() {
		if (redoStack.isEmpty())
			return;

		DrawingCanvas.State canvasState = redoStack.pop();
		undoStack.push(canvasState);
		canvas.restoreState(canvasState);
	}
}
