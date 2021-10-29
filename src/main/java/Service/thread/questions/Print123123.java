package Service.thread.questions;

public class Print123123 implements Runnable {
    int threadId;
    static Object monitor=new Object();
    static int number=1;

    public Print123123(int threadId){
        this.threadId=threadId;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (monitor){
               while(number%3 != threadId) {
                 try {
                     monitor.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
                 System.out.println(Thread.currentThread().getName() + "  "+(threadId+1));
                 number++;
                 monitor.notifyAll();
            }
           }
         }
    }

