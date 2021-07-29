package Service.javaMiscellaneous.lamdaExpression;


public class LamdaExample2 {

       public static void main (String[] args) {

           //Java Lambda expression can implement interface with
           // a single unimplemented method (abstract) method ,
           //but as many default or static methods as you like.

           MyInterface myInterface = (String text) -> {
               System.out.println(text);
           };
           myInterface.printIt("Hello World");

           MyInterface.printItToSystemOutString("Hi Static Method");
       }
}
