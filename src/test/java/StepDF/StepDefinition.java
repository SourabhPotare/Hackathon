package StepDF;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.diagnostics.logging.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.BaseClass;
import pageObjectModel.FindHospitals;
import pageObjectModel.ForCorporate;
import pageObjectModel.Surgeries;
import pageObjectModel.ThankYou;


public class StepDefinition  
{
	
	public org.apache.logging.log4j.Logger logger=BaseClass.getLogger();
	public WebDriver driver; 
	
	public static FindHospitals fh;
	public static Surgeries sr;
	public static ForCorporate cr;
	public static ThankYou ty;
	
	
	@Given("go to practo and  Select the city and Search Speciality")
	public void go_to_practo_and_select_the_city_and_search_speciality() throws InterruptedException, IOException {
	  
		driver = Hooks.driver;
		fh= new FindHospitals(driver);
		sr = new Surgeries(driver);
		cr = new ForCorporate(driver);
		ty = new ThankYou(driver);
		fh.SetLocation();
		fh.EnterDoctors();
		logger.info("set the city and speciality in practo");
	}

	@When("Apply filters for Patient stories,Experiences,fees,availability and any one sorting")
	public void apply_filters_for_patient_stories_experiences_fees_availability_and_any_one_sorting() throws InterruptedException {
		
		//fh.SelectGender();
		fh.SelectPatientStories();
		fh.SetExperience();
		fh.AllFilters();
		fh.SortBy();
		logger.info("Applying all the filters");
		
	}

	@Then("Display the five Doctors Details")
	public void display_the_five_doctors_details() throws IOException, InterruptedException 
	{
		
		fh.get_drNames();
		logger.info("get the details of Doctors");
	}

	@When("Click the Surgeries and get all the surgeries")
	public void click_the_surgeries_and_get_all_the_surgeries() throws IOException, InterruptedException {
		
		sr.Get_Details();
		logger.info("Get the all surgeries");
	}

	@When("select the For Corporate option and select the health and wellness")
	public void select_the_for_corporate_option_and_select_the_health_and_wellness() {
	  
		cr.SelectForCorporate();
		logger.info("select the health and wellness in for corporate");
	}

	@When("fill the all details with invalid email and check the demo button is discable or not and After checking search button enter the valid email and click on button")
	public void fill_the_all_details_with_invalid_email_and_check_the_demo_button_is_discable_or_not_and_after_checking_search_button_enter_the_valid_email_and_click_on_button() throws InterruptedException, IOException {
		
		cr.EnterDetails();
		logger.info("enter the all details with invalid email and check the demo button is decable or not after that enter valid email");
	}

	@Then("validate the Thank you message is display or not")
	public void validate_the_thank_you_message_is_display_or_not() {	
		
		ty.Msg();
		logger.info("validate the thank you message is display or not and print it");
		
	}



}
