package Service.utils;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CsvFileProcessor {

    public static void main(String[] args) throws IOException {

        JSONObject jsonObject = new JSONObject();
        JSONObject merchantJson = new JSONObject();
        merchantJson.put("CUST_ID", "custIdReceived");
        jsonObject.put("merchantJson", merchantJson);

        JSONObject merchantJson1 = jsonObject.getJSONObject("merchantJson");
        merchantJson1.put("CUST_ID2", "custIdReceived");
        String custIdReceived= jsonObject.has("CUST_ID") ? jsonObject.getString("CUST_ID") : "";
        jsonObject.put("CUST_ID", custIdReceived);

        List<String> mids =new ArrayList<>();
        mids.add("acd");
        mids.add("cd");
        mids.add("cdea");


        mids = mids.stream().filter(mid -> {
            String businessEntity="OCL";
            if(mid.contains("a"))
                businessEntity = "PPSL";

            return !StringUtils.equals(businessEntity,"PPSL");
        }).collect(Collectors.toList());



        System.out.println("fejnf" +mids);


//        String fileName="/Users/kunalgupta/Downloads/SAMPLE_TID_3DS_KEY_UPDATE3.csv";
//        MultipartFile multipartFile = new MockMultipartFile("SAMPLE_TID_3DS_KEY_UPDATE5.csv", new FileInputStream(new File(fileName)));
//        multipartFile= addRowToCsvTop(multipartFile,"Line No 1");
//        File file = new File("/Users/kunalgupta/Downloads/SAMPLE_TID_3DS_KEY_UPDATE7.csv");
//
//        try (OutputStream os = new FileOutputStream(file)) {
//            os.write(multipartFile.getBytes());
//        }
    }


    public static boolean isValidDateOfIncorporation(String doi) {
        if (doi == null || !doi.matches("\\d{4}-[01]\\d-[0-3]\\d"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            df.parse(doi);
        } catch (ParseException ex) {
            return false;
        }
        Date date = Calendar.getInstance().getTime();
        String today = df.format(date);
        if(today.compareTo(doi) >= 0)
            return true;
        return false;
    }


    public static void change(MultipartFile multipartFile) throws IOException {
        multipartFile= addRowToCsvTop(multipartFile,"Line No 1");

    }






    public static MultipartFile addRowToCsvTop(MultipartFile multipartFile, String newRow) throws IOException {

        InputStream inputStream = multipartFile.getInputStream();
        List<String> lines = readCsv(inputStream);
        lines.add(0, newRow);
        String updatedCsv = String.join("\n", lines);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(updatedCsv.getBytes(StandardCharsets.UTF_8));
        // Create a new MultipartFile with the same name
        return null;
    }

    private static List<String> readCsv(InputStream inputStream) throws IOException {
        List<String> lines = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}