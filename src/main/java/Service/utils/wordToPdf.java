package Service.utils;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.ToPdfParameterList;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.*;

public class wordToPdf {

    public static void main(String[] args) throws IOException {
        //Create a Document instance
        Document doc = new Document();
        String fileName="/Users/kunalgupta/Downloads/4716.docx";

        //Load a sample Word document
        doc.loadFromStream(new FileInputStream(fileName), FileFormat.Docx);

        //Create a ToPdfParameterList instance
        ToPdfParameterList ppl=new ToPdfParameterList();

        //Embed all fonts in the PDF document
        ppl.isEmbeddedAllFonts(true);

        //Remove the hyperlinks and keep the character formats
        ppl.setDisableLink(true);

        //Set the output image quality as 40% of the original image. 80% is the default setting.
        doc.setJPEGQuality(40);
        OutputStream fileForPdf =new ByteArrayOutputStream();
        OutputStream os =new FileOutputStream(new File(
                "src/main/resources/abcdefghjbi.pdf"));


        doc.saveToStream(fileForPdf,FileFormat.PDF);
        byte[] arr= ((ByteArrayOutputStream) fileForPdf).toByteArray();
        PDDocument pdDocument=PDDocument.load(arr);
        System.out.println(pdDocument.getNumberOfPages());
        ByteArrayOutputStream baos2=new ByteArrayOutputStream();
        pdDocument.save(baos2);
        pdDocument.close();
        baos2.writeTo(os);
        baos2.close();
        os.close();



        //Save the document as PDF
//        doc.saveToFile("src/main/resources/abcdefghjbijk.pdf", ppl);
    }
}
