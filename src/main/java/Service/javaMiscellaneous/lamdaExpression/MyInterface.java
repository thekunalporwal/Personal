package Service.javaMiscellaneous.lamdaExpression;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public interface MyInterface {

     void printIt(String text);

//     void print2(String text);

     default public void printUtf8o(String text , OutputStream outputStream){
         try{
             outputStream.write(text.getBytes(StandardCharsets.UTF_8));
         }catch (IOException e){
             throw new RuntimeException("error writing string as UTF-8",e);
         }
     }

     static void printItToSystemOutString (String text){
         System.out.println("text");
     }
}
