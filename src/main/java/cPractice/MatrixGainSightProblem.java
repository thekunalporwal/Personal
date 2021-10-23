package cPractice;

public class MatrixGainSightProblem {

    static void matrix(int[][] matrix,int n){
        int[][] matrix2=new int[n][n];

        for(int i=0 ;i<n;i++){
            for(int j=0; j<n ;j++){
                int sumRow=0;
                int sumColomn=0;

                for(int k=0;k<n;k++) {
                    sumRow+=matrix[k][j];
                }
                for(int l=0;l<n;l++) {
                    sumColomn+=matrix[i][l];
                }
                matrix2[i][j]=(sumRow+sumColomn-(2*matrix[i][j]));
            }
        }
        for(int i=1; i<=n ;i++){
            for(int j=1; j<=n; j++){
                System.out.println(matrix2[i-1][j-1]);
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix=new int[3][3];
        int counter=0;
        for(int i=1; i<=3 ;i++){
            for(int j=1; j<=3; j++){
                matrix[i-1][j-1]=++counter;
            }
        }

        matrix(matrix,3);

    }
}
