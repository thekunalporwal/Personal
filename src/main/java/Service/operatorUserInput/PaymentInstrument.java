package Service.operatorUserInput;

import lombok.Data;

@Data
public class PaymentInstrument {
    private String type;
    private String ifscCode;
    private String refId;
}
