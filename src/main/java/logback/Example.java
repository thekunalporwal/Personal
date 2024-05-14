package logback;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Example {

    public static void main(String[] args) {
        log.info("Example address deviceId=1235 , address1=kunal log from {}", Example.class.getSimpleName());
        log.info("Example address log from {}", "hehe");
    }
}
