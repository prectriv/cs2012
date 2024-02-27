import java.util.ArrayList;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        System.out.println(" Hello world!");

        //Declaration and initialization of an Array
        int[] intArray = new int[3]; // takes a new spot in memory for a list with 3 entries.
            intArray[0] = 10;
            intArray[1] = 20;
            intArray[2] = 30;

        //Convenience Syntax:
        int[] intArray2 = {10,20,30};

        //ArrayList                                       could add number into () to make set list length
        ArrayList<Integer> intAL = new ArrayList<Integer>(); // <- Constructor
            intAL.add(10);
            intAL.add(20);
            intAL.add(30);

        //LinkedList - List where we add new items to the front instead.
        LinkedList<Integer> intLL = new LinkedList<Integer>(); // <- Constructor
            intLL.add(10);
            intLL.add(20);
            intLL.add(30);

        //How many elements?
        //Array
        System.out.println(intArray.length);
        //ArrayList
        System.out.println(intAL.size());
        //LinkedList
        System.out.println(intLL.size());


        for(int i = 0; i < intArray.length; i++){
            //accessing it
            System.out.println(intArray[i]);
            //mutating it
            intArray[i] = intArray[i] * 2;
        }
        /*for(int i = 0; i < intAL.size(); i++){
            //accessing it
            System.out.println(intLL.get(i));
            //mutating it
            intArray[i] = intArray[i] * 2;
        }*/


        String hello = "Hello";
        String world = "world";

        String helloWorld = hello + ", " + world;
        String helloWorld2 = String.format("%s, %s", hello, world); // %s is basically a param for a minuture function; (hello, world) are inputs
        String twoPlusTwo = String.format("%d + %d = %d", 2,2,4);
        System.out.println(twoPlusTwo);

        System.out.println(helloWorld.contains("wo"));
        System.out.println("wow".contains("wo"));

        String five = Integer.toString(5);

    }
}