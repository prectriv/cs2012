
//Blueprint
public class Dillo {
	//Properties/Fields
	//HAS
	//Data types
	//Primitive types - int, boolean, double
	int length;
	boolean isDead;
	
	//Constructor
	public Dillo(int length, boolean isDead) {
		this.length = length;
		this.isDead = isDead;
	}
	
	//Actions
	//Methods
	public boolean canShelter() {
		if(this.isDead == true && this.length > 60) {
			return true;
		}
		else {
			return false;
		}
	}
}
