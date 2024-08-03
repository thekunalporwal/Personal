package javaMiscellaneous.multithreading.useofSyncronizedKeyword;

public class SeparateObjectsUsingSynchronized {

    public static void main(String args[]) {

        Runnable runnable1=new MyRunnableMemory() ;
        Runnable runnable2=new MyRunnableMemory() ;

        Thread t1=
                new Thread(runnable1 ,"THREAD 1");
        Thread t2=
                new Thread(runnable1 ,"THREAD 2");

        t1.start();
        t2.start();
    }
}
