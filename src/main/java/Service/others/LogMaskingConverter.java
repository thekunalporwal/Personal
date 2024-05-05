package Service.others;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Plugin(name="LogMasking", category = "Converter")
@ConverterKeys({"PIImask2"})
public class LogMaskingConverter extends LogEventPatternConverter {

    private static final String ENCRYPT_KEY = "etJS1W+SyXUHXEZgbgK/Pg==";
    private static final String IV = "012345610abcde";

    /* Regex to identify keys of DTO and Hashmap. */
    private static final String DTO_REGEX = "(?i)((address1|address2|address3|country|state|city|bankAccountHolderName|bankAccount|firstName|lastName|userId|zipcode|pincode|pincodes|vpa|personalPan|businessPan|panNo|PAN_NO|panNumber|panNoBusiness|GSTIN|serialNo|deviceSerialNo|deviceSerialNumber|PROOF_NO|communicationpin|pin|COMMUNICATION_PIN|accountNo|bankAccNo|BANK_ACCOUNT_NO|authSignatoryIdProofNo)\\s*=\\s*[']?)((?!null\\b)([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+))";
    private static final Pattern DTO_PATTERN = Pattern.compile(DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String DTO_REPLACEMENT_REGEX = "$1****$5";
    private static final String PHONE_DTO_REGEX = "(?i)((mobileNumber1|mobileNumber2|alternateMobileNumber|phone|phoneNo|phoneNum|phoneNumber|Phone_Number|Mobile_Number|mobile|mobileNo|mobileNum|mobile_no|mobileNumber)\\s*=\\s*[']?)((?!null\\b)([+][\\w]{2})?((-[\\w]{2})|([\\w]{2}-?))([\\w]{6})([\\w!.#$%&'*+-/=?^_`{|}~]+))";
    private static final Pattern PHONE_DTO_PATTERN = Pattern.compile(PHONE_DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String PHONE_DTO_REPLACEMENT_REGEX = "$1$4$5******$9";

    /* Regex to identify contact number of JSON objects. */
    private static final String PHONE_JSON_REGEX = "(\"[\\w\\s]*(mobileNumber1|mobileNumber2|alternateMobileNumber|phone|phoneNo|phoneNum|phoneNumber|Phone_Number|Mobile_Number|mobile|mobileNo|mobileNum|mobile_no|mobileNumber)\"\\s*:\\s*\")(([+][\\w]{2})?((-[\\w]{2})|([\\w]{2}-?))([\\w]{6})([\\w!.#$%&'*+-/=?^_`{|}~]+))";
    private static final Pattern PHONE_JSON_PATTERN = Pattern.compile(PHONE_JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String PHONE_JSON_REPLACEMENT_REGEX = "$1$4$5******$9";

    private static final String EMAIL_DTO_REGEX = "(?i)((EmailId|email|pEmail|sEmail|contactEmailId|primaryEmail|communicationEmails)\\s*=\\s*[']?)((?!null\\b)([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]+[@])([\\w!.#$%&'*+-/=?^_`{|}~]+))";
    private static final Pattern EMAIL_DTO_PATTERN = Pattern.compile(EMAIL_DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String EMAIL_DTO_REPLACEMENT_REGEX = "$1***$5******@$7";

    /* Regex to identify contact number of JSON objects. */
    private static final String EMAIL_JSON_REGEX = "(\"[\\w\\s]*(EmailId|email|pEmail|sEmail|contactEmailId|primaryEmail|communicationEmails)\"\\s*:\\s*\")(([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]+[@])([\\w!.#$%&'*+-/=?^_`{|}~]+))";
    private static final Pattern EMAIL_JSON_PATTERN = Pattern.compile(EMAIL_JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String EMAIL_JSON_REPLACEMENT_REGEX = "$1***$5******@$7";

    /* Regex to identify keys of JSON objects. */
    private static final String JSON_REGEX = "(\"[\\w\\s]*(address1|address2|address3|country|state|city|bankAccountHolderName|bankAccount|firstName|lastName|userId|zipcode|pincode|pincodes|vpa|personalPan|businessPan|panNo|PAN_NO|panNumber|panNoBusiness|GSTIN|serialNo|deviceSerialNo|deviceSerialNumber|PROOF_NO|communicationpin|pin|COMMUNICATION_PIN|accountNo|bankAccNo|BANK_ACCOUNT_NO|authSignatoryIdProofNo)\"\\s*:\\s*[\"\\[]?)(([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+))";
    private static final Pattern JSON_PATTERN = Pattern.compile(JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String JSON_REPLACEMENT_REGEX = "$1****$5";

    /* Regex to identify keys of JSON objects. */
    private static final String URL_DTO_REGEX = "(?i)(URL=)(https?://)?(www\\.)?(?!null\\b)([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern URL_DTO_PATTERN = Pattern.compile(URL_DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String URL_DTO_REPLACEMENT_REGEX = "$1$2$3****$5";
    private static final String URL_REGEX = "(?i)(https?://)?(www\\.)?(?!null\\b)([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+)([.][\\w]+)";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String URL_REPLACEMENT_REGEX = "$1$2****$4$5";
    private static final String ARRAY_URL_DTO_REGEX = "(?i)(url=\\[[^\\]*]+\\])";
    private static final Pattern ARRAY_URL_DTO_PATTERN = Pattern.compile(ARRAY_URL_DTO_REGEX,Pattern.CASE_INSENSITIVE);

    private static final String ARRAY_URL_JSON_REGEX = "(\"[\\w\\s]*(URL)\":\\s*\\[\"[^\\]*]+\\])";
    private static final Pattern ARRAY_URL_JSON_PATTERN = Pattern.compile(ARRAY_URL_JSON_REGEX,Pattern.CASE_INSENSITIVE);

    /* Regex to identify keys of JSON objects. */
    private static final String URL_JSON_REGEX = "(\"[\\w\\s]*(URL)\":\\s*\")(https?://)?(www\\.)?([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern URL_JSON_PATTERN = Pattern.compile(URL_JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String URL_JSON_REPLACEMENT_REGEX = "$1$3$4****$6";
    public static String encryptionProperty = "false" ;


    protected LogMaskingConverter(String name, String style) {
        super(name, style);
    }

    public static LogMaskingConverter newInstance(String[] options) {
        return new LogMaskingConverter("PIImask",Thread.currentThread().getName());
    }

    @Override
    public void format(LogEvent event, StringBuilder outputMessage) {

        String message = event.getMessage().getFormattedMessage();
        String maskedMessage = message;
        try {
            maskedMessage = mask(message);
        } catch (Exception e) {
            maskedMessage = message;
        }
        outputMessage.append(maskedMessage);

    }
    private String mask(String message) throws Exception {
        Matcher matcher =null;
        StringBuffer buffer = new StringBuffer();
        StringBuffer tempBuffer = new StringBuffer();
        String urls = null;
        Matcher tempMatcher =null;
        boolean showEncrypted = Boolean.parseBoolean(encryptionProperty);
        matcher = DTO_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,DTO_REPLACEMENT_REGEX,showEncrypted);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = JSON_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,JSON_REPLACEMENT_REGEX,showEncrypted);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = PHONE_DTO_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,PHONE_DTO_REPLACEMENT_REGEX,showEncrypted);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = PHONE_JSON_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,PHONE_JSON_REPLACEMENT_REGEX,showEncrypted);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = EMAIL_DTO_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,EMAIL_DTO_REPLACEMENT_REGEX,showEncrypted);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = EMAIL_JSON_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,EMAIL_JSON_REPLACEMENT_REGEX,showEncrypted);
        message = buffer.toString();
        buffer.setLength(0);


        return message;
    }
    private StringBuffer maskMatcher(Matcher matcher, StringBuffer buffer, String maskStr, boolean showEncrypted) throws Exception {
        while (matcher.find()) {
                matcher.appendReplacement(buffer,maskStr);
        }
        matcher.appendTail(buffer);
        return buffer;
    }
}