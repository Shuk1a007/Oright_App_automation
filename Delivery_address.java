package Testcases;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Baseclass;
//
public class Delivery_address extends Baseclass {
	@Test(dataProvider = "testdata1")
    public void login(String user_name, String password, String Customer_Code) throws IOException, InterruptedException {
	// try {
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
            Thread.sleep(5000);
           // WebElement dashboard=driver.findElement(By.xpath(Logins.getProperty("dashboard")));
            //dashboard.click();
            
 }
 
 @DataProvider(name = "testdata1")
    public Object[][] tdata() {
        return new Object[][] {
        	{"jite201547", "jite201547", "or19"},
        };
    }	
     //checking delivery address title is visible or not
     @Test
     public void Verify_that_delivery_address_title_is_visible_or_Not() throws IOException, InterruptedException {
    	 login("jite201547","jite201547","or19");
    	 WebElement delivery_address_title=driver.findElement(By.xpath(Delivery_address.getProperty("Delivery_address_title")));
    	 String actual_delivery_address_title=delivery_address_title.getText();
    	 System.out.println(actual_delivery_address_title);
    	 String expected_Delivery_address_title="Delivery Address";
    	 if(actual_delivery_address_title.equals(expected_Delivery_address_title)) {
    		 System.out.println("Delivery Address Title is visible and is correctly spelled");
    	 }
    	 else {
    		 System.out.println("Delivery Address Title is not visible ");
    	 }
     }
     //verify that Delivery Address is in Bold Text or Not
     @Test
     public void verify_that_Delivery_Address_is_in_Bold_Text_or_Not() throws IOException, InterruptedException {
    	 login("jite201547","jite201547","or19");
    	 WebElement delivery_address_title=driver.findElement(By.xpath(Delivery_address.getProperty("Delivery_address_title")));
    	 Dimension delivery_address_title_dimension=delivery_address_title.getSize();
    	 int title_size=delivery_address_title_dimension.getWidth();
    	 System.out.println(title_size);
    	 int expected_weidth=386;
    	 if(title_size>=expected_weidth) {
    		 System.out.println("Delivery Address Title is in Bold Text ");
    	 }
    	 else {
    		 System.out.println("Delivery Address Title is not in Bold Text ");
    	 }
     } 
     //verify that delivery address title is correctly aligned or not 
     @Test
     public void verify_that_delivery_address_title_is_correctly_aligned_or_not() throws IOException, InterruptedException {
    	 login("jite201547","jite201547","or19");
    	 WebElement delivery_address_title=driver.findElement(By.xpath(Delivery_address.getProperty("Delivery_address_title")));
    	// Get screen size
         int screenWidth = driver.manage().window().getSize().getWidth();
         System.out.println("Screen Weidth="+screenWidth);
      // Get title position & size
         int elementX = delivery_address_title.getLocation().getX();
         System.out.println("Title X Position="+elementX);
         int elementY = delivery_address_title.getLocation().getY();
         System.out.println("Title Y Position="+elementY);
         int elementWidth = delivery_address_title.getSize().getWidth();
         System.out.println("Title Weidth="+elementWidth);
         //calculating center 
         int elementCenter=elementX+(elementWidth/2);
         System.out.println("Title Center="+elementCenter);
         int screenCenter=screenWidth/2;
         System.out.println("Screen Center="+screenCenter);
         
         if(Math.abs(elementCenter-screenCenter)<=10) {
        	 System.out.println("Delivery Address Title is centered Alligned");
         }
         else if(elementX<=10) {
        	 System.out.println("Delivery Address Title is Left Alligend");
         }
         else if((elementX+elementWidth)>=(screenWidth-10)) {
        	 System.out.println("Delivery Address Title is Right Alligend");
         }
         else {
        	 System.out.println("Delivery Addresss title is not correctly alligned");
        	 
         }    	 
     }    
     //checking Search Bar is visible or not 
     @Test
     public void search_Bar() throws IOException, InterruptedException {
    	 login("jite201547","jite201547","or19");
    	 boolean search_bar_available =driver.findElement(By.xpath(Delivery_address.getProperty("Search_bar_available"))).isDisplayed();
    	 if(search_bar_available==true) {
    		 System.out.println("Search Bar is available");
    	 }
    	 else {
    		 System.out.println("Search Bar is Not Available");
    	 }
    	 
     }
     
         
 }
 