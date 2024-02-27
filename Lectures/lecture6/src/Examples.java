import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    @Test
    public void test_ProfSig1(){
        ProfSig mahrensSig = new ProfSig("Matthew Ahrens", "Computer Science", "Fuller Labs", 144);
        // mahrensSig.officeNum = 145; <- to update
        assertEquals("Matthew Ahrens\nComputer Science, WPI\nFuller Labs 144", mahrensSig.emailSig());
    }
    @Test
    public void test_StudentSig(){
        StudentSig sex = new StudentSig("Cee S. Tudent", "Computer Science", 27);
        assertEquals("Cee S. Tudent\nComputer Science, WPI\nClass of '27", sex.emailSig());
    }
}
