package pageObjectModel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utilities.ExcelOutput;

public class testngpom extends BaseClass {
	
	public static WebDriver driver;
	
	public static FindHospitals fh;
	public static Surgeries sr;
	public static ForCorporate cr;
	public static ThankYou ty;
	
	@BeforeClass 
   void setup() throws IOException 
	{	  
	   driver = initilizeBrowser();
	   driver.get(getProperties().getProperty("Site"));
	   fh=new FindHospitals(driver);
	   sr=new Surgeries(driver);
	   ty = new ThankYou(driver);
	   cr = new ForCorporate(driver);
   }
	
	@Test (priority=1)
	void FindHospitals() throws InterruptedException, IOException {
		
		fh.SetLocation();
		fh.EnterDoctors();
		//fh.SelectGender();
		fh.SelectPatientStories();
		fh.SetExperience();
		fh.AllFilters();
		fh.SortBy();
		fh.get_drNames();
		
	}
		
	@Test (priority=2)
	void Surgeries() throws IOException, InterruptedException {
		sr.Get_Details();
	}
	
	@Test (priority=3)
	void ForCorporate() throws InterruptedException, IOException {
		
		cr.SelectForCorporate();	
		cr.EnterDetails();
							
   }
		
	@Test (priority=4)
	void ThankYou() {			
		ty.Msg();
	}
		
	@AfterClass
	public void tearDown() {
	    driver.quit();
	}
}

