package StepDF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class Hooks {
	

	 public static WebDriver driver;
	 static FileInputStream fis;
	 static Properties prop = new Properties();

	@BeforeAll
	 public static void driverSetup() throws IOException 
	{		   
			fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		    prop.load(fis);
	    	driver=new ChromeDriver();
	    	driver.manage().deleteAllCookies(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(prop.getProperty("Site"));
	    	driver.manage().window().maximize();
		}	
	
	@After
	public void addSS(Scenario scenario)
	{
		if(!scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
 
            // Embed the screenshot in the report
            scenario.attach(screenshot, "image/png", "Passed Test Screenshot");
		}
	}

   
  @AfterAll
   public static void tearDown() {
      driver.quit();
   }
}

