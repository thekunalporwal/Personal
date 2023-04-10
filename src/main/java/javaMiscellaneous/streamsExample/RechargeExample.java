package javaMiscellaneous.streamsExample;

import Service.utils.FeatureListV2;
import Service.utils.LombookCheck;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RechargeExample {

    public static void main (String[] args) throws JsonProcessingException {
        JSONObject jsonObject2=new JSONObject();
        JSONObject jsonObject1=new JSONObject();

        JSONObject jsonObject3=new JSONObject();
        JSONObject paymentConfirmationMode=new JSONObject();
        paymentConfirmationMode.put("value",true);
        paymentConfirmationMode.put("sound",false);
        paymentConfirmationMode.put("print",null);
        jsonObject3.put("voiceAds",true);
        jsonObject3.put("paymentConfirmationMode",paymentConfirmationMode);

        jsonObject1.put("featureList",jsonObject3);

        ObjectMapper mapper=new ObjectMapper();
        FeatureListV2 featureListV2=mapper.readValue(jsonObject3.toString(),FeatureListV2.class);
        System.out.println("Value featureListV2 is " +featureListV2 );

        JSONObject featureList= mapper.convertValue(featureListV2,JSONObject.class);
        jsonObject1.put("featureList",featureList);


        System.out.println("Value featureList is " +featureList );
        System.out.println("Json object 1  is " +jsonObject1 );

        if(featureListV2.getPaymentConfirmationMode()==null)
             System.out.println("mid is ");




//        LombookCheck lombookCheck=new LombookCheck();
//        lombookCheck.setIsCircleId(1);
//        System.out.println("Value checkfind is " +lombookCheck );
//        JSONObject jsonObject=new JSONObject();
//        LombookCheck response=mapper.readValue(jsonObject2.toString(),LombookCheck.class);
//        jsonObject= JSONObject.fromObject(mapper.writeValueAsString(lombookCheck));
//        System.out.println("Value checkfind is 2 " +jsonObject);
//        System.out.println(" is " + response);




//        boolean check=false;
        List<PaymentItemList> lineItemList = new ArrayList<>();
        lineItemList.add(new PaymentItemList("A", "ABC"));
        lineItemList.add(new PaymentItemList("B", "null"));
        lineItemList.add(new PaymentItemList("C", "ABCde"));

        List<PaymentItemList> lineItemList2=new ArrayList<>();


        System.out.println("Value find is " +lineItemList);

        lineItemList2=  lineItemList.stream().filter(l ->
                        (StringUtils.equalsIgnoreCase(l.getDisplayName(),"C"))).collect(Collectors.toList());

        System.out.println("Value for check2 is  " +lineItemList2);


        lineItemList.forEach(line->{
            System.out.println("Value find sequence is " +line.toString());
       });
    }

    public static void justcheckBoolean(List<PaymentItemList> lineItemList,MutableBoolean check){
        System.out.println("size " +lineItemList.stream().anyMatch(lt -> lt.getDisplayName().equalsIgnoreCase("a")));
        check.setValue(lineItemList.stream().anyMatch(lt -> lt.getDisplayName().equalsIgnoreCase("a")));
        System.out.println("Value for check is  " +check);
    }
}
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
class PaymentItemList {

    private String displayName;
    private String displayValue;

    public PaymentItemList(String displayName, String displayValue){
        this.displayName = displayName;
        this.displayValue = displayValue;
    }
}
