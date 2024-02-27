public class Customer {
    public String name;
    public int phoneNumber;

    public Customer(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //need to override both of these for the hashmap to work properly.
    //later versions of java, use record keyword
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Customer)){
            return false;
        }

        Customer c = (Customer) o;
        return this.name.equals(c.name) &&
                this.phoneNumber == c.phoneNumber;
    }

    @Override
    public int hashCode(){
        //return this.phoneNumber;
        //this would work, but if multiple people with same phone number the .get will return a large linked list

        return (13 * this.name.hashCode()) + (23 * this.phoneNumber); // "minimize collisions"
        // multiply by primes to make it more unique (harder to divide). Ideally use a very large prime

    }
}
