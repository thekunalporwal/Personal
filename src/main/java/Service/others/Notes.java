package Service.others;

import java.util.*;
import java.util.regex.Pattern;

public class Notes {

    public static void main(String args[]) {
//        POJOOutput pojoOutput = null;
//        POJOOutput pojoOutput1=new POJOOutput();
//
//
//        System.out.println(pojoOutput.getBody()); //Will throw null pointer
//        System.out.println(pojoOutput1.getBody());//fine

        String str="abc|def|ghi|jkl";
        String strings[]=str.split(Pattern.quote("|"));
        List<String> list= Arrays.asList(strings);
//        Collections.addAll(list,strings);
        System.out.println(list);

    }
}
