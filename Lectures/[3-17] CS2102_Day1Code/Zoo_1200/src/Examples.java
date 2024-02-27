import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

	Dillo babyDillo = new Dillo(8, false);
	Dillo hugeDeadDillo = new Dillo(65, true);
	
	@Test
	public void testBabyDillo_CannotShelter() {
		assertFalse(babyDillo.canShelter());
	}

	@Test
	public void testHugeDeadDillo_CannotShelter() {
		assertTrue(hugeDeadDillo.canShelter());
	}

	
}
