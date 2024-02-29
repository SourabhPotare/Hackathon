Feature: Finding Hospitals
   @sanity @regression
  Scenario: Find the Hospitals in your city and print the Details
    Given go to practo and  Select the city and Search Speciality
    When Apply filters for Patient stories,Experiences,fees,availability and any one sorting
    Then Display the five Doctors Details
     
     @sanity
  Scenario: Print the all surgeries
    When Click the Surgeries and get all the surgeries
    
     @regression
  Scenario: Fill the Demo form and capture the Thank you message
    When select the For Corporate option and select the health and wellness
    When fill the all details with invalid email and check the demo button is discable or not and After checking search button enter the valid email and click on button
    
    @sanity
  Scenario: Print the Thank You message
    Then validate the Thank you message is display or not

    
    