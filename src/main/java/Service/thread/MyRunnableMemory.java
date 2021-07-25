package Service.thread;

import POJO.OfflinePojo;

public class MyRunnableMemory implements Runnable{

    private int count=0;

    @Override
    public void run() {

            for(int i=0; i<1000000; i++) {
                synchronized (this) {
                    this.count++;
                }
            }
            System.out.println(
                    Thread.currentThread().getName()
                    +" : "+ this.count);
    }
}
