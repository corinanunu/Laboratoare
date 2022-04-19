package lab1;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();

        //create first sheet
        HSSFSheet sheet = workbook.createSheet("tag1Name1 - 1");

        HSSFFont font = workbook.createFont();
        font.setBold(true);

        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        HSSFRow row1 = sheet.createRow(0);

        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("Tag2-id");
        cell1.setCellStyle(style);

        HSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("t1");
        cell2.setCellStyle(style);

        HSSFCell cell3 = row1.createCell(2);
        cell3.setCellValue("t2");
        cell3.setCellStyle(style);

        HSSFCell cell4 = row1.createCell(3);
        cell4.setCellValue("t3");
        cell4.setCellStyle(style);

        HSSFCell cell5 = row1.createCell(4);
        cell5.setCellValue("t4");
        cell5.setCellStyle(style);

        HSSFCell cell7 = row1.createCell(5);
        cell7.setCellValue("List");
        cell7.setCellStyle(style);

        HSSFCell cell8 = row1.createCell(6);
        cell8.setCellValue("t8");
        cell8.setCellStyle(style);

        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("001");
        row2.createCell(1).setCellValue("string1 t1");
        row2.createCell(2).setCellValue("string1 t2");
        row2.createCell(3).setCellValue("date or int 1");
        row2.createCell(4).setCellValue("string1 t4");
        HSSFCell cell25 = row2.createCell(5);
        List<String> listItems = new ArrayList<>();
        listItems.add("list1 string a");
        listItems.add("list1 string b");
        listItems.add("list1 string c");
        listItems.add("list1 string d");
        numberedListInCell(workbook, listItems, cell25, 1, 1);
        row2.createCell(6).setCellValue("string1 t5");

        HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("002");
        row3.createCell(1).setCellValue("string2 t1");
        row3.createCell(2).setCellValue("string2 t2");
        row3.createCell(3).setCellValue("date or int 2");
        row3.createCell(4).setCellValue("string2 t4");
        HSSFCell cell35 = row3.createCell(5);
        List<String> listItems2 = new ArrayList<>();
        listItems2.add("list2 string a");
        listItems2.add("list2 string b");
        listItems2.add("list2 string c");
        listItems2.add("list2 string d");
        numberedListInCell(workbook, listItems2, cell35, 1, 1);
        row3.createCell(6).setCellValue("string2 t5");

        //create second sheet
        HSSFSheet sheet2 = workbook.createSheet("tag1Name2 - 2");
        HSSFRow row4 = sheet2.createRow(0);

        HSSFCell cell12 = row4.createCell(0);
        cell12.setCellValue("Tag2-id");
        cell12.setCellStyle(style);

        HSSFCell cell22 = row4.createCell(1);
        cell22.setCellValue("t1");
        cell22.setCellStyle(style);

        HSSFCell cell32 = row4.createCell(2);
        cell32.setCellValue("t2");
        cell32.setCellStyle(style);

        HSSFCell cell42 = row4.createCell(3);
        cell42.setCellValue("t3");
        cell42.setCellStyle(style);

        HSSFCell cell52 = row4.createCell(4);
        cell52.setCellValue("t4");
        cell52.setCellStyle(style);

        HSSFCell cell72 = row4.createCell(5);
        cell72.setCellValue("List");
        cell72.setCellStyle(style);

        HSSFCell cell82 = row4.createCell(6);
        cell82.setCellValue("t8");
        cell82.setCellStyle(style);

        HSSFRow row5 = sheet2.createRow(1);
        row5.createCell(0).setCellValue("003");
        row5.createCell(1).setCellValue("string3 t1");
        row5.createCell(2).setCellValue("string3 t2");
        row5.createCell(3).setCellValue("date or int 3");
        row5.createCell(4).setCellValue("string3 t4");
        HSSFCell cell45 = row5.createCell(5);
        List<String> listItems3 = new ArrayList<>();
        listItems3.add("list3 string a");
        listItems3.add("list3 string b");
        listItems3.add("list3 string c");
        listItems3.add("list3 string d");
        numberedListInCell(workbook, listItems3, cell45, 1, 1);
        row5.createCell(6).setCellValue("string3 t5");

        HSSFRow row6 = sheet2.createRow(2);
        row6.createCell(0).setCellValue("004");
        row6.createCell(1).setCellValue("string4 t1");
        row6.createCell(2).setCellValue("string4 t2");
        row6.createCell(3).setCellValue("date or int 4");
        row6.createCell(4).setCellValue("string4 t4");
        HSSFCell cell55 = row6.createCell(5);
        List<String> listItems4 = new ArrayList<>();
        listItems4.add("list4 string a");
        listItems4.add("list4 string b");
        listItems4.add("list4 string c");
        listItems4.add("list4 string d");
        numberedListInCell(workbook, listItems4, cell55, 1, 1);
        row6.createCell(6).setCellValue("string4 t5");

        try(OutputStream fileout = new FileOutputStream("lab1.xlsx")){
            workbook.write(fileout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void numberedListInCell(HSSFWorkbook workbook,
                                          List<String> listItems,
                                          HSSFCell cell,
                                          int startingValue,
                                          int increment) {
        StringBuilder buffer = new StringBuilder();
        int itemNumber = startingValue;
        // Note that again, an HSSFCellStye object is required and that
        // it's wrap text property should be set to 'true'
        HSSFCellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        // Note that the basic method is identical to the listInCell() method
        // with one difference; a number prefixed to the items text.
        for(String listItem : listItems) {
            buffer.append(itemNumber).append(". ");
            buffer.append(listItem);
            buffer.append("\n");
            itemNumber += increment;
        }
        // The StringBuilder's contents are the source for the contents
        // of the cell.
        cell.setCellValue(new HSSFRichTextString(buffer.toString().trim()));
        cell.setCellStyle(wrapStyle);
    }
}
