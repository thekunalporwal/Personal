package Service.javaMiscellaneous.streamsExample;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RechargeExample {

    public static void main (String[] args) {


        List<PaymentItemList> lineItemList = new ArrayList<>();
        lineItemList.add(new PaymentItemList("OPERATOR_REF_NO", "ABC"));
        lineItemList.add(new PaymentItemList("OPERATOR_REF_NO2", null));
        lineItemList.add(new PaymentItemList("OPERATOR_REF_NO3", "ABCde"));

        System.out.println("Value find is " +lineItemList.size());

        lineItemList=  lineItemList.stream().filter(lineItem -> !StringUtils.isEmpty(lineItem.getDisplayValue())).collect(Collectors.toList());

        System.out.println("size " +lineItemList.size());


       lineItemList.forEach(line->{
            System.out.println("Value find is " +line.toString());
       });
    }
}
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
class PaymentItemList {

    private String displayName;
    private String displayValue;
    private Boolean toCopy;

    public PaymentItemList(){}

    public PaymentItemList(String displayName, String displayValue){
        this.displayName = displayName;
        this.displayValue = displayValue;
    }
}
