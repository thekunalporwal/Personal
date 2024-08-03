package javaMiscellaneous.multithreading;

public class ThreadLocalExample {

    public void threadCheck() throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread t1= new Thread( () -> {
            threadLocal.set("ThreadLocal 1");
            threadLocal.remove();
            System.out.println("This is the thread 1 " +Thread.currentThread().getName() +" and " + threadLocal.get());
        });

        Thread t2= new Thread(() -> {
            threadLocal.set("ThreadLocal 2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("This is the thread 2 " +Thread.currentThread().getName() +" and " + threadLocal.get());
        });

        t1.start();
//        t1.join();  //either way to make t1 run first.
        t2.start();

    }




    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample=new ThreadLocalExample();
        threadLocalExample.threadCheck();
    }
}
