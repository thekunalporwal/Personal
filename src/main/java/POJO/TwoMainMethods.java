package POJO;


//private class TwoMainMethods {  //private not allowed.
public class TwoMainMethods extends InheritanceClass{

    static int count=5;
    static final private int count2=4;

    public static void main(){
        System.out.println("key is "+ ++count);

    }

    public static void main(int i){
        System.out.println("overloaded method  is this");

    }
    public void method(){      //can't be overridden as parent class has static keyword.
        System.out.println("key is "+ count2);

    }

    static {
        count++;
        System.out.println("key in the block is "+count);

    }

    static {
        count++;
        System.out.println("key in the 2nd block is "+count);

    }


    public static void main(String args[]) {

        TwoMainMethods mainMethods=new TwoMainMethods();
        mainMethods.method();
        main();
        main(10);
    }
}
