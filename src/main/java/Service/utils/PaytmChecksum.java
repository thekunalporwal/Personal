package Service.utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PaytmChecksum {


    public static void main (String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, NoSuchProviderException, InvalidKeyException, IOException {

        String key ="thisiskeytobeEn'crypted";
//        System.out.println("noneMatch" +RandomStringUtils.randomAlphabetic(16));
        String secretKey= "DVrEOFPutQmGiHIY";
        long epochTime = 1709283018000L;

        Map<String,Object> map=new HashMap<>();
        map.put("TERMINAL_ACTIVATION_TIME", "2024-02-23T13:38:07.000+0530");


            // Convert epoch time to LocalDateTime
           if(Objects.nonNull(map.get("TERMINAL_ACTIVATION_TIME")) && map.get("TERMINAL_ACTIVATION_TIME") instanceof Long) {
            LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli((Long) map.get("TERMINAL_ACTIVATION_TIME")), ZoneId.systemDefault());
            map.replace("TERMINAL_ACTIVATION_TIME", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        }
        System.out.println("hash map is: " +map);

//        String setTerminalActivationTime= Objects.isNull(hash.get("TERMINAL_ACTIVATION_TIME")) ? null : map.get("TERMINAL_ACTIVATION_TIME").toString());


        String encryptedValue = encrypt(key,secretKey);
        System.out.println("encryptedValue: " +encryptedValue);
        System.out.println("decryptedValue: " +decrypt(encryptedValue,secretKey));

        List<LombookCheck> lombookChecks= new ArrayList<>();
        List<String> KYC_ACCOUNT_TYPE_VALUES = Arrays.asList("savings","current","SOD","UOD");
        String kycAccountTypeValue = "";
        boolean valueExist = KYC_ACCOUNT_TYPE_VALUES.stream().anyMatch(kycAccountType -> kycAccountType.equalsIgnoreCase(kycAccountTypeValue));
        System.out.println("valueExist: " + valueExist);


    }

    private static final String ALGTHM_TYPE_AES = "AES";
    private static final String ALGTHM_CBC_PAD_AES = "AES/CBC/PKCS5PADDING";
    private static final String ALGTHM_PROVIDER_BC = "SunJCE";
    private static final byte[] ivParamBytes = {'@', '@', '@', '@', '&', '&', '&', '&', '#', '#', '#', '#', '$', '$', '$', '$'};

    public static String encrypt(String input, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String encryptedValue = "";
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "SunJCE");
        cipher.init(1, new SecretKeySpec(key.getBytes(), "AES"), new IvParameterSpec(ivParamBytes));
        byte[] baseEncodedByte = Base64.getEncoder().encode(cipher.doFinal(input.getBytes()));
        encryptedValue = new String(baseEncodedByte);
        return encryptedValue;
    }
    public static String decrypt(String input, String key) throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, IOException, BadPaddingException, IllegalBlockSizeException {
        String decryptedValue = "";
        Cipher cipher = Cipher.getInstance(ALGTHM_CBC_PAD_AES,ALGTHM_PROVIDER_BC);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), ALGTHM_TYPE_AES),new IvParameterSpec(ivParamBytes));
        byte[] baseDecodedByte = Base64.getDecoder().decode(input);
        decryptedValue = new String(cipher.doFinal(baseDecodedByte));
        return decryptedValue;
    }

    public static void main2(String[] args) {
        try {
            String line="Line No 1:Terminal ID : 9807123 Updated successfully Term Resource key:thisismydecryptedKey";
            Pattern pattern = Pattern.compile("Terminal ID : ([^\\s]+) Updated successfully Term Resource key:([^\\s]+)");
            // Iterate through each line in the CSV file
            // Use a Matcher to find the pattern in the line
            Matcher matcher = pattern.matcher(line);

            // If the pattern is found, extract Terminal ID and Key
            if (matcher.find()) {
                String tid = matcher.group(1);
                String key = matcher.group(2);

                // Output the results
                System.out.println("Terminal ID: " + tid + ", Term Resource key: " + key);
            } else {
                System.out.println("not found");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

