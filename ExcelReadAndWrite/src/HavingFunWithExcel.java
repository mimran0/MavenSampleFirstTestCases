import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HavingFunWithExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelFilePath="C:\\Users\\imran\\workspace_Test\\MyExcel.xlsx";
		FileInputStream inputStream=new FileInputStream(new File(excelFilePath));
		
		Workbook workbook=new XSSFWorkbook(inputStream);

	}

}
