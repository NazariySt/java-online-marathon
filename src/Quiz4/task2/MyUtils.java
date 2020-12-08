package Quiz4.task2;

import java.util.*;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return getId() == student.getId() &&
                    Objects.equals(getName(), student.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> resultSet = new HashSet<>();

        for (Student st1 : list1) {

            for (Student st2 : list2) {
                if (st1.equals(st2)) {
                    resultSet.add(st2);
                }

            }

        }

        return resultSet;
    }


    public static void main(String[] args) {
        Student student1 = new Student(1, "Ivan");
        Student student2 = new Student(2, "Petro");
        Student student3 = new Student(3, "Denys");
        List<Student> list1 = new ArrayList<>();
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        Student student4 = new Student(1, "Ivan");
        Student student5 = new Student(2, "Petro");
        Student student6 = new Student(3, "Denys");
        List<Student> list2 = new ArrayList<>();
        list2.add(student4);
        list2.add(student5);
        list2.add(student6);

        MyUtils myUtils = new MyUtils();
        System.out.println( myUtils.commonStudents(list1, list2));
    }

}
