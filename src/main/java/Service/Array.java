package Service;

class GFG
{
    public static boolean sum_of_elements(int []arr,
                                       int n)
    {
        if((n+1)%2!=0)
            return false ;
        int m=(n+1)/2 ;

        for (int i = 0; i <= (n+1)/2; i++)
        {
            if(arr[i]!=arr[m+1])
                return false;
            m++;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        int []arr = { 20, 30, 60, 10, 25, 15, 40 };
        int n = arr.length;

        // Function call
        sum_of_elements(arr, n);
    }
}
