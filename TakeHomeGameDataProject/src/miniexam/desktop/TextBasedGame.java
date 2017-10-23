package miniexam.desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import miniexam.datamodel.ActionChoice;
import miniexam.datamodel.Effect;
import miniexam.datamodel.GameData;
import miniexam.datamodel.GameDataTester;
import miniexam.datamodel.GameSession;
import miniexam.datamodel.Player;
import miniexam.datamodel.Slide;

public class TextBasedGame {
	private static final Scanner CONSOLE = new Scanner(System.in);
	private static GameSession session;
	
	public static void main(String[] args) {
			session = new GameSession(GameDataTester.getTestGameData());
			playGame();
	}
	
	/** Actually play the game stored in this GameData */
	public static void playGame() {
		
		while (!session.isGameOver()) {
			displayCurrentSlide();
			ActionChoice choice = getUserChoice();
			String failMessage = session.attemptChoice(choice);
			if (failMessage.length() > 0) {
				System.out.println("\n" + failMessage);
				CONSOLE.nextLine();
				CONSOLE.nextLine();
			}
		}		
	}
	
	public static void displayCurrentSlide() {
		Slide curSlide = session.getCurrentSlide();
		System.out.println();
		System.out.println("TITLE: " + curSlide.getTitle());
		System.out.println("(imagine the image " + curSlide.getImageFileName() + ")");
		System.out.println(curSlide.getStoryText());
		
		Player player = session.getPlayer();
		System.out.println("You are " + player.getGender() 
								+ " and your name is " + player.getName());
		System.out.println("You have:");
		for (String item : player.getItemNames()) {
			int howMany = player.getItemQuantity(item);
			System.out.println("  " + item + ": " + howMany);
		}
		System.out.println();
	}
	
	public static ActionChoice getUserChoice() {
		List<ActionChoice> choices = session.getVisibleChoicesForCurrentSlide();
		for (int i = 0; i < choices.size(); i++) {
			ActionChoice choice = choices.get(i);
			System.out.println((i + 1) +": " + choice.getChoiceText());			
		}
		System.out.print("What's your choice? ");
		int choiceIndex = CONSOLE.nextInt() - 1;
		return choices.get(choiceIndex);		
	}
	
	/**
	 * @param textFile - the text file to load
	 * @return a string with the full contents of that file
	 * @throws FileNotFoundException 
	 */
	public static String loadTextFromFile(File textFile) throws FileNotFoundException {
		Scanner scan = new Scanner(textFile);  
		scan.useDelimiter("\\Z");  
		String content = scan.next();
		scan.close();
		return content;
	}

}
