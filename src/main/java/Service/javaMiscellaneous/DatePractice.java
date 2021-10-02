package Service.javaMiscellaneous;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.springframework.util.StringUtils;

import java.util.Map;

public class DatePractice {

    public void dates(String date) throws ParseException {
        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Date currentDate = new Date();


        if(!StringUtils.isEmpty(date) && !StringUtils.isEmpty(expiryDate)){
            if (DateTimeComparator.getDateOnlyInstance().compare(date, currentDate) > 0) {
                System.out.println(currentDate + "This is Future date " + date);
            }
        }

        DateTime dateTime = new DateTime();
        dateTime = dateTime.minusMinutes(15);
//        System.out.println(currentDate + "This is 15 minus date " + dateTime);

        double amount= Double.parseDouble("236.0");
//        System.out.println(String.format("%.0f",amount * 100));




    }

        public static void main(String args[]) throws ParseException {
         DatePractice datePractice=new DatePractice();
         datePractice.dates("2021-10-14");
    }
}
