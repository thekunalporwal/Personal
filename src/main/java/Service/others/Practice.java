package Service.others;

import Service.utils.LombookCheck;
import logback.LoggerUtil;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
    private static final Logger logger = LoggerFactory.getLogger(Practice.class);

    private static final String EMAIL_DTO_REGEX = "(?i)(Email=)(\\w{5})(\\w*)";
    private static final Pattern EMAIL_DTO_PATTERN = Pattern.compile(EMAIL_DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String EMAIL_DTO_REPLACEMENT_REGEX = "$1****$3";

    /* Regex to identify email keys of JSON objects. */
    private static final String EMAIL_JSON_REGEX = "(\"[a-zA-Z0-9\\s]*email\":\\s*\")(\\w{4})(\\w*)";
    private static final Pattern EMAIL_JSON_PATTERN = Pattern.compile(EMAIL_JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String EMAIL_JSON_REPLACEMENT_REGEX = "$1****$3";

    public static void checkIterator(LombookCheck lombookCheck){

//        logger.info("logger info for hashmap {}", mask(lombookCheck.getHashmap()));

//        logger.info("logger info is {}", mask(lombookCheck));
//        logger.info("logger info json object is {}", mask(lombookCheck.getJsonObject()));
//        String list="country=username@domain.com, email=kunalgupta@gmail.com, mode=sandbox, wixMerchantId=4aeffb33-78a5-498c-9769-fb1968ad9558";
        String payOpt="UPI,STORE_CASH,CC,DC";
        if((payOpt.indexOf("EMI_DC", 0) >= 0 || payOpt.indexOf("EMI", 0) < 0)
                && !(("PPBL".equals("HDFC") || "PPBT".equals("HDFC")) &&
                ((payOpt.indexOf("NB", 0) >= 0) || (payOpt.indexOf("BANK_TRANSFER", 0) >= 0) || (payOpt.indexOf("BANK_TRANSFER_CHECKOUT", 0) >= 0)))){

            logger.info("logger info is {}",payOpt.indexOf("STORE_CASH",0) >=0);

            System.out.println("Masked input string:" + lombookCheck);
        }


      }

    public static String mask(Object loggerObject) {


        if(Objects.isNull(loggerObject))
            return null;

        String maskedMessage = loggerObject.toString();
        try {
            maskedMessage = maskEmail(maskedMessage);
        } catch (Exception e) {
            logger.info("Failed while masking");
        }
        return maskedMessage;
    }

    private static String maskEmail(String message) {
        Matcher matcher;

        matcher = EMAIL_DTO_PATTERN.matcher(message);
        message= maskMatcher(matcher,EMAIL_DTO_REPLACEMENT_REGEX);

        matcher = EMAIL_JSON_PATTERN.matcher(message);
        message= maskMatcher(matcher,EMAIL_JSON_REPLACEMENT_REGEX);
//        throw new RuntimeException();


        return message;
    }

    private static String maskMatcher(Matcher matcher, String maskStr) {
        return matcher.replaceAll(maskStr);
    }

    public static void main(String args[]) {
        JSONObject object = new JSONObject();
        object.put("currency3","1123");
        object.put(" 8pEmail","kunagup@gmail.com");
        object.put("currency23","1123");

        Map<String,Object> hashmap=new HashMap<>();
        hashmap.put("primaryEmail","hashmap@gmail.com");


        LombookCheck lombookCheck=new LombookCheck();
        lombookCheck.setBillNumber("1345");
        lombookCheck.setEmail("kunalgupta@gmail.com");
        lombookCheck.setPrimaryEmail("comojne@gmail.com");
//        lombookCheck.setSEmail("kunalgupta@gmail,com");

        lombookCheck.setJsonObject(object);
        lombookCheck.setHashmap(hashmap);
        checkIterator(lombookCheck);
//        practice.jsonToObject();
//        practice.arrayListPrint();
    }
}




//    public static void main(String args[]) {
//        String s1="xyzabcdefghijklmnopqrstuvw";
//        char[] arr=s1.toCharArray();
//        int value = 0;
//        for (int i = 0; i < (arr.length)-1; i++)
//        {
//            int valueTill=0;
//            if(arr[i]==97) {
//                 int j=i;
//                while (j+1 <arr.length && arr[j] + 1 == arr[j + 1] ) {
//                    valueTill=valueTill+1;
//                    j++;
//                }
//            }
//            if(valueTill>value)
//                value=valueTill;
//        }
//        System.out.println(25-value);

//    }

//    public static void main(String args[]) {
//        POJOOutput pojoOutput = null;
//        if(Objects.nonNull(pojoOutput))
//        System.out.println(pojoOutput.getBody());
//    }

//    public static void main(String args[]) {
//        List<String> list=new ArrayList<>();
//        list.add("kunal");
//        list.add("hi");
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("('");
//        for (String i : list){
//            sb.append(i+"','");
//        }
//        sb.deleteCharAt(sb.length() -1);
//        sb.deleteCharAt(sb.lastIndexOf(","));
//        sb.append(")");
//
//        String query="Select prop_key, prop_value from recharge_dynamic_properties where prop_type = 'RECHARGE_CONFIGURATION' AND prop_key IN ".concat(sb.toString());
//        System.out.println(query);
//    }



//    public static void main(String[] args)
//    {
//        int day = 5;
//        String dayString;
//        String cashback;
//
//        // switch statement with int data type
//        switch (day) {
//            case 1:
//                dayString = "Monday";
//                cashback="supercash";
//                break;
//            case 2:
//                dayString = "Tuesday";
//                cashback="wallet";
//                break;
//            case 3:
//                dayString = "Wednesday";
//                cashback="instant";
//                break;
//            default:
//                dayString = "Invalid day";
//                cashback="instantVoucher";
//        }
//        System.out.println(dayString);
//        System.out.println(cashback);
//    }

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
//
//
//    int add(int a, int b) {
//        return a + b;
//    }
//
//   class B extends Practice {
//       public static void main(String args[]) {
//           short s = 9;
//        System.out.println(add(s,6)); //error on this line
//       }
//   }
