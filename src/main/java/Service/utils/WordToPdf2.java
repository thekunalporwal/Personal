package Service.utils;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.*;

public class WordToPdf2 {
    public static void main(String[] args) throws Exception {
        //Create a Document instance
        String fileName="/Users/kunalgupta/Downloads/4716.docx";
        Document doc = new Document(fileName);


        ByteArrayOutputStream fileForPdf =new ByteArrayOutputStream();
        OutputStream os =new FileOutputStream(new File(
                "src/main/resources/abcdefghjbi.pdf"));

        doc.save(fileForPdf,40);
        byte[] arr= fileForPdf.toByteArray();
        PDDocument pdDocument=PDDocument.load(arr);
        System.out.println(pdDocument.getNumberOfPages());
        ByteArrayOutputStream baos2=new ByteArrayOutputStream();
        pdDocument.save(baos2);
        pdDocument.close();
        baos2.writeTo(os);
        baos2.close();
        os.close();
    }
}
