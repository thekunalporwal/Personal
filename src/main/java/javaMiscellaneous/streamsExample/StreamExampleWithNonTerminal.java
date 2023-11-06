package javaMiscellaneous.streamsExample;

import java.util.*;

public class StreamExampleWithNonTerminal {

    public static void main (String[] args) throws Exception {

        List<String> prefTypeName= Arrays.asList("A","B","C");
        entityHasAnyStaticPreference(prefTypeName);


        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Hello");
        list.add("Who");
        list.add("What");

        System.out.println("hehe is " +getValueS(list));


        list.stream().
                map((String ls )-> {     //non-terminal stream
                              return ls.toLowerCase();
                }).
                forEach(ls2 -> {               //terminal stream
                                 System.out.println(ls2);
        });


    }

    public static void entityHasAnyStaticPreference(List<String> prefTypeName) throws Exception {
        List<String> lookupDetailsAll = new ArrayList<>();
        prefTypeName.stream().forEach( pf-> {
            List<String> lookupDetails = getValue(pf);
            lookupDetailsAll.addAll(lookupDetails);
        });
        System.out.println(lookupDetailsAll);
    }

    public static boolean getValueS(List<String> list){
        Set<String> strSet= new HashSet<>(list);
        for(String str : strSet){
            if(str.equals("Hi"))
                return true;
        }
        return false;
    }

    public static List<String> getValue(String pf){
        if(pf.equals("A"))
            return Arrays.asList("0","HEHE");
        if(pf.equals("B"))
            return Collections.singletonList("1");
        if(pf.equals("C"))
            return Collections.singletonList("2");
        return Collections.singletonList("-1");
    }
}
