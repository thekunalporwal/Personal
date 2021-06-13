//package Service;
//
//import java.math.BigInteger;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Stack;
//
//class GFG
//{
//    public static boolean sum_of_elements(int []arr,
//                                       int n) {
//        Stack<Integer> s1 = new Stack<Integer>();
//        s1.push(arr[0]);
//        for (int i = 1; i < n - 1; i++) {
//            int next = arr[i];
//            if (!s1.isEmpty()) {
//                int element = s1.pop();
//                while (element < next) {
//                    System.out.println("Next element for this is this");
//                    if (s1.isEmpty())
//                        break;
//                    s1.pop();
//                }
//                if (element > next)
//                    s1.push(element);
//            }
//            s1.push(next);
//        }
//
//        Iterator iterator = s1.iterator();
//        iterator.hasNext();
//
//    }
//
//
//
//    // Driver code
//    public static void main(String[] args)
//    {
//        int []arr = { 20, 30, 60, 10, 25, 15, 40 };
//        int n = arr.length;
//
//        // Function call
//        sum_of_elements(arr, n);
//    }
//
//    public void Iterator()
//    {
//        HashMap<String,String> s1 = new HashMap<>();
//        s1.put("A","1");
//        s1.put("B","2");
//        s1.put("C","3");
//        s1.put("D","4");
//
//        Iterator iterator=s1.keySet().iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }
//
//        Iterator iterator2=s1.values().iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }
//
//        for(String itr : s1.keySet())
//        {
//            System.out.println(itr);
//        }
//
//        for (Map.Entry<String,String > entry : s1.entrySet())
//        {
//            System.out.println(entry.getKey() + entry.getValue());
//        }
//
//    }
//
//    public int secondLargest( String arr[])
//    {
//     int n= arr.length;
//     if(n==0 || n==1 )
//         return -1;
//
//        BigInteger first_largest=new BigInteger(arr[0]);
//        BigInteger second_largest=new BigInteger(arr[1]);
//        if(first_largest.compareTo(second_largest)<0)
//        {
//            BigInteger swap=first_largest;
//            first_largest=second_largest;
//            second_largest=swap;
//        }
//
//        for (int i=0 ; i < n ;i++)
//        {
//            BigInteger temp=new BigInteger(arr[i]);
//
//            if(temp.compareTo(first_largest)>0)
//              {
//             second_largest=first_largest;
//             first_largest=temp;
//         }
//         else if(temp.compareTo(second_largest)>0 && temp.compareTo(first_largest)!=0)
//             second_largest=temp;
//            else if(temp.compareTo(second_largest)<0 && first_largest.compareTo(second_largest)==0)
//            {
//             second_largest=temp;
//            }
//
//     }
//
//     if (second_largest.compareTo(first_largest)==0)
//            return -1;
//        else
//            return second_largest;
//    }
//
//
//    public void secondLargest2( String arr[])
//    {
//        String first_largest="";
//        String second_largest="";
//
//        if(n==0 || n==1 ){
//            System.out.println("-1");
//            return ;
//        }
//
//        for (int i=0 ; i < n ;i++)
//        {
//            if((arr[i]).compareTo(first_largest)>0)
//            {
//                second_largest=first_largest;
//                first_largest=arr[i];
//            }
//            else if(arr[i].compareTo(second_largest) >0 && ! arr[i].equals(first_largest) )
//                second_largest=arr[i];
//
//        }
//
//        if (second_largest.isEmpty())
//        {
//            System.out.println("-1");
//            return ;
//        }
////        else if (first_largest.compareTo("1")<0 && second_largest.compareTo("1")<0)
////        {
////            System.out.println(first_largest);
////        }
//        else{
//            System.out.println(second_largest);
//            return;
//        }
//    }
//
//}
