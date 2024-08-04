package javaMiscellaneous.multithreading.executorService;

import java.util.concurrent.*;

public final class ExecutorServiceExample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executor1 = Executors.newFixedThreadPool(3);

        //Method 1
        executor1.execute(newRunnable("Task 1.1"));


        //Method 2
        Future future= executor1.submit(newRunnable("Task 1.2"));   //submit return an object by default
        System.out.println("First done is " +future.isDone());
        try{
            System.out.println("runnable object is " +future.get());   // It will provide null
        } catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }
        System.out.println("Second done is " +future.isDone());

       //Notice difference between callable and Runnable.

        //Method 3
        Future<String> future2= executor1.submit(newCallable("Task 1.3"));
        System.out.println("callable object is " +future2.get() +" and result is " +future.isDone());   //It will provide the result String
        executor1.shutdown();
        System.out.println("Await termination " + executor1.awaitTermination(5,TimeUnit.MILLISECONDS));


        //Another way to initiate thread pool by defining the thread pool max size and keep alive time.
        ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor(4, 20, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(newRunnable("Task 2.1"));
        threadPoolExecutor.shutdown();



        //awaitTermination logic
        ExecutorService executor2 = Executors.newFixedThreadPool(3);
        // Submit tasks to the executor
        for (int i = 0; i < 20; i++) {
            executor2.submit(() -> {
                try {
                    // Simulate task work by sleeping for 1 second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Initiate an orderly shutdown
        executor2.shutdown();

        try {
            // Wait for the termination of all tasks
            // The timeout is set to 1 second, which is not enough for all tasks to complete
            boolean terminated = executor2.awaitTermination(1, TimeUnit.SECONDS);
            if (terminated) {
                System.out.println("All tasks completed within the timeout.");
            } else {
                System.out.println("Not all tasks completed within the timeout.");
                // Force shutdown if necessary
                executor2.shutdownNow();
            }
        } catch (InterruptedException e) {
            // Re-cancel if current thread also interrupted
            executor2.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }

    }

    private static Runnable newRunnable(String message){
        return () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
                // Exception to be thrown in case of thread sleep is interrupted in case Runnable is used else compile error
            }
            System.out.println(Thread.currentThread().getName() +": " +message);
        };
    }

    private static Callable<String> newCallable(String message){
        return () -> {
            Thread.sleep(10000);
            //No exception handling needed in case of Callable as it throws checked exception
            return Thread.currentThread().getName() +": " +message;
        };
    }
}
