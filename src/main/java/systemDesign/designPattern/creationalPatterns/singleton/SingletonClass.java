package systemDesign.designPattern.creationalPatterns.singleton;

/**
 If singleton class is Serializable, you can serialize the singleton instance.
 Once it is serialized, you can deserialize it, and it will not return the singleton object.
 To resolve this issue, you need to override the readResolve() method that enforces the singleton.
 refer class CustomSingleton.java
 */
public class SingletonClass {

      public String s;


      //Eager initialization if we make it Final
      //private static SingletonClass singletonClassInstance=new SingletonClass();
        private static SingletonClass singletonClassInstance ;

        private SingletonClass() {
            s="Hi Starting Singleton class.";
        }

        public static SingletonClass getInstance (){
            if (singletonClassInstance == null) {    // Lazy Initialization , Double locking used in the industry
                synchronized (SingletonClass.class) {
                    if (singletonClassInstance == null) {
                        singletonClassInstance = new SingletonClass();
                    }
                }
            }
            return singletonClassInstance;
        }
}
