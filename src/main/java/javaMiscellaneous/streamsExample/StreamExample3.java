package javaMiscellaneous.streamsExample;

import java.util.ArrayList;
import java.util.List;

public class StreamExample3 {

     public static class Employee{
         public String salary;
         public Employee (String salary){
             this.salary=salary;
         }
     }

    public static void main (String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("5000"));
        list.add(new Employee("6000"));
        list.add(new Employee("4000"));
        list.add(new Employee("2000"));

       int value =list.stream()
                .map(employ -> employ.salary)
                .map(Integer::parseInt)
                .filter(emp-> emp.equals(1000))
                .findAny()
                .orElse(1);

       System.out.println("Value find is " +value);
    }

}
