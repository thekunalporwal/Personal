package javaMiscellaneous.streamsExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstVSFindAny {
    public static void main (String[] args) {

        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

        //parallelStream() Utilize the multiple cores of the computer but doesn't maintain the order to fix this use
        // list.parallelStream().forEachOrdered(System.out::print);
        Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
        Optional<String> findAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

        System.out.println(findFirst.get()); //Always print David
        System.out.println(findAny.get()); //Random Value
    }
}
