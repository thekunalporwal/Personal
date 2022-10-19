package Service.utils;
import Service.operatorUserInput.MongoQuery;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pdf {


//    public byte[] process(File file) throws IOException {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        PDDocument document = PDDocument.load(file);
//
//
//    }


    public static void main(String[] args) throws IOException {
        Pdf pdf=new Pdf();
        String FILEPATH = "src/main/resources/abcdefghjbi.pdf";
        File file = new File(FILEPATH);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        ByteArrayOutputStream baos2=new ByteArrayOutputStream();


        OutputStream os = new FileOutputStream(file);
        Path pdfPath = Paths.get("/Users/kunalgupta/Downloads/777001788207309.pdf");
        Path pdfPath2 = Paths.get("/Users/kunalgupta/Downloads/10277687580001.pdf");
        Path pdfPath3 = Paths.get("/Users/kunalgupta/Downloads/ArtsAnnexure.jpg");

        byte[] existingContent2=Files.readAllBytes(pdfPath2);
        byte[] existingContent=Files.readAllBytes(pdfPath);
        byte[] existingContent3=Files.readAllBytes(pdfPath3);

        PDDocument pdDocument=PDDocument.load(existingContent);
        PDDocument pdDocument2=PDDocument.load(existingContent2);


        System.out.println(pdDocument.getNumberOfPages());
        for(int i=0; i <pdDocument2.getNumberOfPages();i++ ){
            pdDocument.addPage(pdDocument2.getPage(i));
        }
//        pdDocument.getPage(0);
//        PDPage newPage=new PDPage(PDRectangle.A4);
//        pdDocument.addPage(pdDocument.getPage(0));

//        os.write(existingContent);
        System.out.println(pdDocument.getNumberOfPages());

        pdDocument.addPage(new PDPage(PDRectangle.A4));
        PDPageContentStream contentStream=new PDPageContentStream(pdDocument,pdDocument.getPage(4));
        PDImageXObject image = PDImageXObject.createFromByteArray(pdDocument,existingContent3,"ArtsAnnexure.jpg");
        contentStream.drawImage(image,36F,36F, image.getWidth(), image.getHeight());
        System.out.println(pdDocument.getNumberOfPages());
        contentStream.close();
        pdDocument.save(baos);
        pdDocument.close();
        baos.writeTo(os);
        baos.close();
        os.close();
//
//
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(existingContent.length);
//        baos.write(existingContent);
//        PDRectangle currentPageType;
//        PDDocument document = new PDDocument();
//        PDPage newPage;
//        newPage = new PDPage(PDRectangle.A4);
//        currentPageType = PDRectangle.A4;
//        document.addPage(newPage);



    }

}
