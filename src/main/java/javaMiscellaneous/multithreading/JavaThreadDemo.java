package javaMiscellaneous.multithreading;

public class JavaThreadDemo extends Thread{

    public void run(){
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {

           Thread T1=new Thread(new JavaThreadDemo());
           JavaThreadDemo javaThreadDemo=new JavaThreadDemo();
         JavaThreadDemo javaThreadDemo2=new JavaThreadDemo();


         T1.start();
        javaThreadDemo.start();
        javaThreadDemo2.start(); //Exception can't run two times.

    }
}
