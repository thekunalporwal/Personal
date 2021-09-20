package Service.thread;

public class JavaThreadDemo extends Thread{

    public void run(){
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {

           Thread T1=new Thread(new JavaThreadDemo());
           JavaThreadDemo javaThreadDemo=new JavaThreadDemo();
//         JavaThreadDemo javaThreadDemo2=new JavaThreadDemo();

        javaThreadDemo.start();
        javaThreadDemo.start(); //Exception can't run two times.

    }
}
