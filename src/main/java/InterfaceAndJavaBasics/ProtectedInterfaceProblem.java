package InterfaceAndJavaBasics;

public interface ProtectedInterfaceProblem {

//    protected void protectedMethod(int i);

    //NoBody defined.
    String str="me";
    public void Method(int i);
    abstract void abstractMethod(int i);

    default int defaultMethod() {
        return 0;
    }

    static int staticMethod(){return 1;}
}
