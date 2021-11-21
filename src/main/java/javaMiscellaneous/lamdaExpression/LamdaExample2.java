package javaMiscellaneous.lamdaExpression;


public class LamdaExample2 implements MyInterface{

       public static void main (String[] args) {

           //Java Lambda expression can implement interface with
           // a single unimplemented method (abstract) method ,
           //but as many default or static methods as you like.

           MyInterface myInterface = (String text,String text2) -> {
               System.out.println(text);
           };
           myInterface.print2("Hello World","HEHE");
           LamdaExample2 lamdaExample2=new LamdaExample2();
           lamdaExample2.printUtf8o("HAHAHA");

       }

    @Override
    public void print2(String text,String text2) {

    }
    @Override
    public void printUtf8o(String text) {
        System.out.println(text);

    }
}
