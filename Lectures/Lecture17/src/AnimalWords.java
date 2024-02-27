
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class AnimalWords implements IWords{

    private LinkedList<String> animals = new LinkedList<>();
    public AnimalWords() throws IOException {
        //https://gist.githubusercontent.com/atduskgreg/3cf8ef48cb0d29cf151bedad81553a54/raw/82f142562cf50b0f6fb8010f890b2f934093553e/animals.txt
        FileInputStream in = new FileInputStream("Animals.txt"); //"borrowed" from github
        Scanner reader = new Scanner(in);
        while(reader.hasNext()){
            String line = reader.nextLine();
            if(! line.contains(" ") && ! line.equals("list")){
                animals.add(line.trim());
            }
        }
        in.close();
    }
    @Override
    public String[] getWords() {
        return this.animals.toArray(new String[0]);
    }

    @Override
    public String randomWord() {
        Random r = new Random();
        return animals.get(r.nextInt(animals.size()));
    }
}
