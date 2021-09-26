package cPractice;

public class PermutationString {

    public void permutation(String str,int start,int end){

        if(start==end)
            System.out.print(str+" ");
        else{
            for(int i=start ;i<=end ; i++){
                str=swap(str,start,i);
                permutation(str,start+1,end);
                str=swap(str,start,i);
            }
        }

    }

    public void permute(String s , String answer)
    {
        if (s.length() == 0) {
            System.out.print(answer + "  ");
            return;
        }

        for(int i = 0 ;i < s.length(); i++) {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            System.out.println("rest is " +rest);

            permute(rest, answer + ch);
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        PermutationString permutationString=new PermutationString();
        String s1="ABC";
//        permutationString.permutation(s1,0,s1.length()-1);
        System.out.println("");

        permutationString.permute(s1,"");
    }
}
