package Testcases;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.interactions.Sequence;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Base.Baseclass;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class Collection_center extends Baseclass {

    @Test
    public void login() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        WebElement getStartedButton = driver.findElement(By.xpath(Loc.getProperty("getStarted")));
        getStartedButton.click();
        WebElement emailInput = driver.findElement(By.xpath(Loc.getProperty("Email_id")));
        emailInput.sendKeys("baani201537");
        WebElement nextButton = driver.findElement(By.xpath(Loc.getProperty("Next_button")));
        nextButton.click();
        WebElement passwordInput = driver.findElement(By.xpath(Loc.getProperty("Password_inputbox_placeholder")));
        passwordInput.sendKeys("baani201537");
        WebElement customerCodeInput = driver.findElement(By.xpath(Loc.getProperty("customer_code_input_box")));
        customerCodeInput.sendKeys("baa31");
        WebElement loginButton = driver.findElement(By.xpath(Loc.getProperty("Login")));
        loginButton.click();
        try {
            WebElement successMessage = driver.findElement(By.xpath(Loc.getProperty("Login_successful")));
            if (successMessage.isDisplayed()) {
                System.out.println("Login successful.");
            }
        } catch (Exception e) {
            System.out.println("Login unsuccessful.");
        }
    }
    @Test
    public void VerifyThatMenuButtonVisibilityClickableAndEnabled() throws IOException, InterruptedException {
    	login();
    	Thread.sleep(8000);
    	WebElement menuButton  = driver.findElement(By.xpath(Loc.getProperty("MenuButton")));
    	boolean menuButton1 = menuButton.isDisplayed();
    	if(menuButton.isDisplayed()) {
    		System.out.println("Menu Button is Displayed:" + menuButton1);
    	}else {
    		System.out.println("Menu Button is Not-DIsplayed:" + menuButton1);
    	}
    	menuButton.isEnabled();
    	boolean menuButton2 = menuButton.isEnabled();
    	if(menuButton.isEnabled()) {
    		System.out.println("Menu Button is Enabled:" + menuButton2);
    	}else {
    		System.out.println("Menu Button is Not-Enabled:" + menuButton2);
    	}
    	Thread.sleep(12000);
    	try {  menuButton.click();
    	System.out.println("Menu Button Is Clickable ");
    	
    	} catch (Exception e){
    		System.out.println("Element is not Clickable ");
    	}
    
    }
    @Test
    public void testMenuItemsDisplayed() throws IOException, InterruptedException {
    	VerifyThatMenuButtonVisibilityClickableAndEnabled();
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("dashboardtext"))).isDisplayed(), "Dashboard is not Displayed");
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("edputext"))).isDisplayed(), "e-DPU is not displayed");
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("reporttext"))).isDisplayed(), "Reports is not displayed");
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("languagetext"))).isDisplayed(), "Switch Language is not displayed");
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("contactus"))).isDisplayed(), "Contact Us is not displayed");
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("abouttext"))).isDisplayed(), "About Us is not displayed");
        Assert.assertTrue(driver.findElement(By.xpath(Loc.getProperty("logouttext"))).isDisplayed(), "Logout is not displayed");
    }
    @Test
    public void testDashboardNavigationToCCDashboard() throws IOException, InterruptedException {
     	VerifyThatMenuButtonVisibilityClickableAndEnabled();
WebElement dashboardButton = driver.findElement(By.xpath(Loc.getProperty("dashboardtext")));
        dashboardButton.click();

      
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      
  WebElement ccDashboardTitle = driver.findElement(By.xpath(Loc.getProperty("ccdashboardheader")));
        Assert.assertTrue(ccDashboardTitle.isDisplayed(), "Navigation to CC Dashboard failed");
    }
    @Test
    public void testEDPUIsClickable() throws IOException, InterruptedException {
    	VerifyThatMenuButtonVisibilityClickableAndEnabled();
        try {
         WebElement eDPU = driver.findElement(By.xpath(Loc.getProperty("edputext")));

            if (eDPU.isDisplayed() && eDPU.isEnabled()) {
                System.out.println("'e-DPU' is clickable.");
            } else {
                Assert.fail("'e-DPU' is not clickable.");
            }
            eDPU.click();
        } catch (NoSuchElementException e) {
            Assert.fail("'e-DPU' element not found.");
           
        }
       
    }
    
    @Test
    public void testEDPUOptionsDisplayedAfterClick() throws IOException, InterruptedException {
    	 testEDPUIsClickable();
        WebElement edpuTesting = driver.findElement(By.xpath(Loc.getProperty("e-dputesting")));
        Assert.assertTrue(edpuTesting.isDisplayed(), "'e-DPU Testing' option is not visible.");
        WebElement dispatch = driver.findElement(By.xpath(Loc.getProperty("dispatch")));
        Assert.assertTrue(dispatch.isDisplayed(), "'Dispatch' option is not visible.");
    }
    @Test
    public void testEDPUTestingIsClickable() throws IOException, InterruptedException {
    	testEDPUIsClickable();	
        try {
         WebElement eDPUTesting= driver.findElement(By.xpath(Loc.getProperty("e-dputesting")));

            if (eDPUTesting.isDisplayed() && eDPUTesting.isEnabled()) {
                System.out.println("'e-DPU Testing' is clickablle.");
            } else {
                Assert.fail("'e-DPU Testing' is not clickable.");
            }
            eDPUTesting.click();
        } catch (NoSuchElementException e) {
            Assert.fail("'e-DPU Testing' is not found.");
           
        }
       
    }
    @Test
    public void testDispatchIsClickable() throws IOException, InterruptedException {
        testEDPUIsClickable();	
        try {
            WebElement dispatch = driver.findElement(By.xpath(Loc.getProperty("dispatch")));

            if (dispatch.isDisplayed() && dispatch.isEnabled()) {
                System.out.println("'Dispatch' is clickable.");
            } else {
                Assert.fail("'Dispatch' is not clickable.");
            }
            dispatch.click();
        } catch (NoSuchElementException e) {
            Assert.fail("'Dispatch' is not found.");
        }
    }
    @Test
    public void testSwitchLanguageIsClickable() throws IOException, InterruptedException {
        VerifyThatMenuButtonVisibilityClickableAndEnabled();
        try {
            WebElement switchLang = driver.findElement(By.xpath(Loc.getProperty("languagetext")));

            if (switchLang.isDisplayed() && switchLang.isEnabled()) {
                System.out.println("'Switch Language' is clickable.");
            } else {
                Assert.fail("'Switch Language' is not clickable.");
            }
            switchLang.click();
        } catch (NoSuchElementException e) {
            Assert.fail("'Switch Language' element not found.");
        }
    }
    @Test
    public void testLogoutFunctionality() throws IOException, InterruptedException {
        VerifyThatMenuButtonVisibilityClickableAndEnabled();
        Thread.sleep(2000); 
        try {
            WebElement logoutButton = driver.findElement(By.xpath(Loc.getProperty("logouttext")));
            logoutButton.click();
            Thread.sleep(3000); 
            WebElement loginScreenElement = driver.findElement(By.xpath(Loc.getProperty("getStarted")));
            if (loginScreenElement.isDisplayed()) {
                System.out.println("Logout successful. User redirected to login screen.");
            } else {
                Assert.fail("Logout failed. Login screen not displayed.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Logout button or login screen element not found.");
        }
    }



	@Test
    public void VerifyThatTheCollectionCenterDashboardIsDisplayed() throws IOException {
    			login();
		 WebElement ccdashboard = driver.findElement(By.xpath(Loc.getProperty("ccdashboardheader")));
		String dashboard = ccdashboard.getText();
		if (ccdashboard.isDisplayed()) {
			System.out.println("Yes " + dashboard + " is Displayed");
		}else
		{
			System.out.println("No " +dashboard + " is Not-Displayed");
		}
}
    @Test
    public void VerifyThatTheBelowTheCollectionCenterDashboardNameOfTheCollectionCenterWithCodeIsDisplayed() throws IOException {
    	  login();
		 WebElement ccnameandcode = driver.findElement(By.xpath(Loc.getProperty("ccname")));
		String ccnametext = ccnameandcode.getText();
		if (ccnameandcode.isDisplayed()) {
			System.out.println("Yes CollectionCeneter Name" + ccnametext + " is Displayed");
		}else
		{
			System.out.println("No  CollectionCetner Name" +ccnametext + " is Not-Displayed");
		}
    	
    }
    @Test
    public void VerifyThatTheNotificationBellIconIsDisplayed() throws IOException {
  	  login();
		 WebElement notification = driver.findElement(By.xpath(Loc.getProperty("notification")));
		if (notification.isDisplayed()) {
			System.out.println("Yes Notification Icon is Displayed");
		}else
		{
			System.out.println("No Notification Icon is Not-Displayed");
		}
}
    @Test
    public void VerifyThatTheNotificationBellIconIsClickable() throws IOException {
    	VerifyThatTheNotificationBellIconIsDisplayed();
  		 WebElement notification = driver.findElement(By.xpath(Loc.getProperty("notification")));
  		notification.click();
  		 WebElement notificationclick = driver.findElement(By.xpath(Loc.getProperty("notificationclick")));
  		 String gettext = notificationclick.getText();
  		 String expected = "Notification";
  		if (gettext.equals(expected)) {
  			System.out.println("Notification Bell icon is Clickable & after click on that navigated to " + gettext + " page ");
  		}else
  		{
  			System.out.println("Notification bell icon is not clickable");
  		}   
}
    @Test
    public void VerifyThatIfNotificationIsAvailableThenDisplayedOtherwiseNoDataFoundMessageDisplayed() throws IOException {
    	VerifyThatTheNotificationBellIconIsClickable();
  		 WebElement notification = driver.findElement(By.xpath(Loc.getProperty("notification")));
  		notification.click();
  		 WebElement notification1 = driver.findElement(By.xpath(Loc.getProperty("notifictionnodatafound")));
  		 String gettext = notification1.getText();
  		 String expected = "No data found";
  		 if (gettext.equals(expected)) {
  			  System.out.println("No data found (No notifications).");
         } else {
           
             System.out.println("Notification is available.");
         }     
}
    @Test
    public void VerifyThatTheBackButtonIsDisplayedOnNotificationPage() throws IOException {
    	VerifyThatTheNotificationBellIconIsClickable();
  		 WebElement notification = driver.findElement(By.xpath(Loc.getProperty("notificationbackbutton")));
  		if (notification.isDisplayed() && notification.isEnabled()){
  			System.out.println("Yes Back Button is Displayed and Enabled");
  		}else
  		{
  			System.out.println("No Back Button is Not-Displayed ");
  		}
}
    @Test
    public void VerifyThatAfterClickOnBackButtonItsNavigatedToBackPage() throws IOException {
    	VerifyThatTheBackButtonIsDisplayedOnNotificationPage();
  		 WebElement notification = driver.findElement(By.xpath(Loc.getProperty("notificationbackbutton")));
  		notification.click();
  		 WebElement ccdashboard = driver.findElement(By.xpath(Loc.getProperty("ccdashboardheader")));
 		String dashboard = ccdashboard.getText();
  		if (dashboard.equals("Collection Center Dashboard")) {
  			System.out.println("Yes Back Button is Clickable");
  		}else
  		{
  			System.out.println("No Back Button is Not-Clickable");
  		}
}
    @Test
    public void VerifyThatDateIsDisplayedOnDashboard() throws IOException {
    	login();
  		 WebElement date = driver.findElement(By.xpath(Loc.getProperty("date")));
  	   if(date.isDisplayed()) {
  		   System.out.println("Yes Date is Displayed");
  	   }else {
  		 System.out.println("No Date is Displayed");
  	   }
  		
}
    @Test
    public void VerifyThatTheDateIsMatchedWithSystemDateOnDashboard() throws IOException {
    	login();
    	 WebElement date1 = driver.findElement(By.xpath(Loc.getProperty("date")));
    	 LocalDate currentDate = LocalDate.now();  // Gets current date
         String systemDate = currentDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    	 String date = date1.getText();
    	 if(date.equals(systemDate)) {
    		 System.out.println("Yes bydefault Displayed Date is Current Date " + date);
    	 } else {
    		 System.out.println("No bydefault Displayed Date is Not-Current Date");
    	 }
}
    @Test
    public void VerifyThatCalenderIconDisplayedOnDashboard() throws IOException {
    	login();
  		 WebElement calendericon = driver.findElement(By.xpath(Loc.getProperty("calendericon")));
  	   if(calendericon.isDisplayed()) {
  		   System.out.println("Yes Calender Icon is Displayed");
  	   }else {
  		 System.out.println("No Calender Icon is Not-Displayed");
  	   }
    }
    @Test
  	 public void VerifyThatCalenderIconIsClickable() throws IOException {
    	VerifyThatCalenderIconDisplayedOnDashboard();
   		 WebElement calendericon = driver.findElement(By.xpath(Loc.getProperty("calendericon")));
   		calendericon.click();
   	 WebElement calenderdate = driver.findElement(By.xpath(Loc.getProperty("calenderdate")));
   	 if(calenderdate.isDisplayed()) {
   		 System.out.println("Calendar opened successfully");
	 } else {
		 System.out.println("Calendar did not open");
	 
   	 }
   	 }
    @Test
    public void verifyThatCurrentDateDisplayedInCalendarAndSameDateDisplayedOnDashboard() throws IOException, InterruptedException {
        VerifyThatCalenderIconDisplayedOnDashboard();
        Thread.sleep(4000);
        WebElement dashboardDateElement = driver.findElement(By.xpath(Loc.getProperty("dashboarddate")));
        String dashboardDate = dashboardDateElement.getText();
        System.out.println("Dashboard Date: " + dashboardDate);
        Thread.sleep(4000);
        WebElement calendarIcon = driver.findElement(By.xpath(Loc.getProperty("calendericon")));
        calendarIcon.click();
        System.out.println("Click Performed On Calendar");
        Thread.sleep(4000);
        String systemDay = new SimpleDateFormat("d").format(new Date());
        System.out.println("System Date: " + systemDay);
        Thread.sleep(4000);
        List<WebElement> calendarDates = driver.findElements(By.xpath(Loc.getProperty("datelist")));
        Thread.sleep(4000);
        boolean isDateFound = false;
        for (WebElement dateElement : calendarDates) {
            if (dateElement.getText().trim().equals(systemDay)) {
                isDateFound = true;
                break;
            }
        }
        if (isDateFound) {
            System.out.println(" The current date " + systemDay + " is correctly displayed in the calendar.");
        } else {
            System.out.println("The current date is NOT found in the calendar.");
        }
        if (dashboardDate.contains(systemDay)) {
            System.out.println("Dashboard date contains the system day.");
        } else {
            System.out.println(" Dashboard date does NOT contain the system day.");
        }
    }
/*
 // this is correct code 
    @Test
    public void verifySelectedDateDataIfDataAailableThenDisplayedOtherwiseNoDataFoundMessageDisplayed() throws IOException, InterruptedException {
        login();

        // ✅ Click Dashboard and Calendar
        driver.findElement(By.xpath(Loc.getProperty("DashboardButton"))).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath(Loc.getProperty("calendericon"))).click();
        System.out.println("Calendar Icon Clicked");
        Thread.sleep(2000);

        // ✅ Select Date
        String selectedDate = "19";
        for (WebElement date : driver.findElements(By.xpath(Loc.getProperty("datelist")))) {
            if (date.getText().trim().equals(selectedDate)) {
                date.click();
                System.out.println("Selected Date: " + selectedDate);
                break;
            }
        }
        Thread.sleep(3000);

        // ✅ Verify Dashboard Date
        WebElement dashboardDateElement = driver.findElement(By.xpath(Loc.getProperty("dashboarddate")));
        if (dashboardDateElement.getText().trim().contains(selectedDate)) {
            System.out.println("Selected date is displayed on the dashboard.");
        } else {
            System.out.println("Selected date is NOT displayed on the dashboard.");
        }

        Set<String> processedData = new HashSet<>();
        boolean hasMoreData = true;
        boolean firstScrollDone = false; // ✅ Ensures we scroll at least once

        while (hasMoreData) {
            // ✅ Scroll first before checking for "No Data Found"
            if (!firstScrollDone) {
                System.out.println("Performing initial scroll...");
                scrollDown1();
               // Thread.sleep(4000);
                firstScrollDone = true;
            }

            // ✅ Check if "No Data Found" message appears AFTER scrolling
            List<WebElement> noDataElements = driver.findElements(By.xpath(Loc.getProperty("noDataFound")));
            if (!noDataElements.isEmpty()) {
                System.out.println(" No data found on selected data : " + noDataElements.get(0).getText());
                break; // Stop scrolling since no data is available
            }

            List<WebElement> beforeScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));
            
            // ✅ If no data elements found even after scrolling, print message and stop
            if (beforeScroll.isEmpty()) {
                System.out.println("No data elements found on the screen.");
                break;
            }

            scrollDown1();
          //  Thread.sleep(4000);
            List<WebElement> afterScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));

            // ✅ After scrolling, check again if "No Data Found" appears
            noDataElements = driver.findElements(By.xpath(Loc.getProperty("noDataFound")));
            if (!noDataElements.isEmpty()) {
                System.out.println("No data found after scrolling: " + noDataElements.get(0).getText());
                break;
            }

            // ✅ Stop scrolling if no new elements are found
            if (beforeScroll.size() == afterScroll.size() && getLastElementText1(beforeScroll).equals(getLastElementText1(afterScroll))) {
                hasMoreData = false;
            }

            // ✅ Fetch and Print Data Only If Available
            String[] xpaths = {
            		 "//android.widget.TextView[matches(@text, '\\d{4} : .*')]",
                     "//android.widget.TextView[contains(@text, 'Unit Price(₹) :')]",
                     "//android.widget.TextView[contains(@text, 'Quantity(L) :')]",
                     "//android.widget.TextView[contains(@text, 'Fat(%) :')]",
                     "//android.widget.TextView[contains(@text, 'SNF(%) :')]",
                     "//android.view.View[@resource-id='content']//android.widget.TextView[contains(@text, '₹') and not(contains(@text, 'Unit Price'))]",
                     "//android.widget.Image[matches(@text, '^(cow|Buff|Mix)$')]"
        };

            List<List<WebElement>> allElements = new ArrayList<>();
            for (String xpath : xpaths) {
                allElements.add(driver.findElements(By.xpath(xpath)));
            }

            for (int i = 0; i < allElements.get(0).size(); i++) {
                String dataIdentifier = getElementText1(allElements.get(0), i) + getElementText1(allElements.get(6), i);
                if (!processedData.contains(dataIdentifier)) {
					
//					 System.out.println("------------------------------------------------");
//					 System.out.println(getElementText1(allElements.get(0), i));
//					 System.out.println(getElementText1(allElements.get(1), i));
//					 System.out.println(getElementText1(allElements.get(2), i));
//					 System.out.println(getElementText1(allElements.get(3), i));
//					 System.out.println(getElementText1(allElements.get(4), i));
//					 System.out.println("Amount: " + getElementText1(allElements.get(5), i));
//					 System.out.println("MilkType: " + getElementText1(allElements.get(6), i));
//					 System.out.println("------------------------------------------------");
//					 
                    processedData.add(dataIdentifier);


                }
            }
        }

        System.out.println("Scrolled until the last element.");
        Thread.sleep(9000);
    }
*/
/*
    @Test    
    public void verifySelectedDateData1() throws IOException, InterruptedException {
        login();
Thread.sleep(9000);
        // Click Dashboard and Calendar
   //     driver.findElement(By.xpath(Loc.getProperty("DashboardButton"))).click();
     //   Thread.sleep(6000);
driver.findElement(By.xpath(Loc.getProperty("calendericon"))).click();
System.out.println("✅ Calendar Icon Clicked");
Thread.sleep(5000);

// ✅ Select Date
String selectedDate = "4";
boolean dateSelected = false;

for (WebElement date : driver.findElements(By.xpath(Loc.getProperty("datelist")))) {
    if (date.getText().trim().equals(selectedDate)) {
        date.click();
        System.out.println("✅ Selected Date: " + selectedDate);
        dateSelected = true;
        break;
    }
}

if (!dateSelected) {
    System.out.println("❌ ERROR: Date " + selectedDate + " not found in the calendar.");
    return;
}

        // Verify Dashboard Date
        WebElement dashboardDateElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("dashboarddate"))));
        if (dashboardDateElement.getText().trim().contains(selectedDate)) {
            System.out.println("Selected date is displayed on the dashboard.");
        } else {
            System.out.println("Selected date is NOT displayed on the dashboard.");
        }

        // Define XPaths for data elements
        String[] xpaths = {
            "//android.widget.TextView[matches(@text, '\\d{4} : .*')]",
            "//android.widget.TextView[contains(@text, 'Unit Price(₹) :')]",
            "//android.widget.TextView[contains(@text, 'Quantity(L) :')]",
            "//android.widget.TextView[contains(@text, 'Fat(%) :')]",
            "//android.widget.TextView[contains(@text, 'SNF(%) :')]",
            "//android.view.View[@resource-id='content']//android.widget.TextView[contains(@text, '₹') and not(contains(@text, 'Unit Price'))]"
        };

        // Keep track of processed elements to avoid duplicates
        Set<String> processedData = new HashSet<>();
        boolean hasMoreData = true;

        while (hasMoreData) {
            // Get current visible elements
            List<List<WebElement>> currentElements = new ArrayList<>();
            for (String xpath : xpaths) {
                currentElements.add(driver.findElements(By.xpath(xpath)));
            }

            // Process visible elements
            int maxElements = currentElements.get(0).size();
            for (int i = 0; i < maxElements; i++) {
                // Create a unique identifier for this data set
                String dataIdentifier = getElementText1(currentElements.get(0), i) + getElementText1(currentElements.get(5), i); // Using time and amount as unique identifier

                // Only process if we haven't seen this data before
                if (!processedData.contains(dataIdentifier)) {
                    System.out.println("------------------------------------------------");
                    System.out.println(getElementText1(currentElements.get(0), i));
                    System.out.println(getElementText1(currentElements.get(1), i));
                    System.out.println(getElementText1(currentElements.get(2), i));
                    System.out.println(getElementText1(currentElements.get(3), i));
                    System.out.println(getElementText1(currentElements.get(4), i));
                    System.out.println("Amount: " + getElementText1(currentElements.get(5), i));
                    System.out.println("------------------------------------------------");

                    // Find milk type for current element
                    List<WebElement> imageElements = driver.findElements(By.xpath("//android.widget.Image"));
                    Pattern pattern = Pattern.compile("^(cow|buff|mix)$"); // Exact match pattern

                    for (WebElement img : imageElements) {
                        String text = img.getAttribute("text");  // Get the text attribute
                        if (text != null && pattern.matcher(text).matches()) {
                            System.out.println("Matched Image Text: " + text);
                        }
                    }

                    processedData.add(dataIdentifier);
                }
            }

            // Store elements before scroll
            List<WebElement> beforeScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));

            // Scroll
            scrollDown1();
            new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.stalenessOf(beforeScroll.get(beforeScroll.size() - 1)));

            // Check if we've reached the end
            List<WebElement> afterScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));
            if (beforeScroll.size() == afterScroll.size() && getLastElementText1(beforeScroll).equals(getLastElementText1(afterScroll))) {
                hasMoreData = false;
                System.out.println("✅ Reached the end of the list.");
            }
        }

        // Check for No Data Found Message
        try {
            System.out.println("❌ No data found: " + driver.findElement(By.xpath(Loc.getProperty("noDataFound"))).getText());
        } catch (NoSuchElementException e) {
            System.out.println("✅ Data is available for the selected date.");
        }
    }

    // Helper function to get last element's text
    private String getLastElementText2(List<WebElement> elements) {
        return elements.isEmpty() ? "" : elements.get(elements.size() - 1).getText();
    }

    // Helper Function to Get Element Text
    private String getElementText2(List<WebElement> elements, int index) {
        return (index < elements.size()) ? elements.get(index).getText() : "N/A";
    }

    // Function for Scrolling
    private void scrollDown2() {
        int screenHeight = driver.manage().window().getSize().height;
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

  */ 
    @Test    // correct code this is here no issues to run
    public void verifySelectedDateDataIfDataAvailableThenDisplayedOtherwiseNoDataFoundMessageDisplayed() throws IOException, InterruptedException {
        login();

        // ✅ Click Dashboard and Calendar
       // driver.findElement(By.xpath(Loc.getProperty("DashboardButton"))).click();
       Thread.sleep(9000);  // Reduced wait time

        driver.findElement(By.xpath(Loc.getProperty("calendericon"))).click();
        System.out.println("✅ Calendar Icon Clicked");
        Thread.sleep(5000);

        // ✅ Select Date
        String selectedDate = "4";
        boolean dateSelected = false;

        for (WebElement date : driver.findElements(By.xpath(Loc.getProperty("datelist")))) {
            if (date.getText().trim().equals(selectedDate)) {
                date.click();
                System.out.println("✅ Selected Date: " + selectedDate);
                dateSelected = true;
                break;
            }
        }

        if (!dateSelected) {
            System.out.println("❌ ERROR: Date " + selectedDate + " not found in the calendar.");
            return;
        }

        // ✅ Verify Dashboard Date
        WebElement dashboardDateElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("dashboarddate"))));

        if (dashboardDateElement.getText().trim().contains(selectedDate)) {
            System.out.println("Selected date is correctly displayed on the dashboard.");
        } else {
            System.out.println("ERROR: Selected date is NOT displayed on the dashboard.");
            return;
        }

        Set<String> processedData = new HashSet<>();
        boolean hasMoreData = true;
        boolean firstScrollDone = false;

        while (hasMoreData) {
            
            if (!firstScrollDone) {
                System.out.println("Performing initial scroll...");
                scrollDown1();
                Thread.sleep(2000);
                firstScrollDone = true;
            }
            List<WebElement> noDataElements = driver.findElements(By.xpath(Loc.getProperty("noDataFound")));
            if (!noDataElements.isEmpty() && noDataElements.get(0).isDisplayed()) {
                System.out.println("No data found on selected date: " + noDataElements.get(0).getText());
                return; 
            }
            List<WebElement> beforeScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));
            System.out.println("Found " + beforeScroll.size() + " data elements before scrolling.");
            if (beforeScroll.isEmpty()) {
                System.out.println("No data elements found on the screen.");
                return;
            }

            scrollDown1();
            Thread.sleep(2000);

            List<WebElement> afterScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));
        
            noDataElements = driver.findElements(By.xpath(Loc.getProperty("noDataFound")));
            if (!noDataElements.isEmpty() && noDataElements.get(0).isDisplayed()) {
                System.out.println("No data found after scrolling: " + noDataElements.get(0).getText());
                return;
            }

            if (beforeScroll.size() == afterScroll.size() && getLastElementText1(beforeScroll).equals(getLastElementText1(afterScroll))) {
                hasMoreData = false;
            }

            // ✅ Fetch and Print Data Only If Available
            String[] xpaths = {
                "//android.widget.TextView[matches(@text, '\\d{4} : .*')]",
                "//android.widget.TextView[contains(@text, 'Unit Price(₹) :')]",
                "//android.widget.TextView[contains(@text, 'Quantity(L) :')]",
                "//android.widget.TextView[contains(@text, 'Fat(%) :')]",
                "//android.widget.TextView[contains(@text, 'SNF(%) :')]",
                "//android.view.View[@resource-id='content']//android.widget.TextView[contains(@text, '₹') and not(contains(@text, 'Unit Price'))]",
                "//android.widget.Image[matches(@text, '^(cow|Buff|Mix)$')]"
            };

            List<List<WebElement>> allElements = new ArrayList<>();
            for (String xpath : xpaths) {
                allElements.add(driver.findElements(By.xpath(xpath)));
            }
            Thread.sleep(5000);
            for (int i = 0; i < allElements.get(0).size(); i++) {
                String dataIdentifier = getElementText1(allElements.get(0), i) + getElementText1(allElements.get(6), i);
                if (!processedData.contains(dataIdentifier)) {
                    System.out.println("✅ Data Entry " + (i + 1) + ":");
                    System.out.println("   📌 " + getElementText1(allElements.get(0), i));
                    System.out.println("   💰 " + getElementText1(allElements.get(1), i));
                    System.out.println("   📦 " + getElementText1(allElements.get(2), i));
                    System.out.println("   🥛 Fat%: " + getElementText1(allElements.get(3), i));
                    System.out.println("   🥛 SNF%: " + getElementText1(allElements.get(4), i));
                    System.out.println("   💵 Amount: " + getElementText1(allElements.get(5), i));
                    System.out.println("   🐄 Milk Type: " + getElementText1(allElements.get(6), i));
                    System.out.println("------------------------------------------------");

                    processedData.add(dataIdentifier);
                }
            }
        }

        System.out.println("✅ Successfully scrolled until the last element.");
        Thread.sleep(5000);
    }

    // ✅ Helper Methods

    private String getLastElementText1(List<WebElement> elements) {
        return elements.isEmpty() ? "" : elements.get(elements.size() - 1).getText();
    }

    private String getElementText1(List<WebElement> elements, int index) {
        return (index < elements.size()) ? elements.get(index).getText() : "N/A";
    }

    private void scrollDown1() {
        int screenHeight = driver.manage().window().getSize().height;
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    // check data duplicacy on dashboard
@Test
    public void verifyDataDuplicacyOnDashboard() throws IOException, InterruptedException {
        login();
        Thread.sleep(9000);

        Map<String, Integer> dataCountMap = new HashMap<>();
        boolean hasMoreData = true;
        boolean firstScrollDone = false;

        while (hasMoreData) {
            if (!firstScrollDone) {
                System.out.println("🔄 Performing initial scroll...");
                scrll();
                Thread.sleep(2000);
                firstScrollDone = true;
            }

            List<WebElement> noDataElements = driver.findElements(By.xpath(Loc.getProperty("noDataFound")));
            if (!noDataElements.isEmpty() && noDataElements.get(0).isDisplayed()) {
                System.out.println("⚠️ No data found on the dashboard.");
                return;
            }

            List<WebElement> beforeScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));
            if (beforeScroll.isEmpty()) {
                System.out.println("⚠️ No data elements found on the screen.");
                return;
            }

            scrll();
            Thread.sleep(2000);

            List<WebElement> afterScroll = driver.findElements(By.xpath(Loc.getProperty("dataelement")));

            String[] xpaths = {
                    "//android.widget.TextView[matches(@text, '\\d{4} : .*')]",
                    "//android.widget.TextView[contains(@text, 'Unit Price(₹) :')]",
                    "//android.widget.TextView[contains(@text, 'Quantity(L) :')]",
                    "//android.widget.TextView[contains(@text, 'Fat(%) :')]",
                    "//android.widget.TextView[contains(@text, 'SNF(%) :')]",
                    "//android.view.View[@resource-id='content']//android.widget.TextView[contains(@text, '₹') and not(contains(@text, 'Unit Price'))]",
                    "//android.widget.Image[matches(@text, '^(cow|Buff|Mix)$')]"
            };

            List<List<WebElement>> allElements = new ArrayList<>();
            for (String xpath : xpaths) {
                allElements.add(driver.findElements(By.xpath(xpath)));
            }

            Thread.sleep(5000);

            for (int i = 0; i < allElements.get(0).size(); i++) {
                String dataIdentifier = getElementText1(allElements.get(0), i) + getElementText1(allElements.get(6), i);
                dataCountMap.put(dataIdentifier, dataCountMap.getOrDefault(dataIdentifier, 0) + 1);
            }

            if (beforeScroll.size() == afterScroll.size() &&
                    getLastElementText1(beforeScroll).equals(getLastElementText1(afterScroll))) {
                hasMoreData = false;
            }
        }

        System.out.println("✅ Duplicated Data Entries:");
        for (Map.Entry<String, Integer> entry : dataCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("   🔁 " + entry.getKey() + " (Count: " + entry.getValue() + ")");
            }
        }

        Thread.sleep(5000);
    }

