package Service.thread.executorService;

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

        String result= (String) executor1.invokeAny((Collection) callables);
        System.out.println("result = " + result);

        executor1.shutdown();
    }

    private static Callable newCallable(String message) {
        return new Callable() {
            @Override
            public Object call() {
                String msg = Thread.currentThread().getName() + ": " + message;
                return msg;
            }
        };
    }
}

