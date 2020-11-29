package firstQuiz;

public class Employee2 {
    private String fullName;
    private float salary;

    public Employee2(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public Employee2() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
