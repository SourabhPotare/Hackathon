package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageObjectModel.FindHospitals;
import pageObjectModel.Surgeries;

public class ExcelOutput 
{
	
	
	public static void printDrDetailsExcel(List<String>details) throws IOException, InterruptedException {
		try 
		{
            System.out.println("Writing Started");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Details");

            // Create headers
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Doctor's Details:");
          //  headerRow.createCell(1).setCellValue("Surgeries:");

            // Populate details
            for (int i = 0; i <details.size(); i++) 
            {
                XSSFRow row = sheet.createRow(i + 1); 
                row.createCell(0).setCellValue(details.get(i));
            }
          
            String filePath = System.getProperty("user.dir") + "\\ExcelData\\DrDetails.xlsx";
            FileOutputStream file = new FileOutputStream(filePath);
            workbook.write(file);
            workbook.close();
            file.close();
            
        } 
		catch (IOException e) 
		{
            System.err.println("Error writing to Excel file: " + e.getMessage());
        }
	
	}
	
//	public static void printSurgeriesExcel(List<String>surgery_list) throws IOException, InterruptedException {
//		try 
//		{
//			String filePath = System.getProperty("user.dir") + "\\ExcelData\\DrDetails.xlsx";
//            FileInputStream fis = new FileInputStream(filePath);
//            XSSFWorkbook workbook = new XSSFWorkbook(fis);
//            XSSFSheet sheet = workbook.getSheet("Details");
//
//            // Populate details
//            for (int i = 0; i <surgery_list.size(); i++) 
//            {
//                XSSFRow row = sheet.createRow(i + 1); 
//                row.createCell(0).setCellValue(surgery_list.get(i));
//            }
//          
//            FileOutputStream file = new FileOutputStream(filePath);
//            workbook.write(file);
//            workbook.close();
//            file.close();
//            System.out.println("Writing is Done!");
//            
//        } 
//		catch (IOException e) 
//		{
//            System.err.println("Error writing to Excel file: " + e.getMessage());
//        }
//	
//	}

}
