public abstract class UniSig implements ISignature {
    public String name;
    public String dept;
    public UniSig(String name, String dept){
        this.name = name;
        this.dept = dept;
    }
    public abstract String lastLine();

    @Override
    public String emailSig(){
        return String.format("%s\n%s, WPI\n%s",
            this.name, this.dept, this.lastLine());

    }
}
