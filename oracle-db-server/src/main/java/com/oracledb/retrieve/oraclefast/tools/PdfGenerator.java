package com.oracledb.retrieve.oraclefast.tools;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.oracledb.retrieve.oraclefast.models.ResultFM;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class PdfGenerator {

    private PdfPTable tryAddCell(PdfPTable table, String add, String string) {
        if (string != null) {
            table.addCell(add + string);
        } else {
            table.addCell(add);
        }
        return table;
    }
    private PdfPTable tryAddCFMAddress(PdfPTable table, ResultFM res) {
        String c = "";
        if (res.getCfmSeatArea() != (null)) {
            c = c + ("1. Область: " + res.getCfmSeatArea()+ "\n");
        } else {
            c = c + ("1. Область: \n");
        }
        if (res.getCfmSeatRegion() != (null)) {
            c = c + ("2. Район: " + res.getCfmSeatRegion()+ "\n");
        } else {
            c = c + ("2. Район: \n");
        }
        if (res.getCfmSeatCity() != null) {
            c = c + ("3. Населенный пункт (город/поселок/село): " + res.getCfmSeatCity()+ "\n");
        } else {
            c = c + ("3. Населенный пункт (город/поселок/село): \n");
        }
        if (res.getCfmSeatStreet() != (null)) {
            c = c + ("4. Наименование улицы/проспекта/мр-на: " + res.getCfmSeatStreet()+ "\n");
        } else {
            c = c + ("4. Наименование улицы/проспекта/мр-на: \n");
        }
        if (res.getCfmSeatHouse() != (null)) {
            c = c + ("5. № дома: " + res.getCfmSeatHouse()+ "\n");
        } else {
            c = c + ("5. № дома: \n");
        }
        if (res.getCfmSeatOffice() != (null)) {
            c = c + ("6. № квартиры/офиса (при наличии): " + res.getCfmSeatOffice()+ "\n");
        } else {
            c = c + ("6. № квартиры/офиса (при наличии): \n");
        }
        if (res.getCfmSeatPostcode()!= (null)) {
            c = c + ("7. Почтовый индекс: " + res.getCfmSeatPostcode()+ "\n");
        } else {
            c = c + ("7. Почтовый индекс: \n");
        }
        table.addCell(c);
        return table;
    }
    private PdfPTable tryAddCFMAddress(PdfPTable table, HashMap<String, String> res) {
        String c = "";
        if (res.get("cfmSeatArea") != (null)) {
            c = c + ("1. Область: " + res.get("cfmSeatArea") + "\n");
        } else {
            c = c + ("1. Область: \n");
        }
        if (res.get("cfmSeatRegion") != (null)) {
            c = c + ("2. Район: " + res.get("cfmSeatRegion") + "\n");
        } else {
            c = c + ("2. Район: \n");
        }
        if (res.get("cfmSeatCity") != null) {
            c = c + ("3. Населенный пункт (город/поселок/село): " + res.get("cfmSeatCity") + "\n");
        } else {
            c = c + ("3. Населенный пункт (город/поселок/село): \n");
        }
        if (res.get("cfmSeatStreet") != (null)) {
            c = c + ("4. Наименование улицы/проспекта/мр-на: " + res.get("cfmSeatStreet")+ "\n");
        } else {
            c = c + ("4. Наименование улицы/проспекта/мр-на: \n");
        }
        if (res.get("cfmSeatHouse") != (null)) {
            c = c + ("5. № дома: " + res.get("cfmSeatHouse") + "\n");
        } else {
            c = c + ("5. № дома: \n");
        }
        if (res.get("cfmSeatOffice") != (null)) {
            c = c + ("6. № квартиры/офиса (при наличии): " + res.get("cfmSeatOffice") + "\n");
        } else {
            c = c + ("6. № квартиры/офиса (при наличии): \n");
        }
        if (res.get("cfmSeatPostcode")!= (null)) {
            c = c + ("7. Почтовый индекс: " + res.get("cfmSeatPostcode") + "\n");
        } else {
            c = c + ("7. Почтовый индекс: \n");
        }
        table.addCell(c);
        return table;
    }

    public Document generate(ResultFM result, ByteArrayOutputStream response) throws DocumentException, IOException {
//        URL loadr = PdfGenerator.class.getResource("PdfGenerator.class");
//        System.out.println(loadr);
//        String path = loadr.toString().replace("PdfGenerator.class", "fontstimes.ttf");
//        BaseFont baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response);
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = new Font();
        fontTiltle.setSize(16);
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
        table.setWidths(new float[] {0.7f,5,5});
        table.setSpacingBefore(5);

        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.WHITE);
        cell.setPadding(5);

        Font font = new Font();
        font.setColor(CMYKColor.BLACK);

        cell.setPhrase(new Phrase("№ п.п.", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Наименование", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Содержание", font));
        table.addCell(cell);

        PdfPCell heading = new PdfPCell();
        heading.setBackgroundColor(CMYKColor.ORANGE);
        heading.setPadding(5);
        heading.setColspan(3);
        heading.setPhrase(new Phrase("1. Сведения по форме ФМ-1", font));
        table.addCell(heading);

        table.addCell("1.1");
        table.addCell("№ Формы ФМ-1*");
        table = tryAddCell(table, "1. Номер: ", result.getMessOfmId().toString());
        table.addCell("1.2");
        table.addCell("Дата формы ФМ-1*");
        if (result.getMessDate() != null) {
            table = tryAddCell(table, "", result.getMessDate().toString());
        } else {
            table = tryAddCell(table, "", null);
        }
        table.addCell("1.3");
        table.addCell("Вид документа*");
        table = tryAddCell(table, "", result.getMessType());
        table.addCell("1.4");
        table.addCell("Состояние операции*");
        table = tryAddCell(table, "", result.getOperStatus());
        table.addCell("");
        table.addCell("Дата и время операции");
        if (result.getOperDocDate() != null) {
            table = tryAddCell(table, "", result.getOperDocDate().toString());
        } else {
            table = tryAddCell(table, "", null);
        }
        table.addCell("1.5");
        table.addCell("Основание для подачи сообщения*");
        table = tryAddCell(table, "", result.getMessReason());

        //2
        heading.setPhrase(new Phrase("2. Сведения о субъекте финансового мониторинга, направившем форму ФМ-1", font));
        table.addCell(heading);
        table.addCell("2.1");
        table.addCell("Код субъекта финансового мониторинга*");
        table = tryAddCell(table, "", result.getCfmCode().toString());
        table.addCell("2.2");
        table.addCell("Наименование субъекта финансового мониторинга*");
        table = tryAddCell(table, "", result.getCfmName());
        table.addCell("2.3");
        table.addCell("РНН");
        table = tryAddCell(table, "", result.getOperDocNumber());
        table.addCell("2.4");
        table.addCell("ИИН/БИН*");
        table = tryAddCell(table, "", result.getCfmMainCode());
        table.addCell("2.5");
        table.addCell("Адрес места нахождения*");
        table = tryAddCFMAddress(table, result);
        table.addCell("2.6");
        table.addCell("Документ, удостоверяющий личность (для физических лиц)*");
        table = tryAddCell(table, "", result.getDocType());
        table.addCell("2.6.1");
        table.addCell("Номер и серия документа, удостоверяющего личность (для физических лиц)*");
        String cfm = "";
        if (result.getCfmDocNumber()!=null) {
            cfm = cfm + "1. Номер: " + result.getCfmDocNumber() + "\n";
        } else {
            cfm = cfm + "1. Номер: \n";
        }
        if (result.getCfmDocSeries()!=null) {
            cfm = cfm + "2. Серия: " + result.getCfmDocSeries() + "\n";
        } else {
            cfm = cfm + "2. Серия: \n";
        }
        table.addCell(cfm);
        table.addCell("2.6.2");
        table.addCell("Кем выдан документ, удостоверяющий личность (для физических лиц)*");
        table = tryAddCell(table, "", result.getCfmDocWhom());
        table.addCell("2.6.3");
        table.addCell("Когда выдан документ, удостоверяющий личность (для физических лиц)*");
        if (result.getCfmDocDate() != null) {
            table = tryAddCell(table, "", result.getCfmDocDate().toString());
        } else {
            table = tryAddCell(table, "", null);
        }
//        table.addCell("2.7");
//        table.addCell("Ответственное должностное лицо");
//        table = tryAddCell(table, "", result.getMemberUrFistHeadName());
//        table.addCell("2.7.1");
//        table.addCell("Должность ответственного должностного лица");
//        table = tryAddCell(table, "", result.getMemberVid());
//        table.addCell("2.8");
//        table.addCell("Контактные телефоны*");
//        table = tryAddCell(table, "", result.getMemberPhone());
//        table.addCell("2.9");
//        table.addCell("Электронная почта");
//        table = tryAddCell(table, "", result.getMemberEmail());


        //3
        heading.setPhrase(new Phrase("3. Информация об операции, подлежащей финансовому мониторингу", font));
        table.addCell(heading);
        table.addCell("3.1");
        table.addCell("Номер операции*");
        if (result.getOperNumber()!= null) {
            table = tryAddCell(table, "", result.getOperNumber().toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.2");
        table.addCell("Основание совершения операции");
        table = tryAddCell(table, "", result.getOperPaymentPurpose());
        table.addCell("3.3");
        table.addCell("Количество участников операции*");
        if (result.getOperMembersCount() != null) {
            table = tryAddCell(table, "", result.getOperMembersCount().toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.4");
        table.addCell("Код страны резиденства");
        if (result.getMemberResidenceCountrycode() != null) {
            table = tryAddCell(table, "", result.getMemberResidenceCountrycode().toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.5");
        table.addCell("Валюта");
        table = tryAddCell(table, "", result.getCurrencyType().toString());

        table.addCell("3.6");
        table.addCell("Сумма операции в валюте ее проведения*");
        if (result.getOperCurrencyAmount() != null) {
            table = tryAddCell(table, "", result.getOperCurrencyAmount().toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.7");
        table.addCell("Сумма операции в тенге*");
        if (result.getOperTengeAmount() != null) {
            table = tryAddCell(table, "", result.getOperTengeAmount().toString());
        } else {
            table = tryAddCell(table, "", "");
        }

        table.addCell("3.8");
        table.addCell("Дата  и номер документа, на основании которого осуществляется операция ");
        String dateOper = "";
        if (result.getOperDocDate() != null) {
            dateOper = dateOper + "1. Дата: " +result.getOperDocDate().toString() + "\n";
        } else {
            dateOper = dateOper + "1. Дата: \n";
        }
        if (result.getOperDocNumber()!= null) {
            dateOper = dateOper + "2. Номер документа: " +result.getOperDocNumber().toString() + "\n";
        } else{
            dateOper = dateOper + "2. Номер документа: \n";
        }
        table.addCell(dateOper);
        table.addCell("3.9");
        table.addCell("1 признак подозрительности");
        table = tryAddCell(table, "", result.getSuspFirst());
        table.addCell("3.10");
        table.addCell("2 признак подозрительности");
        table = tryAddCell(table, "", result.getSuspSecond());
        table.addCell("3.11");
        table.addCell("3 признак подозрительности");
        table = tryAddCell(table, "", result.getSuspThird());

        table.addCell("3.12");
        table.addCell("Дополнительная информация по операции");
        table = tryAddCell(table, "", result.getOperDopInfo());

        heading.setPhrase(new Phrase("4. Сведения об участниках  операции, подлежащей финансовому мониторингу", font));
        table.addCell(heading);

        table.addCell("4.1");
        table.addCell("Идентификатор участника");
        if (result.getMemberId()!= null) {
            table = tryAddCell(table, "", result.getMemberId().toString());
        } else {
            table.addCell("");
        }
        table.addCell("4.2");
        table.addCell("Вид участника");
        table = tryAddCell(table, "", result.getMemberVid());
        table.addCell("4.3");
        table.addCell("Резиденство (1-да, 0-нет)");
        if (result.getMemberResidence()!=null) {
            table = tryAddCell(table, "", result.getMemberResidence().toString());
        } else {
            table.addCell("");
        }
        table.addCell("4.4");
        table.addCell("Код страны резиденства");
        if (result.getMemberResidenceCountrycode()!=null) {
            table = tryAddCell(table, "", result.getMemberResidenceCountrycode().toString());
        } else {
            table.addCell("");
        }
        table.addCell("4.5");
        table.addCell("Тип участника");
        table = tryAddCell(table, "", result.getMemberType());
        table.addCell("4.6");
        table.addCell("Показатель иностранного публичного лица и аффилированных с ним лиц");
        table = tryAddCell(table, "", result.getMemberForeign());
        table.addCell("4.7");
        table.addCell("Банк участника операции*");
        String c = "";
        if (result.getMemberBankCode() != (null)) {
            c = c + ("1. Код банка участника: " + result.getMemberBankCode()+ "\n");
        } else {
            c = c + ("1. Код банка участника: \n");
        }
        if (result.getMemberBankName() != (null)) {
            c = c + ("2. Название банка: " + result.getMemberBankName()+ "\n");
        } else {
            c = c + ("2. Название банка: \n");
        }
        if (result.getMemberBankAccount() != null) {
            c = c + ("3. Счет участника: " + result.getMemberBankAccount()+ "\n");
        } else {
            c = c + ("3. Счет участника: \n");
        }
        if (result.getMemberBankAddress() != (null)) {
            c = c + ("4. Адрес банка: " + result.getMemberBankAddress()+ "\n");
        } else {
            c = c + ("4. Адрес банка: \n");
        }
        table.addCell(c);

        table.addCell("4.8");
        table.addCell("Наименование участника операции (для юридических лиц)*");
        c = "";
        if (result.getMemberUrName()!=null) {
            c = c + "1. Имя участника (Юр лицо): " + result.getMemberUrName() + "\n";
        } else {
            c = c + "1. Имя участника (Юр лицо): \n";
        }
        table.addCell(c);

        table.addCell("4.9");
        table.addCell("Фио первого руководителя (Юр лицо)");
        table = tryAddCell(table, "", result.getMemberUrFistHeadName());

        table.addCell("4.10");
        table.addCell("ОКЭД");
        table = tryAddCell(table, "", result.getMemberOked());

        table.addCell("4.11");
        table.addCell("ИИН\\БИН");
        table = tryAddCell(table, "", result.getMemberMaincode());

        table.addCell("4.12");
        table.addCell("ФИО (для физических лиц и индивидуальных предпринимателей)*");
        c = "";
        if (result.getMemberAcFirstName()!= null) {
            c = c + "1. Имя (Физ лицо либо ип): " + result.getMemberAcFirstName() + "\n";
        } else {
            c = c + "1. Имя (Физ лицо либо ип): " + "\n";
        }
        if (result.getMemberAcSecondName()!= null) {
            c = c + "2. Фамилия: " + result.getMemberAcSecondName() + "\n";
        } else {
            c = c + "2. Фамилия: " + "\n";
        }
        if (result.getMemberAcSecondName()!= null) {
            c = c + "3. Отчество: " + result.getMemberAcMiddlename() + "\n";
        } else {
            c = c + "3. Отчество: " + "\n";
        }
        table.addCell(c);

        table.addCell("4.13");
        table.addCell("Тип и серия документа, удостоверяющего личность ");
        c = "";
        if (result.getMemberAcDocType()!=null) {
            c = c + "1. Тип: " + result.getMemberAcDocType() + "\n";
        } else {
            c = c + "1. Тип: " + "\n";
        }
        if (result.getMemberAcDocSeries()!=null) {
            c = c + "2. Серия: " + result.getMemberAcDocSeries() + "\n";
        } else {
            c = c + "2. Серия: " + "\n";
        }
        table.addCell(c);

        table.addCell("4.14");
        table.addCell("Кем выдан документ, удостоверяющий  личность");
        table = tryAddCell(table, "", result.getMemberAcDocWhom());
        table.addCell("4.15");
        table.addCell("Когда выдан документ, удостоверяющий личность");
        if (result.getMemberAcDocDate()!=null) {
            table = tryAddCell(table, "", result.getMemberAcDocDate().toString());
        } else {
            table.addCell("");
        }

        table.addCell("4.16");
        table.addCell("Дата рождения (для физических лиц и индивидуальных предпринимателей)");
        if (result.getMemberAcBirthDate()!= null) {
            table = tryAddCell(table, "", result.getMemberAcBirthDate().toString());
        } else {
            table.addCell("");
        }

        table.addCell("4.17");
        table.addCell("Место рождения (для физических лиц и индивидуальных предпринимателей)");
        table = tryAddCell(table, "", result.getMemberAcBirthPlace());

        table.addCell("4.18");
        table.addCell("Юридический адрес");
        c = "";
        if (result.getMemberRegArea() != (null)) {
            c = c + ("1. Область: " + result.getMemberRegArea()+ "\n");
        } else {
            c = c + ("1. Область: \n");
        }
        if (result.getMemberRegRegion() != (null)) {
            c = c + ("2. Район: " + result.getMemberRegRegion()+ "\n");
        } else {
            c = c + ("2. Район: \n");
        }
        if (result.getMemberRegSity() != null) {
            c = c + ("3. Населенный пункт (город/поселок/село): " + result.getMemberRegSity()+ "\n");
        } else {
            c = c + ("3. Населенный пункт (город/поселок/село): \n");
        }
        if (result.getMemberRegStreet() != (null)) {
            c = c + ("4. Наименование улицы/проспекта/мр-на: " + result.getMemberRegStreet()+ "\n");
        } else {
            c = c + ("4. Наименование улицы/проспекта/мр-на: \n");
        }
        if (result.getMemberRegHouse() != (null)) {
            c = c + ("5. № дома: " + result.getMemberRegHouse()+ "\n");
        } else {
            c = c + ("5. № дома: \n");
        }
        if (result.getMemberRegOffice() != (null)) {
            c = c + ("6. № квартиры/офиса (при наличии): " + result.getMemberRegOffice()+ "\n");
        } else {
            c = c + ("6. № квартиры/офиса (при наличии): \n");
        }
        table.addCell(c);

        table.addCell("4.19");
        table.addCell("Номер контактного телефона");
        table = tryAddCell(table, "", result.getMemberPhone());

        table.addCell("4.20");
        table.addCell("Электронная почта");
        table = tryAddCell(table, "", result.getMemberEmail());

        table.addCell("4.21");
        table.addCell("Фактический адрес");
        c = "";
        if (result.getCfmSeatArea() != (null)) {
            c = c + ("1. Область: " + result.getCfmSeatArea()+ "\n");
        } else {
            c = c + ("1. Область: \n");
        }
        if (result.getMemberSeatRegion() != (null)) {
            c = c + ("2. Район: " + result.getMemberSeatRegion()+ "\n");
        } else {
            c = c + ("2. Район: \n");
        }
        if (result.getMemberSeatSity() != null) {
            c = c + ("3. Населенный пункт (город/поселок/село): " + result.getMemberSeatSity()+ "\n");
        } else {
            c = c + ("3. Населенный пункт (город/поселок/село): \n");
        }
        if (result.getMemberSeatStreet() != (null)) {
            c = c + ("4. Наименование улицы/проспекта/мр-на: " + result.getMemberSeatStreet()+ "\n");
        } else {
            c = c + ("4. Наименование улицы/проспекта/мр-на: \n");
        }
        if (result.getMemberSeatHouse() != (null)) {
            c = c + ("5. № дома: " + result.getMemberSeatHouse()+ "\n");
        } else {
            c = c + ("5. № дома: \n");
        }
        if (result.getMemberSeatOffice() != (null)) {
            c = c + ("6. № квартиры/офиса (при наличии): " + result.getMemberSeatOffice()+ "\n");
        } else {
            c = c + ("6. № квартиры/офиса (при наличии): \n");
        }
        table.addCell(c);

        document.add(table);
        document.close();
        return document;
    }

    public Document generate(HashMap<String, String> result, ByteArrayOutputStream response) throws DocumentException, IOException {
//        URL loadr = PdfGenerator.class.getResource("PdfGenerator.class");
//        System.out.println(loadr);
//        String path = loadr.toString().replace("PdfGenerator.class", "fontstimes.ttf");
//        BaseFont baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response);
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = new Font();
        fontTiltle.setSize(16);
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
        table.setWidths(new float[] {0.7f,5,5});
        table.setSpacingBefore(5);

        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.WHITE);
        cell.setPadding(5);

        Font font = new Font();
        font.setColor(CMYKColor.BLACK);

        cell.setPhrase(new Phrase("№ п.п.", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Наименование", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Содержание", font));
        table.addCell(cell);

        PdfPCell heading = new PdfPCell();
        heading.setBackgroundColor(CMYKColor.ORANGE);
        heading.setPadding(5);
        heading.setColspan(3);
        heading.setPhrase(new Phrase("1. Сведения по форме ФМ-1", font));
        table.addCell(heading);

        table.addCell("1.1");
        table.addCell("№ Формы ФМ-1*");
        table = tryAddCell(table, "1. Номер: ", result.get("messOfmId").toString());
        table.addCell("1.2");
        table.addCell("Дата формы ФМ-1*");
        if (result.get("messDate") != null) {
            table = tryAddCell(table, "", result.get("messDate").toString());
        } else {
            table = tryAddCell(table, "", null);
        }
        table.addCell("1.3");
        table.addCell("Вид документа*");
        table = tryAddCell(table, "", result.get("messType"));
        table.addCell("1.4");
        table.addCell("Состояние операции*");
        table = tryAddCell(table, "", result.get("operStatus"));
        table.addCell("");
        table.addCell("Дата и время операции");
        if (result.get("operDocDate") != null) {
            table = tryAddCell(table, "", result.get("operDocDate").toString());
        } else {
            table = tryAddCell(table, "", null);
        }
        table.addCell("1.5");
        table.addCell("Основание для подачи сообщения*");
        table = tryAddCell(table, "", result.get("messReason"));

        //2
        heading.setPhrase(new Phrase("2. Сведения о субъекте финансового мониторинга, направившем форму ФМ-1", font));
        table.addCell(heading);
        table.addCell("2.1");
        table.addCell("Код субъекта финансового мониторинга*");
        table = tryAddCell(table, "", result.get("cfmCode").toString());
        table.addCell("2.2");
        table.addCell("Наименование субъекта финансового мониторинга*");
        table = tryAddCell(table, "", result.get("cfmName"));
        table.addCell("2.3");
        table.addCell("РНН");
        table = tryAddCell(table, "", result.get("operDocNumber"));
        table.addCell("2.4");
        table.addCell("ИИН/БИН*");
        table = tryAddCell(table, "", result.get("cfmMainCode"));
        table.addCell("2.5");
        table.addCell("Адрес места нахождения*");
        table = tryAddCFMAddress(table, result);
        table.addCell("2.6");
        table.addCell("Документ, удостоверяющий личность (для физических лиц)*");
        table = tryAddCell(table, "", result.get("docType"));
        table.addCell("2.6.1");
        table.addCell("Номер и серия документа, удостоверяющего личность (для физических лиц)*");
        String cfm = "";
        if (result.get("cfmDocNumber")!=null) {
            cfm = cfm + "1. Номер: " + result.get("cfmDocNumber") + "\n";
        } else {
            cfm = cfm + "1. Номер: \n";
        }
        if (result.get("cfmDocSeries")!=null) {
            cfm = cfm + "2. Серия: " + result.get("cfmDocSeries") + "\n";
        } else {
            cfm = cfm + "2. Серия: \n";
        }
        table.addCell(cfm);
        table.addCell("2.6.2");
        table.addCell("Кем выдан документ, удостоверяющий личность (для физических лиц)*");
        table = tryAddCell(table, "", result.get("cfmDocWhom"));
        table.addCell("2.6.3");
        table.addCell("Когда выдан документ, удостоверяющий личность (для физических лиц)*");
        if (result.get("cfmDocDate") != null) {
            table = tryAddCell(table, "", result.get("cfmDocDate").toString());
        } else {
            table = tryAddCell(table, "", null);
        }
//        table.addCell("2.7");
//        table.addCell("Ответственное должностное лицо");
//        table = tryAddCell(table, "", result.getMemberUrFistHeadName());
//        table.addCell("2.7.1");
//        table.addCell("Должность ответственного должностного лица");
//        table = tryAddCell(table, "", result.getMemberVid());
//        table.addCell("2.8");
//        table.addCell("Контактные телефоны*");
//        table = tryAddCell(table, "", result.getMemberPhone());
//        table.addCell("2.9");
//        table.addCell("Электронная почта");
//        table = tryAddCell(table, "", result.getMemberEmail());


        //3
        heading.setPhrase(new Phrase("3. Информация об операции, подлежащей финансовому мониторингу", font));
        table.addCell(heading);
        table.addCell("3.1");
        table.addCell("Номер операции*");
        if (result.get("operNumber")!= null) {
            table = tryAddCell(table, "", result.get("operNumber").toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.2");
        table.addCell("Основание совершения операции");
        table = tryAddCell(table, "", result.get("operPaymentPurpose"));
        table.addCell("3.3");
        table.addCell("Количество участников операции*");
        if (result.get("operMembersCount") != null) {
            table = tryAddCell(table, "", result.get("operMembersCount").toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.4");
        table.addCell("Код страны резиденства");
        if (result.get("memberResidenceCountrycode") != null) {
            table = tryAddCell(table, "", result.get("memberResidenceCountrycode").toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.5");
        table.addCell("Валюта");
        table = tryAddCell(table, "", result.get("currencyType").toString());

        table.addCell("3.6");
        table.addCell("Сумма операции в валюте ее проведения*");
        if (result.get("operCurrencyAmount") != null) {
            table = tryAddCell(table, "", result.get("operCurrencyAmount").toString());
        } else {
            table = tryAddCell(table, "", "");
        }
        table.addCell("3.7");
        table.addCell("Сумма операции в тенге*");
        table = tryAddCell(table, "", result.get("operTengeAmount").toString());

        table.addCell("3.8");
        table.addCell("Дата  и номер документа, на основании которого осуществляется операция ");
        String dateOper = "";
        if (result.get("operDocDate") != null) {
            dateOper = dateOper + "1. Дата: " +result.get("operDocDate").toString() + "\n";
        } else {
            dateOper = dateOper + "1. Дата: \n";
        }
        if (result.get("operDocNumber")!= null) {
            dateOper = dateOper + "2. Номер документа: " +result.get("operDocNumber").toString() + "\n";
        } else{
            dateOper = dateOper + "2. Номер документа: \n";
        }
        table.addCell(dateOper);
        table.addCell("3.9");
        table.addCell("1 признак подозрительности");
        table = tryAddCell(table, "", result.get("suspFirst"));
        table.addCell("3.10");
        table.addCell("2 признак подозрительности");
        table = tryAddCell(table, "", result.get("suspSecond"));
        table.addCell("3.11");
        table.addCell("3 признак подозрительности");
        table = tryAddCell(table, "", result.get("suspThird"));

        table.addCell("3.12");
        table.addCell("Дополнительная информация по операции");
        table = tryAddCell(table, "", result.get("operDopInfo"));

        heading.setPhrase(new Phrase("4. Сведения об участниках  операции, подлежащей финансовому мониторингу", font));
        table.addCell(heading);

        table.addCell("4.1");
        table.addCell("Идентификатор участника");
        if (result.get("memberId")!= null) {
            table = tryAddCell(table, "", result.get("memberId").toString());
        } else {
            table.addCell("");
        }
        table.addCell("4.2");
        table.addCell("Вид участника");
        table = tryAddCell(table, "", result.get("memberVid"));
        table.addCell("4.3");
        table.addCell("Резиденство (1-да, 0-нет)");
        if (result.get("memberResidence")!=null) {
            table = tryAddCell(table, "", result.get("memberResidence").toString());
        } else {
            table.addCell("");
        }
        table.addCell("4.4");
        table.addCell("Код страны резиденства");
        if (result.get("memberResidenceCountrycode")!=null) {
            table = tryAddCell(table, "", result.get("memberResidenceCountrycode").toString());
        } else {
            table.addCell("");
        }
        table.addCell("4.5");
        table.addCell("Тип участника");
        table = tryAddCell(table, "", result.get("memberType"));
        table.addCell("4.6");
        table.addCell("Показатель иностранного публичного лица и аффилированных с ним лиц");
        table = tryAddCell(table, "", result.get("memberForeign"));
        table.addCell("4.7");
        table.addCell("Банк участника операции*");
        String c = "";
        if (result.get("memberBankCode") != (null)) {
            c = c + ("1. Код банка участника: " + result.get("memberBankCode") + "\n");
        } else {
            c = c + ("1. Код банка участника: \n");
        }
        if (result.get("memberBankName") != (null)) {
            c = c + ("2. Название банка: " + result.get("memberBankName")+ "\n");
        } else {
            c = c + ("2. Название банка: \n");
        }
        if (result.get("memberBankAccount") != null) {
            c = c + ("3. Счет участника: " + result.get("memberBankAccount")+ "\n");
        } else {
            c = c + ("3. Счет участника: \n");
        }
        if (result.get("memberBankAddress") != (null)) {
            c = c + ("4. Адрес банка: " + result.get("memberBankAddress") + "\n");
        } else {
            c = c + ("4. Адрес банка: \n");
        }
        table.addCell(c);

        table.addCell("4.8");
        table.addCell("Наименование участника операции (для юридических лиц)*");
        c = "";
        if (result.get("memberUrName")!=null) {
            c = c + "1. Имя участника (Юр лицо): " + result.get("memberUrName") + "\n";
        } else {
            c = c + "1. Имя участника (Юр лицо): \n";
        }
        table.addCell(c);

        table.addCell("4.9");
        table.addCell("Фио первого руководителя (Юр лицо)");
        table = tryAddCell(table, "", result.get("memberUrFistHeadName"));

        table.addCell("4.10");
        table.addCell("ОКЭД");
        table = tryAddCell(table, "", result.get("memberOked"));

        table.addCell("4.11");
        table.addCell("ИИН\\БИН");
        table = tryAddCell(table, "", result.get("memberMaincode"));

        table.addCell("4.12");
        table.addCell("ФИО (для физических лиц и индивидуальных предпринимателей)*");
        c = "";
        if (result.get("memberAcFirstName")!= null) {
            c = c + "1. Имя (Физ лицо либо ип): " + result.get("memberAcFirstName") + "\n";
        } else {
            c = c + "1. Имя (Физ лицо либо ип): " + "\n";
        }
        if (result.get("memberAcSecondName")!= null) {
            c = c + "2. Фамилия: " + result.get("memberAcSecondName") + "\n";
        } else {
            c = c + "2. Фамилия: " + "\n";
        }
        if (result.get("memberAcMiddlename")!= null) {
            c = c + "3. Отчество: " + result.get("memberAcMiddlename") + "\n";
        } else {
            c = c + "3. Отчество: " + "\n";
        }
        table.addCell(c);

        table.addCell("4.13");
        table.addCell("Тип и серия документа, удостоверяющего личность ");
        c = "";
        if (result.get("memberAcDocType")!=null) {
            c = c + "1. Тип: " + result.get("memberAcDocType") + "\n";
        } else {
            c = c + "1. Тип: " + "\n";
        }
        if (result.get("memberAcDocSeries")!=null) {
            c = c + "2. Серия: " + result.get("memberAcDocSeries") + "\n";
        } else {
            c = c + "2. Серия: " + "\n";
        }
        table.addCell(c);

        table.addCell("4.14");
        table.addCell("Кем выдан документ, удостоверяющий  личность");
        table = tryAddCell(table, "", result.get("memberAcDocWhom"));
        table.addCell("4.15");
        table.addCell("Когда выдан документ, удостоверяющий личность");
        if (result.get("memberAcDocDate")!=null) {
            table = tryAddCell(table, "", result.get("memberAcDocDate").toString());
        } else {
            table.addCell("");
        }

        table.addCell("4.16");
        table.addCell("Дата рождения (для физических лиц и индивидуальных предпринимателей)");
        if (result.get("memberAcBirthDate")!= null) {
            table = tryAddCell(table, "", result.get("memberAcBirthDate").toString());
        } else {
            table.addCell("");
        }

        table.addCell("4.17");
        table.addCell("Место рождения (для физических лиц и индивидуальных предпринимателей)");
        table = tryAddCell(table, "", result.get("memberAcBirthPlace"));

        table.addCell("4.18");
        table.addCell("Юридический адрес");
        c = "";
        if (result.get("memberRegArea") != (null)) {
            c = c + ("1. Область: " + result.get("memberRegArea") + "\n");
        } else {
            c = c + ("1. Область: \n");
        }
        if (result.get("memberRegRegion") != (null)) {
            c = c + ("2. Район: " + result.get("memberRegRegion") + "\n");
        } else {
            c = c + ("2. Район: \n");
        }
        if (result.get("memberRegSity") != null) {
            c = c + ("3. Населенный пункт (город/поселок/село): " + result.get("memberRegSity") + "\n");
        } else {
            c = c + ("3. Населенный пункт (город/поселок/село): \n");
        }
        if (result.get("memberRegStreet") != (null)) {
            c = c + ("4. Наименование улицы/проспекта/мр-на: " + result.get("memberRegStreet") + "\n");
        } else {
            c = c + ("4. Наименование улицы/проспекта/мр-на: \n");
        }
        if (result.get("memberRegHouse") != (null)) {
            c = c + ("5. № дома: " + result.get("memberRegHouse") + "\n");
        } else {
            c = c + ("5. № дома: \n");
        }
        if (result.get("memberRegOffice") != (null)) {
            c = c + ("6. № квартиры/офиса (при наличии): " + result.get("memberRegOffice") + "\n");
        } else {
            c = c + ("6. № квартиры/офиса (при наличии): \n");
        }
        table.addCell(c);

        table.addCell("4.19");
        table.addCell("Номер контактного телефона");
        table = tryAddCell(table, "", result.get("memberPhone"));

        table.addCell("4.20");
        table.addCell("Электронная почта");
        table = tryAddCell(table, "", result.get("memberEmail"));

        table.addCell("4.21");
        table.addCell("Фактический адрес");
        c = "";
        if (result.get("memberSeatArea") != (null)) {
            c = c + ("1. Область: " + result.get("memberSeatArea")+ "\n");
        } else {
            c = c + ("1. Область: \n");
        }
        if (result.get("memberSeatRegion") != (null)) {
            c = c + ("2. Район: " + result.get("memberSeatRegion")+ "\n");
        } else {
            c = c + ("2. Район: \n");
        }
        if (result.get("memberSeatSity") != null) {
            c = c + ("3. Населенный пункт (город/поселок/село): " + result.get("memberSeatSity") + "\n");
        } else {
            c = c + ("3. Населенный пункт (город/поселок/село): \n");
        }
        if (result.get("memberSeatStreet") != (null)) {
            c = c + ("4. Наименование улицы/проспекта/мр-на: " + result.get("memberSeatStreet") + "\n");
        } else {
            c = c + ("4. Наименование улицы/проспекта/мр-на: \n");
        }
        if (result.get("memberSeatHouse") != (null)) {
            c = c + ("5. № дома: " + result.get("memberSeatHouse") + "\n");
        } else {
            c = c + ("5. № дома: \n");
        }
        if (result.get("memberSeatOffice") != (null)) {
            c = c + ("6. № квартиры/офиса (при наличии): " + result.get("memberSeatOffice")+ "\n");
        } else {
            c = c + ("6. № квартиры/офиса (при наличии): \n");
        }
        table.addCell(c);

        document.add(table);
        document.close();
        return document;
    }
}
