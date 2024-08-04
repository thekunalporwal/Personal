package javaMiscellaneous.multithreading.executorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyExample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService executor1 = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));

        //Assume you have 3 services to call, and you want to get the result of the first service which is completed.
        // It will return the result of the first service which is completed. (Multi bank edc configuration use-case of OE)

        String result= executor1.invokeAny( callables);
        System.out.println("result = " + result);

        executor1.shutdown();
    }

    private static Callable<String> newCallable(String message) {
        return new Callable<String>() {
            @Override
            public String call() {
                return Thread.currentThread().getName() + ": " + message;
            }
        };
    }
}

