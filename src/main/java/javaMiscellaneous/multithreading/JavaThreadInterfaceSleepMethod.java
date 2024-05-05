package javaMiscellaneous.multithreading;

public class JavaThreadInterfaceSleepMethod implements Runnable{


    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName()+"is running...");

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("thread is finished...");
    }

    public static void main(String args[]) {

        Thread t1=new Thread(new JavaThreadInterfaceSleepMethod());
        t1.start();

    }
}
