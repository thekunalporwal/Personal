package Service.others;

public class Practice {
      public void checkIterator(){
          int operatorId=140;
          int circleId=1;
          String planCode="102003";

          StringBuilder mapKey=new StringBuilder();

          mapKey.append(operatorId).append("~").append(circleId).append("~").append(planCode);
          System.out.println(mapKey.toString());
      }

//    public void jsonToObject() {
//        String jasonString = "{\"success\":true,\"data\":[{\"operatorId\":1,\"operatorName\":\"airtel\",\"operatorTitle\":\"Airtel\",\"categoryName\":\"prepaid\",\"categoryId\":1},{\"operatorId\":2,\"operatorName\":\"vodafone\",\"operatorTitle\":\"Vodafone\",\"categoryName\":\"prepaid\",\"categoryId\":1}]}";
//
//        RechargeSharedOperator rechargeSharedOperator = new Gson().fromJson(jasonString, RechargeSharedOperator.class);
//
//        List<Data> list = new ArrayList<>(rechargeSharedOperator.getData());
//
//        for (Data datalist : list) {
//            System.out.println(datalist.getOperatorId());
//            System.out.println(datalist.getOperatorName());
//        }
//    }
//
//    public void arrayListPrint(){
//        List<String> widgetsPriority = new ArrayList<>();
//        widgetsPriority.add("KYC");
//        widgetsPriority.add("ZIP");
//        widgetsPriority.add("UPI");
//        widgetsPriority.add("AUTO_RECHARGE");
//        widgetsPriority.add("GRAND_SLAM");
//
//
//        widgetsPriority.forEach(widgets -> System.out.println(widgets));
//    }


    public static void main(String args[]) {
        Practice practice=new Practice();
        practice.checkIterator();
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
