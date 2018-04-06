import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */

/**
 * @author imran
 *
 */
public class ReadCellData {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\imran\\workspace_Test\\MyExcel.xlsx");
		Workbook	wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheetAt(0);	
		Row row = sheet.getRow(3);    
		Cell cell = row.getCell(4); 		
		System.out.print(cell.getStringCellValue());
	}

}
