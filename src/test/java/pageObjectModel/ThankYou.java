package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYou {
	
	WebDriver driver;
	
	public ThankYou(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy (xpath="//*[@class='u-text--bold text-alpha']") WebElement TYmsg;

	public void Msg() {
		
		boolean msg= TYmsg.isDisplayed();
		System.out.println(" THANK YOU Message is Displayed: "+msg);
						
	}
	
}
