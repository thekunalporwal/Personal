package javaMiscellaneous.streamsExample;

import java.util.*;
import java.util.regex.Pattern;

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
