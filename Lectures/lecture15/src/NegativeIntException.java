public class NegativeIntException extends Exception { // needs no body, exception does everything itself

    public NegativeIntException(int age){
        super(String.format("Can't use %d as an age.", age));
    }


}
