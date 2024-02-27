import java.util.LinkedList;

/**
 * Batch-processing major processor
 */
public class MajorProcessor1 implements IMajorProcessor{
    LinkedList<StudentMajor> sms = new LinkedList<>();
    @Override
    public LinkedList<String> getByMajor(String major) {
        //declare a LinkedList to return
        LinkedList<String> names = new LinkedList<String>();
        //find all students for a particular major
        for(StudentMajor sm : this.sms){
            if(sm.major.equals(major)) names.add(sm.name);
        }
        //return that list
        return names;
    }

    @Override
    public void putInData(LinkedList<StudentMajor> sms) {
        //store without processing
        this.sms.addAll(sms);
    }
}
