package javaMiscellaneous.streamsExample;

import Service.utils.LombookCheck;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RechargeExample {

    public static void main (String[] args) {
        MutableBoolean check=new MutableBoolean();

        LombookCheck lombookCheck=new LombookCheck();
        System.out.println("Value checkfind is " + Optional.ofNullable(lombookCheck).isPresent());
        Boolean posProviderRequest=lombookCheck.getIsIntFlag()!=null ? lombookCheck.getIsIntFlag() : false;
        System.out.println(" is " + posProviderRequest);




//        boolean check=false;
        List<PaymentItemList> lineItemList = new ArrayList<>();
        lineItemList.add(new PaymentItemList("A", "ABC"));
        lineItemList.add(new PaymentItemList("B", "null"));
        lineItemList.add(new PaymentItemList("C", "ABCde"));


        System.out.println("Value find is " +lineItemList);

        lineItemList=  lineItemList.stream().filter(lineItem -> (!lineItem.getDisplayValue().equals("ABCde")) && (StringUtils.equalsIgnoreCase(lineItem.getDisplayName(),"C") ||StringUtils.equalsIgnoreCase(lineItem.getDisplayName(),"d") )).collect(Collectors.toList());
//        justcheckBoolean(lineItemList,check);
        if(CollectionUtils.isNotEmpty(lineItemList))
        System.out.println("Value for check2 is  " +check);


        lineItemList.forEach(line->{
            System.out.println("Value find is " +line.toString());
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
