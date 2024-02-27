import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {

    @Test
    public void test_cat(){
        try {
            Cat c = new Cat("Yan", -5);
            assertEquals(5, c.age);
        } catch (NegativeIntException e){

        }
    }
}
