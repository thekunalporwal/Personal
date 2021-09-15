package Service.javaMiscellaneous.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class SyncronisedHashMap {

    public void iterateMap(Map<Integer,String> hashMap){

        for( Map.Entry<Integer,String> map:  hashMap.entrySet()) {
            System.out.println("key is "+ map.getKey());
        }

        for( String values:  hashMap.values()) {
            System.out.println("key value is "+ values);
        }

        hashMap.forEach((key,value) -> {
            System.out.println(key +" " +value);
        });

        List<Integer> list =new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(5);

        list.forEach((l1)->{
            System.out.println(" " +l1);
        });


        hashMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,k->k.getValue()));

        Collections.synchronizedMap(hashMap);
        System.out.println();

    }

    public void sortMap(Map<Integer,String> hashMap){


        //Using TreeMap ,sorting only by keys not values.
        TreeMap<Integer,String> treeMap=new TreeMap<>();
        treeMap.putAll(hashMap);

        for(Map.Entry<Integer,String> keys:treeMap.entrySet()){
            System.out.println(keys.getKey() +" " +keys.getValue());
        }

        //sort map by keys
       List<Map.Entry<Integer,String>> l1= hashMap.entrySet().stream().collect(Collectors.toList());
        Collections.sort(l1,(i1,i2)-> i1.getKey().compareTo(i2.getKey()));
        System.out.println(l1);

        //sort map by values
        List<Map.Entry<Integer,String>> l2= new ArrayList<>(hashMap.entrySet());
        Collections.sort(l2, Comparator.comparing(Map.Entry::getValue));
        System.out.println(l2);

        Map<Integer,String> sortedMap=new LinkedHashMap<Integer,String>();
        for(Map.Entry<Integer,String> map: l2 ){
            sortedMap.put(map.getKey(),map.getValue());
        }
        System.out.println(sortedMap);

    }


        public static void main(String args[]){
        Map<Integer,String> hashMap=new HashMap<>();
        hashMap.put(8,"hello");
        hashMap.put(4,"world");
        hashMap.put(11,"nice");


        SyncronisedHashMap syncronisedHashMap=new SyncronisedHashMap();
        syncronisedHashMap.iterateMap(hashMap);
        syncronisedHashMap.sortMap(hashMap);


        }


    }
