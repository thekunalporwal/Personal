package Service.utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class TestCon {

    private static final PDFont FONT = PDType1Font.TIMES_ROMAN;
    private static final float FONT_SIZE = 12;
    private static final float LEADING = -1.5f * FONT_SIZE;

    public static PDDocument method( String text) throws IOException {

            final PDDocument doc = new PDDocument();

            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

            PDRectangle mediaBox = page.getMediaBox();
            float marginY = 80;
            float marginX = 60;
            float width = mediaBox.getWidth() - 2 * marginX;
            float startX = mediaBox.getLowerLeftX() + marginX;
            float startY = mediaBox.getUpperRightY() - marginY;

//            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
//                    " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
//                    " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
//                    " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
//                    " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
//                    "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
//                    " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

            contentStream.beginText();
            contentStream.setFont(FONT, FONT_SIZE);
            addParagraph(contentStream, width, startX, startY, text, true);
            addParagraph(contentStream, width, 0, -FONT_SIZE, text);
            addParagraph(contentStream, width, 0, -FONT_SIZE, text, false);
            contentStream.endText();

            contentStream.close();

           return doc;
        }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text) throws IOException {
        addParagraph(contentStream, width, sx, sy, text, false);
    }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text, boolean justify) throws IOException {
        List<String> lines = parseLines(text, width);
//        contentStream.setFont(FONT, FONT_SIZE);
        contentStream.newLineAtOffset(sx, sy);
        for (String line: lines) {
            float charSpacing = 0;
            if (justify){
                if (line.length() > 1) {
                    float size = FONT_SIZE * FONT.getStringWidth(line) / 1000;
                    float free = width - size;
                    if (free > 0 && !lines.get(lines.size() - 1).equals(line)) {
                        charSpacing = free / (line.length() - 1);
                    }
                }
            }
            contentStream.setCharacterSpacing(charSpacing);
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, LEADING);
        }
    }

    private static List<String> parseLines(String text, float width) throws IOException {
        List<String> lines = new ArrayList<String>();
        int lastSpace = -1;
        while (text.length() > 0) {
            int spaceIndex = text.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0)
                spaceIndex = text.length();
            String subString = text.substring(0, spaceIndex);
            float size = FONT_SIZE * FONT.getStringWidth(subString) / 1000;
            if (size > width) {
                if (lastSpace < 0){
                    lastSpace = spaceIndex;
                }
                subString = text.substring(0, lastSpace);
                lines.add(subString);
                text = text.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == text.length()) {
                lines.add(text);
                text = "";
            } else {
                lastSpace = spaceIndex;
            }
        }
        return lines;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        String k=null;
        OutputStream fileForPdf =null;

        try {

            String fileName="/Users/kunalgupta/Downloads/4716.docx";

                XWPFDocument docx = new XWPFDocument(new FileInputStream(
                        fileName));
                // using XWPFWordExtractor Class
                XWPFWordExtractor we = new XWPFWordExtractor(docx);
                k = we.getText();
                k = k.replace("\n", "").replace("\r", "");
             PDDocument doc = new PDDocument();

            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

            PDRectangle mediaBox = page.getMediaBox();
            float marginY = 80;
            float marginX = 60;
            float width = mediaBox.getWidth() - 2 * marginX;
            float startX = mediaBox.getLowerLeftX() + marginX;
            float startY = mediaBox.getUpperRightY() - marginY;

//            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
//                    " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
//                    " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
//                    " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
//                    " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
//                    "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
//                    " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

            contentStream.beginText();
            contentStream.setFont(FONT, FONT_SIZE);
            addParagraph(contentStream, width, startX, startY, k, true);
            addParagraph(contentStream, width, 0, -FONT_SIZE, k);
            addParagraph(contentStream, width, 0, -FONT_SIZE, k, false);
            contentStream.endText();

            contentStream.close();

                fileForPdf = new FileOutputStream(new File(
                        "src/main/resources/abcdefghjbijk.pdf"));
                 we.close();

            doc.save(baos);
            doc.close();
            baos.writeTo(fileForPdf);
            baos.close();
            fileForPdf.close();

//
//            PDDocument document2=new PDDocument();
//          document2.getDocumentCatalog()
//            Document document = new Document();
//            PdfWriter.getInstance(document, fileForPdf);
//
//            document.open();
//
//            document.add(new Paragraph(k));
//
//            document.close();
//            fileForPdf.close();





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
