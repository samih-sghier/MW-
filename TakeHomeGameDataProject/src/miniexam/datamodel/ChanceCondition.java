package miniexam.datamodel;

public class ChanceCondition implements Condition {
	double percentChance; 
	
	@SuppressWarnings("unused") // needed for Json deserialization! 
	public ChanceCondition() {  	
	}

	public ChanceCondition(double percentChance) {
		this.percentChance = percentChance;
	}
	
	@Override
	public boolean evaluate(Player p) {
		return Math.random() * 100 < percentChance;
	}

}
