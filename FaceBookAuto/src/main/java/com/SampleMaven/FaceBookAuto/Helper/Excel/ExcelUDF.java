package com.SampleMaven.FaceBookAuto.Helper.Excel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelUDF {
	
	///data  read from excel  
			/// identify the file ,  identify the  excel,  identify the workbook, identify the sheet
			///identify the cell  (row, col),  read data , close file 
			public static String CellValue;
			public static  String fnReadFromExcel(String FileAddress, String SheetName, int row, int col) throws BiffException, IOException
			{
				///identify the file  
				File myFile  = new File(FileAddress);
				///identify the excel and workbook 
				Workbook myBook  = Workbook.getWorkbook(myFile);
				
				///identify the sheet 
				Sheet mySheet  = myBook.getSheet(SheetName);
				///identify the cell 
				Cell myCell  = mySheet.getCell(col, row);
				///read  data
				
					 CellValue = myCell.getContents();
					 
				 
				 /////close 
				 myBook.close();
				return CellValue;
			}
			
			///sheet  Count  
			///identify the file , identify the excel and workbook, count sheets and close  file  
			public static int SheetCount;
			public static int fnSheetCount(String FileAddress) throws BiffException, IOException
			{
				//identify the file
				File myFile = new File(FileAddress);
				//identify the excel and workbook
				Workbook myBook= Workbook.getWorkbook(myFile);
				//Sheet Count
				SheetCount=myBook.getNumberOfSheets();
				//close file
				myBook.close();
				return SheetCount;
				
			}
			//Row Count
			//identify file, identify the excel and workbook, identify the sheet, count the rows, close the file
			public static int RowCount;
			public static int fnRowCount(String FileAddress, String SheetName) throws BiffException, IOException
			{
				//identify the file
				File myFile=new File(FileAddress);
				//identify the excel and workbook
				Workbook myBook=Workbook.getWorkbook(myFile);
				//identify the sheet
				Sheet mySheet= myBook.getSheet(SheetName);
				//Count the rows
				RowCount=mySheet.getRows();
				//Close the file
				myBook.close();
				return RowCount;
			}
			
			//Column Count
			//Identify file, identify excel and workbook, identify sheet, count columns, close file
			public static int ColumnCount;
			public static int fnColCount(String FileAddress, String SheetName) throws BiffException, IOException
			{
				//identify the file
				File myFile=new File(FileAddress);
				//identify the excel and workbook
				Workbook myBook=Workbook.getWorkbook(myFile);
				//identify the sheet
				Sheet mySheet=myBook.getSheet(SheetName);
				//Count the columns
				ColumnCount=mySheet.getColumns();
				//close
				myBook.close();
				return ColumnCount;
			}
			//Capture SheetName
			//identify the file, identify the excel and workbook, capture sheetname, close file
			public static String[] SheetNames;
			public static String[] fnSheetNames(String FileAddress) throws BiffException, IOException
			{
				//identify the file
				File myFile=new File(FileAddress);
				//workbook
				Workbook myBook=Workbook.getWorkbook(myFile);
				//Capture sheetname
				SheetNames = myBook.getSheetNames();
				myBook.close();
				return SheetNames;
				
			}
			
			
			//Data write in Excel (Single Column)
			//identify the file, identify the excel and workbook, identify the writable workbook, identify the writable sheet, 
			//identify the writable cell (label--> row, col, data), write data, close file.
			public static void fnExcelWriteSingleColumn(String FileAddress, String SheetName, int row, int col, String CellData) throws BiffException, IOException, RowsExceededException, WriteException
			{
				//identify file
				File myFile=new File(FileAddress);
				//excel and workbook
				Workbook myBook=Workbook.getWorkbook(myFile);
				//Identify the writable workbook
				WritableWorkbook myWriteBook=Workbook.createWorkbook(myFile, myBook);
				//writable sheet
				WritableSheet mySheet=myWriteBook.getSheet(SheetName);
				//identify the cell (label)
				Label myCell  = new Label(col, row, CellData);
				///write data  
				 mySheet.addCell(myCell);
				 myWriteBook.write();
				 ///close file  
				 myWriteBook.close();	
			}
			///Data write in Excel (Multiple columns)
			//Identify the file, identify the excel and workbook, identify the writable workbook, identify the writable sheet,
			//Take row count, identify the label(cell) with multiple columns and rows with data, write data, close file.
			public static void fnExcelWriteMultiple(String FileAddress, String SheetName, String ObjectName, String Functionality, String ExpectedRes, String ActualRes, String Status) throws BiffException, IOException, RowsExceededException, WriteException
			{
				//identify the file
				File myFile=new File(FileAddress);
				//workbook and Excel
				Workbook myBook=Workbook.getWorkbook(myFile);
				//writable workbook
				WritableWorkbook myWriteBook=Workbook.createWorkbook(myFile, myBook);
				//writable sheet
				WritableSheet mySheet=myWriteBook.getSheet(SheetName);
				//row count
				int rowcount=mySheet.getRows();
				
				///date simple 
				String ReqDate  = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				////identify the cell / label 
				Label myCell = new Label(0, rowcount, ReqDate);
				mySheet.addCell(myCell);
				
				myCell = new  Label(1, rowcount, ObjectName);
				///add data ----> ObjectName
				mySheet.addCell(myCell);
				
				myCell = new Label(2, rowcount, Functionality);
				///add data ----> functionality
				mySheet.addCell(myCell);
				
				myCell = new Label(3, rowcount, ExpectedRes);
				///add data ----> ExpectedRes
				mySheet.addCell(myCell);
				
				
				myCell = new Label(4, rowcount, ActualRes);
				///add data ---->ActualRes
				mySheet.addCell(myCell);

				
				myCell = new Label(5, rowcount, Status);
				///add data ----> Status
				mySheet.addCell(myCell);
				
				///write
				myWriteBook.write();
				///close file 
				myWriteBook.close();	
				
			}


}
