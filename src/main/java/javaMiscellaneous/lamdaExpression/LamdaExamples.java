package javaMiscellaneous.lamdaExpression;

import java.util.Comparator;

public class LamdaExamples {

    public static void main(String[] args){

        Comparator<String> stringComparator=new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        System.out.println(stringComparator.compare("hello","world"));


        Comparator<String> stringComparatorLamda=
                (String o1 ,String o2) ->( o1.compareTo(o2));

        int result=stringComparatorLamda.compare("hello","world");
        System.out.println(result);

    }


}
