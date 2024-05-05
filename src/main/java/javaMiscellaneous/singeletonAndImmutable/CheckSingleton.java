package javaMiscellaneous.singeletonAndImmutable;

class CheckSingleton{

    public static void main(String args[]) {
        CustomSingleton x = CustomSingleton.CustomSingleton();
        CustomSingleton y = CustomSingleton.CustomSingleton();
        CustomSingleton z = CustomSingleton.CustomSingleton();

        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(z.hashCode());

    }
}
