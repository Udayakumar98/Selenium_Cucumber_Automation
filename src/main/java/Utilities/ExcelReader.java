package Utilities;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.HashMap;

public class ExcelReader {

    private static HashMap<String, String> map = new HashMap<>();

    public static void loadData() {

        try {
            String env = System.getProperty("environment");

            String path = System.getProperty("user.dir")
                    + "/src/test/resources/TestData/AmazonData.xlsx";

            FileInputStream file = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(file);
            Sheet sheet = wb.getSheet("Iphone");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(env)) {
                    map.put("url", row.getCell(1).getStringCellValue());
//                    map.put("username", row.getCell(2).getStringCellValue());
//                    map.put("password", row.getCell(3).getStringCellValue());
                    break;
                }
            }
            wb.close();

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);
        }
    }

    public static String getData(String key) {
        return map.get(key);
    }
}
