package miniexam.datamodel;

public class GenderChangeEffect implements Effect {
	private Gender newGender;
	
	@SuppressWarnings("unused") // needed for Json deserialization! 
	public GenderChangeEffect() {  	
	}
	
	public GenderChangeEffect(Gender newGender) {
		this.newGender = newGender;
	}

	@Override
	public void execute(Player p) {
		p.setGender(newGender);
	}

}
