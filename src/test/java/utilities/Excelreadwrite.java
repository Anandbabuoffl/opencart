package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreadwrite {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet xs;
	public XSSFCell xc;
	String path = null;

	public Excelreadwrite(String path) {
		this.path = path;
	}

	public int rowcount(String sheetname) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();

		return rowcount;
	}

	public int columncount(String sheetname, int row) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheet(sheetname);
		XSSFRow rrow = Sheet.getRow(row);
		int columncount = rrow.getLastCellNum();
		wb.close();
		fis.close();

		return columncount;

	}

	public String getcellvalue(String sheetname, int row, int cellvalue) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheet(sheetname);
		XSSFRow rrow = Sheet.getRow(row);
		XSSFCell cell = rrow.getCell(cellvalue);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
		data =formatter.formatCellValue(cell); //return value of the cell irrepective of the cell types
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fis.close();
		
		return data;

	}
	
	public void setdata(String sheetname,int row,int column,String data) throws IOException {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
      XSSFSheet  sheet=wb.getSheet(sheetname);
      
     XSSFRow rrow= sheet.getRow(row);
    XSSFCell cell=rrow.createCell(column);
    cell.setCellValue(data);
    
    fos=new FileOutputStream(path);
    wb.write(fos);
    wb.close();
    fis.close();
    fos.close();
      
		
		
	}

}
