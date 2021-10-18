package InterfaceAndJavaBasics;

public interface InterfaceWithVariable {

    //by default public static and final.
    //declaration is must for every variable.
    String variable="hello";
     void method();
}
class Check{
    static int x[];

    //null pointer exception.
    static {
        x[0]=1;
    }

    public static void main(String args[]){
       Check check=new Check();
    }
}
