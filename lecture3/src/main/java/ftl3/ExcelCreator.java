package ftl3;

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
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
        }
    }

    public void addRows(List<Person> persons) {
        for (Person person : persons) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(person.getSurname());
            row.createCell(1).setCellValue(person.getName());
            row.createCell(2).setCellValue(person.getMiddleName());
            row.createCell(3).setCellValue(person.getAge());
            row.createCell(4).setCellValue(person.getGender());
            row.createCell(5).setCellValue(person.getBirthday().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            row.createCell(6).setCellValue(person.getInn());
            row.createCell(7).setCellValue(person.getPostCode());
            row.createCell(8).setCellValue(person.getCountry());
            row.createCell(9).setCellValue(person.getRegion());
            row.createCell(10).setCellValue(person.getCity());
            row.createCell(11).setCellValue(person.getNumHouse());
            row.createCell(12).setCellValue(person.getNumFlat());
        }
    }

    public void writeToFile(String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName + ".xls")) {
            workbook.write(fileOut);
        }
    }
}
