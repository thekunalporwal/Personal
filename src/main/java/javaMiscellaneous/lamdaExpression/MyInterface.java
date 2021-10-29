package javaMiscellaneous.lamdaExpression;

public interface MyInterface {

//     void printIt(String text);

    //can contain Variables
    String t="kunal";

     void print2(String text,String text2);

     default public void printUtf8o(String text ){
         System.out.println("default");

     }

     static void printItToSystemOutString (String text){
         System.out.println(text);
     }
}
