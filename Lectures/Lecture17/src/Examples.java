import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Examples {

    @Test
    public void test_animalwords() throws IOException {
        AnimalWords aw = new AnimalWords();
        assertEquals(400, aw.getWords().length);
    }
}
