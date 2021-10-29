package javaMiscellaneous.singeletonAndImmutable;

public class StringPoolCheck {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s4=new String("abc");
        StringBuilder s3=new StringBuilder("abc");

        if (s1==s4.intern())
            System.out.println("Yes inside == method");

        if (s1==s2)
            System.out.println("Yes inside == method of String Pool");

        if (s1.equals(s3.toString()))
            System.out.println("Yes inside Equals");
        else
            System.out.println("No Inside Equals");
    }
}
