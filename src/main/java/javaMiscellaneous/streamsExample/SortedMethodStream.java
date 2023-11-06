package javaMiscellaneous.streamsExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class SortedMethodStream {

    public static void main(String[] args) throws JsonProcessingException {
        Map<Integer,String> hashMap=new HashMap<>();
        hashMap.put(8,null);
        hashMap.put(4,"world");
        hashMap.put(9,"nice");
        hashMap.put(1,"nice");
        hashMap.put(2,"nice");
        hashMap.put(12,"nice");
        hashMap.put(11,"nice");
        Integer a=5;
        String b=null;


       String date="2023-10-04 18:55:13.11";
            if(99041233 % 100 < 0){
                System.out.println( 99041233 % 100);
            }



//        for (String prefInfo : jsonNode) {
//            System.out.println(prefInfo);
//
//        }

//        body.put("version", getMIDPreferenceVersion(mid,prefKey));
        //        String peplRequestTypes="DEALS,STORECASH,MGV";
//        List<String> dealsRequestTypeList=Arrays.asList(peplRequestTypes.trim().split(","));
//
//        System.out.println(requestType.stream().filter(r-> !dealsRequestTypeList.contains(r)).findAny().get());

//        sortMap(hashMap);
//        sortList();
    }

    public static void sortMap(Map<Integer,String> hashMap) {

        Map<Integer,String> sortedMap=new LinkedHashMap<Integer,String>();

        //sort map by Values or Keys using stream
        hashMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> t1, Map.Entry<Integer, String> t2) {
                return t1.getValue().compareTo(t2.getValue());
            }
        }).forEach((k)-> sortedMap.put(k.getKey(),k.getValue()));

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
