package javaMiscellaneous.multithreading.raceCondition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceConditionExample {


    public static void main(String args[]) {

        Counter counter=new Counter() ;

        Map<String,String> map = new ConcurrentHashMap<>();
        map.remove("key");

        Thread t1=
                new Thread(getRunnale(counter ,"THREAD 1 final count "));
        Thread t2=
                new Thread(getRunnale(counter ,"THREAD 2 final count "));

        t1.start();
        t2.start();
    }

    private static Runnable getRunnale(Counter counter , String message){
        return () -> {
            for(int i =0 ; i< 1_000_000 ; i++){
                counter.incAndGet();
            }
            System.out.println(message + counter.getCount());
        };
    }
}
