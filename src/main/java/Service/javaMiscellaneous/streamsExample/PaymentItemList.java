package Service.javaMiscellaneous.streamsExample;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentItemList {

    private String displayName;
    private String displayValue;
    private Boolean toCopy;

    public PaymentItemList(){}

    public PaymentItemList(String displayName, String displayValue){
        this.displayName = displayName;
        this.displayValue = displayValue;
    }
}
