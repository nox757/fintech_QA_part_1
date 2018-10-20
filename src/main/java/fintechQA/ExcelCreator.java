package fintechQA;

import fintechQA.model.Person;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
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

    public void addRow(List<String> cells) throws NullPointerException {
        if (cells == null) {
            throw new NullPointerException("Try add empty row");
        }
        Row row = sheet.createRow(rowNum++);
        for (int i = 0; i < cells.size(); i++) {
            row.createCell(i).setCellValue(cells.get(i));
        }
    }

    public String writeToFile(String fileName) throws IOException {
        File file = new File(fileName+".xls");
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
            return file.getAbsolutePath();
        } catch (IOException e) {
            throw new IOException("Could not write xls to " + file.getAbsolutePath(), e);
        }
    }
}
