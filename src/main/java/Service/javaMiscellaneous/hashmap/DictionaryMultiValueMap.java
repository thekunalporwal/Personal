package Service.javaMiscellaneous.hashmap;


import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class DictionaryMultiValueMap {

    public void MultiValueMap(){

        MultiMap multiMap = new MultiValueMap();
        multiMap.put(1, "Hello there, It's a wonderful day");
        multiMap.put(1, "nice to meet you");

        System.out.println("A : " + multiMap.get(1));
        List<String> list=(List<String>) multiMap.get(1);
        list.stream().forEach(ls ->{
                System.out.println(ls);
        });
    }

    public void dictionaryMethod(){

        Dictionary dictionary=new Hashtable();
        dictionary.put("123","hehe");
        dictionary.put("111","nope");

        Enumeration i=dictionary.elements();

    }

    public static void main(String args[]){
       DictionaryMultiValueMap d1=new DictionaryMultiValueMap();
       d1.MultiValueMap();

    }

}
