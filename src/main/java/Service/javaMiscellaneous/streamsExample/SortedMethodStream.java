package Service.javaMiscellaneous.streamsExample;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class SortedMethodStream {

    public static void main(String[] args) {
        Map<Integer,String> hashMap=new HashMap<>();
        hashMap.put(8,"hello");
        hashMap.put(4,"world");
        hashMap.put(9,"nice");
        hashMap.put(1,"nice");
        hashMap.put(2,"nice");
        hashMap.put(12,"nice");
        hashMap.put(11,"nice");

        sortMap(hashMap);
        sortList();
    }

    public static void sortMap(Map<Integer,String> hashMap) {

        Map<Integer,String> sortedMap=new LinkedHashMap<Integer,String>();

        //sort map by Values or Keys using stream
        hashMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> t1, Map.Entry<Integer, String> t2) {
                return t1.getValue().compareTo(t2.getValue());
            }
        }).forEach((k)->{
            sortedMap.put(k.getKey(),k.getValue());
        });

        System.out.println(sortedMap);


        hashMap.entrySet().stream().sorted(comparingByValue()).collect(
                Collectors.toMap(Map.Entry ::getKey,Map.Entry ::getValue,(e1,e2)->e2,LinkedHashMap::new));


    }

    public static void sortList() {
        List<Integer> stringList = new ArrayList<Integer>();

        stringList.add(5);
        stringList.add(15);
        stringList.add(7);
        stringList.add(2);
        stringList.add(19);

        List<Integer> lList=new LinkedList<>();
        stringList.stream().sorted();
    }



}
