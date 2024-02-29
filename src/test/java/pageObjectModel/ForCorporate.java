package pageObjectModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ForCorporate {
	
	WebDriver driver;
	FileInputStream fis;
	Properties prop = new Properties();
	
	public  ForCorporate(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="//*[text()='For Corporates']") WebElement ForCprporate;
	@FindBy (xpath="//*[text()='Health & Wellness Plans']") WebElement SelectHWP;
	
	@FindBy (xpath="//input[@id='name']") WebElement Name;
	@FindBy (xpath="//input[@id='organizationName']") WebElement OrganizationName;
	@FindBy (xpath="//input[@id='contactNumber']") WebElement ContactNumber;
	@FindBy (xpath="//input[@id='officialEmailId']") WebElement invalidEmailid;
	@FindBy (xpath="//select[@id='organizationSize']") WebElement Organizationsize;
	@FindBy (xpath="//select[@id='interestedIn']") WebElement Interestedin;
	@FindBy (xpath="//*[@id=\"app\"]/div/div/header[2]/div[2]/div/form/button") WebElement demobtn;
	@FindBy (xpath="//*[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue']") WebElement Button;
	
	public void SelectForCorporate() {
		ForCprporate.click();
		SelectHWP.click();		
	}
	public void EnterDetails() throws InterruptedException, IOException {
		Thread.sleep(2000);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
	    prop.load(fis);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,200)");
		
		Name.click();
		Name.sendKeys(prop.getProperty("Name"));
		
		OrganizationName.click();
		OrganizationName.sendKeys(prop.getProperty("OrganizationName"));
		
		ContactNumber.click();
		ContactNumber.sendKeys(prop.getProperty("ContactNum"));
		
		invalidEmailid.click();
		invalidEmailid.sendKeys(prop.getProperty("InValidEmail"));
		
		Select sl=new Select(Organizationsize);
		sl.selectByVisibleText("501-1000");
		
		Select sl1=new Select(Interestedin);
		sl1.selectByIndex(1);
		
		boolean ss=demobtn.isEnabled();
		System.out.println("Demo Button is Disabled: "+ss);
		
		
		invalidEmailid.clear();
		invalidEmailid.sendKeys(prop.getProperty("ValidEmail"));
		
		Thread.sleep(4000);
		Button.click();
		Thread.sleep(6000);
		
	}
	

}