//check that if cow milk type selected then only cow milk type data dispayed with lable 
@Test
public void verifyCowMilkTypeDataDisplayed() throws IOException, InterruptedException {
    login();
    Thread.sleep(9000); 
    driver.findElement(By.xpath(Loc.getProperty("AllMilktypeClick"))).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(Loc.getProperty("Cow"))).click();
    Thread.sleep(1000); 
    driver.findElement(By.xpath(Loc.getProperty("MilkTypeOk"))).click();
    System.out.println("Cow filter applied");
    Set<String> milkTypes = new HashSet<>();
    boolean cowFound = false;

    for (int i = 0; i < 7; i++) {
        if (!driver.findElements(By.xpath(Loc.getProperty("noDataFound"))).isEmpty()) {
            System.out.println("No data found for Cow milk type after scrolling");
            return;
        }

        List<WebElement> elements = driver.findElements(By.xpath(Loc.getProperty("CowMilkTypeLable")));
        for (WebElement e : elements) {
            String text = e.getText().trim().toLowerCase();
            if (text.equals("cow")) {
                milkTypes.add(text);
                cowFound = true;
            }
        }

        if (cowFound) {
            break; 
        }

        scrll();
    }
    if (milkTypes.isEmpty()) {
        System.out.println("No milk type labels found!");
    } else if (milkTypes.stream().allMatch(t -> t.equals("cow"))) {
        System.out.println("All entries match selected type: cow");
    } else {
        System.out.println("Mismatched milk types: " + milkTypes);
    }
}

