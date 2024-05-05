package javaMiscellaneous.multithreading.questions.print123;

import javaMiscellaneous.multithreading.questions.Print123123;

public class Trigger123 {


    public static void main (String args[]){

        Thread t1=new Thread(new Print123123(0));
        Thread t2=new Thread(new Print123123(1));
        Thread t3=new Thread(new Print123123(2));

        t1.start();
        t2.start();
        t3.start();

    }
}
