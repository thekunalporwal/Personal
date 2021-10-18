package Service.url;

public class Example {

    public boolean checkIfItPrime(int number){
        boolean isPrime=true;
        for(int i=2 ; i<=number/2;i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public void alternatePrime(int n){
        int count=0;
        int variable=2;
        System.out.println(checkIfItPrime(4));
        for(int j=2 ; j<Integer.MAX_VALUE ;j++){
            if(checkIfItPrime(j)){
                if(count==n)
                    return;
                if(variable%2==0) {
                    System.out.println(j);
                    count++;
                }
                variable++;

            }
        }

    }

    public static void main(String args[]){
        Example example=new Example();
        example.alternatePrime(3);

    }
}
