package Service.javaMiscellaneous.streamsExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StreamExampleWithNonTerminal {

    public static void main (String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Who");
        list.add("What");

        list.stream().
                map((String ls )-> {     //non-terminal stream
                              return ls.toLowerCase();
                }).
                forEach(ls2 -> {               //terminal stream
                                 System.out.println(ls2);
        });


    }
}
