package Service.operatorUserInput;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {


    public static void isValidError(String responseStg) throws JSONException {

        JSONObject jobj = new JSONObject(responseStg);
        String message = jobj.getString("message");
        System.out.println(jobj);
        System.out.println(message);


        if(StringUtils.equals(message,"CONTACT NOT PRESENT FOR GIVEN OWNER"))
            System.out.println(true);
        else
        System.out.println(false);
    }


    public static String generateDeleteInstrumentsRequestBody(String mid, List<String> ownerPaymentRefIds, boolean isPpsl) throws JSONException {

        JSONObject requestBody = new JSONObject();
        JSONArray paymentInstruments = new JSONArray();

        for(String ownerRefId : ownerPaymentRefIds) {
            JSONObject paymentInstrument = new JSONObject();
            paymentInstrument.put("ownerPaymentInstrumentRefId", ownerRefId);
            paymentInstruments.put(paymentInstrument);
        }

        JSONObject deleteBody= new JSONObject();
        deleteBody.put("paymentInstruments", paymentInstruments);
        requestBody.put("delete",deleteBody);
        requestBody.put("clientContactId", mid);
        JSONObject ownerDetails = new JSONObject();
        if(isPpsl)
            ownerDetails.put("ownerId", "PPCL Owner Id");
        else
            ownerDetails.put("ownerId", "OWNER_ID");
        requestBody.put("ownerDetails", ownerDetails);
        System.out.println("Delete Instrument and Update MID Request Body: " +requestBody);
        return requestBody.toString();
    }

    public static String generateDeleteInstrumentsAndMidUpdateRequest(String mid, List<String> ownerPaymentRefIds, String contactId, boolean isPpsl) throws JSONException {

        JSONObject requestBody = new JSONObject();

        JSONObject deleteBody= new JSONObject();
        JSONArray paymentInstruments = new JSONArray();
        for(String ownerRefId : ownerPaymentRefIds) {
            JSONObject paymentInstrument = new JSONObject();
            paymentInstrument.put("ownerPaymentInstrumentRefId", ownerRefId);
            paymentInstruments.put(paymentInstrument);
        }
        deleteBody.put("paymentInstruments", paymentInstruments);

        JSONObject updateObject = new JSONObject();
        JSONObject contactInfo = new JSONObject();
        contactInfo.put("clientContactRefId", mid);
        updateObject.put("contactInfo", contactInfo);

        requestBody.put("delete",deleteBody);
        requestBody.put("update", updateObject);

        JSONObject ownerDetails = new JSONObject();
        if(isPpsl)
            ownerDetails.put("ownerId", "PPCL Owner Id");
        else
            ownerDetails.put("ownerId", "OWNER_ID");

        requestBody.put("ownerDetails", ownerDetails);
        requestBody.put("contactId",contactId);
        System.out.println("Delete Instrument and Update MID Request Body: " +requestBody);
        return requestBody.toString();
    }

    public static void main(String args[]) throws Exception {

        List<PaymentInstrument> list=new ArrayList<>();
        List<PaymentInstrument> list2=new ArrayList<>();

        PaymentInstrument paymentInstrument=new PaymentInstrument();
        paymentInstrument.setType("WALLET");
        paymentInstrument.setIfscCode("1234");
        paymentInstrument.setRefId("1");

        PaymentInstrument paymentInstrument2=new PaymentInstrument();
        paymentInstrument2.setType("prepaid");
        paymentInstrument2.setIfscCode("PYTM0123456");
        paymentInstrument2.setRefId("2");


        PaymentInstrument paymentInstrument3=new PaymentInstrument();
        paymentInstrument3.setType("another");
        paymentInstrument3.setIfscCode("123456789");
        paymentInstrument3.setRefId("3");


        list.add(paymentInstrument);
        list.add(paymentInstrument2);
        list.add(paymentInstrument3);

        System.out.println(list);


//        List<PaymentInstrument> bankTypeFiltered= list.stream().filter(p -> !((StringUtils.equals(p.getIfscCode(), "1234") && StringUtils.equals(p.getType(), "WALLET")) || StringUtils.equals(p.getIfscCode(),"PYTM0123456")))
//                .collect(Collectors.toList());

        List<String> ownerPayRefIds2=list.stream().filter(p -> !((StringUtils.equals(p.getIfscCode(), "1234") && StringUtils.equals(p.getType(), "WALLET")) || StringUtils.equals(p.getIfscCode(),"PYTM0123456")))
                .map(PaymentInstrument::getRefId).collect(Collectors.toList());
        System.out.println("Tested Method "+ ownerPayRefIds2);

        Optional<PaymentInstrument> walletBankInfo = list.stream()
                .filter(data -> StringUtils.equals(data.getIfscCode(),"1234")).findFirst();
        System.out.println("output "+ walletBankInfo.isPresent());

        System.out.println(list);




//        System.out.println(bankTypeFiltered);
//        List<String> ownerPayRefIds = bankTypeFiltered.stream().map(PaymentInstrument::getRefId).collect(Collectors.toList());

//        if(!ownerPayRefIds.isEmpty())
//        System.out.print(ownerPayRefIds);


//      generateDeleteInstrumentsAndMidUpdateRequest("1234",ownerPayRefIds,"abcd",false);
//      generateDeleteInstrumentsRequestBody("1234",ownerPayRefIds,false);
//        isValidError("{\"success\":false,\"code\":\"490\",\"errorCode\":\"490\",\"status\":\"SUCCESS\",\"message\":\"CONTACT NOT PRESENT FOR GIVEN OWNER\"}");

    }
}
