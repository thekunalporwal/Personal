package javaMiscellaneous;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import InterfaceAndJavaBasics.Enum1;
import InterfaceAndJavaBasics.SampleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.springframework.util.StringUtils;

public class DatePractice {

    public void dates(String date) throws ParseException, JsonProcessingException {
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

        SampleDTO sampleDTO=new SampleDTO();
        sampleDTO.setUserId("Kunal");
        sampleDTO.setEnumValue(Enum1.HEY_KUNAL);

        SampleDTO sampleDTO2=new SampleDTO();
        sampleDTO2.setUserId("Kunal");
//        sampleDTO2.setEnumValue(Enum1.HEY_KUNAL);

//        String objStr= sampleDTO.jsonStringify(new ObjectMapper());
//                System.out.println("OBJstr is" + objStr);

//        SampleDTO obj= SampleDTO.getInstance(objStr,new ObjectMapper());
        if(sampleDTO2!=null && Enum1.HEY.equals(null))
         System.out.println("OBJ str DTO is" + sampleDTO2);

//        System.out.println("OBJstr DTO boolean is" + obj.equals(sampleDTO2));






    }

        public static void main(String args[]) throws ParseException, JsonProcessingException {
         DatePractice datePractice=new DatePractice();
         datePractice.dates("2021-10-14");
    }
}
