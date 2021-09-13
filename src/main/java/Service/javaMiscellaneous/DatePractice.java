package Service.javaMiscellaneous;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTimeComparator;

import java.util.Map;

public class DatePractice {

    public void dates(String date) throws ParseException {
        Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Date currentDate = new Date();

        if (DateTimeComparator.getDateOnlyInstance().compare(currentDate,expiryDate) > 0 ) {
            System.out.println(currentDate +" " +expiryDate);
        }

    }

        public static void main(String args[]) throws ParseException {
         DatePractice datePractice=new DatePractice();
         datePractice.dates("2021-09-12");
    }
}
