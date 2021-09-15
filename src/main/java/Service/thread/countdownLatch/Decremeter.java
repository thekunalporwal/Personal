package Service.thread.countdownLatch;

import java.util.concurrent.CountDownLatch;

class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println(latch.getCount());


            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println(latch.getCount());


            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println(latch.getCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
