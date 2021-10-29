package cPractice.basicsFormulaCodes;

public class NtoPowerX {

    public int power(int n , int x){
        System.out.println(x%2);

        if(x==0)
            return 1;

        int temp=power(n,x/2);
        if(x%2==0)
            return temp* temp;
        else
            return n* temp* temp;
    }

    public static void main(String args[]) {
        NtoPowerX ntoPowerX=new NtoPowerX();
        System.out.println(ntoPowerX.power(2,8));
    }
}
