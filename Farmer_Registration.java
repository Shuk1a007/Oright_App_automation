package Testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Farmer_Registration extends Baseclass{
	@Test(dataProvider = "testdata")
    public void login(String user_name, String password, String Customer_Code) throws IOException, InterruptedException {
        //try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(44));
            WebElement getStarted = driver.findElement(By.xpath(Logins.getProperty("getStarted")));
            getStarted.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
            WebElement email = driver.findElement(By.xpath(Logins.getProperty("Email_id")));
            email.sendKeys(user_name);
            WebElement nextButton = driver.findElement(By.xpath(Logins.getProperty("Next_button")));
            nextButton.click();
            WebElement passwordField = driver.findElement(By.xpath(Logins.getProperty("Password_inputbox_placeholder")));
            passwordField.sendKeys(password);
            WebElement customerCode = driver.findElement(By.xpath(Logins.getProperty("customer_code_input_box")));
            customerCode.sendKeys(Customer_Code);
            WebElement loginButton = driver.findElement(By.xpath(Logins.getProperty("Login")));
            loginButton.click();
           // WebElement profile_close=driver.findElement(By.xpath(Registration.getProperty("profile_close")));
        	//profile_close.click();
        	Thread.sleep(5000);
            WebElement dashboard=driver.findElement(By.xpath(Logins.getProperty("dashboard")));
            dashboard.click();
          //  try {
//            if (isElementDisplayed(By.xpath(Logins.getProperty("address")))) {
//                System.out.println("Login Successful");
//            }
        }
        //catch (Exception e) {
        	//System.out.println("Invalid Credentials");
        //}
        //}
    @DataProvider(name = "testdata")
    public Object[][] tdata() {
        return new Object[][] {
//            {"jite201546","jite201547","or19"},
//            {"jite201547","jite2015","or19"},
//            {"jite201547","jite201547","or12"},
//            {"jite2004","jite2020","o19"},
//            {"","",""},
            {"jite201547", "jite201547", "or19"}, 
        };
    }

    // Utility method to check element visibility
    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Element not found
        }
    }
    //verify that user is able to Navigate to Farmer Registration Page 
    @Test
    public void verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page () throws Exception {
    	login("jite201547", "jite201547", "or19");
    	Thread.sleep(5000);
    	WebElement FarmerList_Menu=driver.findElement(By.xpath(Registration.getProperty("Farmer_list_menu")));
    	FarmerList_Menu.click();
    	//Add Farmer 
    	Thread.sleep(5000);
    	WebElement Add_farmer=driver.findElement(By.xpath(Registration.getProperty("Add_farmer")));
    	Add_farmer.click();
    }
    //verify that Farmer Registration title is visible on Farmer Registration Page 
    @Test
    public void verify_that_Farmer_Registration_title_is_visible_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page ();
    	boolean Farmer_available_title=false;
    	WebElement farmer_Registration_title=driver.findElement(By.xpath(Registration.getProperty("Farmer_registration_title")));	
    	String Farmer_Registration_title_text=farmer_Registration_title.getText();
    	System.out.println(Farmer_Registration_title_text);
    	Farmer_available_title=true;
    	if(Farmer_available_title) {
    		System.out.println("Farmer Registration Title is available");
    	}
    	else {
    		System.out.println("Farmer Registration Title is Not Available");
    	}
    }
    //verify that Farmer Registration title is correctly spelled and aligned 
    @Test
    public void verify_that_Farmer_Registration_title_is_correctly_spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page ();
    	WebElement farmer_Registration_title=driver.findElement(By.xpath(Registration.getProperty("Farmer_registration_title")));	
    	String Farmer_Registration_title_text=farmer_Registration_title.getText();
    	System.out.println(Farmer_Registration_title_text);
    	String expected_farmer_registration_title_text="Farmer Registrati";
    	if(Farmer_Registration_title_text.equals(expected_farmer_registration_title_text)) {
    		System.out.println("Farmer Registration title is correctly Spelled ");
    	}
    	else {
    		System.out.println("Farmer Registration Title is not correctly Spelled ");
    		Assert.fail("Farmer Registration Title is not correctly Spelled");
    	}
    }
    //Verify that Farmer Registration title is in Bold text or Not 
    @Test
    public void Verify_that_Farmer_Registration_title_is_in_Bold_text_or_Not() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page ();
    	WebElement farmer_Registration_title=driver.findElement(By.xpath(Registration.getProperty("Farmer_registration_title")));
    	Dimension Farmer_Registration_title_size=farmer_Registration_title.getSize();
    	int Farmer_Registration_font_size=Farmer_Registration_title_size.getWidth();
    	System.out.println(Farmer_Registration_font_size);
    	int expected_farmer_registration_title=544;
    	if(Farmer_Registration_font_size==expected_farmer_registration_title) {
    		System.out.println("Farmer Registration Title is in Bold Text");
    	}
    	else {
    		System.out.println("Farmer Registration Title is not in Bold Text");
    		Assert.fail("Farmer Registration Title is not in Bold Text");
    	}
    }
    //verify that Enter Farmer Name is visible on Farmer Registration Page 
    @Test
    public void verify_that_Enter_Farmer_Name_is_visible_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page ();
    	boolean is_Enter_Fermer_name=false;
    	WebElement Enter_Farmer_Name_title=driver.findElement(By.xpath(Registration.getProperty("Enter_Farmer_name")));
    	String Enter_Farmer_Registration_title_text=Enter_Farmer_Name_title.getText();
    	System.out.println(Enter_Farmer_Registration_title_text);
    	is_Enter_Fermer_name=true;
    	if(is_Enter_Fermer_name) {
    		System.out.println("Enter Farmer Name title is available");
    	}
    	else {
    		System.out.println("Enter Farmer Name title is Not available");
    		Assert.fail("Enter Farmer Name title is available");
    	}	
    } 
    //verify that Enter Farmer Name title is correctly Spelled and aligned 
    @Test
    public void verify_that_Enter_Farmer_Name_title_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Enter_Farmer_Name_title=driver.findElement(By.xpath(Registration.getProperty("Enter_Farmer_name")));
    	String Enter_Farmer_Name_title_text=Enter_Farmer_Name_title.getText();
    	System.out.println(Enter_Farmer_Name_title_text);
    	String Expected_Enter_Farmer_Name_title_text="Enter farmer name*";
    	if(Enter_Farmer_Name_title_text.equals(Expected_Enter_Farmer_Name_title_text)) {
    		System.out.println("Enter Farmer Name Title is Available ");
    	}
    	else {
    		System.out.println("Enter Farmer Name Title is Not Available ");
    		Assert.fail("Enter Farmer Name Title is Not Available ");
    	}
    }
    //verify that user is able to enter Farmer Name in Input Box 
    @Test
    public void verify_that_user_is_able_to_enter_Farmer_Name_in_Input_Box() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Enter_Farmer_Name_Input_box=driver.findElement(By.xpath(Registration.getProperty("Farmer_Name_input_box")));
    	String clickable=Enter_Farmer_Name_Input_box.getAttribute("clickable");
    	if("true".equals(clickable)) {
    		Enter_Farmer_Name_Input_box.click();
    		Enter_Farmer_Name_Input_box.sendKeys("Farmer420");
    	}else {
    		System.out.println("Input Box is not clickable");
    		Assert.fail("Input Box is not clickable");
    	}
    }
    //verify that Enter Farmer Code is available on Farmer Registration Page 
    @Test
    public void verify_that_Enter_Farmer_Code_is_available_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	boolean Is_farmer_code_available=false;
    	WebElement Farmer_Code_title=driver.findElement(By.xpath(Registration.getProperty("Enter_Farmer_code_title")));
    	String Farmer_code_title_text=Farmer_Code_title.getText();
    	System.out.println(Farmer_code_title_text);
    	Is_farmer_code_available=true;
    	if(Is_farmer_code_available) {
    		System.out.println("Enter Farmer Code title is Available ");
    	}else {
    		System.out.println("Enter Farmer Code title is not Available ");
    	}
    }
    //verify that Enter Farmer Code is correctly Spelled on Farmer Registration Page 
    @Test
    public void verify_that_Enter_Farmer_Code_is_correctly_Spelled_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Farmer_Code_title=driver.findElement(By.xpath(Registration.getProperty("Enter_Farmer_code_title")));
    	String Farmer_Code_title_text=Farmer_Code_title.getText();
    	System.out.println(Farmer_Code_title_text);
    	String Expeted_farmer_code ="Enter farmer code";
    	if(Farmer_Code_title_text.equals(Expeted_farmer_code)) {
    		System.out.println("Enter Farmer Code title is correctly Spelled ");
    	}else {
    		System.out.print("Enter Farmer Code title is Not correctly Spelled ");
    		Assert.fail("Enter Farmer Code title is Not correctly Spelled ");
    	}
    } 
    //verify that in Enter Farmer code input Box Farmer code is already filled 
    @Test
    public void verify_that_in_Enter_Farmer_code_input_Box_Farmer_code_is_already_filled() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Farmer_Code_text=driver.findElement(By.xpath(Registration.getProperty("Farmer_code_text")));
    	//Thread.sleep(10000);
    	String existing_text=Farmer_Code_text.getAttribute("text");
    	System.out.println(existing_text);
    	if(existing_text!=null) {
    		System.out.println("Enter Farmer Code input Box is already contain text and the Farmer code is = " +existing_text);
    	}else {
    		System.out.println("Enter Farmer Code is Empty ");
    		Assert.fail("Enter Farmer Code is Empty");
    	}
    }
    //verify that enter farmer code input box is editable or not 
    @Test
    public void verify_that_enter_farmer_code_input_box_is_editable_or_not() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Farmer_Code_text=driver.findElement(By.xpath(Registration.getProperty("Farmer_code_text")));
    	boolean isReadonly=Farmer_Code_text.isEnabled();
    	if(isReadonly) {
    		System.out.println("Farmer Code is editable ");
    	}
    	else {
    		System.out.println("Farmer Code is not editable ");
    		Assert.fail("Farmer Code is not Editable");
    	}
    } 
    //verify that User is able to clear Farmer code and enter New Farmer code 
    @Test
    public void verify_that_User_is_able_to_clear_Farmer_code_and_enter_New_Farmer_code() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement Farmer_Code_text=driver.findElement(By.xpath(Registration.getProperty("Farmer_code_text")));
    	Farmer_Code_text.clear();
    	Farmer_Code_text.sendKeys("0001");
