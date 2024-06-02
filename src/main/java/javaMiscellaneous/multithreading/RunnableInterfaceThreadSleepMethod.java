package javaMiscellaneous.multithreading;

public class RunnableInterfaceThreadSleepMethod implements Runnable{


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

        Thread t1=new Thread(new RunnableInterfaceThreadSleepMethod());
        Thread t2=new Thread(new RunnableInterfaceThreadSleepMethod());

        t1.start();
        t2.start();

    }
}
