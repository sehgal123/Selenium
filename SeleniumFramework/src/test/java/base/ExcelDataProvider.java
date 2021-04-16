package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	public static DataFormatter formatter= new DataFormatter();
	private static Workbook workbook=null;
	static String excelFileName=null;
	static String sheetName=null;	
	static String filePath=null;	
	
	@DataProvider
    public static Object[][] CreateAccount() throws IOException
    {
		excelFileName="CreateAccount.xlsx";
		sheetName="Sheet1";	
		filePath="config/CreateAccount.xlsx";
		return CreateDataProvider(filePath, excelFileName, sheetName);
    }
	
	@DataProvider
    public static Object[][] CreateAlert() throws IOException
    {
		excelFileName="CreateAlert.xlsx";
		sheetName="Sheet1";	
		filePath="config/CreateAlert.xlsx";
		return CreateDataProvider(filePath, excelFileName, sheetName);
    }	
	
	public static Object[][] CreateDataProvider(String filePath, String excelFileName, String sheetName) throws IOException
    {		
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		
		String fileExtensionName=excelFileName.substring(excelFileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx"))
		{
			workbook=new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls"))
		{
			workbook= new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
						    
        Object Data[][]= new Object[rowCount-1][colCount]; // pass my  count data in array
         
            for(int i=0; i<rowCount-1; i++) //Loop work for Rows
            {  
                Row row= sheet.getRow(i+1);
                 
                for (int j=0; j<colCount; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        Cell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {                        
                        	//String value=formatter.formatCellValue(cell);
                            //Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                            Data[i][j]=cell.getStringCellValue();
                        }
                    }
                }
            }
 
        return Data;
    }

}


