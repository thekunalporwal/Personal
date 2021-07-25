package Service.thread;

public class JavaThreadDemo extends Thread{

    public void run(){
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {

           JavaThreadDemo javaThreadDemo=new JavaThreadDemo();
           javaThreadDemo.start();

    }
}
