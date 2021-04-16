package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcel {

	private static	DataExcel  instance;
	private static Map<String,Object> propertiesData= new HashMap<String,Object>();
	private static Map<String,Object> moduleMapData=Collections.unmodifiableMap(propertiesData);
	private static String previousFilePath;
	private static String previousSheetName;
	private static Workbook workbook=null;
	
	public static DataExcel getInstance(String filePath,String fileName,String sheetName) 
	{
		if(previousFilePath==null || !filePath.equals(previousFilePath) ||previousSheetName==null ||!sheetName.equals(previousSheetName))
		{
			if(workbook==null)
			{
				workbook=getWorkBook(filePath, fileName);
			}
			instance=new DataExcel(filePath,fileName,sheetName,workbook);
			previousFilePath=filePath;
			previousSheetName=sheetName;		
		}
		return instance;
	}
	
	private static Workbook getWorkBook(String filePath,String fileName)
	{
		try 
		{
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			
			String fileExtensionName=fileName.substring(fileName.indexOf("."));
			if(fileExtensionName.equals(".xlsx"))
			{
				workbook=new XSSFWorkbook(inputStream);
			}
			else if(fileExtensionName.equals(".xls"))
			{
				workbook= new HSSFWorkbook(inputStream);
			}			
			return workbook;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	private DataExcel(String property,String fileName,String sheetName,Workbook workbook)  {
		 System.out.println(sheetName);
		 Sheet sheet = workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();		 
		 for (int i = 0; i < rowCount+1; i++) 
		 {
		    Row row = sheet.getRow(i);
		    propertiesData.put(row.getCell(0).getStringCellValue().trim(), row.getCell(1).getStringCellValue().trim());
		 }
	}
	
	private DataExcel() {
		
	}
	
	static DataExcel getInstance()
	{
		if(instance==null)
		{
			instance= new DataExcel();
		}
		return instance;
	}
	
	public String getProperty(String key)
	{
		return moduleMapData.get(key).toString();
	}
}
