package javaMiscellaneous.streamsExample;

import lombok.Data;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample3 {

    @Data
     public static class Employee{
         public String salary;
         public Employee (String salary){
             this.salary=salary;
         }
     }

    public static String generateHTIDRetry(){
        int count=0;
        String htid="";
        while ( count < 2 && StringUtils.isBlank(htid)) {
            System.out.println("COUNT found is " + count);
            htid="";
//            if (StringUtils.isNotBlank(htid))
//                return htid;
            count++;
        }
        return htid;
    }

    public static void main (String[] args) {

        System.out.println("htid found is " +generateHTIDRetry());

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("5000"));
        list.add(new Employee("6000"));
        list.add(new Employee("4000"));
        list.add(new Employee("2000"));

        int value =list.stream()
                .map(employ -> employ.salary)
                .map(Integer::parseInt)
                .filter(emp-> emp.equals(1000))
                .findAny()
                .orElse(1);

       System.out.println("Value find is " +value);
       String msrBucketName="boss-settlement-report-dev";
       String filePath="s3://boss-settlement-report-dev/historical-reports/MDRPCF36387688962608/harman-test-boss/harman-test-boss.zip";
       String path=filePath.replace("s3://","").replace(msrBucketName+"/","");
       System.out.println("Value replace is " + path);

       if (StringUtils.equalsIgnoreCase("ONE_CLICK_SUPPORTED","ONE_CLICK_SUPPORTED")) {
                String prefValue="";
                String[] prefValues=prefValue.split(",");
                JSONObject payload = new JSONObject();
                payload.put("oneClickCardScheme", prefValues);
                System.out.println(payload.toString());
            }

    }

}
