
package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static String getCellValue(String filePath, String sheetName,
			int row, int col) {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			return sheet.getRow(row).getCell(col).toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
