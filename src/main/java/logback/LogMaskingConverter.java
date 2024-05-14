package logback;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogMaskingConverter extends MessageConverter {
    /* Regex to identify keys of DTO and Hashmap. */
    private static final String DTO_REGEX = "(?i)(deviceId|address1|address2|address3|country|state|city|bankAccountHolderName|bankAccount|firstName|lastName|userId|zipcode|pincode|pincodes|vpa|personalPan|businessPan|panNo|PAN_NO|panNumber|panNoBusiness|GSTIN|serialNo|deviceSerialNo|deviceSerialNumber|PROOF_NO|communicationpin|pin|COMMUNICATION_PIN|accountNo|bankAccNo|BANK_ACCOUNT_NO|authSignatoryIdProofNo)(\\s*=\\s*[']?)(?!null\\b)([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern DTO_PATTERN = Pattern.compile(DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String DTO_REPLACEMENT_REGEX = "$1$2****$4";
    private static final String PHONE_DTO_REGEX = "(?i)(mobileNumber1|mobileNumber2|alternateMobileNumber|phone|phoneNo|phoneNum|phoneNumber|Phone_Number|Mobile_Number|mobile|mobileNo|mobileNum|mobile_no|mobileNumber)(\\s*=\\s*[']?)(?!null\\b)([+][\\w]{2})?((-[\\w]{2})|([\\w]{2}-?))([\\w]{6})([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern PHONE_DTO_PATTERN = Pattern.compile(PHONE_DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String PHONE_DTO_REPLACEMENT_REGEX = "$1$2$3$5$6******$8";

    /* Regex to identify contact number of JSON objects. */
    private static final String PHONE_JSON_REGEX = "(\"[\\w\\s]*(mobileNumber1|mobileNumber2|alternateMobileNumber|phone|phoneNo|phoneNum|phoneNumber|Phone_Number|Mobile_Number|mobile|mobileNo|mobileNum|mobile_no|mobileNumber)\"\\s*:\\s*\")([+][\\w]{2})?((-[\\w]{2})|([\\w]{2}-?))([\\w]{6})([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern PHONE_JSON_PATTERN = Pattern.compile(PHONE_JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String PHONE_JSON_REPLACEMENT_REGEX = "$1$3$5$6******$8";

    private static final String EMAIL_DTO_REGEX = "(?i)(EmailId|email|pEmail|sEmail|contactEmailId|primaryEmail|communicationEmails)(\\s*=\\s*[']?)(?!null\\b)([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]+[@])([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern EMAIL_DTO_PATTERN = Pattern.compile(EMAIL_DTO_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String EMAIL_DTO_REPLACEMENT_REGEX = "$1$2***$4******@$6";

    /* Regex to identify contact number of JSON objects. */
    private static final String EMAIL_JSON_REGEX = "(\"[\\w\\s]*(EmailId|email|pEmail|sEmail|contactEmailId|primaryEmail|communicationEmails)\"\\s*:\\s*\")([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]{3})([\\w!.#$%&'*+-/=?^_`{|}~]+[@])([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern EMAIL_JSON_PATTERN = Pattern.compile(EMAIL_JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String EMAIL_JSON_REPLACEMENT_REGEX = "$1***$4******@$6";

    /* Regex to identify keys of JSON objects. */
    private static final String JSON_REGEX = "(\"[\\w\\s]*(deviceId|address1|address2|address3|country|state|city|bankAccountHolderName|bankAccount|firstName|lastName|userId|zipcode|pincode|pincodes|vpa|personalPan|businessPan|panNo|PAN_NO|panNumber|panNoBusiness|GSTIN|serialNo|deviceSerialNo|deviceSerialNumber|PROOF_NO|communicationpin|pin|COMMUNICATION_PIN|accountNo|bankAccNo|BANK_ACCOUNT_NO|authSignatoryIdProofNo)\"\\s*:\\s*[\"\\[]?)([\\w!.#$%&'*+-/=?^_`{|}~]{1,4})([\\w!.#$%&'*+-/=?^_`{|}~]+)";
    private static final Pattern JSON_PATTERN = Pattern.compile(JSON_REGEX,Pattern.CASE_INSENSITIVE);
    private static final String JSON_REPLACEMENT_REGEX = "$1****$4";

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

    @Override
    public String convert(ILoggingEvent event) {
        String message = event.getFormattedMessage();
        String maskedMsg = message;
        try{
            maskedMsg = mask(message);
        }catch (Exception ex){
            maskedMsg = message;
        }
        return maskedMsg;
    }


    private String mask(String message) {
        Matcher matcher =null;
        StringBuffer buffer = new StringBuffer();
        matcher = DTO_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,DTO_REPLACEMENT_REGEX);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = JSON_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,JSON_REPLACEMENT_REGEX);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = PHONE_DTO_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,PHONE_DTO_REPLACEMENT_REGEX);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = PHONE_JSON_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,PHONE_JSON_REPLACEMENT_REGEX);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = EMAIL_DTO_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,EMAIL_DTO_REPLACEMENT_REGEX);
        message=buffer.toString();
        buffer.setLength(0);

        matcher = EMAIL_JSON_PATTERN.matcher(message);
        maskMatcher(matcher, buffer,EMAIL_JSON_REPLACEMENT_REGEX);
        message = buffer.toString();
        buffer.setLength(0);

        return message;
    }
    private StringBuffer maskMatcher(Matcher matcher, StringBuffer buffer, String maskStr) {
        while (matcher.find()) {
            matcher.appendReplacement(buffer,maskStr);
        }
        matcher.appendTail(buffer);
        return buffer;
    }
}
