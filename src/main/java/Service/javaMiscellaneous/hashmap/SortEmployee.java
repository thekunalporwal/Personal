package Service.javaMiscellaneous.hashmap;

import java.util.Arrays;

public class SortEmployee {

    public static void main(String args[]) {

        EmployeeOwnMethods[] empArr = new EmployeeOwnMethods[4];
        empArr[0] = new EmployeeOwnMethods(10, "Mikey", 25, 10000);
        empArr[1] = new EmployeeOwnMethods(20, "Arun", 29, 20000);
        empArr[2] = new EmployeeOwnMethods(5, "Lisa", 35, 5000);
        empArr[3] = new EmployeeOwnMethods(1, "Pankaj", 32, 50000);

        Arrays.sort(empArr);
        System.out.println(Arrays.toString(empArr));

        Arrays.sort(empArr,EmployeeOwnMethods.NameComparator);
        System.out.println(Arrays.toString(empArr));

    }
}
