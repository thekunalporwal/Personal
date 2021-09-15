package Service.thread.countdownLatch;

import java.util.concurrent.CountDownLatch;

public class Latch extends Thread {

    public static void main(String args[]) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        Thread t1= new Thread(waiter);  //1 way to start a thread.
        t1.start();

        new Thread(decrementer).start(); // another way to start a thread.

        Thread.sleep(4000);
    }
}
