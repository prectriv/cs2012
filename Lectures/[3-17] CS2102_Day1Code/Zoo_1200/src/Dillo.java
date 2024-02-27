
public class Dillo {
	//Data types: 
	//Primitive types: int, boolean, double
	
	//Properties
	//HAS
	int length;
	boolean isDead;
	
	//Constructor
	public Dillo(int length, boolean isDead) {
		this.length = length;
		this.isDead = isDead;		
	}
	
	//Methods
	//CAN DO / ACTIONS
	public boolean canShelter() {
		if (this.isDead == true && this.length > 60)
			return true;
		else
			return false;
	}
}
