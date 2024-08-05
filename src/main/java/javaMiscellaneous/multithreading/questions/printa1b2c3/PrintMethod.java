package javaMiscellaneous.multithreading.questions.printa1b2c3;

public class PrintMethod {

    volatile int abc=65;
    volatile int number=1;

    volatile boolean printAbc=true;


    synchronized void printAbc ()  {
       while(!printAbc){
           try {
               wait();
           }catch (Exception e){

           }
       }
       System.out.println((char) abc);
       abc++;
       printAbc=false;
       notifyAll();
    }

    synchronized void print123 ()   {
        while(printAbc){
            try {
                wait();
            } catch (Exception e){

            }
        }
        System.out.println(number);
        number++;
        printAbc=true;
        notifyAll();
    }
}
