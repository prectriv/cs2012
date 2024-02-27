public class CSProfSig extends ProfSig {

    public CSProfSig(String name, String bldg, Integer officeNum) {
        super(name, "Computer Science", bldg, officeNum);
    }

    // Method Overloading: Multiple constructors with diff param lists
    public CSProfSig(String name, String dept, String bldg, Integer officeNum) {
        super(name,
                !dept.equals("Computer Science") ? dept + "& Computer Science" : "Computer Science",
                bldg,
                officeNum);
    }

    @Override
    public boolean equals(Object o){
        if(! (o instanceof CSProfSig)){
            return false;
        }

        CSProfSig otherSig = (CSProfSig) o;

        return this.bldg.equals(otherSig.bldg) &&
                this.officeNum.equals(otherSig.officeNum) &&
                this.name.equals(otherSig.name) &&
                this.dept.equals(otherSig.dept);
    }

    @Override
    public String toString() {
        return this.emailSig();
    }


}