@Test
public void verifyBuffMilkTypeDataDisplayed() throws IOException, InterruptedException { 
    login();
    Thread.sleep(9000);    
    driver.findElement(By.xpath(Loc.getProperty("bydefaultMilktype"))).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(Loc.getProperty("Buff"))).click(); 
    Thread.sleep(1000);
    driver.findElement(By.xpath(Loc.getProperty("MilkTypeOk"))).click();
    System.out.println("Buff filter applied"); 
    Thread.sleep(2000); 
    Set<String> milkTypes = new HashSet<>();
    boolean BuffFound = false;

    for (int i = 0; i < 7; i++) {
        if (!driver.findElements(By.xpath(Loc.getProperty("noDataFound"))).isEmpty()) {
            System.out.println("No data found for Buff milk type after scrolling");
            return;
        }

        List<WebElement> elements = driver.findElements(By.xpath(Loc.getProperty("BuffMilkTypeLable")));
        for (WebElement e : elements) {
            String text = e.getText().trim().toLowerCase();
            if (text.equals("Buff")) {
                milkTypes.add(text);
                BuffFound = true;
            }
        }

        if (BuffFound) {
            break; 
        }

        scrll(); 
    }
    if (milkTypes.isEmpty()) {
        System.out.println("No milk type labels found!");
    } else if (milkTypes.stream().allMatch(t -> t.equals("Buff"))) {
        System.out.println("All entries match selected type:Buff");
    } else {
        System.out.println("Mismatched milk types: " + milkTypes);
    }

}
@Test
public void verifyMixMilkTypeDataDisplayed() throws IOException, InterruptedException { 
    login();
    Thread.sleep(9000); 
    driver.findElement(By.xpath(Loc.getProperty("bydefaultMilktype"))).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(Loc.getProperty("Mix"))).click(); 
    Thread.sleep(1000);
    driver.findElement(By.xpath(Loc.getProperty("MilkTypeOk"))).click();
    System.out.println("Mix filter applied"); 
    Thread.sleep(2000); 
    Set<String> milkTypes = new HashSet<>();
    boolean MixFound = false;

    for (int i = 0; i < 7; i++) {
        if (!driver.findElements(By.xpath(Loc.getProperty("noDataFound"))).isEmpty()) {
            System.out.println("No data found for Mix milk type after scrolling");
            return;
        }

        List<WebElement> elements = driver.findElements(By.xpath(Loc.getProperty("MixMilkTypeLable")));
        for (WebElement e : elements) {
            String text = e.getText().trim().toLowerCase();
            if (text.equals("MIX")) {
                milkTypes.add(text);
                MixFound = true;
            }
        }

        if (MixFound) {
            break; 
        }

        scrll();
    }
    if (milkTypes.isEmpty()) {
        System.out.println("No milk type labels found!");
    } else if (milkTypes.stream().allMatch(t -> t.equals("MIX"))) {
        System.out.println("All entries match selected type:MIX");
    } else {
        System.out.println("Mismatched milk types: " + milkTypes);
    }
}


    @Test  // Check the total calculation of quantity on the dashboard for current date shift 
    public void VerifyThatTheTotalCalculationOfQuantityIsCorrectOnDashboardForCurrentDateShitAndAllMilkType() throws IOException, InterruptedException {
        login();  
        Thread.sleep(9000); 
        
        WebElement displayedTotal = driver.findElement(By.xpath(Loc.getProperty("TotalCalculatedQty")));
       double expectedTotal = Double.parseDouble(displayedTotal.getText().trim());
        
        double totalSum = 0;
        int previousCount = -1;
        
      
        while (true) {
            List<WebElement> qtyElements = driver.findElements(By.xpath(Loc.getProperty("Quantity")));
            
            if (qtyElements.size() == previousCount) {
                break; 
            }
            
            previousCount = qtyElements.size();
            
            for (WebElement qtyValue : qtyElements) {
                String text = qtyValue.getText().trim().replaceAll("[^0-9.]", ""); 
                try {
                    totalSum += Double.parseDouble(text); // Use Double instead of Integer
                } catch (NumberFormatException e) {
                    System.out.println("Skipping non-numeric value: " + text);
                }
            }

            scrll(); // Scroll again to load more elements
        }
        totalSum = Math.round(totalSum * 100.0) / 100.00;

        System.out.println("Calculated Total Sum of Qty is: " + totalSum);
        System.out.println("Expected Total Sum of Qty is: " + expectedTotal );
        Assert.assertEquals(totalSum, expectedTotal, "Total quantity does not match the expected value!");
    }

    // Scroll function
    private void scrll() {
        int screenHeight = driver.manage().window().getSize().height;
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

// check the avgfat/snf value on the dashboard for current date shift 
    @Test  
    public void VerifyThatTheAverageFatAndAverageSNFIsCorrectlyCalculatedOnDashboardForCurrentDateShiftAndMilkType() throws IOException, InterruptedException {
        login();  
        Thread.sleep(2000); 
        WebElement CalculatedAvgFat = driver.findElement(By.xpath(Loc.getProperty("CalculatedFat")));
        WebElement CalculatedAvgSNF = driver.findElement(By.xpath(Loc.getProperty("CalculatedSNF"))); 
        double expectedAvgFat = Double.parseDouble(CalculatedAvgFat.getText().trim());
        double expectedAvgSNF = Double.parseDouble(CalculatedAvgSNF.getText().trim());
        double totalFatQty = 0.00, totalSNFQty = 0.00, totalQty = 0.00;
        int previousCount = -1;
        while (true) {
            List<WebElement> qtyElements = driver.findElements(By.xpath(Loc.getProperty("Quantity")));
            List<WebElement> fatElements = driver.findElements(By.xpath(Loc.getProperty("Fat")));
            List<WebElement> snfElements = driver.findElements(By.xpath(Loc.getProperty("SNF")));
            if (qtyElements.size() == previousCount) {
                break;
            }
            previousCount = qtyElements.size();

            for (int i = 0; i < qtyElements.size(); i++) {
                String qtyText = qtyElements.get(i).getText().trim().replaceAll("[^0-9.]", ""); // Keep only numbers
                String fatText = fatElements.get(i).getText().trim().replaceAll("[^0-9.]", ""); 
                String snfText = snfElements.get(i).getText().trim().replaceAll("[^0-9.]", ""); 

                try {
                    double qty = Double.parseDouble(qtyText);
                    double fat = Double.parseDouble(fatText);
                    double snf = Double.parseDouble(snfText);
                    totalQty += qty;
                    totalFatQty += (fat * qty);
                    totalSNFQty += (snf * qty);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid values - Qty: " + qtyText + ", Fat: " + fatText + ", SNF: " + snfText);
                }
            }
            Thread.sleep(2000);
            scrll1(); 
        }
        double calculatedAvgFat = Math.floor((totalFatQty / totalQty) * 100) / 100;
        double calculatedAvgSNF = Math.floor((totalSNFQty / totalQty) * 100) / 100;
        System.out.println("Expected Avg Fat: " + expectedAvgFat + " | Calculated Avg Fat: " + calculatedAvgFat);
        System.out.println("Expected Avg SNF: " + expectedAvgSNF + " | Calculated Avg SNF: " + calculatedAvgSNF);
        Assert.assertEquals(calculatedAvgFat, expectedAvgFat, "Fat average calculation mismatch!");
        Assert.assertEquals(calculatedAvgSNF, expectedAvgSNF, "SNF average calculation mismatch!");
    }
   private void scrll1() {
        int screenHeight = driver.manage().window().getSize().height;
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    } 
// check the No.of Samples count from dashboard 
@Test
public void VerifyThatTheNoOfSampleCountForCurrentDateShiftAndMilkType() throws IOException, InterruptedException {
    login();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement noOfSamples = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Loc.getProperty("NoOfSampleCount"))));
    int expectedTotalCount = Integer.parseInt(noOfSamples.getText().trim());

    Set<WebElement> uniqueFarmers = new HashSet<>(); 
    int previousCount = -1;
    while (true) {
        List<WebElement> farmerList = driver.findElements(By.xpath(Loc.getProperty("FarmerIconList")));
        for (WebElement farmer : farmerList) {
            if (farmer.isDisplayed()) {
                uniqueFarmers.add(farmer);
            }
        }
        if (uniqueFarmers.size() == previousCount) {
            break;
        }

        previousCount = uniqueFarmers.size();
        scrllD12(); 
        Thread.sleep(1500);
    }

    System.out.println("Expected No Of Samples: " + expectedTotalCount);
    System.out.println("Actual No Of Samples: " + uniqueFarmers.size());

    Assert.assertEquals(uniqueFarmers.size(), expectedTotalCount, "Total count does not match the expected value!");
}
private void scrllD12() {
    int screenHeight = driver.manage().window().getSize().height;
    int startX = driver.manage().window().getSize().width / 2;
    int startY = (int) (screenHeight * 0.8); 
    int endY = (int) (screenHeight * 0.4); 

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence swipe = new Sequence(finger, 1);
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, startY));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), startX, endY)); 
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(swipe));
}
// check the pouring farmer count from dashboard 
@Test
public void VerifyThatThePouringFarmersCountIsCorrectForCurrentDateShiftAndMilkType() throws IOException, InterruptedException {
    login();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement noOfSamples = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Loc.getProperty("TotalPouringFarmer"))));
    int expectedTotalCount = Integer.parseInt(noOfSamples.getText().trim());

    Set<String> uniqueFarmers = new HashSet<>(); 
    int previousSize = -1;
    while (true) {
        List<WebElement> farmerElements = driver.findElements(By.xpath(Loc.getProperty("FarmerCode&Name")));
        for (WebElement farmer : farmerElements) {
            String farmerName = farmer.getText().trim();
            if (!farmerName.isEmpty()) {
                uniqueFarmers.add(farmerName);
            }
        }
        if (uniqueFarmers.size() == previousSize) {
            break;
        }

        previousSize = uniqueFarmers.size();
        scrllD13(); 
        Thread.sleep(1500);
    }
    System.out.println("Expected Pouring Farmer Count: " + expectedTotalCount);
    System.out.println("Actual Pouring Farmer Count: " + uniqueFarmers.size());

    Assert.assertEquals(uniqueFarmers.size(), expectedTotalCount, "Pouring farmer count mismatch!");
}
private void scrllD13() {
    int screenHeight = driver.manage().window().getSize().height;
    int startX = driver.manage().window().getSize().width / 2;
    int startY = (int) (screenHeight * 0.8); 
    int endY = (int) (screenHeight * 0.4);  

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence swipe = new Sequence(finger, 1);
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, startY));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), startX, endY)); 
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(swipe));
}


    @Test
         public void VerifyThatTheShiftLabelIsDisplayed() throws IOException {
          	login();
        		 WebElement ShiftLable = driver.findElement(By.xpath(Loc.getProperty("shiftlable")));
        		 String ShiftText = ShiftLable.getText();
        	   if(ShiftLable.isDisplayed()) {
        		   System.out.println("Yes " + ShiftText + " Lable is Displayed On Dashboard ");
        	   }else {
        		 System.out.println("No " + ShiftText +  " Lable is Not-Displayed");
        	   } 
        	 }
  @Test    
  public void VerifyThatTheShiftIsDisplayAccordingtoCurrentTimeZone() throws IOException {
	  VerifyThatTheShiftLabelIsDisplayed();
		 LocalTime currentTime = LocalTime.now();
		    String expectedShift = currentTime.isBefore(LocalTime.of(15, 0)) ? "AM" : "PM";
		    System.out.println("Expected Shift: " + expectedShift);
		    WebElement shiftElement = driver.findElement(By.xpath(Loc.getProperty("selectedshift")));
		    String displayedShift = shiftElement.getText();
		    System.out.println("Displayed Shift: " + displayedShift);
		    if (expectedShift.equalsIgnoreCase(displayedShift)) {
		        System.out.println("The shift displayed in the app is correct.");
		    } else {
		        System.out.println("The shift displayed in the app is incorrect.");
		    }
		
  }
  @Test
  public void VerifyThatTheShiftFIlterIsClickabe() throws IOException, InterruptedException {
	  VerifyThatTheShiftIsDisplayAccordingtoCurrentTimeZone();
		Thread.sleep(4000);
	  WebElement shiftClick = driver.findElement(By.xpath(Loc.getProperty("selectedshift")));
	  Thread.sleep(9000);
	  shiftClick.click();
	  if (shiftClick.isDisplayed() && shiftClick.isEnabled()) {
	        System.out.println("The Shift Filter is clickable." +shiftClick.getText() );
	    } else {
	        System.out.println("The Shift Filter is Not clickable." + shiftClick.getText());
	    }
	  
  }
  @Test
  public void VerifyThatTheShiftFIlterContainsShiftList() throws IOException, InterruptedException {
  VerifyThatTheShiftFIlterIsClickabe();
  Thread.sleep(7000);
  List<WebElement> shiftList = driver.findElements(By.className(Loc.getProperty("shiftlist")));
  if (shiftList.isEmpty()) {
	    System.out.println(" No shifts are displayed.");
  }else {
  for(WebElement shift : shiftList) {
	  System.out.println("Shift Contains Lists: " + shift.getText());  
  }
  }
  }
  @Test
	  public void verifyThatTheCancelAndOkIsDisplayedOnShiftSelectionDialog()throws IOException, InterruptedException {
		    VerifyThatTheShiftFIlterIsClickabe();
		    Thread.sleep(4000); 
		    WebElement cancel = driver.findElement(By.xpath(Loc.getProperty("cancel")));
		    Thread.sleep(3000);
		    WebElement ok = driver.findElement(By.xpath(Loc.getProperty("ok")));
		    String cancelText = cancel.getText();
		    String okText = ok.getText();
		    System.out.println(cancel.isDisplayed() ? " Yes, " + cancelText + " is displayed." : " No, " + cancelText + " is NOT displayed.");
		    System.out.println(ok.isDisplayed() ? " Yes, " + okText + " is displayed." : " No, " + okText + " is NOT displayed.");
		}

  @Test
  public void verifyThatTheCancelAndOkIsEnableddOnShiftSelectionDialog()throws IOException, InterruptedException {
	    verifyThatTheCancelAndOkIsDisplayedOnShiftSelectionDialog();
	    Thread.sleep(8000);
	    WebElement cancel = driver.findElement(By.xpath(Loc.getProperty("cancel")));
	    WebElement ok = driver.findElement(By.xpath(Loc.getProperty("ok")));
	    String cancelText = cancel.getText();
	    String okText = ok.getText();
	    System.out.println(cancel.isEnabled() ? " Yes, " + cancelText + " is enabled." : " No, " + cancelText + " is NOT enabled.");
	    System.out.println(ok.isEnabled() ? " Yes, " + okText + " is enabled." : " No, " + okText + " is NOT enabled.");
	}
  @Test
  public void verifyEachShiftSelectionAfterCancelShouldNotDisplay() throws IOException, InterruptedException {
	    VerifyThatTheShiftFIlterIsClickabe();
	    Thread.sleep(4000);

	    List<WebElement> shiftList = driver.findElements(By.className(Loc.getProperty("shiftlist")));

	    for (int i = 0; i < shiftList.size(); i++) {
	        shiftList = driver.findElements(By.className(Loc.getProperty("shiftlist")));
	        WebElement shift = shiftList.get(i);
	        String shiftName = shift.getText().trim();

	        if (!shiftName.isEmpty()) {
	            shift.click();
	            System.out.println("Selected Shift: " + shiftName);
	            Thread.sleep(4000);

	            driver.findElement(By.xpath(Loc.getProperty("cancel"))).click();
	            System.out.println("Cancel button clicked.");
	            Thread.sleep(4000);

	            WebElement shiftAfterCancel = driver.findElement(By.xpath(Loc.getProperty("shiftaftercancel")));
	            String displayedShift = shiftAfterCancel.getText().trim();

	            int retry = 0;
	            while (retry < 3 && (!displayedShift.isEmpty() && !displayedShift.equalsIgnoreCase("No Shift Selected"))) {
	                Thread.sleep(2000);
	                displayedShift = driver.findElement(By.xpath(Loc.getProperty("shiftaftercancel"))).getText().trim();
	                retry++;
	            }

	            if (!shiftName.equals(displayedShift)) {
	                System.out.println("Test Passed: No shift displayed after cancel for '" + shiftName + "'");
	            } else {
	                System.out.println(" Test Failed: Shift '" + shiftName + "' is still displayed after cancel.");
	            }
	            WebElement shiftClick = driver.findElement(By.xpath(Loc.getProperty("selectedshift")));
	      	  Thread.sleep(2000);
	      	  shiftClick.click();
	            Thread.sleep(4000);
	        }
	    }
  }
	@Test
	public void verifyThatTheShiftIsCheckedOrNotAfterClickOnParticularShiftFromList() throws IOException, InterruptedException {
	    VerifyThatTheShiftFIlterIsClickabe();
	    Thread.sleep(4000);
	    List<WebElement> shiftList = driver.findElements(By.className(Loc.getProperty("shiftlist")));
	    Map<WebElement, Rectangle> boundsBeforeClick = new HashMap<>();
	    for (WebElement element : shiftList) {
	        Rectangle rectBefore = element.getRect();
	        boundsBeforeClick.put(element, rectBefore);
	        System.out.println("Before Click - Bounds: " + rectBefore + " is : " + element.getText());
	    }
	    Thread.sleep(4000);  
	    for (WebElement element : shiftList) {
	        element.click();
	        Thread.sleep(4000); 
	        Rectangle rectAfter = element.getRect();
	        System.out.println("After Click - Bounds: " + rectAfter );
	        Rectangle rectBefore = boundsBeforeClick.get(element);
	        if (!rectBefore.equals(rectAfter)) {
	            System.out.println(" Radio button is CHECKED (Bounds changed).");
	        } else {
	            System.out.println(" Radio button is NOT CHECKED (Bounds same).");
	        }
	    }
	    Thread.sleep(4000); 
	}
