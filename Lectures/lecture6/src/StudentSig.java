public class StudentSig extends UniSig {
    public String name;
    public String dept;
    public Integer gradYear;

    public StudentSig(String name, String dept, Integer gradYear){
        super(name, dept);
        this.gradYear = gradYear;
    }

    @Override
    public String lastLine() {
        return "Class of '" + this.gradYear;
    }
}
