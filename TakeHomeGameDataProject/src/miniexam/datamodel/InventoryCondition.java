package miniexam.datamodel;

public class InventoryCondition implements Condition {
	private String itemName;
	private RelationalOperator op;
	private int qtyToCompare;

	@SuppressWarnings("unused") // needed for Json deserialization! 
	public InventoryCondition() {		
	}
	
	
	public InventoryCondition(String itemName, RelationalOperator op, int qtyToCompare) {
		this.itemName = itemName;
		this.op = op;
		this.qtyToCompare = qtyToCompare;
	}

	@Override
	public boolean evaluate(Player p) {
		return op.apply(p.getItemQuantity(itemName),qtyToCompare);		
	}

}
