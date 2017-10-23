package miniexam.datamodel;

public class InventoryEffect implements Effect {
	private String itemName;
	private int qtyChange;

	@SuppressWarnings("unused") // needed for Json deserialization! 
	public InventoryEffect() {		
	}
	
	public InventoryEffect(String itemName, int qtyChange) {
		this.itemName = itemName;
		this.qtyChange = qtyChange;
	}

	@Override
	public void execute(Player p) {
		p.increaseItem(itemName, qtyChange);
	}

}
