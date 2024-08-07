package javaMiscellaneous;

import InterfaceAndJavaBasics.OfflinePojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadExample {


    public static void main(String args[]) {


        Hashtable<String,String> hashtable= new Hashtable<>();
        hashtable.put("1","1");

        List<Hashtable<String,String>> list = new ArrayList<>();
        list.add(hashtable);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (this) {
                        System.out.println(
                                Thread.currentThread().getName() + " : " + i);
                    }
                }
            }
        };

        Runnable runnable1= () -> {
            for (int i = 0; i < 1000; i++) {
                    System.out.println(
                            Thread.currentThread().getName() + " : " + i);

            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable1);
//
//        t1.start();
//        t2.start();
    }

}

