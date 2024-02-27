import java.util.Objects;

public abstract class UniAdopt extends Adoptable {

    /**
     * Creates a profile for an adoptable pet-to-be
     *
     * @param name          the name of the animal with no title(s) nor credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public UniAdopt(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Constructs a name from the adoptable pet-to-be's base name and their title and credentials
     *
     * @return the full name of the pet in "title name, cred" format.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Determines whether the current pet's name has a title and a credential
     *
     * @return true if the name is both titled and credentialed.
     */
    @Override
    public Boolean honorablyTitled() {
        if(Objects.equals(this.name, "")) return false;
        Boolean test1 = (this.name.contains("Prince") ||
                this.name.contains("Princess") ||
                this.name.contains("Duke") ||
                this.name.contains("Dutchess") ||
                this.name.contains("Duchess") ||
                this.name.contains("Baron") ||
                this.name.contains("Baroness") ||
                this.name.contains("Count") ||
                this.name.contains("Countess") ||
                this.name.contains("Judge"));

        Boolean test2 = !test1 && this.name.substring(0, 5).contains(".");
        Boolean test3 = this.name.contains(",");

        return (!(test1 && test2 && test3) && ((test1 && test3) || (test2 && test3)));
    }

    /**
     * Takes a title and adds it to the adoptable pet's name
     * If the adoptable already has a title, it should replace the old title with a new one
     *
     * @param title the title to bestow
     */
    @Override
    public void bestowTitle(String title) {
        if(this.name.contains("Prince") ||
                this.name.contains("Princess") ||
                this.name.contains("Duke") ||
                this.name.contains("Dutchess") ||
                this.name.contains("Duchess") ||
                this.name.contains("Baron") ||
                this.name.contains("Baroness") ||
                this.name.contains("Count") ||
                this.name.contains("Countess") ||
                this.name.contains("Judge")) this.name = title + " " + this.name.split(" ")[0].length();
        else this.name = title + " " + this.name;
    }

    /**
     * Takes a credential and adds it to the end of the adoptable pet's name after a ","
     * If the name already has a credential, add this credential after the current one(s) space separated
     *
     * @param credential the credential to add
     */
    @Override
    public void bestowCredential(String credential) {
        this.name = this.name.contains(",") ? this.name + " " + credential : this.name + ", " + credential;
    }
}