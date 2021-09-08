package Service.url;

import lombok.Data;

import java.util.Map;

@Data
public class LinkAdditionalParam {
    private int operatorId;
    private int circleId;
    private String billerId;
    private String billNumber;
    private String billPeriod;
    private String billDate;
    private String amount;
    private String dueDate;
    private String amountAfterDueDate;
    private String rebateDate;
    private String rebateAmount;
    private String expiryDate;
    private Map<String,String> customerParams;
    private Map<String,String> additionalInfo;
    private String encCustomerParams;
    private String customerName;
    private String directBillContentId;
    private String billChannel;
}
