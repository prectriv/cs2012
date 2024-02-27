import java.util.LinkedList;

public interface IMajorProcessor {

    public LinkedList<String> getByMajor(String major);

    public void putInData(LinkedList<StudentMajor> sms);

}
