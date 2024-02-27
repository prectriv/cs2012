import java.util.LinkedList;

/**
 * Real-time Processing Major Processor
 */
public class MajorProcessor2 implements IMajorProcessor{
    LinkedList<MajorStudents> majorWithStudents = new LinkedList<MajorStudents>();

    @Override
    public LinkedList<String> getByMajor(String major) {
        //for all majors
        for(MajorStudents ms : this.majorWithStudents){
            //if major is what we want
            if(ms.major.equals(major)){
                return ms.names;
            }
            //return those students

        }
        //return an empty list if no majors found.
        return new LinkedList<String>();
    }

    @Override
    public void putInData(LinkedList<StudentMajor> sms) {
        for(StudentMajor sm : sms){
            MajorStudents foundMS = null;
            for(MajorStudents ms: this.majorWithStudents){
                if(ms.major.equals(sm.major)){
                    foundMS = ms;
                }
            }

            //if no ms list for major, make new one
            if(foundMS != null){
                foundMS.names.add(sm.name);
            } else {
                LinkedList<String> names = new LinkedList<String>();
                names.add(sm.name);
                foundMS = new MajorStudents(sm.major, names);
                this.majorWithStudents.add(foundMS);
            }
        }
    }
}
