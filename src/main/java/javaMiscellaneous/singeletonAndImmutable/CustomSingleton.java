package javaMiscellaneous.singeletonAndImmutable;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class CustomSingleton implements Serializable {

    //Eager initialization if we make it Final
    //private static CustomSingleton singleInstance=new CustomSingleton();
    private static CustomSingleton singleInstance;

    public String s;

    //Constructor Private to make it Singleton
    private CustomSingleton(){
        s="Hi Starting Singleton class.";
    }

//    public static CustomSingleton CustomSingleton(){
//            return singleInstance;
//    }


    //Using Synchronized keyword and Lazy Initialization and can be broken by cloning.
    public static CustomSingleton getSingleInstance() {
        if (singleInstance == null) {    // Lazy Initialization , Double locking used in the industry
            synchronized (CustomSingleton.class) {
                if (singleInstance == null) {
                    singleInstance = new CustomSingleton();
                }
            }
        }
        return singleInstance;
    }

    //to prevent breaking using input output stream
    private Object readResolve() throws ObjectStreamException {
        return singleInstance;
    }
}