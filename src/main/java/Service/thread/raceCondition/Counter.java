package Service.thread.raceCondition;

public class Counter {

    private long count = 0 ;

    public long incAndGet(){
        //critical section
        synchronized (this){  //making it synchronized will lock this block so that only one thread can access at a time.
        this.count++;
        return this.count;
        }
    }

    public long getCount() {
        return this.count;
    }
}
