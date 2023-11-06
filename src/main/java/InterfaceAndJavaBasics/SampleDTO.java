package InterfaceAndJavaBasics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;

@Getter
@Setter
@ToString
public class SampleDTO {
    private String userId;
    private Enum1 enumValue;


    public static SampleDTO getInstance(String feesJson, ObjectMapper objectMapper){
        SampleDTO fees = null;
        try {
            fees = objectMapper.readValue(feesJson, SampleDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fees;
    }
    public String jsonStringify(ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsString(this);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("hehe");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleDTO obj = (SampleDTO) o;
        if(!this.getUserId().equals(obj.getUserId()))
            return false;
        if(!(this.getEnumValue()==obj.getEnumValue()))
            return false;
        return true;
    }

}
