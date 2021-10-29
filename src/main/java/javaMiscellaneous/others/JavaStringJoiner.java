package javaMiscellaneous.others;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class JavaStringJoiner {

    public static void main (String[] args){
//
//        LocalDate currentdate = LocalDate.now();
//        Month currentMonth = currentdate.getMonth();
//        System.out.println(currentMonth);
        String billNumber = null;
        if(!StringUtils.isEmpty(billNumber)) {
           if(!billNumber.equals("null"))
               System.out.println("first date of current month is " + billNumber);   // 2019-09-01
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
        String firstDayOfMonth= firstDay.format(formatter);

        System.out.println("first date of current month is " +firstDayOfMonth);   // 2019-09-01


        StringJoiner string1=new StringJoiner(",");
        string1.add("Kunal");
        string1.add("Gupta");

//        System.out.println(string1 +" " +String.valueOf(string1.length()));

        StringJoiner string2=new StringJoiner(",","[","]");
        string2.add("Kunal2");
        string2.add("Gupta2");

//        System.out.println(string2 +" " +String.valueOf(string2.length()));

        StringJoiner merge = string2.merge(string1);

        StringJoiner merge2 = string1.merge(string2);   //2nd string prefix and suffix will get removed.

//        System.out.println(merge +"-> Length is " +String.valueOf(merge.length()));
//        System.out.println(merge2 +"-> Length is " +String.valueOf(merge2.length()));

    }
}
