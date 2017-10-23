package miniexam.datamodel;

public class GameDataTester {

	public static void main(String[] args) {
						
		//System.out.println("Slide 0 has this image: ");
		//System.out.println(gdRecreated.getSlide(0).getImageFileName());
		
	}
	
	public static GameData getTestGameData() {
		GameData gd = new GameData();
		Slide s0 = new Slide("Room 0", "A boring room", "slide_000.png");
		ActionChoice bananaChoice = new ActionChoice("go to jungle and get bananas", 1);
		bananaChoice.getEffects().add(new InventoryEffect("bananas", 42));
		bananaChoice.getFeasibilityConditions().add(new ChanceCondition(42.42));
		
		s0.getActionChoices().add(bananaChoice);
		s0.getActionChoices().add(new ActionChoice("go to emu farm", 2));
		Slide s1 = new Slide("Room 1", "A jungle", "slide_001.png");
		ActionChoice maleChoice = new ActionChoice("become male", 1);
		maleChoice.getEffects().add(new GenderChangeEffect(Gender.MALE));
		ActionChoice femaleChoice = new ActionChoice("become female", 1);
		femaleChoice.getEffects().add(new GenderChangeEffect(Gender.FEMALE));
		s1.getActionChoices().add(maleChoice);
		s1.getActionChoices().add(femaleChoice);
		s1.getActionChoices().add(new ActionChoice("go to emu farm", 2));
		Slide s2 = new Slide("Room 2", "An emu farm", "slide_002.png");
		s2.getActionChoices().add(new ActionChoice("go back to room 0", 0));
		ActionChoice condChoice = new ActionChoice("try to use bananas to win!", 3);
		condChoice.getVisibilityConditions().add(new InventoryCondition("bananas", RelationalOperator.GREATER_THAN_OR_EQUAL, 1));
		condChoice.getFeasibilityConditions().add(new InventoryCondition("bananas", RelationalOperator.GREATER_THAN_OR_EQUAL, 100));
		condChoice.setFailureMessage("Sorry, not enough bananas.");
		s2.getActionChoices().add(condChoice);
		Slide s3 = new Slide("Wonderland", "Your happy emu place.", "slide_win.png");
		 
		
		gd.addSlide(s0);
		gd.addSlide(s1);
		gd.addSlide(s2);
		gd.addSlide(s3);
		return gd;
	}

}
