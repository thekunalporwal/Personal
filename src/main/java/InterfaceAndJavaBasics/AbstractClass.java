package InterfaceAndJavaBasics;

public abstract class AbstractClass implements ProtectedInterfaceProblem{

    String str="a";

    public AbstractClass(String str){
        this.str="kunal";
        this.str=str;
    }

    abstract void methodAbstract();

    abstract void methodAbstract2();


    void methodNormal() {
        System.out.println("hehehe");
    }

    static void methodStatic(){
        System.out.println("hehehe");
    }

}

class normalClass extends AbstractClass{

    //Mandatory to call constructor of Parent abstract class with Super.
    public normalClass(String str) {
        super(str);
    }

    public static void main(String args[]){
        AbstractClass abs=new normalClass("hi");
    }

    @Override
    void methodAbstract() {

    }

    @Override
    void methodAbstract2() {

    }

    @Override
    public void Method(int i) {

    }

    @Override
    public void abstractMethod(int i) {

    }
}
