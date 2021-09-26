package Service.thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Problem1 {

    protected void action() throws InterruptedException {

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(4);

        boolean isMultithreadingEnabled=true;

        List<Integer> list=new ArrayList<>();
        for(int i=0 ; i<50; i++)
            list.add(i);


        Iterator<Integer> iterator=list.iterator();
        int counter=0;
        while(iterator.hasNext()){
            counter++;

            if(isMultithreadingEnabled){
            newFixedThreadPool.submit(new RechargePushConsumer(iterator.next(),countDownLatch));

            if(counter == 4) {
                try {
                    countDownLatch.await(1, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                }
                countDownLatch = new CountDownLatch(4);
                counter = 0;
            }
        }else{
                System.out.println( "thread is " +iterator.next());
            }
        }

        newFixedThreadPool.shutdown();
        try {
            newFixedThreadPool.awaitTermination(120, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Problem1 problem1=new Problem1();
        problem1.action();
    }



        public class RechargePushConsumer implements Runnable {

        int value;
        CountDownLatch latch;

        RechargePushConsumer(int value,CountDownLatch latch) {
            this.value = value;
            this.latch=latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread()+ "thread is " +value);
                Thread.sleep(5000);
            } catch (Exception e) {
            }finally {
                latch.countDown();
            }
        }
    }
}
