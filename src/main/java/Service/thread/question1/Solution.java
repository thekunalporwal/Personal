package Service.thread.question1;

public class Solution {

     volatile boolean thread1=true;
     volatile boolean thread2=false;

     public void printName() {
        while (true){
              if(thread1) {
                  System.out.println(Thread.currentThread().getName() + "Deepak");
                  this.thread2 = true;
                  this.thread1 = false;
              }
    }
    }
    public void printSurName() {
        while (true){
                if(thread2) {
                    System.out.println(Thread.currentThread().getName() + "Kumar");
                    this.thread2 = false;
                    this.thread1 = true;
                }
        }
    }
}
