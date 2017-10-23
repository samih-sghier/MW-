package miniexam.datamodel;

import java.util.ArrayList;
import java.util.List;

public class ActionChoice {
	private String choiceText = "";
	private int destinationSlideIndex = -1;
	private ArrayList<Effect> effects = new ArrayList<>();
	private ArrayList<Condition> visibilityConditions = new ArrayList<>();
	private ArrayList<Condition> feasibilityConditions = new ArrayList<>();
	private String failureMessage; // message shown if the action isn't feasible

	public ActionChoice() {
		failureMessage = "Sorry, you failed.";
	}
	
	public ActionChoice(String choiceText, int destinationSlideIndex) {
		this();
		this.choiceText = choiceText;
		this.destinationSlideIndex = destinationSlideIndex;
	}

	public String getChoiceText() {
		return choiceText;
	}

	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}

	public int getDestinationSlideIndex() {
		return destinationSlideIndex;
	}

	public void setDestinationSlideIndex(int destinationSlideIndex) {
		this.destinationSlideIndex = destinationSlideIndex;
	}
	
	public List<Effect> getEffects() {
		return effects;
	}

	public List<Condition> getVisibilityConditions() {
		return visibilityConditions;
	}

	public List<Condition> getFeasibilityConditions() {
		return feasibilityConditions;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	
	

	
	
}
