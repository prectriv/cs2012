
public class Main {

	public static void main(String[] args) {
		//Instantiating the class
		//Object
		Dillo babyDillo = new Dillo(8, false);

		Dillo adultDillo = new Dillo(24, false);
		Dillo hugeDeadDillo = new Dillo(65, true);
		System.out.println(hugeDeadDillo.canShelter());
		
		Boa fred = new Boa("Fred", 20, "mice");
		System.out.println(fred.eats);
	}

}
