public class AlreadyNominatedException extends Exception {

    /**
     * Accepts a string representing a name, and throws an error to the console
     * @param name the name of the already nominated candidate
     */
    public AlreadyNominatedException(String name){
        super(String.format("The candidate \"%s\" was already nominated.", name));
    }
}
