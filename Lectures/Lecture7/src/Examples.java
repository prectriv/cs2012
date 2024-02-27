import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Examples {
    ISignature me = new CSProfSig("Matthew Ahrens", "Fuller Labs", 144);
    ISignature me2 = new CSProfSig("Matthew Ahrens", "Fuller labs", 144);

    LinkedList<ISignature> sigs = new LinkedList<>();

    public Examples(){
        this.sigs.add(me);
        this.sigs.add(me2);
    }

    @Test
    public void test_ProfSig1(){
        ISignature mahrensSig = new ProfSig("Matthew Ahrens", "Computer Science", "Fuller Labs", 144);
        System.out.println(mahrensSig.emailSig());
        assertEquals("Matthew Ahrens\nComputer Science, WPI\nFuller Labs 144", mahrensSig.emailSig());
    }

    @Test
    public void test_StudentSig1(){
        ISignature ceeSig = new StudentSig("Cee S. Tudent", "Computer Science", 27);
        System.out.println(ceeSig.emailSig());
        assertEquals("Cee S. Tudent\nComputer Science, WPI\nClass of '27", ceeSig.emailSig());
    }

    @Test
    public void test_StudentSigBadCapitals(){
        ISignature ceeSig = new StudentSig("Cee S. Tudent", "computer science", 27);
        System.out.println(ceeSig.emailSig());
        assertEquals("Cee S. Tudent\nComputer Science, WPI\nClass of '27", ceeSig.emailSig());
    }

    @Test
    public void test_CSProfEq(){
        System.out.println(this.me);
        assertEquals(this.me, this.me2);
    }
}
