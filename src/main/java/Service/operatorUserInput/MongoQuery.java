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

    private static final Logger logger = LogManager.getLogger(MongoQuery.class);


    public static Boolean processFile(File file) throws IOException {
        OperatorUserInputNew userInput=new OperatorUserInputNew();

        // Seller Determination.
        List<OperatorUserInputNew.SellerDetermination> sellerDeterminations=new ArrayList<>(); //List of SellerDetermination

        OperatorUserInputNew.SellerDetermination sellerDetermination=new OperatorUserInputNew.SellerDetermination(); //Document of sellerDetermination
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
                        System.out.println(cell.getStringCellValue());
                        System.out.println(cell.getColumnIndex());
                        continue;
                    }
                    if (cell.getStringCellValue().equalsIgnoreCase("BillerId")) {
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
                            System.out.println(map);
                            mapForSchool.put(cell.getStringCellValue(),linkedDocumentList);
                            System.out.println(mapForSchool);
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

                linkedCombinationMap.put(combination,"1");

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
            userInput.setOperatorId("274");


        }catch (Exception e){
            logger.info("Inside fetching");
            logger.info(e,e);
            return false;
        }

//           System.out.println(documentListForState);
        //  System.out.println(documentListForCity);
        //  System.out.println(documentListForSchool);
         System.out.println(userInput.getTopLevelDocuments().get(2).getDocuments().size());
         System.out.println(userInput.getSellerDetermination().get(0).getLinkedCombinations().size());
        System.out.println(new Gson().toJson(userInput));

        return true;
    }

    public static void main(String[] args) throws IOException {
        processFile(new File("/home/nirmeetikhandelwal/Education2.xlsx"));
    }

}

