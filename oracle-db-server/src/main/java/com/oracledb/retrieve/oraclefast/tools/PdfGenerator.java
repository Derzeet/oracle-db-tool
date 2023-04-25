package com.oracledb.retrieve.oraclefast.tools;

import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.oracledb.retrieve.oraclefast.models.ResultFM;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PdfGenerator {
    public void generate(List<ResultFM> resultFMS, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("Данные формы ФМ", fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of the 4 columns
        PdfPTable table = new PdfPTable(3);
        // Setting width of the table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {1,3,3});
        table.setSpacingBefore(5);
        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        // Adding headings in the created table cell or  header
        // Adding Cell to table
        cell.setPhrase(new Phrase("№ п.п.", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Наименование", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Содержание", font));
        table.addCell(cell);
        // Iterating the list of students
        for (ResultFM student: resultFMS) {
            // Adding student id
            table.addCell(student.getCfmDocNumber()       );
            // Adding student name
            table.addCell(student.getCfmName());
            // Adding student email
            table.addCell(student.getMemberAcDocWhom());
            // Adding student mobile
        }
        // Adding the created table to the document
        document.add(table);
        // Closing the document
        document.close();
    }
}
