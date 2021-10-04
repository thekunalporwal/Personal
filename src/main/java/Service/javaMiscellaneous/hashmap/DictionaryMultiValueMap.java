package Service.javaMiscellaneous.hashmap;


import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

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

    public static void main(String args[]){
       DictionaryMultiValueMap d1=new DictionaryMultiValueMap();
       d1.MultiValueMap();

    }

}
