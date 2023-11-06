package javaMiscellaneous.streamsExample;

import java.util.*;
import java.util.regex.Pattern;

public class FindFirstVSFindAny {
    public static void main (String[] args) {
        Long value=2l;
        Long val=3l;

        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jillk","Dany","Julia","Jenish","Divya");

        //parallelStream() Utilize the multiple cores of the computer but doesn't maintain the order to fix this use
        // list.parallelStream().forEachOrdered(System.out::print);
        Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();

        // Explain the difference between findFirst and findAny?
        // Answer: findFirst() returns the first element in the stream whereas findAny() returns any element in the stream.
        // findFirst() is faster than findAny() when called on a parallel stream whereas findAny() is useful when called on a
        // sequential stream in which the first element is returned.

        // findAny() is useful when we are working with a parallel stream because it is easier to parallelize.
        // findFirst() is useful when we are working with a sequential stream because it is easier to optimize.
        // findAny() is useful when we are more interested in the result than the order.
        // findFirst() is useful when we are more interested in the order than the result.
        Optional<String> findAny = lst2.parallelStream().filter(s -> value.equals(val) && s.startsWith("J") && s.endsWith("k")).findAny();

        System.out.println(findFirst.get());

        List<Map<String, Object>> bulkDetails=new ArrayList<>();

        Map<String, Object> bulkdetails1=new HashMap<>();
        bulkdetails1.put("payload","†Documents Pending");
        bulkdetails1.put("mid","hehehe");

        Map<String, Object> bulkdetails2=new HashMap<>();
        bulkdetails2.put("payload","HiDocuments Pending");
        bulkDetails.add(bulkdetails2);
        bulkDetails.add(bulkdetails1);


        Pattern genericBulkFileRecordsPattern = Pattern.compile("[^\\x00-\\x7F]+", Pattern.MULTILINE);
        Optional<Map<String, Object>> findAnyBulk =bulkDetails.parallelStream().filter(bulk -> genericBulkFileRecordsPattern.matcher(bulk.get("payload").toString()).find()).findAny();
        System.out.println("Kya aaya" +findAnyBulk.get().get("mid")); //Random Value




    }
}
