package Service;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class heightChecker{

//    static int heightChecker(int[] heights) {
//
//        int count = 0;
//
//        if (heights == null || heights.length == 0) return count;
//
//        int len = heights.length;
//
//        int[] newArr = new int[heights.length];
//
//        System.arraycopy(heights, 0, newArr, 0, len);
//
//        Arrays.sort(newArr);
//
//        for (int i = 0; i < len; i++) {
//
//            if (newArr[i] != heights[i])
//
//                count++;
//
//        }
//
//        return count;
//
//    }


    public static int priceCheck(List<String> product, List<Float> productPrices, List<String> productSold, List<Float> soldPrice)
    {

        HashMap<String,Float> hm=new HashMap<>();
        int count=0;
        for(int i=0;i<product.size();i++)
        {
            hm.put(product.get(i),productPrices.get(i));
        }
        for(int i=0;i<productSold.size();i++)
        {
            if(hm.get(productSold.get(i))!=soldPrice.get(i))
                count++;
        }
        return count;

    }

    public static void main(String[] args)
    {
       ArrayList<String> l1=new ArrayList<>();


//       System.out.println(heightChecker(array));
    }

}

