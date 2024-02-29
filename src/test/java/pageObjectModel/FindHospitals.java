package pageObjectModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import Utilities.ExcelOutput;

public class FindHospitals {
	
	public static List<String> details=new ArrayList<String>();
	WebDriver driver;
	FileInputStream fis;
	Properties prop = new Properties();
	
	
	 public  FindHospitals(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	 
	@FindBy (xpath="//*[@placeholder='Search location']") WebElement SetLocation;
    @FindBy (xpath="//*[text()='Use my location']") WebElement Location;
    @FindBy (xpath="//*[@data-qa-id='omni-suggestion-main'][text()='Pune']") WebElement Select_pune;
    
	@FindBy (xpath="//*[@placeholder='Search doctors, clinics, hospitals, etc.']") WebElement Search_Doctors;
	@FindBy (xpath="//*[text()='Cardiologist']") WebElement Select_Cardiologist;
	
	//@FindBy (xpath="//*[@data-qa-id='doctor_gender_section']") WebElement Gender;
	@FindBy (xpath="//*[@aria-label='Male Doctor']") WebElement Gen_Male;
	
	@FindBy (xpath="//*[@data-qa-id='doctor_review_count_section']") WebElement Patient_Stories;
	@FindBy (xpath="//*[text()='10+ Patient Stories']") WebElement Select_PS;
	
	@FindBy (xpath="//*[@data-qa-id='years_of_experience_section']") WebElement Select_Drp_Exp;
	@FindBy (xpath="//*[text()='10+ Years of experience']") WebElement Select_Exp;
	
	@FindBy (xpath="//*[@data-qa-id='all_filters_icon']") WebElement Click_AllFilter;
	@FindBy (xpath="//*[text()='Above ₹500']") WebElement Fees;
	@FindBy (xpath="//*[text()='Available in next 7 days']") WebElement Availability;
	
	@FindBy (xpath="//*[@data-qa-id='sort_by_selected']") WebElement Sortby;
	@FindBy (xpath="//*[text()='Experience - High to Low']") WebElement Select_sort;
	
	@FindBy (xpath="//*[@class='doctor-name']") List<WebElement> drnames;
	@FindBy (xpath="//div[@data-qa-id='doctor_experience']") List<WebElement> drExperience;
	@FindBy (xpath="//div[@class='uv2-spacer--sm-top']") List<WebElement> OtherDetails;

	
	public void SetLocation() throws IOException 
	{
		
		fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
	    prop.load(fis);
		SetLocation.click();
		Actions actions = new Actions(driver);
		actions.doubleClick(SetLocation).perform();	
		SetLocation.sendKeys(prop.getProperty("Location"));
		Select_pune.click();
	}
	
	public void EnterDoctors() throws InterruptedException {
		Thread.sleep(2000);
		Search_Doctors.sendKeys(prop.getProperty("Speciality"));
		Select_Cardiologist.click();
		System.out.println("Enter the Details Successfully...");
	}
//	public void SelectGender() throws InterruptedException {
//		Thread.sleep(2000);
//		//Gender.click();
//		//Gen_Male.click();
//		Thread.sleep(5000);
//	}
	
	public void SelectPatientStories() throws InterruptedException 
	{
		Patient_Stories.click();
		Select_PS.click();
		Thread.sleep(5000);
	}
	public void SetExperience() throws InterruptedException 
	{
		Select_Drp_Exp.click();
		Select_Exp.click();
		Thread.sleep(5000);
	}
	
	public void AllFilters() throws InterruptedException {
		Click_AllFilter.click();
		Fees.click();
		Availability.click();
		Thread.sleep(5000);
	}
		
	public void SortBy() throws InterruptedException 
	{
		Sortby.click();
		Select_sort.click();
		Thread.sleep(5000);
	}
	
	public void get_drNames() throws IOException, InterruptedException 
	{	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
		
		System.out.println("Doctor's Details :");
		for (int i=0; i<=4; i++) 
		{			
			String doctors=drnames.get(i).getText();
			System.out.println(drnames.get(i).getText()); 
			details.add(doctors);
			
			String Experience=drExperience.get(i).getText();
			System.out.println(drExperience.get(i).getText());
			details.add(Experience);
			
			String otherdetails=OtherDetails.get(i).getText();
			System.out.println(OtherDetails.get(i).getText());
			details.add(otherdetails);
		}
		
		ExcelOutput.printDrDetailsExcel(details);
	}
	
	


}
