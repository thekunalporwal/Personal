package cPractice.basicsFormulaCodes;

public class SquareRootFunction {

    public double sRoot(int number){


        // sqrtN+1 = (sqrtN + number/sqrtN)/2  ;

        double t;
        double squareRoot=number/2;
        do{
            t=squareRoot;
            squareRoot=(t+(number/t))/2;
            System.out.println(squareRoot);

        }while (t-squareRoot!=0);

        return squareRoot;

    }

    public static void main(String[] args){
        SquareRootFunction squareRootFunction=new SquareRootFunction();
        System.out.println(squareRootFunction.sRoot(27));
    }
}
