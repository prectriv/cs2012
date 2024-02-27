public class MoreThanOnceException extends Exception {

    /**
     * Accepts a string representing a name, and throws an error to the console
     * @param candidate the name of the duplicate nominated candidate
     */
    public MoreThanOnceException(String candidate) {
        super(String.format("The candidate \"%s\" was voted for multiple times.", candidate));
    }
}
