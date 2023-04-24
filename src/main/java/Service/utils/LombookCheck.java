package Service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.json.JSONObject;
import org.openqa.selenium.json.Json;

import java.util.Map;

@ToString
@Data
public class LombookCheck {

    private Boolean sound;
    private int isCircleId;
    private String billerId;
    private String billNumber;
    private String email;
    @ToString.Exclude
    private String primaryEmail;
    private String sEmail;

    private JSONObject jsonObject;
    private Map<String, Object> hashmap;


    public String jsonStringify(ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsString(this);
    }

}
