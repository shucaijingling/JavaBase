package com.shucai.interview04;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {


    public static void exportWords(String name, List<Integer> words, List<Integer> w2) throws IOException {
        String path = "/Users/x/Downloads/" + name + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(name);
        Row row = sheet.createRow(0);
        for (int i = 0; i < words.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(words.get(i));
        }

        Row row2 = sheet.createRow(21);
        for (int i = 0; i < w2.size(); i++) {
            Cell cell = row2.createCell(i);
            cell.setCellValue(w2.get(i));
        }

        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        System.out.println("done");
    }

}
