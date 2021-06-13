package Service;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Practice {

    public static void main(String[] args)
    {
        int day = 5;
        String dayString;
        String cashback;

        // switch statement with int data type
        switch (day) {
            case 1:
                dayString = "Monday";
                cashback="supercash";
                break;
            case 2:
                dayString = "Tuesday";
                cashback="wallet";
                break;
            case 3:
                dayString = "Wednesday";
                cashback="instant";
                break;
            default:
                dayString = "Invalid day";
                cashback="instantVoucher";
        }
        System.out.println(dayString);
        System.out.println(cashback);
    }

//    // Driver code
//    public static void main(String[] args) {
//
//        Integer eligibilityAmount=100000;
//        String amount ="100000.1";
//
//        if(!StringUtils.isEmpty(amount) && (Double.valueOf(amount).compareTo(eligibilityAmount.doubleValue()) >= 0)) {
//            System.out.println("true");
//        }
//        else
//        System.out.println("false");
//    }
//public static void main(String[] args)
//{
//    BigDecimal diff;
//    String input1
//            = "13024.3";
//    String input2
//            = "13019.3";
//    BigDecimal a
//            = new BigDecimal(input1);
//    BigDecimal b
//            = new BigDecimal(input2);
//
//
//    double zipBalanceUsed=0.0;
//    // Using subtract() method
//
//    zipBalanceUsed = (a.subtract(b)).doubleValue();
//
//    // Display the result in BigDecimal
//    System.out.println("The difference of\n"
//            + zipBalanceUsed);
//}

}
