package Service.url;
import java.util.*;

class Result{
    static int count = 0;
    public static int getMaximumDistinctCount(List<Integer> a, List<Integer> b, int k) {

        int size = a.size();
        List<int[]> arrList = new ArrayList<int[]>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int arr[] = new int[2];
                arr[0] = i;
                arr[1] = j;
                arrList.add(arr);
            }
        }
        getMaximumDistinct(arrList, arrList.size(), k, a, b);
        return count;
    }

    static void getMaximumDistinct(List<int[]> arrList, int n, int r, List<Integer> a, List<Integer> b) {
        int data[][] = new int[r][2];
        getMaximum(arrList, data, 0, n - 1, 0, r, a, b);
    }

    static void getMaximum(List<int[]> arrList, int[][] data, int start, int end, int index, int r, List<Integer> a,
                           List<Integer> b) {
        if (index == r) {
            List<Integer> aTemp = a;
            List<Integer> bTemp = b;
            for (int[] s2 : data) {
                int an = aTemp.get(s2[0]);
                int bn = bTemp.get(s2[1]);
                aTemp.set(s2[0], bn);
                bTemp.set(s2[1], an);
            }
            Set<Integer> c = new HashSet<>();
            for (int i = 0; i < aTemp.size(); i++) {
                c.add(aTemp.get(i));
            }
            if (count < c.size()) {
                count = c.size();
            }
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++){
            data[index] = arrList.get(i);
            getMaximum(arrList, data, i + 1, end, index + 1, r, a, b);
        }

    }
}

public class Test {

    public static void main(String args[]) {

        List<Integer> a = new ArrayList<Integer>(), b = new ArrayList<Integer>();
        a.add(1);a.add(1);a.add(4);a.add(5);a.add(5);
        b.add(4);b.add(4);b.add(3);b.add(1);b.add(5);
        //Input ends here

        //Method call
        Result result=new Result();
        System.out.println(result.getMaximumDistinctCount(b, a, 2));

    }
}