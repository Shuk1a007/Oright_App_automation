package Testcases;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Base.Baseclass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class edpu extends Baseclass{
	//Actions Ac1=new Actions(driver);
	
	 @Test(dataProvider = "testdata1")
	    public void login(String user_name, String password, String Customer_Code) throws IOException, InterruptedException {
		// try {
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(66));
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
	            Thread.sleep(5000);
	            WebElement dashboard=driver.findElement(By.xpath(Logins.getProperty("dashboard")));
	            dashboard.click();
	            
	            /*
	            if (isElementDisplayed(By.xpath(Logins.getProperty("location_allow")))) {
	                System.out.println("Login Successful");
	                WebElement allowLocation = driver.findElement(By.xpath(Logins.getProperty("allow")));
	                allowLocation.click();
	            }*/
	 }
	// catch (Exception e) {
    // 	System.out.println("Invalid Credentials");
     //}
     //}
	 @DataProvider(name = "testdata1")
	    public Object[][] tdata() {
	        return new Object[][] {
	        	{"jite201547", "jite201547", "or19"},
	        };
	  }
	 private boolean isElementDisplayed(By locator) {
	        try {
	            WebElement element = driver.findElement(locator);
	            return element.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false; // Element not found
	        }
	    }
	 @Test
	 public void menu() throws Exception {
	     login("jite201547", "jite201547", "or19");
	     try {
	    	 Thread.sleep(50000);
	    	 WebElement menu =driver.findElement(By.xpath(EDPU.getProperty("Menu")));
	         System.out.println("Menu element is visible and clickable.");
	         menu.click();
	         System.out.println("Clicked on the Menu element successfully.");
	     } catch (Exception e) {
	         System.err.println("Failed to click on the Menu element: " + e.getMessage());
	         throw e; // Rethrow the exception to fail the test
	     }
	     WebElement edpu=driver.findElement(By.xpath(EDPU.getProperty("edpu")));
	     edpu.click();
	     WebElement edpu_testing=driver.findElement(By.xpath(EDPU.getProperty("edpu_testing")));
	     edpu_testing.click();
	     //driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
	     Thread.sleep(50000);
	     WebElement testing=driver.findElement(By.xpath(EDPU.getProperty("testing")));
	     testing.click();
	   //  Thread.sleep(50000);
	     WebElement Search_bar=driver.findElement(By.xpath(EDPU.getProperty("Search_bar")));
	     Search_bar.sendKeys("0006");
	    // Thread.sleep(50000);
	     WebElement select=driver.findElement(By.xpath(EDPU.getProperty("farmer_select")));
	     select.click();
	 }
	 @Test
	 public void farmer_milk_testing() throws Exception {
		 menu();
		/// Thread.sleep(50000);
		 WebElement farmer_milk_testing=driver.findElement(By.xpath(EDPU.getProperty("farmer_milk_testing_title")));
		 String title=farmer_milk_testing.getText();
		 System.out.println(title);
		 String expected_farmer_Milk_testing_title="Farmer's Milk Testing";
		 if(expected_farmer_Milk_testing_title.equals(title)) {
			 System.out.println("Farmer_milk_testing Title is correct");
		 }
		 else {
			 System.out.println("Farmer_milk testng Title is Incorrect");
		 }
		 
	 }
	 //verify that Farmer Milk Testing title is correctly spelled and alligned 
	 @Test
	 public void verify_that_farmer_milk_testing_title_is_in_bold_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement farmer_milk_testing=driver.findElement(By.xpath(EDPU.getProperty("farmer_milk_testing_size")));
		 Dimension farmer_milk_testing_size=farmer_milk_testing.getSize();
		 int title_size=farmer_milk_testing_size.getWidth();
		 System.out.println(title_size);
		 int expected_weidth=720;
		 if(title_size>=expected_weidth) {
			 System.out.println("Farmer Milk Testing title is in Bold Text");
		 }
		 else {
			 System.out.println("Farmer Milk Testing title is not in Bold Text");
		 }	
	 }
	 //verify that farmerID is available or not 
	 @Test
	 public void Verify_that_farmer_ID_available_or_Not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement farmer_ID_Available=driver.findElement(By.xpath(EDPU.getProperty("farmer_ID")));
		 String farmer_ID=farmer_ID_Available.getText();
		 System.out.println(farmer_ID);
		 String expected_farmer_ID_Text="Farmer Id";
		 if(expected_farmer_ID_Text.equals(farmer_ID)) {
			 System.out.println("Farmer_ID Title is available");
		 }
		 else {
			 System.out.println("Farmer ID Title is Not available");
		 }
	 }
	 //verify that Farmer Name is available or not
	 @Test
	 public void Verify_that_Farmer_Name_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement farmer_name=driver.findElement(By.xpath(EDPU.getProperty("farmer_name")));
		 String farmer=farmer_name.getText();
		 System.out.println(farmer);
		 String expected_farmer_name="Farmer Name";
		 if(expected_farmer_name.equals(farmer)) {
			 System.out.println("Farmer Name is available");
		 }
		 else {
			 System.out.println("Farmer Name is Not Available");
		 }
	 }
	 //verify the Functionality of Result Option 
	 @Test
	 public void Verify_that_result_Option_is_visible_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement result_option=driver.findElement(By.xpath(EDPU.getProperty("Result")));
		 String result_text=result_option.getText();
		 System.out.println(result_text);
		 String Expected_result_text="Result";
		 if(Expected_result_text.equals(result_text)){
			 System.out.println("Result Text is Available and is correct");
		 }
		 else {
			 System.out.println("Result Text is Not Available ");
		 }
	 }
	 //Verify that result input box is available or not
	 @Test
	 public void verify_that_result_input_box_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 boolean result_input_box=driver.findElement(By.xpath(EDPU.getProperty("result_input_box_available"))).isDisplayed();
		 if(result_input_box==true) {
			 System.out.println("Result Input Box is available");
		 }
		 else {
			 System.out.println("Result Input Box is not available");
		 }
	 }
	 //Verify that QTY(L) is available or not
	 @Test
	 public void verify_that_Qty_option_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement Quantity_available=driver.findElement(By.xpath(EDPU.getProperty("Quantity")));
		 String Quantity=Quantity_available.getText();
		 System.out.println(Quantity);
		 String Expected_Quantity_Text="Qty(L)";
		 if(Expected_Quantity_Text.equals(Quantity)) {
			 System.out.println("Quantity is available and is correctly spelled");
		 }
		 else {
			 System.out.println("Quantity Text is not Not Available");
		 }
	 }
	 //verify that Quantity Input Box is Avaialble to not
	 @Test
	 public void Verify_that_Quantity_inputbox_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 boolean Quantity_Input_Box_available=driver.findElement(By.xpath(EDPU.getProperty("Quantity_Input_box"))).isDisplayed();
		 if(Quantity_Input_Box_available==true) {
			 System.out.println("Input Box is aviailable");
		 }
		 else {
			 System.out.println("Input box is Not available");
		 }	 	 
	 }
	//verify that Fat Option is avaialble
	 @Test
	 public void verify_that_fat_option_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement fat_available=driver.findElement(By.xpath(EDPU.getProperty("fat")));
		 String fat=fat_available.getText();
		 System.out.println(fat);
		 String expected_fat_title ="Fat(%)";
		 if(expected_fat_title.equals(fat)) {
			 System.out.println("Fat is available and is correct");
		 }
		 else {
			 System.out.println("Fat is Not available");
		 }	 
	 }
	 //verify that Fat Input Box is available or not 
	 @Test
	 public void verify_that_Fat_Input_Box_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 boolean Fat_input_Box=driver.findElement(By.xpath(EDPU.getProperty("Fat_input_Box"))).isDisplayed();
		 if(Fat_input_Box==true) {
			 System.out.println("Fat Input Box is available");
		 }
		 else {
			 System.out.println("Fat Input Box is not available");
		 }
	 }
	 //verify that SNF is available or Not
	 @Test
	 public void verify_that_SNF_is_available_or_Not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement SNF_available=driver.findElement(By.xpath(EDPU.getProperty("SNF")));
		 String SNF=SNF_available.getText();
		 System.out.println(SNF);
		 String expected_SNF_title="SNF(%)";
		 if(expected_SNF_title.equals(SNF)) {
			 System.out.println("SNF is available and is correct");
		 }
		 else {
			 System.out.println("SNF is not available");
		 } 
	 }
	 //verify that SNF Input Box is available or Not
	 @Test
	 public void verify_that_SNF_Input_Box_is_available_or_Not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 boolean SNF_Input_box=driver.findElement(By.xpath(EDPU.getProperty("SNF_Input_box"))).isDisplayed();
		 if(SNF_Input_box==true) {
			 System.out.println("SNF Input Box is available");
		 }
		 else {
			 System.out.println("SNF Input Box is not Available");
		 }		 
	 }
	 //verify that Unit Price is available or not 
	 @Test
	 public void verify_That_Unit_Price_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement Unit_price_title=driver.findElement(By.xpath(EDPU.getProperty("unit_price")));
		 String Unit_price=Unit_price_title.getText();
		 System.out.println(Unit_price);
		 String expected_Unit_price_title="Unit Price(₹)";
		 if(expected_Unit_price_title.equals(Unit_price)) {
			 System.out.println("Unit Price is available and is correct");
		 }
		 else {
			 System.out.println("Unit Price is not available");
		 }
	 }
	 //verify that Unit Price Input Box i available or not
	 @Test
	 public void verify_that_Unit_Price_Input_Box_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 boolean Unit_price_Input_box=driver.findElement(By.xpath(EDPU.getProperty("Unit_price_input_box"))).isDisplayed();
		 if(Unit_price_Input_box==true) {
			 System.out.println("Unit Price Input Box is available");
		 }
		 else {
			 System.out.println("Unit Price Input Box is not available");
		 }
	 } 
	 //verify that Total Amount is available or Not 
	 @Test
	 public void verify_that_Total_Amount_is_available_or_Not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement Total_Amount_title=driver.findElement(By.xpath(EDPU.getProperty("Total_Amount")));
		 String total_Amount=Total_Amount_title.getText();
		 System.out.println(total_Amount);
		 String Expected_Total_Amount="Tot Amount(₹)";
		 if(Expected_Total_Amount.equals(total_Amount)) {
			 System.out.println("Total Amount is available and is correct");
		 }
		 else{
			 System.out.println("Total Amount is not Available");
		 }
	 } 
	 //Verify that Total Amount Input Box is available or not 
	 @Test
	 public void Verify_that_Total_Amount_Input_Box_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 boolean Total_Amount_available=driver.findElement(By.xpath(EDPU.getProperty("Total_Amount_Input_box"))).isDisplayed();
		 if(Total_Amount_available==true) {
			 System.out.println("Total Amount Input Box is available");
		 }
		 else {
			 System.out.println("Total Amount Input Box is not available");
		 }
	 }
	// Verify that Save button is visible or not
	 @Test
	 public void Verify_that_save_button_is_Displayed_and_is_enabled_or_not() throws Exception {
		 menu();
		 WebElement Save_Button=driver.findElement(By.xpath(EDPU.getProperty("Save_Button")));
		 if(Save_Button.isDisplayed() ){
			 if(!Save_Button.isEnabled()) {
				 System.out.println("Save Button is Available but is not Enabled");
			 }
			 else {
				 System.out.println("Save Button is Available and is Enabled");
			 }
		 }
		 else {
			 System.out.println("Save Button is not available");
		 }
		
	 }
	 //verify that save Button is correctly spelled or not
	 @Test
	 public void verify_that_save_Button_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement Save_Button=driver.findElement(By.xpath(EDPU.getProperty("Save_Button")));
		 String Save=Save_Button.getText();
		 System.out.println(Save);
		 String Expected_Save_button_text="SAVE";
		 if(Expected_Save_button_text.equals(Save)) {
			 System.out.println("Save button is correctly Spelled");
		 }
		 else {
			 System.out.println("Save Button is not correctly spelled");
		 }	 		 
	 }
	 //verify that Print Button is Visible or not
	 @Test
	 public void Print_button_is_Displayed_and_is_enabled_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement Print_Button=driver.findElement(By.xpath(EDPU.getProperty("Print_Button")));
		 if(Print_Button.isDisplayed()) {
			 if(!Print_Button.isEnabled()) {
				 System.out.println("Print Button is Available But is not Enabled");
			 }
			 else {
				 System.out.println("Print Button iS Available and is Enabled");
			 }
		 }
		 else {
			 System.out.println("Print Button is not Available");
		 }
	 }
	 //checking Print button is correctly spelled or not 
	 @Test
	 public void verify_that_print_button_is_correctly_spelled_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement Print_Button=driver.findElement(By.xpath(EDPU.getProperty("Print_Button")));
		 String Print=Print_Button.getText();
		 System.out.println(Print);
		 String Expected_Print_Button="PRINT";
		 if(Expected_Print_Button.equals(Print)) {
			 System.out.println("Print Button is correctly Spelled");
		 }
		 else {
			 System.out.println("Print Button is not correctly spelled");
		 }
	 }
	 //verify that Farmer List is available or not
	 
	 @Test
	 public void verify_that_Farmer_List_is_available_or_not() throws Exception {
		 menu();
		 Thread.sleep(5000);
		 WebElement farmerID=driver.findElement(By.xpath(EDPU.getProperty("farmer_ID")));
		 farmerID.click();
		 Thread.sleep(5000);
		 WebElement farmer_ID_Clear=driver.findElement(By.xpath(EDPU.getProperty("farmer_id_clear")));
		 farmer_ID_Clear.clear();
		 Thread.sleep(5000);
		 List <WebElement>farmerList=driver.findElements(By.xpath(EDPU.getProperty("farmer_lists")));
		 if(farmerList.isEmpty()) {
			 System.out.println("Farmer List is not Available ");
		 }
		 else {
			 System.out.println("Farmer List is Available:");
			 
			 for(int i=0;i<farmerList.size();i++) {
			 System.out.println(farmerList.get(i).getText());
		 }
	  }
   }
   
	 
	 //checking farmer code should be 4 digit
	 @Test
	 public void verify_that_farmer_ID_is_Upto_four_digit() throws Exception{
		 menu();
		 Thread.sleep(5000);
		 WebElement farmer_ID=driver.findElement(By.xpath(EDPU.getProperty("entered_farmer_ID")));
		 String farmerID_text=farmer_ID.getText().trim();
		 System.out.println(farmerID_text);
		 String numericId = farmerID_text.replaceAll("\\D+", "");
		 System.out.println(numericId);
		 if(numericId.matches("\\d{1,4}")) {
			 System.out.println("Farmer ID is Up To 4 Digit and is correct" +numericId);
		 }
		 else {
			 System.out.println("Farmer ID is Incorrect");
		 } 
	 }
	 
	
	 
	 @Test
	    public void Verify_That_User_is_able_to_perform_testings() throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time

	        menu(); // Open the menu

	        WebElement farmerID = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("farmer_ID"))));
	        farmerID.click();

	        WebElement farmer_ID_Clear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("farmer_id_clear"))));
	        farmer_ID_Clear.clear();

	        farmerID.click();

	        try {
	        	//WebElement farmerListContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDPU.getProperty("farmer_Lists_containers"))));
	            List<WebElement> farmerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                    By.xpath(EDPU.getProperty("farmer_available_list"))
	            ));

	            if (farmerList.isEmpty()) {
	                System.out.println("Farmer List is not Available.");
	            } else {
	               // for (int i = 0; i < farmerList.size(); i++) {
	            	int index = 0;
	                while (index < farmerList.size()) {
	                    farmerID.click();
	                    Thread.sleep(3000);

	                    farmerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EDPU.getProperty("farmer_available_list"))));

	                    WebElement farmer = farmerList.get(index);
	                     scrollUntilElementVisibles(farmer);
	                    //scrollUntilElementVisibles(farmerListContainer,farmer);
	                    

	                    //  Scroll to make the farmer element visible
	                    //scrollUntilElementVisible(farmer);
	                    wait.until(ExpectedConditions.elementToBeClickable(farmer)).click();
	                    System.out.println("Selected Farmer: " + farmer.getText());

	                    //  Generate random values
	                    String qty = generateRandomDecimals(6.00, 12.00);
	                    String fat = generateRandomDecimals(6.00, 12.00);
	                    String snf = generateRandomDecimals(9.00, 12.00);

	                    //  Fill Quantity
	                    WebElement QtyInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("Quantity"))));
	                    QtyInput.click();
	                    new Actions(driver).moveToElement(QtyInput).sendKeys(qty).perform();

	                    //  Fill Fat%
	                    WebElement FatInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("Fat"))));
	                    FatInput.click();
	                    new Actions(driver).moveToElement(FatInput).sendKeys(fat).perform();

	                    //  Fill SNF%
	                    WebElement SNFInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("SNF"))));
	                    SNFInput.click();
	                    new Actions(driver).moveToElement(SNFInput).sendKeys(snf).perform();

	                    // Click Save
	                    Thread.sleep(5000);
	                    WebElement Save_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("Save_Button"))));
	                    Save_button.click();

	                    // ✅ Handle confirmation dialog if it appears
	                   // boolean confirmationAppeared = false;
	                    try {
	                        
	                    	if(isAlertDisplayeds(By.xpath(EDPU.getProperty("confirmation")))){
	                    		WebElement Yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("confirm_Yes"))));
	                            Yes.click();
	                            Thread.sleep(5000);
	                            WebElement Save_Again = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("Save_Button"))));
			                    Save_Again.click();
	                    	}
	                    	
	                    } catch (Exception e) {
	                        System.out.println("No confirmation message appeared.");
	                    }
	                    Thread.sleep(7000);

	                    driver.navigate().back();
	                    index++;
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Timeout Exception: Element not found!");
	            Thread.sleep(5000);
	            WebElement back_button=driver.findElement(By.xpath(EDPU.getProperty("farmer_testing_back_button")));
	            back_button.click();
	            WebElement Stop_testing=driver.findElement(By.xpath(EDPU.getProperty("Stop_testing_confirm")));
	            Stop_testing.click();
	            WebElement Home=driver.findElement(By.xpath(EDPU.getProperty("Home_button")));
	            Home.click();	            	
	            }	            
	        }	    
	 // Scroll Until Element is Visible
	    private void scrollUntilElementVisibles(WebElement targetElement) {
	        int maxScrolls = 10; // Avoid infinite loop by limiting scrolls
	        int scrollCount = 0;

	        while (!isElementVisibles(targetElement) && scrollCount < maxScrolls) {
	            // Use JavaScript to scroll the element into view
	        	//Old Code
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);        	 
	            //scrollCount++;
	             scrollCount++;
	            System.out.println("Scrolling until the element is visible.");
	        }
	        
	    }

	    // Check if Element is Visible on Screen
	    private boolean isElementVisibles(WebElement element) {
	        try {
	            return element.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    // Generate random decimal (6.00 - 12.00)
	    public static String generateRandomDecimals(double min, double max) {
	        Random rand = new Random();
	        double randomValue = min + (max - min) * rand.nextDouble();
	        return String.format("%.2f", randomValue);
	         
	    }
	    //confirmation Alert
	    private boolean isAlertDisplayeds(By locator) {
	        try {
	            WebElement element = driver.findElement(locator);
	            return element.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false; // Element not found
	        }
	    }	
	    	     
	  //checking SNF is out of range
	    @Test
	    public void Verify_that_if_Value_of_SNF_is_less_then_Six_and_greater_then_twelve_then_SNF_Out_of_Range_is_shown() throws Exception {
	    try {	
	    	menu();
	    	Actions actions=new Actions(driver);
	    	Thread.sleep(5000);
	    	String Fat=generateRandomDecimals(5.00, 15.00);
	    	WebElement Fat_Input=driver.findElement(By.xpath(EDPU.getProperty("fat")));
	    	Fat_Input.click();
	    	//Actions actions=new Actions(driver);
			 actions.moveToElement(Fat_Input);
			 actions.sendKeys(Fat);
			 actions.build().perform();
			 Thread.sleep(5000);
	    	//String snf = generateRandomDecimal(5.00, 15.00);
	    	WebElement SNF_Input=driver.findElement(By.xpath(EDPU.getProperty("SNF")));
	    	SNF_Input.click();
	    	//Actions actions=new Actions(driver);
			 actions.moveToElement(SNF_Input);
			 actions.sendKeys("15");
			 actions.build().perform();
			 String Qty=generateRandomDecimals(5.00, 15.00);
			 WebElement Qty_Input=driver.findElement(By.xpath(EDPU.getProperty("Quantity")));
			 Qty_Input.click();
			 actions.moveToElement(Qty_Input);
			 actions.sendKeys(Qty);
			 actions.build().perform();
			 Thread.sleep(5000);
			 WebElement Save_Button=driver.findElement(By.xpath(EDPU.getProperty("Save_Button")));
			 Save_Button.click();
			 //double SNF_Value= Double.parseDouble(snf);
			// if(SNF_Value < 6||SNF_Value>12) {
				// System.out.println("Value of SNF is Out or Range");
			 //}
			 //else {
				// System.out.println("Value of SNF is in Correct Range");
			 //}
			 if(isSNF_out_of_range(By.xpath(EDPU.getProperty("SNF_out_of_range")))) {
				 System.out.println("SNF is out of range ");
				 WebElement OK=driver.findElement(By.xpath(EDPU.getProperty("SNF_Out_of_range_OK")));
				 OK.click();
				 }
			 }catch(Exception e){
				 System.out.println("Value of SNF is correct ");
				 }
			 } 	
	   // }
	    private boolean isSNF_out_of_range(By locator) {
	        try {
	            WebElement element = driver.findElement(locator);
	            return element.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false; // Element not found
	        }
	    }
	    
	    //verify that if user enter value of Quantity, Fat, and SNF Zero then Save Print Button should be disable 
	    @Test
	    public void verify_that_if_user_enter_value_of_Quantity_Fat_and_SNF_Zero_then_Save_Print_Button_should_be_disable() throws Exception {
	    	menu();
	    	Actions actions=new Actions(driver);
	    	Thread.sleep(5000);
	    	WebElement Fat_Input=driver.findElement(By.xpath(EDPU.getProperty("fat")));
	    	Fat_Input.click();
	    	actions.moveToElement(Fat_Input);
			actions.sendKeys("00.00");
			actions.build().perform();
			Thread.sleep(5000);
			WebElement SNF_Input=driver.findElement(By.xpath(EDPU.getProperty("SNF")));
	    	SNF_Input.click();
	    	actions.moveToElement(SNF_Input);
			actions.sendKeys("00.00");
			actions.build().perform();
			Thread.sleep(5000);
			 WebElement Qty_Input=driver.findElement(By.xpath(EDPU.getProperty("Quantity")));
			 Qty_Input.click();
			 actions.moveToElement(Qty_Input);
			 actions.sendKeys("00.00");
			 actions.build().perform();
			 Thread.sleep(5000);
			 WebElement Save_button=driver.findElement(By.xpath(EDPU.getProperty("Save_Button")));
			 WebElement Print_button=driver.findElement(By.xpath(EDPU.getProperty("Print_Button")));
			 if(!Save_button.isEnabled()&&!Print_button.isEnabled()) {
				 System.out.println("Save Button and Print Button is Disable because value of Fat,SNF and Quantity is Zero");
			 }
			 else {
				 System.out.println("Save Button and Print Button is Enable");
			 }
	    }
	    //check without entering farmer ID when User fill Fat snf and Qty then Save button should not be enable
	    @Test
	    public void verify_that_without_entering_farmer_ID_when_User_fill_Fat_snf_and_Qty_Save_button_should_not_enable() throws Exception {
	    	menu();
	    	Actions ac=new Actions(driver);
	    	WebElement farmer_ID=driver.findElement(By.xpath(EDPU.getProperty("farmer_ID")));
	    	farmer_ID.click();
	    	WebElement farmer_ID_Clear=driver.findElement(By.xpath(EDPU.getProperty("farmer_id_clear")));
	    	farmer_ID_Clear.clear();
	    	String Fat=generateRandomDecimals(5.00, 15.00);
	    	String SNF=generateRandomDecimals(5.00, 15.00);
	    	String Qty=generateRandomDecimals(5.00, 15.00);
	    	//for Qty
	    	WebElement Qty_Input=driver.findElement(By.xpath(EDPU.getProperty("Quantity")));
	    	Qty_Input.click();
	    	ac.moveToElement(Qty_Input);
	    	ac.sendKeys(Qty);
	    	ac.build().perform();
	    	//for Fat 
	    	WebElement Fat_Input=driver.findElement(By.xpath(EDPU.getProperty("fat")));
	    	Fat_Input.click();
	    	ac.moveToElement(Fat_Input);
	    	ac.sendKeys(Fat);
	    	ac.build().perform();
	    	//for SNF
	    	WebElement SNF_Input=driver.findElement(By.xpath(EDPU.getProperty("SNF")));
	    	SNF_Input.click();
	    	ac.moveToElement(SNF_Input);
	    	ac.sendKeys(SNF);
	    	ac.build().perform();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	WebElement Save_button=driver.findElement(By.xpath(EDPU.getProperty("Save_Button")));
	    	WebElement Print_button=driver.findElement(By.xpath(EDPU.getProperty("Print_Button")));
	    	if(!Save_button.isEnabled()&&!Print_button.isEnabled()) {
	    		System.out.println("Save and Print Button is Disable because Farmer ID id is Null ");
	    	}
	    	else {
	    		System.out.println("Save and Print Button is enable ");
	    	}	    	
	    }
	    
		//verify that if user enter only Fat SNF and Qty field is Blank then Save and Print Button Should be Disable 
	    @Test
	    public void verify_that_if_user_enter_only_Fat_SNF_and_Qty_field_is_Blank_then_Save_and_Print_Button_Should_be_Disable() throws Exception {
	    	Actions ac=new Actions(driver);
	    	menu();
	    	String Fat=generateRandomDecimals(5.00, 15.00);
	    	WebElement Fat_Input=driver.findElement(By.xpath(EDPU.getProperty("fat")));
	    	Fat_Input.click();
	    	ac.moveToElement(Fat_Input);
	    	ac.sendKeys(Fat);
	    	ac.build().perform();
	    	String SNF=generateRandomDecimals(5.00, 15.00);
	    	WebElement SNF_Input=driver.findElement(By.xpath(EDPU.getProperty("SNF")));
	    	SNF_Input.click();
	    	ac.moveToElement(SNF_Input);
	    	ac.sendKeys(SNF);
	    	ac.build().perform();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	WebElement Save_button=driver.findElement(By.xpath(EDPU.getProperty("Save_Button")));
	    	WebElement Print_button=driver.findElement(By.xpath(EDPU.getProperty("Print_Button")));
	    	if(!Save_button.isEnabled()&&!Print_button.isEnabled()) {
	    		System.out.println("Save and Print Button is Disable because Quantity field is Bank");
	    	}
	    	else {
	    		System.out.println("Save and Print Button is Enable ");
	    	}	
	    }
	    @Test
	    public void verify_that_user_is_able_to_perform_testing_with_WebSocket() throws Exception {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time

	        menu(); // Open the menu
	        Thread.sleep(10000);
			// WebSocket Setup
			    final WebSocketClient[] wsClient = new WebSocketClient[1];
			    new Thread(() -> {
			        try {
			            WebSocketClient client = new WebSocketClient(new URI("ws://10.194.185.217:8889")) {
			                @Override
			                public void onOpen(ServerHandshake handshake) {
			                    System.out.println("WebSocket Connected");
			                }
			                @Override
			                public void onMessage(String message) {
			                    System.out.println("Received: " + message);
			                }
			                @Override
			                public void onClose(int code, String reason, boolean remote) {
			                    System.out.println("WebSocket Closed: " + reason);
			                }
			                @Override
			                public void onError(Exception ex) {
			                    System.err.println("WebSocket Error: " + ex.getMessage());
			                }
			            };
			            client.connectBlocking();
			            wsClient[0] = client;
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }).start();

	        WebElement farmerID = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("farmer_ID"))));
	        farmerID.click();

	        WebElement farmer_ID_Clear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("farmer_id_clear"))));
	        farmer_ID_Clear.clear();

	        farmerID.click();
	        try {
	        	//WebElement farmerListContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDPU.getProperty("farmer_Lists_containers"))));
	            List<WebElement> farmerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                    By.xpath(EDPU.getProperty("farmer_available_list"))
	            ));

	            if (farmerList.isEmpty()) {
	                System.out.println("Farmer List is not Available.");
	            } else {
	               // for (int i = 0; i < farmerList.size(); i++) {
	            	int index = 0;
	                while (index < farmerList.size()) {
	                    farmerID.click();
	                    Thread.sleep(3000);

	                    farmerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EDPU.getProperty("farmer_available_list"))));

	                    WebElement farmer = farmerList.get(index);
	                     scrollUntilElementVisibles(farmer);
	                    //scrollUntilElementVisibles(farmerListContainer,farmer);
	                    

	                    //  Scroll to make the farmer element visible
	                    //scrollUntilElementVisible(farmer);
	                    wait.until(ExpectedConditions.elementToBeClickable(farmer)).click();
	                    System.out.println("Selected Farmer: " + farmer.getText());
	                    String Fat=generateRandomDecimals(5.00, 09.00);
	        	    	String SNF=generateRandomDecimals(9.00, 10.00);
	        	    	String Qty=generateRandomDecimals(5.00, 09.00);
	                    //for Date Sending String 
	                    String ip="40:F5:20:28:32:9C";
	                    //String Formate="MilkoReader@10001@Hisar@OR2@"+ip+"@Pure@2@14.44@12.03.21@"+Fat+"@"+SNF+"@00.00@00.00@00.00@00.00@-0.002@99.90@26.54@2@031351@00.00@00.00@Mix Milk@Pure@4.54@1000.00@"+"@00.00"+"@" +Qty +"@"+"@";
	                    String Formate="MilkoReader@10001@Hisar@OR2@"+ip+"@Pure@2@14.44@12.03.21@"+Fat+"@"+SNF+"@00.00@00.00@00.00@00.00@00.002@99.90@26.54@2@031351@00.00@00.00@Mix Milk@Pure@4.54@1000.00@"+Qty+"@@";
	                    if (wsClient[0] != null && wsClient[0].isOpen()) {
	    	 		        wsClient[0].send(Formate);
	    	 		        System.out.println("Sent to WebSocket: " + Formate);
	    	 		    } else {
	    	 		        System.err.println("WebSocket not connected.");
	    	 		    }
	                    Thread.sleep(1000);
	                    WebElement Save_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("Save_Button"))));
	                    Save_button.click();

                         try {
                        	// Explicitly wait for confirmation alert with timeout
                        	    WebElement confirmationPopup = new WebDriverWait(driver, Duration.ofSeconds(5))
                        	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDPU.getProperty("confirmation"))));

                        	    if (confirmationPopup.isDisplayed()) {
                        	        WebElement Yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("confirm_Yes"))));
                        	        Yes.click();
                        	        System.out.println("Clicked on Yes button in confirmation popup");
	                        /*
	                    	if(isAlertDisplayeds(By.xpath(EDPU.getProperty("confirmation")))){
	                    		WebElement Yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("confirm_Yes"))));
	                            Yes.click();
	                            Thread.sleep(1000);
	                            WebElement Save_Again = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDPU.getProperty("Save_Button"))));
			                    Save_Again.click();*/
                        	 
	                    	}
	                    	
	                    } catch (Exception e) {
	                        System.out.println("No confirmation message appeared.");
	                    }
	                    Thread.sleep(1000);

	                    driver.navigate().back();
	                    index++;
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Timeout Exception: Element not found!");
	            Thread.sleep(1000);
	            WebElement back_button=driver.findElement(By.xpath(EDPU.getProperty("farmer_testing_back_button")));
	            back_button.click();
	            WebElement Stop_testing=driver.findElement(By.xpath(EDPU.getProperty("Stop_testing_confirm")));
	            Stop_testing.click();
	            WebElement Home=driver.findElement(By.xpath(EDPU.getProperty("Home_button")));
	            Home.click();	            	
	            }	            
	        }	    
	    
}
	        
	        
	   
	     

	    
		                    





		            
		        
	    


	    	
	    
	    


 