//    	try {
//            // Wait for "Farmer already exists" popup
//            WebElement farmerAlreadyExistPopup = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(
//                            By.xpath(Registration.getProperty("Farmer_already_exist"))
//                    )
//            );
//
//            if (farmerAlreadyExistPopup.isDisplayed()) {
//                System.out.println("Farmer code already exists");
//
//                // Click OK button if needed
//                //WebElement okButton =
//                  //      driver.findElement(By.xpath(Registration.getProperty("Farmer_exist_OK_Button")));
//                //okButton.click();
//            }
//
//        } catch (TimeoutException e) {
//            // Popup did not appear within wait time
//            System.out.println("Farmer code does NOT exist");
//        }
    }
    //verify that Enter Mobile Number title is visibe on the Farmer Registration Page 
    @Test
    public void verify_that_Enter_Mobile_Number_title_is_visibe_on_the_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	boolean Is_Enter_mobile_number_available=false;
    	WebElement Enter_mobile_number_title=driver.findElement(By.xpath(Registration.getProperty("Enter_mobile_number_title")));
    	String Enter_mobile_number_title_text=Enter_mobile_number_title.getText();
    	System.out.println(Enter_mobile_number_title_text);
    	Is_Enter_mobile_number_available=true;
    	if(Is_Enter_mobile_number_available) {
    		System.out.println("Enter Mobile Number title is available");
    	}
    	else {
    		System.out.println("Enter Mobile Number title is Not available");
    		Assert.fail("Enter Mobile Number title is Not available");
    	}
    }
    //verify that Enter Mobile Number title is correctly Spelled and aligned 
    @Test
    public void verify_that_Enter_Mobile_Number_title_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Enter_mobile_number_title=driver.findElement(By.xpath(Registration.getProperty("Enter_mobile_number_title")));
    	String Enter_mobile_number_title_text=Enter_mobile_number_title.getText();
    	System.out.println(Enter_mobile_number_title_text);
    	String expected_enter_mobile_number_title_text="Enter mobile number*";
    	if(Enter_mobile_number_title_text.equals(expected_enter_mobile_number_title_text)) {
    		System.out.println("Enter Mobile Number title is correctly Spelled ");
    	}
    	else {
    		System.out.println("Enter Mobile Number title is not correctly Spelled ");
    		Assert.fail("Enter Mobile Number title is not correctly Spelled ");
    	}
    } 
    //verify that user is able to enter Mobile number 
    @Test
    public void verify_that_user_is_able_to_enter_Mobile_number() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Enter_Mobile_Number_input_box=driver.findElement(By.xpath(Registration.getProperty("Enter_mobile_number_inputbox")));
    	Enter_Mobile_Number_input_box.clear();
    	Enter_Mobile_Number_input_box.sendKeys("9833362876");
    	//Thread.sleep(5000);
    	String enteredValue = Enter_Mobile_Number_input_box.getText();
        System.out.println("Entered value in field: " + enteredValue);
        // Check only digits
        boolean isOnlyDigits = enteredValue.matches("\\d+");
        // Check length is exactly 10
        boolean isTenDigits = enteredValue.length() == 10;
        //check special character validation 
        boolean hasNoSpecialCharacters = enteredValue.matches("^[0-9]{10}$");
       // Final validation
        if (isOnlyDigits && isTenDigits && hasNoSpecialCharacters) {
            System.out.println("Mobile Number Input box is accepting only 10 digit Numberic value");
        } else {
            System.out.println("Mobile Number Input box is accpecting special character,alphabetic value and More then 10 digit numeric value ");
        }
      // Assertion (TestNG)
        Assert.assertTrue(isOnlyDigits && isTenDigits &&hasNoSpecialCharacters,
                "Mobile number field should accept only 10-digit numeric value");
    } 
    //verify that enter Address title is visible on the Farmer Registration Page 
    @Test
    public void verify_that_enter_Address_title_is_visible_on_the_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	boolean is_Enter_address_available=false;
    	WebElement Enter_address=driver.findElement(By.xpath(Registration.getProperty("Enter_Address_title")));
    	String enter_address_text=Enter_address.getText();
    	System.out.println(enter_address_text);
    	is_Enter_address_available=true;
    	if(is_Enter_address_available) {
    		System.out.println("Enter Address Title is Available");
    	}
    	else {
    		System.out.println("Enter Address Title is not Available");
    	}
    } 
    //verify that enter address title is correctly spelled and aligned 
    @Test
    public void verify_that_enter_address_title_is_correctly_spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Enter_address=driver.findElement(By.xpath(Registration.getProperty("Enter_Address_title")));
    	String enter_address_text=Enter_address.getText();
    	System.out.println(enter_address_text);
    	String Expected_Enter_Address_text="Enter addres";
    	if(enter_address_text.equals(Expected_Enter_Address_text)) {
    		System.out.println("Enter Address Title is correctly Spelled ");
    	}
    	else {
    		System.out.println("Enter Address Title is Not correctly Spelled");
    	}
    } 
    //verify that user is able to enter Address in the Address input box
    @Test
    public void verify_that_user_is_able_to_enter_Address_in_the_Address_input_box() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement enter_address_inputbox=driver.findElement(By.xpath(Registration.getProperty("Enter_Address_inputbox")));
    	String address_inputbox_clickable=enter_address_inputbox.getAttribute("clickable");
    	if("true".equals(address_inputbox_clickable)) {
    	enter_address_inputbox.clear();
    	enter_address_inputbox.sendKeys("GURUGRAM");
    	}
    	else {
    		System.out.println("Enter Address Input Box is not Clickable ");
    		Assert.fail("Enter Address Input Box is not Clickable");
    	} 	
    }
    //verify that Select Cattle Type title is visible on Farmer Registration Page ()
    @Test
    public void verify_that_Select_Cattle_Type_title_is_visible_on_Farmer_Registration_Page () throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	boolean is_cattle_type_available=false;
    	WebElement Select_cattle_type_title=driver.findElement(By.xpath(Registration.getProperty("Select_Catle_title")));
    	String Select_cattle_type_title_text=Select_cattle_type_title.getText();
    	System.out.println(Select_cattle_type_title_text);
    	is_cattle_type_available=true;
    	if(is_cattle_type_available) {
    		System.out.println("Cattle Type Text is Available ");
    	}
    	else {
    		System.out.println("Cattle Type Text is Not Available ");
    		Assert.fail("Cattle Type Text is Not Available ");
    	}
    }
    //verify that Select Cattle type text is correctly Spelled and aligned 
    @Test
    public void verify_that_Select_Cattle_type_text_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Select_cattle_type_title=driver.findElement(By.xpath(Registration.getProperty("Select_Catle_title")));
    	String Select_cattle_type_title_text=Select_cattle_type_title.getText();
    	System.out.println(Select_cattle_type_title_text);
    	String expected_select_cattle_type="Select Cattle Type*";
    	if(Select_cattle_type_title_text.equals(expected_select_cattle_type)) {
    		System.out.println("Select Cattle Type Text is correctly Spelled andd aligned ");
    	}
    	else {
    		System.out.println("Select Cattle Type Tetx is not correctly Spelled and aligned ");
    		Assert.fail("Select Cattle Type Text is not correctly Spelled and aligned ");
    	}
    }
    //verify that cattle list is visible on Farmer_Registration Page and user is able to Select cattle type 
    @Test
    public void verify_that_cattle_list_is_visible_on_Farmer_Registration_Page_and_user_is_able_to_Select_cattle_type() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	List<WebElement> cattle_type_list=driver.findElements(By.xpath(Registration.getProperty("cattle_title_list")));
    	for(int i=0;i<cattle_type_list.size();i+=2){
    		System.out.println(cattle_type_list.get(i).getText());
    		if(cattle_type_list.get(i).getText().contains("Buffalo")) {
    			cattle_type_list.get(i).click();
    		}
    		else {
    			System.out.println("Cattle Type list is not visible ");
    			Assert.fail("Cattle Type list is not visible ");
    		}
    	}
    }
  //verify that Add Bank Details title is visible on Farmer Registration Page 
    @Test
	public void verify_that_Add_Bank_Details_title_is_visible_on_Farmer_Registration_Page() throws Exception {
		verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
		boolean is_Add_Bank_Details_available=false;
		WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
		String Add_Bank_Details_text=Add_Bank_Details.getText();
		System.out.println(Add_Bank_Details_text);
		is_Add_Bank_Details_available=true;
		if(is_Add_Bank_Details_available) {
			System.out.println("Add Bank Details title is Available ");
		}
		else {
			System.out.println("Add Bank Details Title is not Available");
			Assert.fail("Add Bank Details Title is not Available");
		}
	} 
    //verify that Add Bank Details title is correctly Spelled and aligned 
    @Test 
    public void verify_that_Add_Bank_Details_title_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
		String Add_Bank_Details_text=Add_Bank_Details.getText();
		System.out.println(Add_Bank_Details_text);
		String Expected_Add_Bank_Details_text="Add Bank Details";
		if(Add_Bank_Details_text.equals(Expected_Add_Bank_Details_text)) {
			System.out.println("Add Bank Details Title is correctly Spelled and aligned");
		}
		else {
			System.out.println("Add Bank Details Title is Not correctly Spelled and aligned");
		}
    } 
    //verify that After Clicking On Add BankBank details are visible()
    @Test
    public void verify_that_After_Clicking_On_Add_Bank_Bank_details_are_visible() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	boolean is_Bank_Name_title_available=false;
    	WebElement Bank_Name_title=driver.findElement(By.xpath(Registration.getProperty("Bank_Name")));
    	String Bank_Name_title_text=Bank_Name_title.getText();
    	System.out.println(Bank_Name_title_text);
    	is_Bank_Name_title_available=true;
    	if(is_Bank_Name_title_available) {
    		System.out.println("Bank Name Title is Available");
    	}
    	else {
    		System.out.println("Bank Name Title is not Available");
    		Assert.fail("Bank Name Title is not Available");
    	}   	
    }
    //verify that Bank Name title is correctly Spelled and aligned
    @Test
    public void verify_that_Bank_Name_title_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Bank_Name_title=driver.findElement(By.xpath(Registration.getProperty("Bank_Name")));
    	String Bank_Name_title_text=Bank_Name_title.getText();
    	System.out.println(Bank_Name_title_text);
    	String Expected_Bank_Name_text="Bank Name";
    	if(Bank_Name_title_text.equals(Expected_Bank_Name_text)) {
    		System.out.println("Bank Name Title is correctly Spelled and aligned ");
    	}
    	else {
    		System.out.println("Bank Name Title is not correctly Spelled and aligned");
    		Assert.fail("Bank Name Title is not correctly spelled and aligned");
    	}
    }
  //verify that User is able to Enter Bank Name in Bank Name input Box 
    @Test
	public void verify_that_User_is_able_to_Enter_Bank_Name_in_Bank_Name_input_Box() throws Exception {
		verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Bank_Name_Input_box=driver.findElement(By.xpath(Registration.getProperty("Bank_Name_input_Box")));
    	String Bank_Name_Input_click=Bank_Name_Input_box.getAttribute("clickable");
    	if("true".equals(Bank_Name_Input_click)) {
    		Bank_Name_Input_box.clear();
    		Bank_Name_Input_box.sendKeys("Union Bank of India");
    	}
    	else {
    		System.out.println("Bank Name Input Box is Not clickable and User is not able to enter Bank Name ");
    		Assert.fail("Bank Name Input Box is Not clickable and User is not able to enter Bank Name ");
    	}
	}
    //verify that Branch Name title is visible on Farmer Registration Page 
    @Test
    public void verify_that_Branch_Name_title_is_visible_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	boolean is_Branch_name_available=false;
    	WebElement Branch_name=driver.findElement(By.xpath(Registration.getProperty("Branch_Name")));
    	String Branch_Name_text=Branch_name.getText();
    	System.out.println(Branch_Name_text);
    	is_Branch_name_available=true;
    	if(is_Branch_name_available) {
    		System.out.println("Branch Name Title is Available");
    	}
    	else {
    		System.out.println("Branch Name Title is not Available ");
    	}
    }
    //verify that Branch Name title is correctly spelled and aligned 
    @Test
    public void verify_that_Branch_Name_title_is_correctly_spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Branch_name=driver.findElement(By.xpath(Registration.getProperty("Branch_Name")));
    	String Branch_Name_text=Branch_name.getText();
    	System.out.println(Branch_Name_text);
    	String expected_Branch_Name_text="Branch Name";
    	if(Branch_Name_text.equals(expected_Branch_Name_text)) {
    		System.out.println("Branch Name is correctly Spelled and aligned");
    	}
    	else {
    		System.out.println("Branch Name is Not correctly Spelled and aligned");
    		Assert.fail("Branch Name is Not correctly Spelled and aligned");
    	}
    }
    //verify that User is able to enter Branch Name on Farmer Registration Page 
    @Test
    public void verify_that_User_is_able_to_enter_Branch_Name_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Branch_Name_input_box=driver.findElement(By.xpath(Registration.getProperty("Branch_Name_Input_box")));
    	String Branch_Name_input=Branch_Name_input_box.getAttribute("clickable");
    	if("true".equals(Branch_Name_input)) {
    		Branch_Name_input_box.clear();
    		Branch_Name_input_box.sendKeys("Gurugram");
    	}
    	else {
    		System.out.println("User is Not able to Enter Branch Name ");
    		Assert.fail("User is Not able to Enter Branch Name ");
    	}
    } 
    //verify that IFSC Code is visible on Farmer Registration page 
    @Test
    public void verify_that_IFSC_Code_is_visible_on_Farmer_Registration_page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	boolean is_IFSC_Code_available=false;
    	WebElement IFSC_Code_title=driver.findElement(By.xpath(Registration.getProperty("IFSC_Code")));
    	String IFSC_Code_title_text=IFSC_Code_title.getText();
    	System.out.println(IFSC_Code_title_text);
    	is_IFSC_Code_available=true;
    	if(is_IFSC_Code_available){
    		System.out.println("IFSC Code title is available");
    	}
    	else {
    		System.out.println("IFSC Code title is  not Available");
    		Assert.fail("IFSC Code title is not Available ");
    	}
    }
    //verify that IFSC Code title is correctly Spelled and Farmer Registration Page 
    @Test 
    public void verify_that_IFSC_Code_title_is_correctly_Spelled_and_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement IFSC_Code_title=driver.findElement(By.xpath(Registration.getProperty("IFSC_Code")));
    	String IFSC_Code_title_text=IFSC_Code_title.getText();
    	System.out.println(IFSC_Code_title_text);
    	String expected_IFSC_Code_text="IFSC";
    	if(IFSC_Code_title_text.equals(expected_IFSC_Code_text)) {
    		System.out.println("IFSC Code Title is Available");
    	}
    	else {
    		System.out.println("IFSC Code Title is Not Available");
    		Assert.fail("IFSC Code Title is Not Available");
    	}
    } 
    //verify that user is able to enter IFSC Code on Farmer Registration Page 
    @Test
    public void verify_that_user_is_able_to_enter_IFSC_Code_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement IFSC_Code_Input_Box=driver.findElement(By.xpath(Registration.getProperty("IFSC_Code_Input_box")));
    	String IFSC_Code_Input_box_text=IFSC_Code_Input_Box.getAttribute("clickable"); 
    	if("true".equals(IFSC_Code_Input_box_text)) {
    		IFSC_Code_Input_Box.click();
    		IFSC_Code_Input_Box.sendKeys("UCBA0001976");
    	}
    	else {
    		System.out.println("IFSC Code Input Box is Not Clickable");
    		Assert.fail("IFSC Code Input Box is Not Clickable");
    	}
    }
    //verify that Account Number title is visible on Farmer Registration Page 
    @Test
    public void verify_that_Account_Number_title_is_visible_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	boolean is_Account_number_available=false;
    	WebElement Account_Number_title=driver.findElement(By.xpath(Registration.getProperty("Account_Number_title")));
    	String Account_Number_title_text=Account_Number_title.getText();
    	System.out.println(Account_Number_title_text);
    	is_Account_number_available=true;
    	if(is_Account_number_available) {
    		System.out.println("Account Number Title is Available ");
    	}
    	else {
    		System.out.println("Account Number Title is not Available");
    		Assert.fail("Account Number Title is not Available");
    	}
    }
    //verify that Account Number title is correctly Spelled and aligned
    @Test
    public void verify_that_Account_Number_title_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Account_Number_title=driver.findElement(By.xpath(Registration.getProperty("Account_Number_title")));
    	String Account_Number_title_text=Account_Number_title.getText();
    	System.out.println(Account_Number_title_text);
    	String expected_Account_Number_title_text="Account Number";
    	if(Account_Number_title_text.equals(expected_Account_Number_title_text)) {
    		System.out.println("Accunt Number title is correctly Spelled and aligned");
    	}
    	else {
    		System.out.println("Account Number Title is not Correctly Spelled and aligned ");
    		Assert.fail("Account Number Title is not Correctly Spelled and aligned ");
    	}
    }
    //verify that User is able to enter Account Number in Account Number Input Box 
    @Test
    public void verify_that_User_is_able_to_enter_Account_Number_in_Account_Number_Input_Box() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Account_Number_Input_box=driver.findElement(By.xpath(Registration.getProperty("Account_Number_Input_box")));
    	String Account_Number_Input=Account_Number_Input_box.getAttribute("clickable");
    	if("true".equals(Account_Number_Input)) {
    		Account_Number_Input_box.clear();
    		Account_Number_Input_box.sendKeys("736602010011708");
    	}
    	else{
    		System.out.println("Account Number Input Box is not clickable");
    		Assert.fail("Account Number Input Box is Not clickable");
    	} 
    }
    //verify that Account Holder Name title is available on Farmer Registration Page
    @Test
    public void verify_that_Account_Holder_Name_title_is_available_on_farmer_Registration_page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	boolean is_account_holder_name_availabe=false;
    	WebElement Account_Holder_Name_title=driver.findElement(By.xpath(Registration.getProperty("Account_Holder_Name")));
    	String Account_Holder_title_text=Account_Holder_Name_title.getText();
    	System.out.println(Account_Holder_title_text);
    	is_account_holder_name_availabe=true;
    	if(is_account_holder_name_availabe) {
    		System.out.println("Account Holder Name Title is available");
    	}
    	else {
    		System.out.println("Account Holder Name title is not Available");
    		Assert.fail("Account Holder Name title is Not Available");
    	}
    }
    //verify that Account Holder Name is correctly Spelled and aligned 
    @Test
    public void verify_that_Account_Holder_Name_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Account_Holder_Name_title=driver.findElement(By.xpath(Registration.getProperty("Account_Holder_Name")));
    	String Account_Holder_title_text=Account_Holder_Name_title.getText();
    	System.out.println(Account_Holder_title_text);
    	String expected_Account_holder_Name_title="Account Holder Name";
    	if(Account_Holder_title_text.equals(expected_Account_holder_Name_title)) {
    		System.out.println("Account Holder Name is correctly Spelled and aligned ");
    	}
    	else {
    		System.out.println("Account Holder Name is Not Correctly Spelled and Aligned");
    		Assert.fail("Account Holder Namae is not Correctly Spelled and Aligned");
    	}
    }
    //verify that user is able to enter Account Holder Name in Account Number Input Box
    @Test
    public void verify_that_user_is_able_to_enter_Account_Holder_Name_in_Account_Number_Input_Box() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
    	Add_Bank_Details.click();
    	WebElement Account_holder_Input_Box=driver.findElement(By.xpath(Registration.getProperty("Account_Holder_Name_Input_box")));
    	String Account_holder_Input=Account_holder_Input_Box.getAttribute("clickable");
    	if("true".equals(Account_holder_Input)) {
    		Account_holder_Input_Box.clear();
    		Account_holder_Input_Box.sendKeys("Bechan Shukla ");
    	}
    	else {
    		System.out.println("Account Holder Input Box is not Clickable");
    		Assert.fail("Account Holder Input box is not clickable ");
    	}
    }
    //Verify that Submit Button is visible on Farmer Registration Page 
    @Test
    public void verify_that_Submit_Button_is_visible_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
