package Service.utils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

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


    public static void main(String[] args) throws IOException, DocumentException {
        String FILEPATH = "src/main/resources/abcdefghjbi.pdf";
        File file = new File(FILEPATH);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();

        OutputStream os = new FileOutputStream(file);

        Path pdfPath = Paths.get("/Users/kunalgupta/Downloads/777001788207309.pdf");
        Path pdfPath2 = Paths.get("/Users/kunalgupta/Downloads/10277687580001.pdf");
        Path pdfPath3 = Paths.get("/Users/kunalgupta/Downloads/ISHIKA PIC-ImResizer.jpg");
        Path pdfPath4 = Paths.get("/Users/kunalgupta/Downloads/4716.docx");


        byte[] existingContent2=Files.readAllBytes(pdfPath2);
        byte[] existingContent=Files.readAllBytes(pdfPath);
        byte[] existingContent3=Files.readAllBytes(pdfPath3);
        byte[] existingContent4=Files.readAllBytes(pdfPath4);

        XWPFDocument doc = new XWPFDocument(new ByteArrayInputStream(existingContent4));
        XWPFWordExtractor we = new XWPFWordExtractor(doc);
        String k = we.getText();


//
//
////        doc.createStyles();
//        PdfOptions options = PdfOptions.create();
//        PdfConverter.getInstance().convert(doc,os,null);

        PDDocument pdDocument=PDDocument.load(existingContent);
        PDDocument pdDocument2=PDDocument.load(existingContent2);
        PDDocument pdDocument23=PDDocument.load(existingContent4);



        System.out.println(pdDocument.getNumberOfPages());
        for(int i=0; i <pdDocument2.getNumberOfPages();i++ ){
            pdDocument.addPage(pdDocument2.getPage(i));
        }
        System.out.println(pdDocument.getNumberOfPages());
        pdDocument.addPage(new PDPage());
        PDPageContentStream contentStream=new PDPageContentStream(pdDocument,pdDocument.getPage(4));
        PDImageXObject image = PDImageXObject.createFromByteArray(pdDocument,existingContent3,"ISHIKA PIC-ImResizer.jpg");
        contentStream.drawImage(image,20F,20F,image.getWidth(),image.getHeight());
        System.out.println(pdDocument.getNumberOfPages());
        System.out.println(k);


        pdDocument.addPage(new PDPage());
        PDPageContentStream contentStream2=new PDPageContentStream(pdDocument,pdDocument.getPage(5));

        k = k.replace("\n", "").replace("\r", "");
//
//        contentStream2.beginText();
//        contentStream2.setFont(PDType1Font.TIMES_ROMAN, 12);
//        contentStream2.newLineAtOffset(25, 500);
//
//        contentStream2.showText(k);
//        contentStream2.endText();
//        contentStream2.close();
        contentStream.close();
        pdDocument.save(baos);
        pdDocument.close();
        baos.writeTo(os);
        baos.close();
        os.close();

    }

}
