package POJO;


import lombok.Getter;

@Getter
public class Data {

    Integer operatorId;
    String operatorName;
    String operatorTitle;
    String categoryName;
    Integer categoryId;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RechargeSharedOperator{");
        sb.append("operatorId=").append(operatorId);
        sb.append(", operatorName='").append(operatorName).append('\'');
        sb.append(", operatorTitle='").append(operatorTitle).append('\'');
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", categoryId=").append(categoryId);
        sb.append('}');
        return sb.toString();
    }
}
