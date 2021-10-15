package InterfaceAndJavaBasics;

public final class BaseClass extends InheritanceClass{

    int b;
    String s;

    public  void method(int n){
        System.out.println("base Parent class is "+s +b);

    }

    public static void main(String args[]){

        InheritanceClass baseClass=new BaseClass();
        baseClass.method(1);
    }
}
