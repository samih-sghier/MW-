package miniexam.datamodel;

public class RelationalOperator {
	public static RelationalOperator LESS_THAN = new RelationalOperator("<");
	public static RelationalOperator LESS_THAN_OR_EQUAL = new RelationalOperator("<=");
	public static RelationalOperator GREATER_THAN = new RelationalOperator(">");
	public static RelationalOperator GREATER_THAN_OR_EQUAL = new RelationalOperator(">=");
	public static RelationalOperator EQUAL = new RelationalOperator("==");
	public static RelationalOperator NOT_EQUAL = new RelationalOperator("!=");
	
	private String opcode;
	
	@SuppressWarnings("unused") // needed for Json deserialization!
	public RelationalOperator() {		
	}
	private RelationalOperator(String opcode) {
		this.opcode = opcode;
	}
	public boolean apply(double a, double b) {
		switch (opcode) {
			case "<": return a < b;
			case "<=": return a <= b;
			case ">": return a > b;
			case ">=": return a >= b;
			case "==": return a == b;
			case "!=": return a != b;
			default: throw new RuntimeException("Unknown relational operator: "+ opcode);
		}
	}
}
