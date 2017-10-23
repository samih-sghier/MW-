package miniexam.datamodel;

public class GenderCondition implements Condition {

	private Gender genderToCheck;
	
	@SuppressWarnings("unused") // needed for Json deserialization! 
	public GenderCondition() {  	
	}
	
	public GenderCondition(Gender genderToCheck) {
		this.genderToCheck = genderToCheck;
	}

	@Override
	public boolean evaluate(Player p) {
		return p.getGender() == genderToCheck;
	}

}
