package miniexam.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Slide {
	private String title;
	private String storyText;
	private String imageFileName;
	private ArrayList<ActionChoice> actionChoices;

	public Slide() {
		title = "";
		storyText = "An awesome place";
		imageFileName = "";
	}

	public Slide(String title, String storyText, String imageFileName) {
		this.title = title;
		this.storyText = storyText;
		this.imageFileName = imageFileName;
		this.actionChoices = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStoryText() {
		return storyText;
	}

	public void setStoryText(String storyText) {
		this.storyText = storyText;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<ActionChoice> getActionChoices() {
		return actionChoices;
	}

	public void setActionChoices(ArrayList<ActionChoice> actionChoices) {
		this.actionChoices = actionChoices;
	}

}
