package Service.utils;
import com.google.common.html.HtmlEscapers;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

//import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;


public class StringEncoderUtil {

    public static String escapeHTML(String input){
//        return escapeHtml(input);
        return input != null ? HtmlEscapers.htmlEscaper().escape(input) : input;
    }

    public static boolean hasHtml(String text) {
        return !StringUtils.isEmpty(text) && !text.equals(HtmlUtils.htmlEscape(text));
    }



}