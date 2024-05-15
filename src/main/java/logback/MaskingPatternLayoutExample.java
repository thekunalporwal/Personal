package logback;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MaskingPatternLayoutExample {

    public static void main(String[] args) {
        Map<String, String> user = new HashMap<String, String>();
        user.put("user_id", "87656");
        user.put("email", "786445563");
        user.put("address1", "22 Street");
        user.put("city", "Chicago");
        user.put("Country", "U.S.");
        user.put("ip_address", "192.168.1.1");
        user.put("email_id", "spring@baeldung.com");
        JSONObject userDetails = new JSONObject(user);

        log.info("MaskingPatternExample log from {}", userDetails);
    }
}