@Test
public void verifyEachShiftSelectionAftrClickOkAndDisplayOnDashboard() throws IOException, InterruptedException {
    VerifyThatTheShiftFIlterIsClickabe();
    Thread.sleep(4000);  
    for (int i = 0; i < driver.findElements(By.className(Loc.getProperty("shiftlist"))).size(); i++) {
        List<WebElement> shiftList = driver.findElements(By.className(Loc.getProperty("shiftlist")));
        WebElement shift = shiftList.get(i);
        String shiftName = shift.getText().trim();
        if (!shiftName.isEmpty()) {
            shift.click();
            Thread.sleep(4000);  
            driver.findElement(By.xpath(Loc.getProperty("okButton"))).click();
            Thread.sleep(4000);
            System.out.println("Selected Shift: " + shiftName);
            WebElement shiftOnDashboard = driver.findElement(By.xpath(Loc.getProperty("shiftafterok")));
            Thread.sleep(4000);  
            String displayedShift = shiftOnDashboard.getText().trim();
            // Retry logic for shift display
            int retry = 0;
            while (retry < 3 && (displayedShift.isEmpty() || !displayedShift.equalsIgnoreCase(shiftName))) {
                Thread.sleep(4000);  // Wait before retrying
                displayedShift = shiftOnDashboard.getText().trim();
                retry++;
            }
            if (shiftName.equals(displayedShift)) {
                System.out.println("Test Passed: Selected shift '" + shiftName + "' is displayed on the dashboard.");
            } else {
                System.out.println("Test Failed: Selected shift '" + shiftName + "' is NOT displayed on the dashboard.");
            }
            driver.findElement(By.xpath(Loc.getProperty("selectedshift"))).click();
            Thread.sleep(4000);  
        }
    }
}
@Test
    public void VerifyThatTheMilkTypeLabelIsDisplayedOnDashboard() throws IOException {
      	login();
    		 WebElement MilkTypeLable = driver.findElement(By.xpath(Loc.getProperty("milktypelable")));
    		 String MilkTypeLableText = MilkTypeLable.getText();
    	   if(MilkTypeLable.isDisplayed()) {
    		   System.out.println("Yes " + MilkTypeLableText + " Lable is Displayed On Dashboard ");
    	   }else {
    		 System.out.println("No " + MilkTypeLableText +  " Lable is Not-Displayed");
    	   } 
    	 } 
