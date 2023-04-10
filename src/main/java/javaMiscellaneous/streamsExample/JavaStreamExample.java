package javaMiscellaneous.streamsExample;

import java.util.*;
import java.util.stream.Stream;

public class JavaStreamExample {

    public static void main (String[] args) {



        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Who");
        list.add("What");

        Stream<String> strem=list.stream();

        Stream<String> stream2=strem.map((String s) -> {
            return s.toLowerCase();
                }
        );

        Map<String, Object> hash=new HashMap<>();
        hash.put("amount",-0.7);
        System.out.println("found is " + hash.get("amount").toString());


        if(Double.valueOf(hash.get("amount").toString())<0){
            System.out.println("COUNT found is " + hash.get("amount"));
        }


        //can't run again on the stream which is already closed.
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

        Stream<String> stream3=stream2.map((String s) -> {
                    return s.toLowerCase();
                }
        );

      // Stream<String> stream=list.stream();
// forEach method is a terminal operation
        stream3.forEach(ls -> {
            System.out.println(ls);
        });

    }

}
