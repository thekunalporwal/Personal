package javaMiscellaneous.streamsExample;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExample {

    public static void main (String[] args) {



        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Who");
        list.add("What");

        Stream<String> strem=list.stream();

//        Stream<String> stream2=strem.map((String s) -> {
//            return s.toLowerCase();
//                }
//        );

        "abc".equals(null);
        String abc=null;
        List<String> sourceBankList = Arrays.stream("HFDC,hedc".split(",")).map(String::trim).collect(Collectors.toList());

        System.out.println("True find is " + abc.equals("null"));

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
