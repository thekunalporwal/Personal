package javaMiscellaneous.singeletonAndImmutable;

class CheckSingleton{

    public static void main(String args[]) {
        CustomSingleton x = CustomSingleton.getSingleInstance();
        CustomSingleton y = CustomSingleton.getSingleInstance();
        CustomSingleton z = CustomSingleton.getSingleInstance();

        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(z.hashCode());

    }
}
