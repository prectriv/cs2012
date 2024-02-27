import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    //It's better form to have 1 assert per test, but here are a few
    @Test
    public void test_add_int(){
        assertEquals("6 + 6 should = 12", 12, 6 + 6);
    }

    @Test
    public void test_fib(){

        assertEquals("fib(5)", 5, Fib.fib(5)[5]);
        assertEquals(0.5d, 0.5d, 0.001d);
    }

    @Test
    public void test_biggest(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(7);
        list.add(3);
        assertEquals(7, Fib.biggest(list));
    }


}
