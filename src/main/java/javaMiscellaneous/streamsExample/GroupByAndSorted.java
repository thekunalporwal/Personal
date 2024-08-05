package javaMiscellaneous.streamsExample;

import InterfaceAndJavaBasics.OfflinePojo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByAndSorted {

    public static void main(String args[]) {

        OfflinePojo offlinePojo = new OfflinePojo();
        offlinePojo.setId(3);
        OfflinePojo offlinePojo2 = new OfflinePojo();
        offlinePojo2.setId(2);
        OfflinePojo offlinePojo3 = new OfflinePojo();
        offlinePojo3.setId(3);

        List<OfflinePojo> list1 = Arrays.asList(offlinePojo, offlinePojo2,offlinePojo3);
        list1 = list1.stream().sorted(Comparator.comparing(OfflinePojo::getId)).collect(Collectors.toList());


        //Grouping By is used to group it on the basis of ID
        Map<Integer ,List<OfflinePojo>> map = list1.stream().collect(Collectors.groupingBy(OfflinePojo::getId));
        System.out.println(list1);
        System.out.println(map);


        // Sorting of numbers and print the third highest from it
        List< Integer > strings= Arrays.asList(50,51,109,55,59);
        strings = strings.stream().sorted(Comparator.comparing(Integer::valueOf)).skip(2).limit(1).collect(Collectors.toList());
        System.out.println(strings);

    }
    }
