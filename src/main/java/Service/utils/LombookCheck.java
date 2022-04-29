package Service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;


public class LombookCheck {
    public Boolean getIntFlag() {
        return isIntFlag;
    }

    public void setIsIntFlag(Boolean isIntFlag) {
        this.isIntFlag = isIntFlag;
    }


    public int getIsCircleId() {
        return isCircleId;
    }

    public void setIsCircleId(int isCircleId) {
        this.isCircleId = isCircleId;
    }

    private Boolean isIntFlag;
    private int isCircleId;
    private String billerId;
    private String billNumber;

    public String jsonStringify(ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsString(this);
    }

}
