package javaMiscellaneous.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapKaliedofin {

    public static void hashmap(Map<String ,String> h1){
         System.out.println(h1.get("abc"));
        System.out.println(h1.get( new String("abc")));
    }

    public static void main(String args[]){
        String s1="abc";
        String s2=new String("abc");

        System.out.println(s1.equals(s2));

        Map<String,String> map=new HashMap<>();
        map.put(s1,"xvz");
        map.put(s2,"kkk");
        hashmap(map);
        System.out.println(map);   //prints only updated value.
    }
}
