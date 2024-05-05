package javaMiscellaneous.streamsExample;

import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExample {

    public static void main (String[] args) {


        List<Long> list6 = new ArrayList<>();
        list6.add(12345L);
        list6.add(34567L);


        List<Map<String,Object>> terminalIdList = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("TID", 12345L);
        map1.put("BANK_TID","12345");

        terminalIdList.add(map1);

        terminalIdList.forEach(terminal -> completeDigiposUPIOnboarding("mid", (Long) terminal.get("TID"), (String) terminal.get("BANK_TID")));



        String sql="select * from table where";
        sql += " id in ("+ StringUtils.join(list6,",") +")";
        System.out.println(sql);






        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Who");
        list.add("What");

        Stream<String> strem=list.stream();
        String ADDRESS_PATTERN = "^[-a-zA-Z0-9,(),\\[\\].\\/#'\\s]+$";

        String address="OPP MANGALA HOSPITAL & SYDICATE BANK";

        System.out.println("True find is " +StringUtils.equalsIgnoreCase("abc",null));

        Set<String> oldChargebackEmails = new LinkedHashSet<>();
        Set<String> chargebackEmailsNew = new LinkedHashSet<>();

//        System.out.println( StringUtils.join(oldChargebackEmails, ","));

        oldChargebackEmails.add("12345");
        oldChargebackEmails.add("123455");


        chargebackEmailsNew.add("12345");
        chargebackEmailsNew.add("sd12f");

        String[] value = StringUtils.split("a,b", ",");
//        System.out.println("found is " + generateChargebackEmails(oldChargebackEmails,chargebackEmailsNew,"ADD"));
//        System.out.println("found is " + generateChargebackEmails(oldChargebackEmails,chargebackEmailsNew,"REMOVE"));
//        System.out.println("found is " + generateChargebackEmails(oldChargebackEmails,chargebackEmailsNew,"abc"));





        //can't run again on the stream which is already closed.
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

        Stream<String> stream3=strem.map((String s) -> {
                    return s.toLowerCase();
                }
        );

      // Stream<String> stream=list.stream();
// forEach method is a terminal operation
        stream3.forEach(ls -> {
            System.out.println(ls);
        });

    }

    private static void completeDigiposUPIOnboarding(String mid, Long tid, String bankTid){
        System.out.println("mid is " + mid + " tid is " + tid + " bankTid is " + bankTid);
    }


    private static String generateChargebackEmails(Set<String> oldChargebackEmails, Set<String> chargebackEmailsNew, String action) {
        Set<String> updatedChargeBackEmails = new LinkedHashSet<>();
        switch (action) {
            case "ADD":
                updatedChargeBackEmails.addAll(oldChargebackEmails);
                updatedChargeBackEmails.addAll(chargebackEmailsNew);
                break;
            case "REMOVE":
                updatedChargeBackEmails.addAll(oldChargebackEmails);
                System.out.println(updatedChargeBackEmails.removeAll(chargebackEmailsNew));
                break;
            case "REPLACE":
                updatedChargeBackEmails.addAll(chargebackEmailsNew);
                break;
        }
        return StringUtils.join(updatedChargeBackEmails, ",");
    }

}
