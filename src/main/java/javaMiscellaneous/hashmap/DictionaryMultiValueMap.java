package javaMiscellaneous.hashmap;


import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;

import java.util.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


public class DictionaryMultiValueMap {

    public void MultiValueMap(){

        MultiMap multiMap = new MultiValueMap();
        multiMap.put(1, "Hello there, It's a wonderful day");
        multiMap.put(1, "nice to meet you");

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("BD-Timestamp", System.currentTimeMillis());
        headerMap.put("BD-Traceid", "PYT" + "abcdefgh" + RandomStringUtils.random(10, true, true));
        headerMap.put("Accept", "application/jose");
        headerMap.put("Content-Type", "application/jose");
        System.out.println("hehe : " + headerMap);


        MultivaluedMap<String, Object> headerParams = new MultivaluedHashMap<>();
        for (Map.Entry<String, Object> param : headerMap.entrySet())
            headerParams.add(param.getKey(), param.getValue());

        LinkedMultiValueMap<String, String> headerParams2 = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> param : headerMap.entrySet())
            headerParams2.put(param.getKey(), Collections.singletonList(String.valueOf(param.getValue())));

        System.out.println(headerParams);
        System.out.println(headerParams2);


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