@Test
public void VerifyThatBydefaultAllMilkTypeIsDisplayedOnDashboard() throws IOException {
  	login();
		 WebElement MilkType = driver.findElement(By.xpath(Loc.getProperty("bydefaultMilktype")));
		 String MilkTypeText = MilkType.getText();
	   if(MilkType.isDisplayed()) {
		   System.out.println("Yes Bydefault " + MilkTypeText + " MilkType is Displayed On Dashboard ");
	   }else {
		 System.out.println("No " + MilkTypeText +  " is Not-Displayed");
	   } 
	 } 
@Test
public void VerifyThatTheMilkTypeFilterIsClickable() throws IOException, InterruptedException {
login();
		Thread.sleep(4000);
	  WebElement MilkTypeClick = driver.findElement(By.xpath(Loc.getProperty("bydefaultMilktype")));
	  Thread.sleep(9000);
	  MilkTypeClick.click();
	  if (MilkTypeClick.isDisplayed() && MilkTypeClick.isEnabled()) {
	        System.out.println("The MilkType Filter is clickable."  );
	    } else {
	        System.out.println("The MilkType Filter is Not clickable." );
	    }
	  
}

@Test
public void VerifyThatMilkTypeFilteContainsMilkTypeList() throws IOException, InterruptedException {
	VerifyThatTheMilkTypeFilterIsClickable();
	  Thread.sleep(7000);
	  List<WebElement> MilkTypeList = driver.findElements(By.className(Loc.getProperty("milktypelist")));
	  if ( MilkTypeList.isEmpty()) {
		    System.out.println(" No MilkType List are displayed.");
	  }else {
	  for(WebElement MilkType :  MilkTypeList) {
		  System.out.println("MilkType Contains Lists: " + MilkType.getText());  
	  }
	  }
	  }
@Test
public void verifyThatTheCancelAndOkIsDisplayedOnMilkTypeSelectionDialog()throws IOException, InterruptedException {
	VerifyThatTheMilkTypeFilterIsClickable();
    Thread.sleep(4000); 
    WebElement cancel = driver.findElement(By.xpath(Loc.getProperty("MilkTypeCancel")));
    Thread.sleep(3000);
    WebElement ok = driver.findElement(By.xpath(Loc.getProperty("MilkTypeOk")));
    String cancelText = cancel.getText();
    String okText = ok.getText();
    System.out.println(cancel.isDisplayed() ? " Yes, " + cancelText + " is displayed." : " No, " + cancelText + " is NOT displayed.");
    System.out.println(ok.isDisplayed() ? " Yes, " + okText + " is displayed." : " No, " + okText + " is NOT displayed.");
}

