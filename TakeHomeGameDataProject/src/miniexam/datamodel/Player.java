package miniexam.datamodel;

import java.util.Set;
import java.util.TreeMap;

public class Player {
	private String name;
	private Gender gender; 
	private TreeMap<String,Integer> inventory;
	
	public Player(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
		this.inventory =  new TreeMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getItemQuantity(String itemName) {
		if (inventory.containsKey(itemName)) {
			return inventory.get(itemName);
		} else {
			return 0;
		}
	}
	public Set<String> getItemNames() {
		return inventory.keySet();
	}
	
	/**
	 * Increase/decrease the quantity of the item specified.
	 * If the number drops below 0, then it will be set to 0.
	 * @param itemName 
	 * @param deltaItems (could be negative to remove items)
	 */
	public void increaseItem(String itemName, int deltaItems) {
		int currentQuantity = getItemQuantity(itemName);
		int newQuantity = currentQuantity + deltaItems;
		if (newQuantity < 0) {
			newQuantity = 0;
		}
		inventory.put(itemName, newQuantity);		
	}
	
	
	
	
}
