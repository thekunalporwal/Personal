package Service.javaMiscellaneous.hashmap;

import lombok.ToString;

import java.util.Comparator;

@ToString
public class EmployeeOwnMethods implements Comparable<EmployeeOwnMethods> {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public EmployeeOwnMethods(int id2, String name, int age, int salary) {
        this.id = id2;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(EmployeeOwnMethods emp) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object
        System.out.println("own compareTo");
        return (this.id - emp.id);
    }

    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<EmployeeOwnMethods> SalaryComparator = new Comparator<EmployeeOwnMethods>() {

        @Override
        public int compare(EmployeeOwnMethods e1, EmployeeOwnMethods e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    /**
     * Comparator to sort employees list or array in order of Age
     */
    public static Comparator<EmployeeOwnMethods> AgeComparator = new Comparator<EmployeeOwnMethods>() {

        @Override
        public int compare(EmployeeOwnMethods e1, EmployeeOwnMethods e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    /**
     * Comparator to sort employees list or array in order of Name
     */
    public static Comparator<EmployeeOwnMethods> NameComparator = new Comparator<EmployeeOwnMethods>() {

        @Override
        public int compare(EmployeeOwnMethods e1, EmployeeOwnMethods e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
}