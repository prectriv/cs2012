import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        HashMap<String, String> colorMap = new HashMap<>();
//        colorMap.put("sky", "blue");
//        colorMap.put("water","blue");
//        colorMap.put("grass","green");
//        colorMap.put("rock", "brown");
//        colorMap.put("sun", "yellow");
//
//        System.out.println(colorMap.get("grass"));
//        System.out.println(colorMap.get("trees"));
//        System.out.println(colorMap.getOrDefault("trees","idk"));
//
//        //colorMap.entrySet(), colorMap.keySet() are not deep copies, are mutable
//
//        Set<String> keys = new HashSet<String>(); //set is an interface, no constructor.
//        keys.addAll(colorMap.keySet());
//        //this makes a safe copy for encapsulation
//
//        for(Map.Entry<String, String> keyValuePair : colorMap.entrySet()){
//            //do stuff
//        }


        HashMap<Customer, String> addressBook = new HashMap<>();
        addressBook.put(new Customer("plant", 23456789), "forest");

        System.out.println(addressBook.get(new Customer("plant", 23456789)));
        // is null unless hashcode is overwitten as it is simply returning memory address in hashcode()



    }
}