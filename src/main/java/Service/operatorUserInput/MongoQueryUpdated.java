package Service.operatorUserInput;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class MongoQueryUpdated {


    private static final Logger logger = LogManager.getLogger(MongoQueryUpdated.class);


    public static Boolean processFile(File file) throws IOException {
        OperatorUserInput userInput=new OperatorUserInput();
        List<OperatorUserInput.TopLevelDocument> listOFTopLevelDoc=new ArrayList<>();
        OperatorUserInput.TopLevelDocument topLevelDocumentForState=new OperatorUserInput.TopLevelDocument();
        OperatorUserInput.TopLevelDocument topLevelDocumentForCity=new OperatorUserInput.TopLevelDocument();
        OperatorUserInput.TopLevelDocument topLevelDocumentForSchool=new OperatorUserInput.TopLevelDocument();

        List<OperatorUserInput.Document> documentListForState=new ArrayList<>();
        List<OperatorUserInput.Document> documentListForCity=new ArrayList<>();
        List<OperatorUserInput.Document> documentListForSchool=new ArrayList<>();

        Map<String, OperatorUserInput.Document> stateMap=new HashMap<>();
        Map<String, OperatorUserInput.Document> cityMap=new HashMap<>();



        FileInputStream file1 =new FileInputStream(file);

        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(file1);

        XSSFSheet sheet=xssfWorkbook.getSheetAt(0);

        Iterator<Row> rowIterable=sheet.iterator();

        int rowValueForState=0;
        int rowValueForCity=0;
        int rowValueForSchool=0;
        Map<String,Integer> commonMap=new HashMap<>();

        try {
            while (rowIterable.hasNext()) {
                OperatorUserInput.Document documentForState=new OperatorUserInput.Document();
                OperatorUserInput.Document documentForCity=new OperatorUserInput.Document();
                OperatorUserInput.Document documentForSchool=new OperatorUserInput.Document();


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
                        continue;
                    }
                    if (cell.getStringCellValue().equalsIgnoreCase("City")) {
                        topLevelDocumentForCity.setKey("city");
                        topLevelDocumentForCity.setKeyDisplay("City");
                        topLevelDocumentForCity.setSendBack("true");
                        continue;
                    }
                    if (cell.getStringCellValue().equalsIgnoreCase("Schools")) {
                        topLevelDocumentForSchool.setKey("Schools");
                        topLevelDocumentForSchool.setKeyDisplay("Schools");
                        topLevelDocumentForSchool.setSendBack("true");
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
                            linkedDocumentForCity.setLinkedValues(list);
                            linkedDocumentListForCity.add(linkedDocumentForCity);
                            linkedDocumentList.add(linkedDocumentForCity);
                            map.put(cell.getStringCellValue(),linkedDocumentListForCity);
                            mapForSchool.put(cell.getStringCellValue(),linkedDocumentList);
                            mongoDTO.setState(cell.getStringCellValue());

                            break;

                        case 1:
                            if (commonMap.get(cell.getStringCellValue())==null){
                                commonMap.put(cell.getStringCellValue(),rowValueForCity);
                            }
                            linkedDocumentForCity.setKey("city");
                            list.add(commonMap.get(cell.getStringCellValue()));
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
                            break;

                    }

                }

                if (mongoDTO.getCity()!=null ) {
                    if (stateMap.get(mongoDTO.getState()) == null) {
                        documentForState.setValue(String.valueOf(rowValueForState));
                        documentForState.setValueDisplay(mongoDTO.getState());
                        documentListForState.add(documentForState);
                        stateMap.put(mongoDTO.getState(), documentForState);
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

            }
            topLevelDocumentForState.setDocuments(documentListForState);
            topLevelDocumentForCity.setDocuments(documentListForCity);
            topLevelDocumentForSchool.setDocuments(documentListForSchool);
            listOFTopLevelDoc.add(topLevelDocumentForState);
            listOFTopLevelDoc.add(topLevelDocumentForCity);
            listOFTopLevelDoc.add(topLevelDocumentForSchool);
            userInput.setTopLevelDocuments(listOFTopLevelDoc);
            userInput.setOperatorId(Integer.valueOf("274"));


        }catch (Exception e){
            logger.info("Inside fetching");
            logger.info(e,e);
            return false;
        }
//        try {
//            //   rechargeMongoDAO.saveOperationInput(userInput);
//        }catch (Exception e){
//            logger.info(e,e);
//            return false;
//        }
//           System.out.println(documentListForState);
        //  System.out.println(documentListForCity);
        //  System.out.println(documentListForSchool);
        System.out.println(userInput.getTopLevelDocuments().get(0).getDocuments().size());

        System.out.println(new Gson().toJson(userInput));

        return true;
    }

    public static void main(String[] args) throws IOException {

        processFile(new File("/home/nirmeetikhandelwal/Downloads/Education Biller data.xlsx"));
    }

}

