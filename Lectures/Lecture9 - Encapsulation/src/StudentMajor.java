public class StudentMajor {

    public String name;
    public String major;

    public StudentMajor(String name, String major){
        this.name = name;
        this.major = major;
    }

    @Override
    public boolean equals(Object o){
        if(! (o instanceof StudentMajor)){
            return false;
        }
        StudentMajor smo = (StudentMajor) o;
        return this.name.equals(smo.name) && this.major.equals(smo.major);
    }

    @Override
    public String toString(){
        return "name: " + this.name + "; major: " + this.major;
    }
}
