
public class ProfSig extends UniSig {
    public String name;
    public String dept;
    public String bldg;
    public Integer officeNum;

    public ProfSig(String name, String dept, String bldg, Integer officeNum){
        super(name,dept);
        this.bldg = bldg;
        this.officeNum = officeNum;
    }


    @Override
    public String lastLine() {
        return this.bldg + ", " + this.officeNum;
    }
}