@Test
public void verifyThatTheCancelAndOkIsEnableddOnMilkTypeSelectionDialog()throws IOException, InterruptedException {
	verifyThatTheCancelAndOkIsDisplayedOnMilkTypeSelectionDialog();
Thread.sleep(8000);
WebElement cancel = driver.findElement(By.xpath(Loc.getProperty("MilkTypeCancel")));
WebElement ok = driver.findElement(By.xpath(Loc.getProperty("MilkTypeOk")));
String cancelText = cancel.getText();
String okText = ok.getText();
System.out.println(cancel.isEnabled() ? " Yes, " + cancelText + " is enabled." : " No, " + cancelText + " is NOT enabled.");
System.out.println(ok.isEnabled() ? " Yes, " + okText + " is enabled." : " No, " + okText + " is NOT enabled.");
}
@Test
public void verifyEachMilkTypeSelectionAfterCancelShouldNotDisplay() throws IOException, InterruptedException { 
	VerifyThatTheMilkTypeFilterIsClickable();
    Thread.sleep(4000);

    List<WebElement> milkTypeList = driver.findElements(By.className(Loc.getProperty("milktypelist")));

    for (int i = 0; i < milkTypeList.size(); i++) {
        milkTypeList = driver.findElements(By.className(Loc.getProperty("milktypelist"))); 
        WebElement milkType = milkTypeList.get(i);
        String milkTypeName = milkType.getText().trim();

        if (!milkTypeName.isEmpty()) {
            milkType.click();
            System.out.println("Selected Milk Type: " + milkTypeName);
            Thread.sleep(4000);

            driver.findElement(By.xpath(Loc.getProperty("MilkTypeCancel"))).click();
            System.out.println("Cancel button clicked.");
            Thread.sleep(4000);
            WebElement milkTypeAfterCancel = driver.findElement(By.xpath(Loc.getProperty("milkTypeAfterCancel")));
            String displayedMilkType;
            int retry = 0;
            do {
                Thread.sleep(2000);
                displayedMilkType = milkTypeAfterCancel.getText().trim();
                retry++;
            } while (retry < 3 && (!displayedMilkType.isEmpty() && !displayedMilkType.equalsIgnoreCase("No Milk Type Selected")));
            if (!milkTypeName.equals(displayedMilkType)) {
                System.out.println("Test Passed: No Milk Type displayed after cancel for '" + milkTypeName + "'");
            } else {
                System.out.println(" Test Failed: Milk Type '" + milkTypeName + "' is still displayed after cancel.");
            }
            driver.findElement(By.xpath(Loc.getProperty("selectedMilkType"))).click();
            Thread.sleep(4000);
        }
    }
}
@Test
public void verifyEachMilkTypeSelectionAfterClickOkAndDisplayOnDashboard() throws IOException, InterruptedException {
    VerifyThatTheMilkTypeFilterIsClickable();
    Thread.sleep(4000);

    for (int i = 0; i < driver.findElements(By.className(Loc.getProperty("milktypelist"))).size(); i++) {
        List<WebElement> milkTypeList = driver.findElements(By.className(Loc.getProperty("milktypelist")));
        WebElement milkType = milkTypeList.get(i);
        String milkTypeName = milkType.getText().trim();

        if (!milkTypeName.isEmpty()) {
            milkType.click();
            Thread.sleep(4000);

            driver.findElement(By.xpath(Loc.getProperty("MilkTypeOk"))).click();
            Thread.sleep(4000);
            System.out.println("Selected Milk Type: " + milkTypeName);

            WebElement milkTypeOnDashboard = driver.findElement(By.xpath(Loc.getProperty("milkTypeAfterOk")));
            Thread.sleep(4000);
            String displayedMilkType = milkTypeOnDashboard.getText().trim();
            int retry = 0;
            while (retry < 3 && (displayedMilkType.isEmpty() || !displayedMilkType.equalsIgnoreCase(milkTypeName))) {
                Thread.sleep(4000);
                displayedMilkType = milkTypeOnDashboard.getText().trim();
                retry++;
            }

            if (milkTypeName.equals(displayedMilkType)) {
                System.out.println(" Test Passed: Selected Milk Type '" + milkTypeName + "' is displayed on the dashboard.");
            } else {
                System.out.println(" Test Failed: Selected Milk Type '" + milkTypeName + "' is NOT displayed on the dashboard.");
            }

            driver.findElement(By.xpath(Loc.getProperty("selectedMilkType"))).click();
            Thread.sleep(4000);
        }
    }
}
@Test
public void verifyThatTheShiftIsCheckedOrNotAfterClickOnParticularMilkTypeFromList() throws IOException, InterruptedException {
	  VerifyThatTheMilkTypeFilterIsClickable();
    Thread.sleep(4000);
    List<WebElement> MilkTypeList = driver.findElements(By.className(Loc.getProperty("milktypelist")));
    Map<WebElement, Rectangle> boundsBeforeClick = new HashMap<>();
    for (WebElement element : MilkTypeList) {
        Rectangle rectBefore = element.getRect();
        boundsBeforeClick.put(element, rectBefore);
        System.out.println("Before Click - Bounds: " + rectBefore + " is : " + element.getText());
    }
    Thread.sleep(4000);  
    for (WebElement element : MilkTypeList) {
        element.click();
        Thread.sleep(4000); 
        Rectangle rectAfter = element.getRect();
        System.out.println("After Click - Bounds: " + rectAfter );
        Rectangle rectBefore = boundsBeforeClick.get(element);
        if (!rectBefore.equals(rectAfter)) {
            System.out.println(" Radio button is CHECKED (Bounds changed).");
        } else {
            System.out.println(" Radio button is NOT CHECKED (Bounds same).");
        }
    }
    Thread.sleep(4000); 
}
   	 @Test
   	 public void VerifyThatTotalFarmerIconIsDisplayed() throws IOException {
     	login();
   		 WebElement farmericon = driver.findElement(By.xpath(Loc.getProperty("totalfarmericon")));
   	   if(farmericon.isDisplayed()) {
   		   System.out.println("Yes Total Farmer icon is Displayed On Dashboard ");
   	   }else {
   		 System.out.println("No TOtal Farmer Icon is Not-Displayed");
   	   } 
   	 }
   	 @Test
   	 public void VerifyThatTotalFarmerTextIsDisplayed() throws IOException {
      	login();
    		 WebElement farmertext = driver.findElement(By.xpath(Loc.getProperty("totalfarmerstext")));
    		 String farmertext1 = farmertext.getText();
    	   if(farmertext1.equals("Total Farmers")) {
    		   System.out.println("Yes : " + farmertext1 + " : is Displayed On Dashboard ");
    	   }else {
    		 System.out.println("No :Total Farmer text is Not-Displayed");
    	   } 	 
}
   	 @Test
   	public void VerifyThatTotalFarmerCountIsDisplayed() throws IOException, InterruptedException {
   	    login();
   	    Thread.sleep(5000);
   	    WebElement farmerCount = driver.findElement(By.xpath(Loc.getProperty("farmercount")));
   	    String farmerText = farmerCount.getText();
   	    if (farmerCount.isDisplayed()) {
   	        System.out.println("Yes, " + farmerText + " Farmers is displayed on the dashboard.");
   	    } else {
   	        System.out.println("No, total farmers is not displayed.");
   	    }
   	}
 
	 @Test
   	 public void VerifyThatPouringFarmerIconIsDisplayed() throws IOException {
     	login();
   		 WebElement pouringfarmericon = driver.findElement(By.xpath(Loc.getProperty("pouringfarmericon")));
   	   if(pouringfarmericon.isDisplayed()) {
   		   System.out.println("Yes : Pouring Farmer icon is Displayed On Dashboard ");
   	   }else {
   		 System.out.println("No : Pouring Farmer icon is Not-Displayed");
   	   } 
   	 }
   	 @Test
   	 public void VerifyThatPuringFarmerTextIsDisplayed() throws IOException {
      	login();
    		 WebElement pouringfarmertext = driver.findElement(By.xpath(Loc.getProperty("pouringfarmertext")));
    		 String pouringfarmertext1 = pouringfarmertext.getText();
    	   if(pouringfarmertext1.equals("Pouring Farmers")) {
    		   System.out.println("Yes :" + pouringfarmertext1 + " : is Displayed On Dashboard ");
    	   }else {
    		 System.out.println("No Pouring Farmer text is Not-Displayed");
    	   } 	 


   	 }
   	 @Test
 	public void VerifyThatPouringFarmerCountIsDisplayed() throws IOException, InterruptedException {
   	    login();
   	    Thread.sleep(5000);
   	    WebElement PouringFarmerCount = driver.findElement(By.xpath(Loc.getProperty("TotalPouringFarmer")));
   	    String FarmerCount = PouringFarmerCount.getText();

   	    // Check if the element is displayed
   	    if (PouringFarmerCount.isDisplayed()) {
   	        System.out.println("Yes, " + FarmerCount + " is displayed on the dashboard.");
   	    } else {
   	        System.out.println("No, total farmer count is not displayed.");
   	    }
   	}
   	 @Test
   	public void VerifyThatTotaQuantityIconIsDisplayed() throws IOException {
     	login();
   		 WebElement TotalQuantityIcon = driver.findElement(By.xpath(Loc.getProperty("TotalQtyIcon")));
   	   if(TotalQuantityIcon.isDisplayed()) {
   		   System.out.println("Yes : Total Quantity Icon is Displayed On Dashboard ");
   	   }else {
   		 System.out.println("No : Total Quantity Icon is Not-Displayed");
   	   } 
   	 }
   	 @Test
   	 public void VerifyThatTotalQuantityTextIsDisplayed() throws IOException {
      	login();
    		 WebElement TotalQuantityText = driver.findElement(By.xpath(Loc.getProperty("TotalQtyText")));
    		 String TotalQuantityText1 = TotalQuantityText.getText();
    	   if(TotalQuantityText1.equals("Total Quantity(L)")) {
    		   System.out.println("Yes :" + TotalQuantityText1 + " : is Displayed On Dashboard ");
    	   }else {
    		 System.out.println("No :" + TotalQuantityText1 + " :is Not-Displayed");
    	   } 	 


   	 }
   	 @Test
 	public void VerifyThatTotalQuantityIsDisplayed() throws IOException, InterruptedException {
   	    login();
   	    Thread.sleep(9000);
   	    WebElement TotalQuantity = driver.findElement(By.xpath(Loc.getProperty("TotalCalculatedQty")));
   	    String Qty = TotalQuantity.getText();
   	    if (TotalQuantity.isDisplayed()) {
   	        System.out.println("Yes, " + Qty + " is displayed on the dashboard.");
   	    } else {
   	        System.out.println("No, total Qty is not displayed.");
   	    }
   	}
