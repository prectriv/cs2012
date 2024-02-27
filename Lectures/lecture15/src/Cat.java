public class Cat {
    String name;
    int age;

    /**
     * Make a Cat
     * @param name what the Cat is called
     * @param age the age of the cat
     * @throws NegativeIntException if the age is negative
     */
    public Cat(String name, int age) throws NegativeIntException{
        this.name = name;
        if(age < 0) {
            throw new NegativeIntException(age);
        }
    }
}
