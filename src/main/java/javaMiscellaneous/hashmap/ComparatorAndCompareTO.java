package javaMiscellaneous.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorAndCompareTO implements Comparable<ComparatorAndCompareTO>{

    @Override
    public int compareTo(ComparatorAndCompareTO comparatorAndCompareTO) {
        return 0;
    }


    public static void compareOwn(Map<Integer,String> hashMap) {

        List<Map.Entry<Integer,String>> list =hashMap.entrySet().stream().collect(Collectors.toList());

        list.sort(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> t1, Map.Entry<Integer, String> t2) {

                int number= t2.getValue().compareTo(t1.getValue());
                return number==0 ? t2.getKey().compareTo(t1.getKey()) : number;
            }
        });

        for(Map.Entry<Integer,String> ll : list)
            System.out.println(ll.getKey()+" " +ll.getValue());


    }


    public static void main(String args[]) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(8, "hello");
        hashMap.put(4, "world");
        hashMap.put(9, "nice");
        hashMap.put(11, "nice");

          compareOwn(hashMap);

        }

}
