package Quiz4.task6;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int compareByNames = o1.name.compareTo(o2.name);
        if(compareByNames == 0){
            if(o1.getAge() == o2.getAge()){
                return 0;
            }
            if(o1.getAge() > o2.getAge()){
                return 1;
            }
            return -1;
        }
        return compareByNames;
    }
}
