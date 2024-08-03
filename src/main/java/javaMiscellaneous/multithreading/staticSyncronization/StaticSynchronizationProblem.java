package javaMiscellaneous.multithreading.staticSyncronization;

class StaticSynchronizationProblem {

    //if you don't put static here it will result in thread interference as we are calling this method with two different objects.
    synchronized static void printTable(int n){
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName() + " - " + n*i);
                try{
                    Thread.sleep(4);
                }catch(Exception e){}
            }
        }
    }

     class TestSynchronization5 {
        public static void main(String[] args) {

            StaticSynchronizationProblem staticSynchronizationProblem=new StaticSynchronizationProblem();
            StaticSynchronizationProblem staticSynchronizationProblem2=new StaticSynchronizationProblem();

            Thread t1=new Thread(){
                public void run(){
                    staticSynchronizationProblem.printTable(1);
                }
            };

            Thread t2=new Thread(){
                public void run(){
                    staticSynchronizationProblem.printTable(10);
                }
            };

            Thread t3=new Thread(){
                public void run(){
                    staticSynchronizationProblem2.printTable(100);
                }
            };

            Thread t4=new Thread(){
                public void run(){
                    staticSynchronizationProblem2.printTable(1000);
                }
            };
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
    }
