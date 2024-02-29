package pageObjectModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelOutput;

public class Surgeries{
	
	WebDriver driver;
	public static List<String> surgery_list=new ArrayList<String>();
	
	public Surgeries(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//*[text()='Surgeries']") WebElement surgeries_btn;
	@FindBy (xpath="//*[@class='mt-12px AilmentItem-module_itemText__XvCHL']") List<WebElement> surgeries;
	
	
//	public void Click_On_Surgeries() {
//		
//		surgeries_btn.click();
//		
//	}
	public void Get_Details() throws IOException, InterruptedException {
		Thread.sleep(3000);
		surgeries_btn.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");
		
		System.out.println("Surgeries:");		
		for(WebElement nam : surgeries) 
		{
			String sur = nam.getText();
			System.out.println(sur);
			surgery_list.add(sur);
		}
		
	//	ExcelOutput.printSurgeriesExcel(surgery_list);
	}
	
}
