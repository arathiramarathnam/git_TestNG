package com.maven.jenkins.TestNG;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;	

//100 data sets to be passed in a test case then we have data provider
//as supplying data for a test method. 
//The data provider name defaults to method name.
//The annotated method must return an new Object[][] where eachObject[] can be assigned the parameter list of the test method.
//The @Test method that wants to receive data from this DataProviderneeds to use a dataProvider name 
//equals to the name of this annotation.

//DataProviders we will pass it in an excel sheet.
//It will read the excel file and then convert it into an multi dimensional array
//Reading the excel sheet --> Array

public class DataProvider_Excelxls {

	@Test(dataProvider="TrainerInfo")
	public void validatingTrainerInfo(String name, String exp, String email) {
			System.out.println(name+"\t"+exp+"\t"+email);
		}
	
	@DataProvider(name="sUsernameandsPassword")
	public Object[][] getdatasUsernameAndsPassword()	{
		return new Object[][] {{"admin123@gmail.com", "admin123"},{"admin@admin.com","admin"},{"a.gmail.com","a"}};
		
	}
	
	@DataProvider(name="TrainerInfo")
	Object[][] trainerInfoFromExcel()throws Exception{
		String sFile = System.getProperty("user.dir")+"/testExcel.xls";
		 return readDataFromExcelSheet(sFile);
	}
	public Object[][] readDataFromExcelSheet(String sFile) throws Exception {
		File fi = new File(System.getProperty("user.dir")+"/testExcel.xls");
		FileInputStream fstream = new FileInputStream(fi);
		HSSFWorkbook myExcelBook = new HSSFWorkbook(fstream);
		HSSFSheet myExcleSheet = myExcelBook.getSheet("InstructorInfo");
		HSSFRow row1 = myExcleSheet.getRow(0);
		System.out.println(row1.getPhysicalNumberOfCells()); //To take total number of collumns
		System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
		//System.out.println(row1.getLastCellNum());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
		
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol = 0; countCol<iCountCol;countCol++) {
				HSSFRow tempRow=myExcleSheet.getRow(countRow);
				String sTemp;
				try {
				//System.out.println(tempRow.getCell(countCol).getStringCellValue());
				sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception e) {
					//System.out.println(tempRow.getCell(countCol).getNumericCellValue());
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
				}
				excelData[countRow][countCol] = sTemp;
			}
		}
		myExcelBook.close();
		return excelData;
	}
	
	
}		
				





