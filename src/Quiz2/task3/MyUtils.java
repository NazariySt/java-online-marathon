package Quiz2.task3;

import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Worker> workers = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        int maxExpValue = 0;
        int maxStudyValue = 0;

        for (Person person : persons){
            if(person instanceof Worker && !workers.contains(person)){
                workers.add((Worker)person);
                if(((Worker) person).getExpirienceYears() > maxExpValue){
                    maxExpValue = ((Worker) person).getExpirienceYears();
                }
            }

            if(person instanceof Student && !students.contains(person)){
                students.add((Student)person);
                if(((Student) person).getStudyYears() > maxStudyValue){
                    maxStudyValue = ((Student) person).getStudyYears();
                }
            }
        }

        List<Person> ourListOfPersons = new ArrayList<>();
        for(Worker worker : workers){
            if(worker.getExpirienceYears() == maxExpValue) {
                ourListOfPersons.add(worker);
            }
        }
        for(Student student : students){
            if(student.getStudyYears() == maxStudyValue){
                ourListOfPersons.add(student);
            }
        }

        return ourListOfPersons;
    }
}
