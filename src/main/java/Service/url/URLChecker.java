package Service.url;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class URLChecker {

    public void urlChange(String urlString) {

        LinkAdditionalParam linkAdditionalParam=new LinkAdditionalParam();

        URL url = null;
        MultiValueMap<String, String> queryParamsMap=null;
        Map<String, String> result=new HashMap<>();
        try {
            url = new URL(urlString);
            String decodedString = URLDecoder.decode(url.toString(), "UTF-8");
            queryParamsMap = UriComponentsBuilder.fromUriString(decodedString).build().getQueryParams();
            result = queryParamsMap.entrySet().stream().collect(Collectors.toMap( Map.Entry::getKey, e -> e.getValue().get(0)));

//            System.out.println("map is " +result);

        } catch (MalformedURLException | UnsupportedEncodingException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        createDTO(linkAdditionalParam , result);
    }

    public LinkAdditionalParam createDTO(LinkAdditionalParam linkAdditionalParam , Map<String,String> m1) {

        m1.forEach((key,value) -> {
            System.out.println("Key = "
                + key + ", Value = " + value);
            switch (key){
                case "bid":
                    linkAdditionalParam.setBillerId(value);
                    break;
                case "cnm":
                    linkAdditionalParam.setCustomerName(value);
                    break;
                case "bnm":
                    linkAdditionalParam.setBillNumber(value);
                    break;
                case "bpr":
                    linkAdditionalParam.setBillPeriod(value);
                    break;
                case "cid":
                    linkAdditionalParam.setDirectBillContentId(value);
                    break;
                case "bmt":
                    linkAdditionalParam.setAmount(value);
                    break;
                case "bdt":
                    linkAdditionalParam.setBillDate(value);
                    break;
                case "ddt":
                    linkAdditionalParam.setDueDate(value);
                    break;
                case "lmt":
                    linkAdditionalParam.setAmountAfterDueDate(value);
                    break;
                case "rdt":
                    linkAdditionalParam.setRebateDate(value);
                    break;
                case "rmt":
                    linkAdditionalParam.setRebateAmount(value);
                    break;
                case "edt":
                    linkAdditionalParam.setExpiryDate(value);
                    break;
                case "cpm":
                    createCustomerParam(linkAdditionalParam,m1,value);
                    break;
                case "bai":
                    createAdditonalInfo(linkAdditionalParam,m1,value);
                    break;
            }
        }
        );
        System.out.println(linkAdditionalParam);

        return linkAdditionalParam;
    }

    public void createCustomerParam(LinkAdditionalParam linkAdditionalParam,Map<String,String> map,String value){
        Map<String,String> customerParams=new LinkedHashMap<>();

        String cpm[] = value.split("\\|");
        for(int i=0 ; i< cpm.length ; i++){
            String paramName = null;
            String paramValue = null;
            paramName = cpm[i].split(":")[0];
            paramValue = cpm[i].split(":")[1];

            if(i==0) {
                String str="enc_".concat(paramName);
                System.out.println("encrypted key is "+ str);
                linkAdditionalParam.setEncCustomerParams(map.get(str));
            }

            customerParams.put(paramName,paramValue);
            }
        linkAdditionalParam.setCustomerParams(customerParams);
        System.out.println("map is "+ customerParams);

    }
    public void createAdditonalInfo(LinkAdditionalParam linkAdditionalParam,Map<String,String> map,String value){
        Map<String,String> additionalInfo=new LinkedHashMap<>();

        String additionalArray[] = value.split("\\|");
        for(int i=0 ; i< additionalArray.length ; i++){
            String paramName = null;
            String paramValue = null;
            paramName = additionalArray[i].split(":")[0];
            paramValue = additionalArray[i].split(":")[1];

            additionalInfo.put(paramName,paramValue);
        }
        linkAdditionalParam.setAdditionalInfo(additionalInfo);
        System.out.println("Additional info map is "+ additionalInfo);

    }

    public static void main(String args[]) {
        String str="https://bharatbillpay.com/pay?cid=21162414000831202106&bid=CESCOM000KAR01&cpm=Account%20ID%20(RAPDRP)%20OR%20Consumer%20Number%20%2F%20Connection%20ID%20(Non-RAPDRP):C4140008XX&cnm=SHARADAMMA&bnm=10142&bpr=JUNE&bmt=236.0&bdt=2021-09-01&ddt=2021-09-25&edt=2021-09-28&enc_Account%20ID%20(RAPDRP)%20OR%20Consumer%20Number%20%2F%20Connection%20ID%20(Non-RAPDRP)=5F1hMc4zqjVsvUMDhvEhUPoKfxPnVcMkQKMjXPYxxSAfuTLrP8DkXTTNZ2VZXZHHMzfDi2FB9vnv8UB2n7fHpS4";
        String str2="https://bharatbillpay.com/pay?bid=DUMMYBIDVALUE&cpm=CUSTREFID:XX3382636|DUMMYREF2:RTYE4562009|DUMMYREF3:8888888&cnm=Dummyfirstname%20Dummylastname&bnm=DUMMY3743P6631&bpr=NOVEMBER&bmt=5000.50&bdt=2020-01-22&ddt=2020-02-22&lmt=5050.50&rmt=4750.50&rdt=2020-01-15&bai=bf1:12345678901234567890|bf2:12345678901234567890|bf3:12345678901234567890&edt=2020-03-22%2015.30.00&enc_CUSTREFID=04185BEF668F2333C072480B5B746387AA8FC67526B112A9AC75C66A7B78A87F8EDA6CDD4B6FB7BA12F7764C9336192B1F007C4E1F5A2DA52B7F50CC044BA1BEA6C61EC45109D636E163FEE09B07A39496FC70029E8D746A8A25BA1E9575EFBD8953B0445B&cid=202259765409";

        URLChecker urlChecker=new URLChecker();
        urlChecker.urlChange(str2);
    }

}
