public class CandidateNotNominatedException extends Exception {
    private String candidate;

    /**
     * Accepts a string representing a name, and throws an error to the console
     * 
     * @param candidate the name of the non-nominated candidate
     */
    public CandidateNotNominatedException(String candidate) {
        super(String.format("The candidate \"%s\" has no been nominated.", candidate));
        this.candidate = candidate;
    }

    /**
     * returns the name of the candidate that wasn't nominated properly
     */
    public String getCandidate() {
        // return candidate;
        return this.candidate;

    }
}
