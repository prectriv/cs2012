
public class Main {

	public static void main(String[] args) {
		// Instantianting the class
		// Object
		Dillo babyDillo = new Dillo(8, false);
		Dillo adultDillo = new Dillo(24, false);
		Dillo hugeDeadDillo = new Dillo(65, true);

		System.out.println(babyDillo.canShelter());
		System.out.println(adultDillo.canShelter());
		System.out.println(hugeDeadDillo.canShelter());

		Boa fred = new Boa("Fred", 20, "mice");

		System.out.println(fred.eats);
	}

}
