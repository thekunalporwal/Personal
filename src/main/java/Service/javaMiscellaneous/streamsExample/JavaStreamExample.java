package Service.javaMiscellaneous.streamsExample;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamExample {

    public static void main (String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Who");
        list.add("What");

      // Stream<String> stream=list.stream();
// forEach method is a terminal operation
        list.stream().forEach(ls -> {
            System.out.println(ls);
        });

    }

}
