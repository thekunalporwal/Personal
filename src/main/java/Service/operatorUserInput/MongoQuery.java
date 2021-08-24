package Service.operatorUserInput;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class MongoQuery{

    static int fieldId=0;
    static int layoutId=0;


    private static final Logger logger = LogManager.getLogger(MongoQuery.class);


    public static Boolean processFile(File file) throws IOException {
        OperatorUserInputNew userInput=new OperatorUserInputNew();

        // Seller Determination.
        List<OperatorUserInputNew.SellerDetermination> sellerDeterminations=new ArrayList<>(); //List of SellerDetermination

        OperatorUserInputNew.SellerDetermination sellerDetermination=new OperatorUserInputNew.SellerDetermination(); //Document of sellerDetermination

        List<OperatorUserInputNew.Field> fieldList =new ArrayList<>(); //List of Fields
        List<OperatorUserInputNew.Layout> layoutList =new ArrayList<>(); //List of Layouts.

        List<Map<String,String>> linkedCombinationList=new ArrayList<>(); //MAP of Linked combination
        sellerDetermination.setIdentifier("47");

        //TOP level document.
        List<OperatorUserInput.TopLevelDocument> listOFTopLevelDoc=new ArrayList<>(); //List of Top Level document.


        OperatorUserInput.TopLevelDocument topLevelDocumentForState=new OperatorUserInput.TopLevelDocument(); //State
        OperatorUserInput.TopLevelDocument topLevelDocumentForCity=new OperatorUserInput.TopLevelDocument();  //City
        OperatorUserInput.TopLevelDocument topLevelDocumentForSchool=new OperatorUserInput.TopLevelDocument(); //School

        List<OperatorUserInput.Document> documentListForState=new ArrayList<>(); //ListState
        List<OperatorUserInput.Document> documentListForCity=new ArrayList<>();   //ListCity
        List<OperatorUserInput.Document> documentListForSchool=new ArrayList<>();  //ListSchool

        Map<String, OperatorUserInput.Document> stateMap=new HashMap<>();
        Map<String, OperatorUserInput.Document> cityMap=new HashMap<>();

        Map<String, OperatorUserInputNew.Field> fieldMap=new HashMap<>();
        Map<String, String> fieldMapCombination=new HashMap<>();

        Map<String, OperatorUserInput.Document> labelMap=new HashMap<>();



        Map<String,Integer> commonMap=new HashMap<>();
        Map<String,String> linkedCombinationMap=new HashMap<>();


        FileInputStream file1 =new FileInputStream(file);

        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(file1);

        XSSFSheet sheet=xssfWorkbook.getSheetAt(0);

        Iterator<Row> rowIterable=sheet.iterator();

        int rowValueForState=1;
        int rowValueForCity=1;
        int rowValueForSchool=1;

        try {   //traverse row one by one
            while (rowIterable.hasNext()) {

                OperatorUserInput.Document documentForState=new OperatorUserInput.Document();
                OperatorUserInput.Document documentForCity=new OperatorUserInput.Document();
                OperatorUserInput.Document documentForSchool=new OperatorUserInput.Document();


                String combination=new String();
                String id=new String();


                Row row = rowIterable.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Map<String,List<OperatorUserInput.LinkedDocument>> map=new HashMap<>();
                Map<String,List<OperatorUserInput.LinkedDocument>> mapForSchool=new HashMap<>();

                List<OperatorUserInput.LinkedDocument>linkedDocumentList=new ArrayList<>();

                MongoDTO mongoDTO=new MongoDTO();

                while (cellIterator.hasNext()) {
                    List<OperatorUserInput.LinkedDocument> linkedDocumentListForCity=new ArrayList<>();
                    OperatorUserInput.LinkedDocument linkedDocumentForCity=new OperatorUserInput.LinkedDocument();

                    List<Integer> list=new ArrayList<>();


                    Cell cell = cellIterator.next();
                    if (cell.getStringCellValue().equalsIgnoreCase("State")) {
                        topLevelDocumentForState.setKey("state");
                        topLevelDocumentForState.setKeyDisplay("state");
                        topLevelDocumentForState.setSendBack("true");
                        System.out.println(cell.getStringCellValue());
                        System.out.println(cell.getColumnIndex());
                        continue;
                    }
                    if (cell.getStringCellValue().equalsIgnoreCase("City")) {
                        topLevelDocumentForCity.setKey("city");
                        topLevelDocumentForCity.setKeyDisplay("City");
                        topLevelDocumentForCity.setSendBack("true");
                        System.out.println(cell.getStringCellValue());
                        System.out.println(cell.getColumnIndex());
                        continue;
                    }
                    if (cell.getStringCellValue().equalsIgnoreCase("Schools")) {
                        topLevelDocumentForSchool.setKey("Schools");
                        topLevelDocumentForSchool.setKeyDisplay("Schools");
                        topLevelDocumentForSchool.setSendBack("true");
//                        System.out.println(cell.getStringCellValue());
//                        System.out.println(cell.getColumnIndex());
                        continue;
                    }
                    if (cell.getStringCellValue().equalsIgnoreCase("BillerId")) {
//                        System.out.println(cell.getStringCellValue());
//                        System.out.println(cell.getColumnIndex());
                        continue;
                    }

                    switch (cell.getColumnIndex()){

                        case 0:
                            if (commonMap.get(cell.getStringCellValue())==null){
                                commonMap.put(cell.getStringCellValue(),rowValueForState);
                            }
                            linkedDocumentForCity.setKey("state");
                            list.add(commonMap.get(cell.getStringCellValue()));
                            combination=String.valueOf(commonMap.get(cell.getStringCellValue()));
                            linkedDocumentForCity.setLinkedValues(list);
                            linkedDocumentListForCity.add(linkedDocumentForCity);
                            linkedDocumentList.add(linkedDocumentForCity);
                            map.put(cell.getStringCellValue(),linkedDocumentListForCity);
//                            System.out.println(map);
                            mapForSchool.put(cell.getStringCellValue(),linkedDocumentList);
//                            System.out.println(mapForSchool);
                            mongoDTO.setState(cell.getStringCellValue());

                            break;

                        case 1:
                            if (commonMap.get(cell.getStringCellValue())==null){
                                commonMap.put(cell.getStringCellValue(),rowValueForCity);
                            }
                            linkedDocumentForCity.setKey("city");
                            list.add(commonMap.get(cell.getStringCellValue()));
                            combination=combination+"~"+String.valueOf(commonMap.get(cell.getStringCellValue()));
                            linkedDocumentForCity.setLinkedValues(list);
                            linkedDocumentList.add(linkedDocumentForCity);
                            mapForSchool.put(cell.getStringCellValue(),linkedDocumentList);
                            mongoDTO.setCity(cell.getStringCellValue());
                            break;

                        case 2:
                            mongoDTO.setSchool(cell.getStringCellValue());
                            break;

                        case 3:
                            mongoDTO.setBillerId(cell.getStringCellValue());
                            fieldList.add(generateFieldMap(cell.getStringCellValue(),fieldMap,fieldMapCombination));
                            id=generateLayoutMap(cell.getStringCellValue(),fieldMap,fieldMapCombination,layoutList);
                            combination=combination+"~"+cell.getStringCellValue();
                            break;

                    }

                }
                System.out.println(mongoDTO.toString());
//                System.out.println(linkedDocumentList);

                if (mongoDTO.getCity()!=null ) {
                    if (stateMap.get(mongoDTO.getState()) == null) {
                        documentForState.setValue(String.valueOf(rowValueForState));
                        documentForState.setValueDisplay(mongoDTO.getState());
                        documentListForState.add(documentForState);
                        stateMap.put(mongoDTO.getState(), documentForState);
//                        System.out.println(stateMap);
                        rowValueForState++;
                    }

                    if (cityMap.get(mongoDTO.getCity())==null) {
                        documentForCity.setValue(String.valueOf(rowValueForCity));
                        documentForCity.setValueDisplay(mongoDTO.getCity());
                        documentForCity.setLinkedDocuments(map.get(mongoDTO.getState()));
                        documentListForCity.add(documentForCity);
                        cityMap.put(mongoDTO.getCity(),documentForCity);
                        rowValueForCity++;
                    }


                    documentForSchool.setValue(mongoDTO.getBillerId());
                    documentForSchool.setValueDisplay(mongoDTO.getSchool());
                    documentForSchool.setLinkedDocuments(linkedDocumentList);
                    documentListForSchool.add(documentForSchool);
                    rowValueForSchool++;
                }

                linkedCombinationMap.put(combination,id);

            }
            topLevelDocumentForState.setDocuments(documentListForState);
            topLevelDocumentForCity.setDocuments(documentListForCity);
            topLevelDocumentForSchool.setDocuments(documentListForSchool);
            listOFTopLevelDoc.add(topLevelDocumentForState);
            listOFTopLevelDoc.add(topLevelDocumentForCity);
            listOFTopLevelDoc.add(topLevelDocumentForSchool);
            userInput.setTopLevelDocuments(listOFTopLevelDoc);
            sellerDetermination.setLinkedCombinations(linkedCombinationMap);
            sellerDeterminations.add(sellerDetermination);
            userInput.setSellerDetermination(sellerDeterminations);
            userInput.setFields(fieldList);
            userInput.setLayouts(layoutList);
            userInput.setOperatorId("274");


        }catch (Exception e){
            logger.info("Inside fetching");
            logger.info(e,e);
            return false;
        }

        System.out.println(fieldMap);
        System.out.println(fieldMapCombination);

        //  System.out.println(documentListForCity);
        //  System.out.println(documentListForSchool);
//         System.out.println(userInput.getTopLevelDocuments().get(2).getDocuments().size());
//         System.out.println(userInput.getSellerDetermination().get(0).getLinkedCombinations().size());
        System.out.println(new Gson().toJson(userInput));

        return true;
    }

    public static OperatorUserInputNew.Field generateFieldMap(String Biller_id,Map<String,OperatorUserInputNew.Field> fieldmap,Map<String,String> fieldMapCombination){
        StringBuilder combination=new StringBuilder();

        if(fieldmap.get("abcdegh")!=null) {
            combination.append(fieldmap.get("abcdefgh").getIdentifier()).append('~');
            return null;
        } else {
            OperatorUserInputNew.Field field = new OperatorUserInputNew.Field();
            field.setFieldKey(generatingRandomString());
            field.setIdentifier(String.valueOf(fieldId));
            field.setName(generatingRandomString());
            field.setIsnumeric(true);
            field.setRegex(generatingRandomString());
            field.setIcon("x");
            combination.append(fieldId).append('~');
            fieldId++;
            fieldmap.put(field.getName(), field);
            fieldmap.put(field.getIdentifier(), field);
            fieldMapCombination.put(Biller_id,combination.toString());
//            System.out.println("fieldid is" + fieldId);
            return field;
        }
    }

    public static String generateLayoutMap(String Biller_id,Map<String,OperatorUserInputNew.Field> fieldmap,Map<String,String> fieldMapCombination, List<OperatorUserInputNew.Layout> layoutList){

           OperatorUserInputNew.Layout layout=new OperatorUserInputNew.Layout();
           List<Integer> linkedLabel=new ArrayList<>();
           List<OperatorUserInputNew.LabelMapping> labelMapping=new ArrayList<>();


           String[] lables=fieldMapCombination.get(Biller_id).split("~");
//         String[] lables={"1","2","3"};
           for(String l1 : lables){
               OperatorUserInputNew.LabelMapping mapping= new OperatorUserInputNew.LabelMapping();
//               if(Objects.nonNull(fieldmap.get(l1)))
               mapping.setFieldName(fieldmap.get(l1).getName());
               mapping.setLabels(Collections.singletonList(Integer.valueOf(l1)));
               mapping.setSeparator(null);
               labelMapping.add(mapping);
               System.out.println(Integer.valueOf(l1));
               linkedLabel.add(Integer.valueOf(l1));
           }
//              linkedLabel.add(5);
           layout.setIdentifier(String.valueOf(layoutId++));
           layout.setViewBill(true);
           layout.setIsAmountRequired(false);
           layout.setLinkedLabels(linkedLabel);
           layout.setLabelMapping(labelMapping);

           layoutList.add(layout);
        return layout.getIdentifier();
    }

    public static String generatingRandomString() {

            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();

            return generatedString;

    }

    public static void main(String[] args) throws IOException {
        processFile(new File("/home/nirmeetikhandelwal/Education2.xlsx"));
    }

}

