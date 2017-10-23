package miniexam.datamodel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class will represent all of the data needed to 
 * load/save an adventure game.
 */
public class GameData {
	private ArrayList<Slide> slides;
	
	public GameData() { // needed for GSon
		slides = new ArrayList<Slide>();
	}

	public void addSlide(Slide slide) {

		slides.add(slide);
	}
	public Slide getSlide(int index) {
		return slides.get(index);
	}
	
	public void insertSlide(Slide slide, int index) {
		
		// TODO: Fill in this method
		
		// Note: You may also have to add getters/setters to 
		//   a few other classes in order to provide this functionality.
	}
	
}

