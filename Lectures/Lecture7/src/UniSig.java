public abstract class UniSig implements ISignature {
    public String name;
    public String dept;

    public UniSig(String name, String dept){
        this.name = name;
        // Example we didn't get to in class, but what if we wanted to
        // Enforce capitalization on first letter of each:
        this.dept = "";
        String[] deptParts = dept.split(" "); // get String
        for(String deptPart : deptParts) {
            if (deptPart.length() > 0) {
                String firstLetter = deptPart.substring(0, 1);
                this.dept = this.dept + firstLetter.toUpperCase() + deptPart.substring(1) + " ";
            }
        }
        this.dept = this.dept.trim();

    }

    /**
     * The last line of a signature is role-specific
     * @return the concrete class specific last line of an email signature
     */
    public abstract String lastLine();

    @Override
    public String emailSig() {
        String line = this.lastLine();
        return String.format("%s\n%s, WPI\n%s", this.name, this.dept, line);
    }
}
