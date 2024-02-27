import java.util.LinkedList;

public class ProfSig extends UniSig {
    public String bldg;
    public Integer officeNum;

    public ProfSig(String name, String dept, String bldg, Integer officeNum){
        super(name, dept); // <- call UniSig's constructor
        this.bldg = bldg;
        this.officeNum = officeNum;
    }

    @Override
    public String lastLine(){
        return this.bldg + " " + this.officeNum;
    }



}
