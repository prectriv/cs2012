public class StudentSig extends UniSig {

    public Integer classOf;

    public StudentSig(String name, String depts, Integer classOf){
        super(name, depts);
        this.classOf = classOf;
    }

    public String lastLine(){
        return "Class of '" + classOf;
    }

}
