package Service.thread.executorService;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executor1 = Executors.newFixedThreadPool(3);

        //Method 1
        executor1.execute(newRunnable("Task 1.1"));


        //Method 2
        Future future= executor1.submit(newRunnable("Task 1.2"));   //submit return an object by default
        System.out.println(future.isDone());
        try{
            future.get();
        }catch (InterruptedException | ExecutionException e){ }
        System.out.println(future.isDone());

       //Notice difference between callable and Runnable.

        //Method 3
        Future future2= executor1.submit(newCallable("Task 1.3"));
        System.out.println(future.isDone());
        System.out.println(future2.get());


        executor1.shutdown();
    }

    private static Runnable newRunnable(String message){
        return new Runnable() {
            @Override
            public void run() {
             System.out.println(Thread.currentThread().getName() +": " +message);
            }
        };
    }

    private static Callable newCallable(String message){
        return new Callable() {
            @Override
            public Object call() {
                String msg = Thread.currentThread().getName() +": " +message;
                return msg;
            }
        };
    }
}