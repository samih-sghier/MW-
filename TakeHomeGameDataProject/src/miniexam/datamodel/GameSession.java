package miniexam.datamodel;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
	private GameData gameData;
	private Player player;
	private int currentSlideIndex;
	private boolean gameOver;
	
	public GameSession(GameData gd) {
		this.gameData = gd;
		this.player = new Player("Unknown", Gender.UNKNOWN);
		this.currentSlideIndex = 0;
		this.gameOver = false;
	}

	public GameData getGameData() {
		return gameData;
	}

	public Player getPlayer() {
		return player;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public Slide getCurrentSlide() {
		return gameData.getSlide(currentSlideIndex);
	}
	
	public List<ActionChoice> getVisibleChoicesForCurrentSlide() {
		List<ActionChoice> allChoices = getCurrentSlide().getActionChoices();
		List<ActionChoice> visibleChoices = new ArrayList<>();
		for (ActionChoice choice : allChoices) {
			boolean thisChoiceVisible = true;
			for (Condition cond : choice.getVisibilityConditions()) {
				if (!cond.evaluate(player)) {
					thisChoiceVisible = false;
					break;
				}
			}
			if (thisChoiceVisible) {
				visibleChoices.add(choice);				
			}
		}
		return visibleChoices;
	}
	
	/**
	 * 
	 * @param choice
	 * @return a failure message (if the choice was not feasible), or the empty String "" if it was successful
	 */
	public String attemptChoice(ActionChoice choice) {
		for (Condition cond : choice.getFeasibilityConditions()) {
			if (!cond.evaluate(player)) {
				return choice.getFailureMessage();
			}
		}
		
		for (Effect e : choice.getEffects()) {
			e.execute(player);
		}
		currentSlideIndex = choice.getDestinationSlideIndex();
		return ""; // successfully took this action
	}
	

}
