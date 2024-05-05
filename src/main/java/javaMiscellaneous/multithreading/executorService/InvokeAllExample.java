package javaMiscellaneous.multithreading.executorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {

    public static void main(String args[]) {

        ExecutorService executor1 = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));

        try {
            List<Future<String>> results = executor1.invokeAll((Collection<Callable<String>>) callables);

            for (Future result : results) {
                System.out.println("result = " + result.get());
            }
        }catch (InterruptedException | ExecutionException e){
        }

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
