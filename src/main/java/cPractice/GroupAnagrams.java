package cPractice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    static String sort(String str){
        //'rat'

        int[] tmparray=new int[26];
        StringBuffer sbr=new StringBuffer("");
        for(int i=0 ; i < 26; i++)
            tmparray[i]=0;

        for(int i=0; i< str.length() ; i++){
            tmparray[str.charAt(i)-'a']++;
        }

        for(int i=0; i<26;i++){
            int value=tmparray[i];
            while(value>0){
                char character = (char) (i+97);
                sbr.append(character);
                value--;
            }
        }
        return sbr.toString();
    }

    public static void sortAnagram(List<String> list){

        Map<String,List<String>> map=new HashMap<>();

        for(String li : list){
            String word=li;
            String newString=new String(sort(word));

            if(map.containsKey(newString)){
                System.out.println("hi");
                map.get(newString).add(li);
            }else{
                List<String> list2=new ArrayList<String>();
                list2.add(li);
                map.put(newString,list2);
            }
        }
        System.out.println(map);
    }

    public static void main(String args[]){

        List<String> list=new ArrayList<>();
        list.add("cat");
        list.add("act");
        list.add("rat");

        sortAnagram(list);

    }
}