//    	WebElement Add_Bank_Details=driver.findElement(By.xpath(Registration.getProperty("Add_Bank_Details")));
//    	Add_Bank_Details.click();
    	boolean is_submit_button_available=false;
    	WebElement Submit_button=driver.findElement(By.xpath(Registration.getProperty("Submit_Button")));
    	String Submit_button_text=Submit_button.getText();
    	System.out.println(Submit_button_text);
    	is_submit_button_available=true;
    	if(is_submit_button_available) {
    		System.out.println("Submit Button is visible");
    	}
    	else {
    		System.out.println("Submit Button is Not Visible");
    		Assert.fail("Submit Button is Not Visible");
    	}
    }
    //verify that Submit button is correctly Spelled and aligned 
    @Test
    public void verify_that_Submit_button_is_correctly_Spelled_and_aligned() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Submit_button=driver.findElement(By.xpath(Registration.getProperty("Submit_Button")));
    	String Submit_button_text=Submit_button.getText();
    	System.out.println(Submit_button_text);
    	String expected_Submit_button_text="Submit";
    	if(Submit_button_text.equals(expected_Submit_button_text)) {
    		System.out.println("Submit Button is correctly Spelled and aligned ");
    	}
    	else {
    		System.out.println("Submit Button is not Correctly Spelled and aligned");
    		Assert.fail("Submit Button is not Correctly Spelled and aligned");
    	}
    }
    //verify that Submit Button is in Bold text on Farmer Registration Page 
    @Test
    public void verify_that_Submit_Button_is_in_Bold_text_on_Farmer_Registration_Page() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	WebElement Submit_button=driver.findElement(By.xpath(Registration.getProperty("Submit_Button")));
    	String Submit_button_text=Submit_button.getText();
    	System.out.println(Submit_button_text);
    	Dimension Submit_button_title_size=Submit_button.getSize();
    	int Submit_button_font_size=Submit_button_title_size.getWidth();
    	System.out.println(Submit_button_font_size);
    	int expected_Submit_button_text=85;
    	if(Submit_button_font_size==expected_Submit_button_text) {
    		System.out.println("Submit Button is in Bold text ");
    	}
    	else {
    		System.out.println("Submit Button is not in Bold text");
    		Assert.fail("Submit Button is not in Bold text");
    	}
    }
    //verify that after filling all the Required field User is able to Register farmer
    @Test
    public void verify_that_after_filling_all_the_Required_field_User_is_able_to_Register_farmer() throws Exception {
    	verify_that_user_is_able_to_Navigate_to_Farmer_Registration_Page();
    	Thread.sleep(5000);
    	WebElement Enter_Farmer_Name_Input_box=driver.findElement(By.xpath(Registration.getProperty("Farmer_Name_input_box")));	
        Enter_Farmer_Name_Input_box.click();
        Enter_Farmer_Name_Input_box.sendKeys("Farmer420");
        WebElement Enter_Mobile_Number_input_box=driver.findElement(By.xpath(Registration.getProperty("Enter_mobile_number_inputbox")));
    	Enter_Mobile_Number_input_box.clear();
    	Enter_Mobile_Number_input_box.sendKeys("9833362876");
    	WebElement enter_address_inputbox=driver.findElement(By.xpath(Registration.getProperty("Enter_Address_inputbox")));
    	enter_address_inputbox.clear();
    	enter_address_inputbox.sendKeys("Gurugram");
    	List<WebElement> cattle_type_list=driver.findElements(By.xpath(Registration.getProperty("cattle_title_list")));
    	for(int i=0;i<cattle_type_list.size();i+=2){
    		//System.out.println(cattle_type_list.get(i).getText());
    		if(cattle_type_list.get(i).getText().contains("Buffalo")) {
    			cattle_type_list.get(i).click();
    		}
    	}
    	WebElement Submit_button=driver.findElement(By.xpath(Registration.getProperty("Submit_Button")));
    	Submit_button.click();
    	//verify that farmer is successfully registered or not 
    	Thread.sleep(5000);
    	WebElement Search_Bar=driver.findElement(By.xpath(Registration.getProperty("Search_Bar")));
    	Search_Bar.sendKeys("Farmer420");
    }
}