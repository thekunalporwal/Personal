package javaMiscellaneous.multithreading.countdownLatch;

import java.util.concurrent.CountDownLatch;

public class Latch extends Thread {

    public static void main(String args[]) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        // We specify the number of threads it should wait for,
        // all such thread are required to do count down by calling CountDownLatch.countDown()
        // Once they are completed or ready to the job. As soon as count reaches zero, the waiting task starts running.
        // In this case waiter will start running once Decrementer has done its job.
        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        Thread t1= new Thread(waiter);  //1 way to start a thread.
        t1.start();

        new Thread(decrementer).start(); // another way to start a thread.

        Thread.sleep(4000);
    }
}
