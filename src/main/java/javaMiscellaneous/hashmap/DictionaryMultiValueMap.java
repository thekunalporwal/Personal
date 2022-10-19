package javaMiscellaneous.hashmap;


import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;
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

//        MultiMap multiMap = new MultiValueMap();
//        multiMap.put(1, "Hello there, It's a wonderful day");
//        multiMap.put(1, "nice to meet you");
//
//        Map<String, Object> headerMap = new HashMap<>();
//        headerMap.put("BD-Timestamp", System.currentTimeMillis());
//        headerMap.put("BD-Traceid", "PYT" + "abcdefgh" + RandomStringUtils.random(10, true, true));
//        headerMap.put("Accept", "application/jose");
//        headerMap.put("Content-Type", "application/jose");
//        System.out.println("hehe : " + headerMap);
//
//
//        MultivaluedMap<String, Object> headerParams = new MultivaluedHashMap<>();
//        for (Map.Entry<String, Object> param : headerMap.entrySet())
//            headerParams.add(param.getKey(), param.getValue());
//
//        LinkedMultiValueMap<String, String> headerParams2 = new LinkedMultiValueMap<>();
//        for (Map.Entry<String, Object> param : headerMap.entrySet())
//            headerParams2.put(param.getKey(), Collections.singletonList(String.valueOf(param.getValue())));
//
//        System.out.println("A : " + multiMap.get(1));
//        List<String> list=(List<String>) multiMap.get(1);
//        list.stream().forEach(ls ->{
//                System.out.println(ls);
//        });
//
//        JSONObject result=new JSONObject();
//        result.put("success",true);
//            System.out.println(result);
        String[] HITACHI_BANK = { "HITA", "PEDC", "HITR" };
        List<String> hitachiSupportedBanks =Arrays.asList(HITACHI_BANK);
        //        String bank2="n";
//        if(StringUtils.isNotBlank(bank2))
        String name="sundasekunauusjejejejnjfjefnengnrjgnjrnjrgejqjejjejejejewdjdndnfjfnjfnfnjefnejfnejfnfejnfjnfjnfjnfjnefjfenjefnfejfejeeererrrrrjejejenlgngjngrljngrgjrnjgrjgrjgjrjngrnjgrjjgrgljrlgrjejejejejejejejejejej";
            System.out.println("bank " +name.length());

        List<String> bankList = new ArrayList<>();
        bankList.add("HITA");
        bankList.add("PEDC");

//             System.out.println("start " +Optional.ofNullable(bankList).isPresent() );
//
        boolean isHitachiOnboarded = bankList.stream().anyMatch(bank -> hitachiSupportedBanks.contains(bank)) ;
        System.out.println(isHitachiOnboarded);


//
//        String Pattern= "^[0-9a-zA-Z\t ./?;:,'`!@#$^*(){}_=|\\-////]+$";
//        String Pattern2= "^[0-9a-zA-Z'\\. ]*$";
//        MutableBoolean isBankTidConfigured = new MutableBoolean();  //to check if new BankTID required or not for PEDC/HITA
//        System.out.println(isBankTidConfigured);


//        if(!name.matches(Pattern2))
//            System.out.println("not matched");

    }

    public void dictionaryMethod(StringBuilder str,MutableBoolean mutableBoolean){
        str.append("abcd");
        mutableBoolean.setValue(true);
    }

    public static void main(String args[]){
       DictionaryMultiValueMap d1=new DictionaryMultiValueMap();
       d1.MultiValueMap();

    }

}
