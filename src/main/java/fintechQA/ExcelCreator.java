package fintechQA;

import fintechQA.model.Person;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelCreator {

    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private int rowNum = 0;

    public ExcelCreator(String sheetName) {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }

    public void createHeaderRow(List<String> headers) {
        Row headerRow = sheet.createRow(rowNum++);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
        }
    }

    public void addRow(List<String> cells) {
        if (cells == null) {
            // todo: create execption
            return;
        }
        Row row = sheet.createRow(rowNum++);
        for (int i = 0; i < cells.size(); i++) {
            row.createCell(i).setCellValue(cells.get(i));
        }
    }

    public void writeToFile(String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName + ".xls")) {
            workbook.write(fileOut);
        }
    }
}
