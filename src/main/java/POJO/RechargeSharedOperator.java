package POJO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RechargeSharedOperator {

    private Boolean success;
    private List<Data> data;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RechargeSharedOperator.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("success");
        sb.append('=');
        sb.append(((this.success == null)?"<null>":this.success));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