@Test
   	 public void VerifyThatNoOfSamplesIconIsDisplayed() throws IOException {
      	login();
    		 WebElement NoOfSamplesIcon = driver.findElement(By.xpath(Loc.getProperty("NoOfSampleIcon")));
    	   if(NoOfSamplesIcon.isDisplayed()) {
    		   System.out.println("Yes : No. Of Samples Icon is Displayed On Dashboard ");
    	   }else {
    		 System.out.println("No : No. Of Samples Icon is Not-Displayed");
    	   } 
    	 }
    	 @Test
    	 public void VerifyThatNoOfSamplesTextIsDisplayed() throws IOException {
       	login();
     		 WebElement NoOfSamplesText = driver.findElement(By.xpath(Loc.getProperty("NoOfSampleText")));
     		 String NoOfSamplesText1 = NoOfSamplesText.getText();
     	   if(NoOfSamplesText1.equals("No. Of Samples")) {
     		   System.out.println("Yes :" + NoOfSamplesText1 + " : is Displayed On Dashboard ");
     	   }else {
     		 System.out.println("No :" + NoOfSamplesText1 + " : is Not-Displayed");
     	   } 	 


    	 }
     @Test
  	public void VerifyThatTotalNoOfSamplesIsDisplayed() throws IOException, InterruptedException {
    	    login();
    	    Thread.sleep(5000);
    	    WebElement NoOfSamples = driver.findElement(By.xpath(Loc.getProperty("NoOfSampleCount")));
    	    String Samples = NoOfSamples.getText();

    	    // Check if the element is displayed
    	    if (NoOfSamples.isDisplayed()) {
    	        System.out.println("Yes, " + Samples + " is displayed on the dashboard.");
    	    } else {
    	        System.out.println("No, total Samples is not displayed.");
    	    }
    	}
     @Test
     public void VerifyThatFatIconIsDisplayed() throws IOException {
      	login();
    		 WebElement FatIcon = driver.findElement(By.xpath(Loc.getProperty("FatIcon")));
    	   if(FatIcon.isDisplayed()) {
    		   System.out.println("Yes : Fat Icon is Displayed On Dashboard ");
    	   }else {
    		 System.out.println("No : Fat Icon is Not-Displayed");
    	   } 
    	 }
    	 @Test
    	 public void VerifyThatFatTextIsDisplayed() throws IOException {
       	login();
     		 WebElement FatText = driver.findElement(By.xpath(Loc.getProperty("FatText")));
     		 String FatText1 = FatText.getText();
     	   if(FatText1.equals("Fat(%)")) {
     		   System.out.println("Yes :" + FatText1 + " : is Displayed On Dashboard ");
     	   }else {
     		 System.out.println("No :" + FatText1 + " :is Not-Displayed");
     	   } 	 


    	 }
    	 @Test
  	public void VerifyThatTotalFatIsDisplayed() throws IOException, InterruptedException {
    	    login();
    	    Thread.sleep(5000);
    	    WebElement TotalFat = driver.findElement(By.xpath(Loc.getProperty("CalculatedFat")));
    	    String FAT = TotalFat.getText();

    	    // Check if the element is displayed
    	    if (TotalFat.isDisplayed()) {
    	        System.out.println("Yes, " + FAT + " is displayed on the dashboard.");
    	    } else {
    	        System.out.println("No, FAT(%) is not displayed.");
    	    }
    	}
    	 @Test
    	  public void VerifyThatSNFIconIsDisplayed() throws IOException {
    	      	login();
    	    		 WebElement SNFIcon = driver.findElement(By.xpath(Loc.getProperty("SNFIcon")));
    	    	   if(SNFIcon.isDisplayed()) {
    	    		   System.out.println("Yes : SNF Icon is Displayed On Dashboard ");
    	    	   }else {
    	    		 System.out.println("No : SNF Icon is Not-Displayed");
    	    	   } 
    	    	 }
    	    	 @Test
    	    	 public void VerifyThatSNFTextIsDisplayed() throws IOException, InterruptedException {
    	       	login();
    	       	Thread.sleep(3000);
    	     		 WebElement SNFText = driver.findElement(By.xpath(Loc.getProperty("SNFText")));
    	     		 String SNFText1 = SNFText.getText();
    	     	   if(SNFText1.equals("SNF(%)")) {
    	     		   System.out.println("Yes :" + SNFText1 + " : is Displayed On Dashboard ");
    	     	   }else {
    	     		 System.out.println("No :" + SNFText1 + " : is Not-Displayed");
    	     	   } 	 


    	    	 }
    	    	 @Test
    	  	public void VerifyThatTotalSNFIsDisplayed() throws IOException, InterruptedException {
    	    	    login();
    	    	    Thread.sleep(5000);
    	    	    WebElement TotalSNF = driver.findElement(By.xpath(Loc.getProperty("CalculatedSNF")));
    	    	    String SNF = TotalSNF.getText();

    	    	    // Check if the element is displayed
    	    	    if (TotalSNF.isDisplayed()) {
    	    	        System.out.println("Yes, " + SNF + " is displayed on the dashboard.");
    	    	    } else {
    	    	        System.out.println("No, SNF(%) is not displayed.");
    	    	    }
    	    	}
    	    	 @Test
    	    	 public void VerifyThatTheMilkProcurementTrendTextIsDisplayedWithCorrectSpelled() throws IOException, InterruptedException {
    	    	       	login();
    	    	       	Thread.sleep(3000);
    	    	     		 WebElement MilkProcurementTrendText = driver.findElement(By.xpath(Loc.getProperty("MilkProcurementTrendText")));
    	    	     		 String MilkProcurementTrendText1 = MilkProcurementTrendText.getText();
    	    	     		String Expected = "Milk Procurement Trend";
    	    	     	   if( MilkProcurementTrendText.isDisplayed() && MilkProcurementTrendText1.equals(Expected)) {
    	    	     		   System.out.println("Yes :" +  MilkProcurementTrendText1 + " : text is Displayed And Correct Spelled On Dashboard ");
    	    	     	   }else {
    	    	     		 System.out.println("No :" + MilkProcurementTrendText1 + " : text is Not-Displayed");
    	    	     	   } 	 
    	    	    	 } 
    	    	 @Test  //   issue here to handle bargraph   
    	    	 public void extractGraphData() throws InterruptedException, IOException {
    	    		    login();
    	    		    Thread.sleep(3000);
    	    		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    		    Dimension screenSize = driver.manage().window().getSize();
    	    		    int startX = (int) (screenSize.width * 0.1);
    	    		    int endX = (int) (screenSize.width * 0.2);
    	    		    int tapY = (int) (screenSize.height * 0.8);
    	    		    int numBars = 7;
    	    		    int stepX = (endX - startX) / (numBars - 1);

    	    		    Map<String, String> graphData = new LinkedHashMap<>();

    	    		    for (int i = 0; i < numBars; i++) {
    	    		        System.out.println("Tapping on bar " + (i + 1));
    	    		        tap(startX + (i * stepX), tapY);
    	    		        Thread.sleep(100);  // Wait for tooltip to appear

    	    		        try {
    	    		            WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	    		                    By.xpath("//android.widget.TextView[contains(@text, 'Total Volume')]")));

    	    		            String tooltipText = tooltip.getText();
    	    		            System.out.println("Tooltip text found: " + tooltipText);

    	    		            String[] parts = tooltipText.split("\n");
    	    		            if (parts.length == 2) {
    	    		                String date = parts[0].trim();
    	    		                String volume = parts[1].replace("Total Volume(L):", "").trim();
    	    		                graphData.put(date, volume);
    	    		            }
    	    		        } catch (Exception e) {
    	    		            System.out.println("Tooltip not found for bar " + (i + 1) + ", retrying...");

    	    		            // 🔄 Retry tapping if tooltip was not found
    	    		            tap(startX + (i * stepX), tapY);
    	    		            Thread.sleep(2000);

    	    		            try {
    	    		                WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	    		                        By.xpath("//android.widget.TextView[contains(@text, 'Total Volume')]")));

    	    		                String tooltipText = tooltip.getText();
    	    		                System.out.println("Tooltip text after retry: " + tooltipText);

    	    		                String[] parts = tooltipText.split("\n");
    	    		                if (parts.length == 2) {
    	    		                    String date = parts[0].trim();
    	    		                    String volume = parts[1].replace("Total Volume(L):", "").trim();
    	    		                    graphData.put(date, volume);
    	    		                }
    	    		            } catch (Exception ex) {
    	    		                System.out.println("❌ Tooltip still not found for bar " + (i + 1));
    	    		            }
    	    		        }
    	    		    }

    	    		    // Print extracted data
    	    		    System.out.println(" Extracted Graph Data:");
    	    		    graphData.forEach((date, volume) -> System.out.println(date + " -> " + volume + " L"));

    	    		    if (graphData.isEmpty()) {
    	    		        System.out.println("No graph data found! Check if tooltips are displayed properly.");
    	    		    } else {
    	    		        System.out.println(" Graph data extracted successfully.");
    	    		    }
    	    		}
    	    		private void tap(int x, int y) {
    	    		    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    	    		    Sequence tap = new Sequence(finger, 1);
    	    		    tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
    	    		    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    	    		    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    	    		    driver.perform(Collections.singletonList(tap));
    	    		}
    	    	 @Test 
    	    	 public void VerifyThatThePouringFarmerDetailsTextIsDisplayedWithCorrectSpelled() throws IOException, InterruptedException {
 	    	       	login();
 	    	       	Thread.sleep(12000);
 	    	       int screenHeight = driver.manage().window().getSize().height;
 	  	            int screenWidth = driver.manage().window().getSize().width;
 	  	     
 	  	            int startX = screenWidth / 2;
 	  	            int startY = (int) (screenHeight * 0.8); 
 	  	            int endY = (int) (screenHeight * 0.3);   
 	  	     
 	  	            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
 	  	            Sequence swipe = new Sequence(finger, 1);
 	  	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
 	  	            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
 	  	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
 	  	            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
 	  	            driver.perform(Collections.singletonList(swipe));
 	  	            System.out.println("Scrolled using W3C Actions.");
 	    	     		 WebElement PouringFarmerDetailsText = driver.findElement(By.xpath(Loc.getProperty("PouringFarmerDetailsText")));
 	    	     		 String PouringFarmerDetailsText1 = PouringFarmerDetailsText.getText();
 	    	     		String Expected = "Pouring Farmer Details";
 	    	     	   if( PouringFarmerDetailsText.isDisplayed() && PouringFarmerDetailsText1.equals(Expected)) {
 	    	     		   System.out.println("Yes :" + PouringFarmerDetailsText1 + " : is Displayed And Correct Spelled On Dashboard ");
 	    	     	   }else {
 	    	     		 System.out.println("No :" + PouringFarmerDetailsText1 + " : is Not-Displayed");
 	    	     	   } 	
}
    	    	 @Test()  
    	    	 public void VerifyThatTheFarmersTextIsDisplayedWithCorrectSpelled() throws IOException, InterruptedException {
  	    	       	login();
  	    	  	Thread.sleep(9000);
  	    	      WebElement DashboardButton = driver.findElement(By.xpath(Loc.getProperty("DashboardButton")));
  	    	    DashboardButton.click();
  	    	    Thread.sleep(12000);
  	    	      int screenHeight = driver.manage().window().getSize().height;
  	            int screenWidth = driver.manage().window().getSize().width;
  	     
  	            int startX = screenWidth / 2;
  	            int startY = (int) (screenHeight * 0.8); 
  	            int endY = (int) (screenHeight * 0.3);   
  	            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
  	            Sequence swipe = new Sequence(finger, 1);
  	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
  	            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
  	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
  	            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
  	     
  	            driver.perform(Collections.singletonList(swipe));
  	            System.out.println("Scrolled using W3C Actions.");
  	            
  	    	     		 WebElement FarmersText = driver.findElement(By.xpath(Loc.getProperty("Farmers")));
  	    	     		 String FarmersText1 = FarmersText.getText();
  	    	     		String Expected = "Farmers";
  	    	     	   if(FarmersText.isDisplayed() && FarmersText1.equals(Expected)) {
  	    	     		   System.out.println("Yes :" + FarmersText1 + ": is Displayed And Correct Spelled On Dashboard ");
  	    	     	   }else {
  	    	     		 System.out.println("No :" + FarmersText1 + ": is Not-Displayed");
  	    	     	   } 	
 }
    	    	 @Test
    	    	 public void VerifyThatTheSeeAllTextIsDisplayedWithCorrectSpelled() throws IOException, InterruptedException {
   	    	       	login();
   	    	  	Thread.sleep(9000);
   	    	      WebElement DashboardButton = driver.findElement(By.xpath(Loc.getProperty("DashboardButton")));
   	    	    DashboardButton.click();
   	    	    Thread.sleep(12000);
   	    	      int screenHeight = driver.manage().window().getSize().height;
   	            int screenWidth = driver.manage().window().getSize().width;
   	     
   	            int startX = screenWidth / 2;
   	            int startY = (int) (screenHeight * 0.8);  
   	            int endY = (int) (screenHeight * 0.3);   
   	     
   	            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
   	            Sequence swipe = new Sequence(finger, 1);
   	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
   	            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
   	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
   	            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
   	     
   	            driver.perform(Collections.singletonList(swipe));
   	            System.out.println("Scrolled using W3C Actions.");
   	            
   	    	     		 WebElement SeeAllText = driver.findElement(By.xpath(Loc.getProperty("SeeAll")));
   	    	     		 String SeeAllText1 = SeeAllText.getText();
   	    	     		String Expected = "See All>";
   	    	     	   if(SeeAllText.isDisplayed() && SeeAllText1.equals(Expected)) {
   	    	     		   System.out.println("Yes :" + SeeAllText1 + ": is Displayed And Correct Spelled On Dashboard ");
   	    	     	   }else {
   	    	     		 System.out.println("No :" + SeeAllText1 + ": is Not-Displayed");
   	    	     	   } 	
  }		
    	    	 @Test
    	    	 public void VerifyThaFarmerAndSeeAllAreInSameAlignment() throws IOException, InterruptedException {
    	    	       	login();
    	    	  	Thread.sleep(9000);
    	    	   //   WebElement DashboardButton = driver.findElement(By.xpath(Loc.getProperty("DashboardButton")));
    	    	 //   DashboardButton.click();
    	    	    Thread.sleep(12000); 
    	    	    int screenHeight = driver.manage().window().getSize().height;
       	            int screenWidth = driver.manage().window().getSize().width;
       	     
       	            int startX = screenWidth / 2;
       	            int startY = (int) (screenHeight * 0.8);  
       	            int endY = (int) (screenHeight * 0.3);   
       	     
       	            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
       	            Sequence swipe = new Sequence(finger, 1);
       	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
       	            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
       	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
       	            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
       	     
       	            driver.perform(Collections.singletonList(swipe));
       	            System.out.println("Scrolled using W3C Actions.");
    	    	    WebElement SeeAll = driver.findElement(By.xpath(Loc.getProperty("SeeAll")));
    	    	    WebElement Farmers = driver.findElement(By.xpath(Loc.getProperty("Farmers")));
    	    	    String SeeAllText = SeeAll.getText();
    	    	    String FarmersText = Farmers.getText();
    	    	    int Farmer = Farmers.getLocation().getY();
    	    	    int SeeAll1 = SeeAll.getLocation().getY();
    	    	    System.out.println(Farmer);
    	    	    System.out.println(SeeAll1);
    	    	    if (SeeAll1 == Farmer) {
    	    	        System.out.println("Both elements " + SeeAllText + " & " + FarmersText + " are  aligned.");
    	    	    } else {
    	    	        System.out.println("Elements are NOT  aligned.");
    	    	    }
}
    	    	 @Test
    	    	 public void VerifyThatTheSeeAllIsClickable() throws IOException, InterruptedException {
 	    	       	login();
 	    	  	Thread.sleep(9000);
 	    	   //   WebElement DashboardButton = driver.findElement(By.xpath(Loc.getProperty("DashboardButton")));
 	    	 //   DashboardButton.click();
 	    	    Thread.sleep(12000); 
 	    	    int screenHeight = driver.manage().window().getSize().height;
    	            int screenWidth = driver.manage().window().getSize().width;
    	     
    	            int startX = screenWidth / 2;
    	            int startY = (int) (screenHeight * 0.8);  // Start from 80% of the screen height
    	            int endY = (int) (screenHeight * 0.3);    // Scroll up to 20% of the screen height
    	     
    	            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    	            Sequence swipe = new Sequence(finger, 1);
    	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
    	            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    	            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
    	            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    	     
    	            driver.perform(Collections.singletonList(swipe));
    	            System.out.println("Scrolled using W3C Actions.");
 	    	    WebElement SeeAll = driver.findElement(By.xpath(Loc.getProperty("SeeAll")));
 	    	    SeeAll.click();
 	    	    if(SeeAll.isDisplayed() && SeeAll.isEnabled()) {
 	    	    	System.out.println("Yes, See All is Clickable.");
 	    	    } else {
 	    	    	System.out.println("No, See All is Not-Clickable.");
 	    	    }
    	    	 }	
    	    	 @Test
    	    	 public void verifyThatBAckButtonAndFarmersAreAvailableOnHeaders() throws Exception {
    	    		    VerifyThatTheSeeAllIsClickable(); // Ensure 'See All' is clicked
    	    		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    		    // Wait for elements to be visible
    	    		    WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("BackButtonFarmers"))));
    	    		    WebElement farmersText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("Farmers"))));

    	    		    // Verify elements are displayed
    	    		    Assert.assertTrue(backButton.isDisplayed(), "❌ Back button is NOT displayed!");
    	    		    Assert.assertTrue(farmersText.isDisplayed(), "❌ Farmers label is NOT displayed!");

    	    		    System.out.println("Back button and Farmers label are displayed correctly.");
    	    		}
    	    	 @Test
    	    	 public void verifyThatBackButtonAndFarmersAreInSameAlignment() throws Exception{
    	    		 VerifyThatTheSeeAllIsClickable();
    	    		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    		 WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("BackButtonFarmers"))));
 	    		    WebElement farmersText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("Farmers"))));
 	    		    int backButtony = backButton.getLocation().getY();
 	    		   int farmersTexty = farmersText.getLocation().getY();
 	    		    
 	    		   if (backButtony == farmersTexty) {
 	    			   System.out.println("both element are same alignment" +  backButtony + "  " + farmersTexty );
 	    		   }else {
 	    			  System.out.println("element are not in same alignment"  +  backButtony + "  " + farmersTexty );
    	    	 }
    	    	 } 
    	    	 @Test
    	    	 public void verifyThatWhenUserClickOnBackButtonItsNavigatedToBackPage() throws Exception {
    	    		    VerifyThatTheSeeAllIsClickable();
    	    		  
    	    		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    		    
    	    		    // Wait for the back button to be visible
    	    		    WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("BackButtonFarmers"))));
      	    		 backButton.click();
      	    	    WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("ccdashboardheader"))));
   	    		   String headerText = header.getText();
      	    		 if( headerText.equals("Collection Center Dashboard")) {
      	    			 System.out.println("User Navigated Back to CC Dashboard");
      	    		 }else {
      	    			 System.out.println("Back button is not clickable");
      	    		 }
    	    		    
    	    	 }
    	    	 @Test
    	    	public void verifyThatifDataAvailbleThenDIsplayedOnFarmersPageElseNoDataFoundDisplayed() throws Exception{
    	    		 VerifyThatTheSeeAllIsClickable();
    	    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    		List<WebElement> data  = driver.findElements(By.xpath(Loc.getProperty("dataOnFarmers")));
    	    		if(data.size()> 0) {
    	    			System.out.println("Data Available on Farmers Page");
    	    		} else {
    	    			System.out.println("No Data Found");
    	    		}
    	    		
    	    	}

    	    	@Test
    	    	 public void VerifyThatDataDuplicacyOnFarmersPage() throws IOException, InterruptedException {
    	    		 VerifyThatTheSeeAllIsClickable();
    	    			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	    			    List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Loc.getProperty("data"))));
 List<String> dataList = new ArrayList<>();
    	    			    Set<String> uniqueDataSet = new HashSet<>();
 for (WebElement element : elements) {
    	    			        String text = element.getText().trim();
    	    			        if (!text.isEmpty()) {
    	    			            dataList.add(text);
    	    			        }
    	    			    }
    	    			    for (String data : dataList) {
    	    			        if (!uniqueDataSet.add(data)) { 
    	    			            System.out.println("Duplicate Found: " + data);
    	    			            return;  
    	    			        }
    	    			    }
    	    			    
    	    			    return;
    	    			}
    	   
    	    	@Test
    	    	public void VerifyThatTheBackButtonIsDisplayedAndClickableOnFarmersPage() throws IOException, InterruptedException {
    	    	    VerifyThatTheSeeAllIsClickable();

    	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    	    WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc.getProperty("BackButtonFarmers"))));

    	    	    Assert.assertTrue(backButton.isDisplayed(), " Back Button is not displayed");
    	    	    Assert.assertTrue(backButton.isEnabled(), "Back Button is not enabled");
    	    	    System.out.println("Back Button is displayed and enabled");
    	    	    backButton.click();
    	    	    Thread.sleep(2000); 
    	    	    boolean isLandedBack = !driver.findElements(By.xpath(Loc.getProperty("ccdashboardheader"))).isEmpty();
    	    	    Assert.assertTrue(isLandedBack, " Back button click failed or did not navigate correctly");

    	    	    System.out.println(" Click on Back Button successful and navigation verified");
    	    	}
    	    	@Test
    	    	public void verifyEDPUClickFromFooterNavigatesToTestingDashboard() throws IOException, InterruptedException {
    	            login(); 
    	            Thread.sleep(9000); 
    	            WebElement edpuElement = driver.findElement(By.xpath(Loc.getProperty("EDPUFooter")));
    	            Assert.assertTrue(edpuElement.isDisplayed(), "E-DPU element is not displayed");
    	            edpuElement.click();
    	            Thread.sleep(3000); 
    	            List<WebElement> dashboardElements = driver.findElements(By.xpath(Loc.getProperty("TestingDashboard")));;
    	            Assert.assertTrue(!dashboardElements.isEmpty(), "Navigation to Testing Dashboard failed");
    	        }
    	    	
    	    	@Test
    	    	public void verifyFarmerListClickFromFooterNavigatesToFarmerList() throws IOException, InterruptedException {
    	            login(); 
    	            Thread.sleep(9000); 
    	            WebElement FarmerListElement = driver.findElement(By.xpath(Loc.getProperty("FarmerListFooter")));
    	            Assert.assertTrue(FarmerListElement.isDisplayed(), "FarmerList element is not displayed");
    	            FarmerListElement.click();
    	            Thread.sleep(3000); 
    	            List<WebElement> FarmerListElements = driver.findElements(By.xpath(Loc.getProperty("FarmaerListHeader")));
    	            Assert.assertTrue(!FarmerListElements.isEmpty(), "Navigation to FarmerList failed");
    	        }
    	    	@Test
    	    	public void verifyDispatchClickFromFooterNavigatesToDispatch() throws IOException, InterruptedException {
    	            login(); 
    	            Thread.sleep(9000); 
    	            WebElement DispatchElement = driver.findElement(By.xpath(Loc.getProperty("DispatchFooter")));
    	            Assert.assertTrue(DispatchElement.isDisplayed(), "Dispatch element is not displayed");
    	            DispatchElement.click();
    	            Thread.sleep(3000); 
    	            List<WebElement> DispatchElements = driver.findElements(By.xpath(Loc.getProperty("DispatchHeader")));
    	            Assert.assertTrue(!DispatchElements.isEmpty(), "Navigation to Dispatch failed");
    	        }	
    	    	@Test
    	    	public void verifyCompositeClickFromFooterNavigatesToComposite() throws IOException, InterruptedException {
    	            login(); 
    	            Thread.sleep(9000); 
    	            WebElement CompositeElement = driver.findElement(By.xpath(Loc.getProperty("CompositeFooter")));
    	            Assert.assertTrue(CompositeElement.isDisplayed(), "Composite element is not displayed");
    	            CompositeElement.click();
    	            Thread.sleep(3000); 
    	            List<WebElement> CompositeElements = driver.findElements(By.xpath(Loc.getProperty("CompositeHeader")));
    	            Assert.assertTrue(!CompositeElements.isEmpty(), "Navigation to Composite failed");
    	        }	
    	    	
    	    	@Test
    	    	public void verifyHomeClickFromFooterNavigatesToHome() throws IOException, InterruptedException {
    	            login(); 
    	            Thread.sleep(9000); 
    	            WebElement HomeElement = driver.findElement(By.xpath(Loc.getProperty("HomeFooter")));
    	            Assert.assertTrue(HomeElement.isDisplayed(), "Home element is not displayed");
    	            HomeElement.click();
    	            Thread.sleep(3000); 
    	            List<WebElement>HomeElements = driver.findElements(By.xpath(Loc.getProperty("Home")));
    	            Assert.assertTrue(!HomeElements.isEmpty(), "Navigation to Home failed");
    	        }
}
 	    	 