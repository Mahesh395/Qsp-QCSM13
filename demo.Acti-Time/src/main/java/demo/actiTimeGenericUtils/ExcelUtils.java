package demo.actiTimeGenericUtils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	 /**
		 * This method is used to return the String cell value
		 * @param filepath
		 * @param sheetName
		 * @param rowNo
		 * @param columnNo
		 * @return
		 */
		public String getStringData(String filepath, String sheetName, int rowNo,int columnNo )
		{
			try 
			{
				FileInputStream file = new FileInputStream(filepath);
				Workbook workbook = WorkbookFactory.create(file);
				return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getStringCellValue();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return null;
		}
		
		
		/**
		 * This method is used to return the boolean cell value
		 * @param filepath
		 * @param sheetName
		 * @param rowNo
		 * @param columnNo
		 * @return
		 */

		public Boolean getBooleanData(String filepath, String sheetName, int rowNo,int columnNo )
		{
			try 
			{
				FileInputStream file = new FileInputStream(filepath);
				Workbook workbook = WorkbookFactory.create(file);
				return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getBooleanCellValue();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return null;
		}
		
		
		/**
		 * This method is used to return the Numeric cell value
		 * @param filepath
		 * @param sheetName
		 * @param rowNo
		 * @param columnNo
		 * @return
		 */
		
		public double getNumericData(String filepath, String sheetName, int rowNo,int columnNo )
		{
			try 
			{
				FileInputStream file = new FileInputStream(filepath);
				Workbook workbook = WorkbookFactory.create(file);
				return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getNumericCellValue();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return 0;
		}
}
