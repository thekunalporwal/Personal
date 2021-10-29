package javaMiscellaneous.streamsExample;

import org.apache.poi.hssf.record.CommonObjectDataSubRecord;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducesTerminal {

    public static void main(String[] args) {

        List<Integer> stringList = new ArrayList<Integer>();

        stringList.add(5);
        stringList.add(15);
        stringList.add(7);

        Stream<Integer> stream = stringList.stream();

        Optional<Integer> reduced = stream.reduce((value, combinedValue) -> {
            return combinedValue + value;
        });

        stringList.stream().forEach(value -> {
            System.out.println(value);
        });

        List<Integer> list=stringList.stream().collect(Collectors.toList());


        System.out.println(reduced.get());
    }
}
