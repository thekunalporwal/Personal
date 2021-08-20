package Service.javaMiscellaneous.lamdaExpression;

public interface MyInterface {

     void printIt(String text);

//     void print2(String text);

     default public void printUtf8o(String text ){
         System.out.println("default");

     }

     static void printItToSystemOutString (String text){
         System.out.println(text);
     }
}
