package no.hiof.dcon;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * This class is used to perform conversions with Excel format.
 */
public class ExcelConverter {

    private ExcelConverter() {
        throw new UnsupportedOperationException("ExcelConverter is a utility class and should not be instantiated.");
    }

    /**
     * This method convert an object into Excel file
     *
     * @param object   The object to be converted
     * @param outputFileLocation The File name representing the file to which the objects should be written
     * @param <T>      The generic type of the object to be converted.
     * @throws IOException If there is an error writing to the file.
     */
    public static <T> void excelFromObject(String outputFileLocation, T object) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(object);
        Iterator<String> fieldNames = jsonNode.fieldNames();

        Row headerRow = sheet.createRow(0);
        int colNum = 0;
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            Cell cell = headerRow.createCell(colNum++);
            cell.setCellValue(fieldName);
        }

        Row dataRow = sheet.createRow(1);
        colNum = 0;
        fieldNames = jsonNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode fieldValue = jsonNode.get(fieldName);
            Cell cell = dataRow.createCell(colNum++);
            if (fieldValue.isTextual()) {
                cell.setCellValue(fieldValue.asText());
            } else if (fieldValue.isNumber()) {
                cell.setCellValue(fieldValue.asDouble());
            }
        }

        FileOutputStream fileOut = new FileOutputStream(outputFileLocation);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

    }
}
