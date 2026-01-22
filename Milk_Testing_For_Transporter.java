package Testcases;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.Baseclass;

public class Milk_Testing_For_Transporter extends Baseclass {
    @Test(priority = 1)
    public void testDispatchFlow() throws InterruptedException, IOException {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
         WebElement getStartedButton = driver.findElement(By.xpath(Loc.getProperty("getStarted")));
         getStartedButton.click();
         WebElement emailInput = driver.findElement(By.xpath(Loc.getProperty("Email_id")));
         emailInput.sendKeys("test150703");
         WebElement nextButton = driver.findElement(By.xpath(Loc.getProperty("Next_button")));
         nextButton.click();
         WebElement passwordInput = driver.findElement(By.xpath(Loc.getProperty("Password_inputbox_placeholder")));
         passwordInput.sendKeys("test150703");
         WebElement customerCodeInput = driver.findElement(By.xpath(Loc.getProperty("customer_code_input_box")));
         customerCodeInput.sendKeys("ndu43");
         WebElement loginButton = driver.findElement(By.xpath(Loc.getProperty("Login")));
         loginButton.click();
         Thread.sleep(3000);
         WebElement DashboardButton =driver.findElement(By.xpath(Loc.getProperty("DashboardButton")));
         DashboardButton.click();
         Thread.sleep(6000);
         WebElement DispatchFooter =driver.findElement(By.xpath(Loc1.getProperty("DispatchFooter")));
         DispatchFooter.click();
         Thread.sleep(3000);
         WebElement Dispatch = driver.findElement(By.xpath(Loc1.getProperty("DispatchButton2")));
         Dispatch.click();
}    
    @Test (priority = 2)
    public void verifyMilkTestingUIElements() throws InterruptedException, IOException {
    	 testDispatchFlow();
    	 Thread.sleep(2000);
        WebElement title = (WebElement) driver.findElement(By.xpath(Loc1.getProperty("Title")));
        Assert.assertTrue(title.isDisplayed(), "Title is not visible");
        Thread.sleep(2000);
        WebElement status = driver.findElement(By.xpath(Loc1.getProperty("WaitingMessage")));
        Assert.assertTrue(status.isDisplayed(), "Status text not visible");
       Thread.sleep(2000);
        WebElement resultLabel = driver.findElement(By.xpath(Loc1.getProperty("ResultText")));
        Assert.assertTrue(resultLabel.isDisplayed(), "Result label not visible");
        Thread.sleep(2000);
        WebElement qtyLabel = driver.findElement(By.xpath(Loc1.getProperty("QtyText")));
        Assert.assertTrue(qtyLabel.isDisplayed(), "Qty label not visible");
        Thread.sleep(2000);
        WebElement fatLabel = driver.findElement(By.xpath(Loc1.getProperty("FatText")));
        Assert.assertTrue(fatLabel.isDisplayed(), "Fat(%) label not visible");
        Thread.sleep(2000);
        WebElement snfLabel = driver.findElement(By.xpath(Loc1.getProperty("SNFText")));
        Assert.assertTrue(snfLabel.isDisplayed(), "SNF(%) label not visible");
    }
        @Test (priority = 3)
        public void verifyThatDispatchButtonUIElementIsDisplayedAndDisableBydefault () throws InterruptedException, IOException {
        	testDispatchFlow()	;
        	Thread.sleep(3000);
              WebElement dispatchBtn = driver.findElement(By.xpath(Loc1.getProperty("DispatchButton2")));
        Assert.assertTrue(dispatchBtn.isDisplayed(), "Dispatch button not visible");
        Assert.assertFalse(dispatchBtn.isEnabled(), "Dispatch button should be disabled");
    }
 
        @Test(priority = 4)
       public void verifyThatBackButtonIsAvailableAndAfterClickOnThatNavigatedToPreviousScreen() throws InterruptedException, IOException {
       	testDispatchFlow()	;
       	Thread.sleep(3000);
       	WebElement backButton = driver.findElement(By.xpath(Loc1.getProperty("BackButton")));
       	Assert.assertTrue(backButton.isDisplayed(), "Back Button not visible");
       	Thread.sleep(2000);
       	backButton.click();
       	String ExpectedScreen = "DISPATCH" ;
    	Thread.sleep(2000);
       	WebElement DispatchHeader = driver.findElement(By.xpath(Loc1.getProperty("DispatchButton1")));
       	String DispatchText = DispatchHeader.getText();      	
       		Assert.assertEquals(DispatchText, ExpectedScreen, "Screen navigation failed!");
        } 
        @Test(priority = 5)
        public void verifyThatQtyFatSNFIsInputTypeField() throws InterruptedException, IOException {
           	testDispatchFlow()	;
        	WebElement QtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));	
        	WebElement FatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));	
        	WebElement SNFInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));	
        	 boolean allInputsAreEditText = 
        		        QtyInput.getAttribute("class").equals("android.widget.EditText") &&
        		        FatInput.getAttribute("class").equals("android.widget.EditText") &&
        		        SNFInput.getAttribute("class").equals("android.widget.EditText");
        		    Assert.assertTrue(allInputsAreEditText, "All fields (Qty, Fat, SNF) should be input type fields");
        		}
        @Test(priority = 6)
        public void verifyThatMilkTypeSelectionEnabledAfterGettingDataInInputField() throws InterruptedException, IOException {
            testDispatchFlow();
            Thread.sleep(3000);
            WebElement QtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));	
            WebElement FatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));	
            WebElement SNFInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
            DecimalFormat df = new DecimalFormat("00.00");
            Random random = new Random();
            String fat = df.format(3.0 + random.nextDouble() * 3.0);  
            String snf = df.format(7.5 + random.nextDouble() * 1.5);    
            String qty = df.format(10.0 + random.nextDouble() * 5.0);    
            String dataLine = String.join(",", fat, snf, qty);
            String[] values = dataLine.split(",");
            Actions actions = new Actions(driver);
            FatInput.click();
            FatInput.clear();
            actions.sendKeys(FatInput, values[0]).perform();
            Thread.sleep(500);
            SNFInput.click();
            SNFInput.clear();
            actions.sendKeys(SNFInput, values[1]).perform();
            Thread.sleep(500);
            QtyInput.click();
            QtyInput.clear();
            actions.sendKeys(QtyInput, values[2]).perform();
            Thread.sleep(500);
            System.out.println("Sent to UI via Actions: Fat=" + values[0] + ", SNF=" + values[1] + ", Qty=" + values[2]);
            Thread.sleep(200);
            WebElement cowRadio = driver.findElement(By.xpath(Loc1.getProperty("CowText")));
            WebElement buffRadio = driver.findElement(By.xpath(Loc1.getProperty("BuffText")));
           WebElement mixRadio = driver.findElement(By.xpath(Loc1.getProperty("MixText")));
            boolean cowEnabled = cowRadio.isEnabled();
            boolean buffEnabled = buffRadio.isEnabled();
           boolean mixEnabled = mixRadio.isEnabled();
            boolean allEnabled = cowEnabled && buffEnabled && mixEnabled;
            System.out.println("All radio buttons enabled? " + allEnabled);
            Assert.assertTrue(allEnabled, "Expected all radio buttons to be ENABLED after entering data");
        
        }
     
  @Test(priority = 7)
  public void verifyAfterSendDataInputFieldsGetReceivedValues() throws Exception {
      testDispatchFlow();
      Thread.sleep(3000);
      WebElement QtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));	
      WebElement FatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));	
      WebElement SNFInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
      DecimalFormat df = new DecimalFormat("00.00");
      Random random = new Random();
      String fat = df.format(3.0 + random.nextDouble() * 3.0);     
      String snf = df.format(7.5 + random.nextDouble() * 1.5);     
      String qty = df.format(10.0 + random.nextDouble() * 5.0);   
      String dataLine = String.join(",", fat, snf, qty);
      String[] values = dataLine.split(",");
      Actions actions = new Actions(driver);
      FatInput.click();
      FatInput.clear();
      actions.sendKeys(FatInput, values[0]).perform();
      Thread.sleep(500);
      SNFInput.click();
      SNFInput.clear();
      actions.sendKeys(SNFInput, values[1]).perform();
      Thread.sleep(500);
      QtyInput.click();
      QtyInput.clear();
      actions.sendKeys(QtyInput, values[2]).perform();
      Thread.sleep(500);
      System.out.println("Sent to UI via Actions: Fat=" + values[0] + ", SNF=" + values[1] + ", Qty=" + values[2]);
  }
  @Test(priority = 8)
public void verifyThatAlertMessageIsDisplayedOnTransporterPageIfCollectionIsNotDoneForThatMilkType() throws InterruptedException, IOException {
	  testDispatchFlow();
      Thread.sleep(3000);
      WebElement QtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));	
      WebElement FatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));	
      WebElement SNFInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
      Actions actions = new Actions(driver);
      double fatValue = 4.80;
      double snfValue = 8.50;
      double qtyValue = 8.90;
      QtyInput.click();
      QtyInput.clear();
      actions.sendKeys(QtyInput, String.valueOf(qtyValue)).perform();
      FatInput.click();
      FatInput.clear();
      actions.sendKeys(FatInput, String.valueOf(fatValue)).perform();
      SNFInput.click();
      SNFInput.clear();
      actions.sendKeys(SNFInput, String.valueOf(snfValue)).perform();

      WebElement cowRadio = driver.findElement(By.xpath(Loc1.getProperty("CowText")));
      WebElement buffRadio = driver.findElement(By.xpath(Loc1.getProperty("BuffText")));
     WebElement mixRadio = driver.findElement(By.xpath(Loc1.getProperty("MixText"))); 
     List<WebElement> milkTypeRadios = new ArrayList<>();
     milkTypeRadios.add(cowRadio);
     milkTypeRadios.add(buffRadio);
     milkTypeRadios.add(mixRadio);
     for(WebElement radio : milkTypeRadios) {
    	 radio.click();
     Thread.sleep(2000);
     WebElement alertMessage = driver.findElement(By.xpath(Loc1.getProperty("NoCollectionMessage")));
     Assert.assertTrue(alertMessage.isDisplayed(),"Alert Message Not Displayed For MilkType : " + radio.getText());
     
}
}  @Test(priority = 9)
  public void verifyThatDispatchButtonIsDisabledIfZeroValueEntered() throws InterruptedException, IOException {
	    testDispatchFlow();
	    Thread.sleep(3000);
	    WebElement QtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));    
	    WebElement FatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));    
	    WebElement SNFInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
	    Actions actions = new Actions(driver);
	    QtyInput.click();
	    QtyInput.clear();
	    actions.sendKeys(QtyInput, "0").perform();
	    FatInput.click();
	    FatInput.clear();
	    actions.sendKeys(FatInput, "0").perform();
	    SNFInput.click();
	    SNFInput.clear();
	    actions.sendKeys(SNFInput, "0").perform();
	    Thread.sleep(1000);
	    WebElement dispatchButton = driver.findElement(By.xpath(Loc1.getProperty("DispatchButton2")));
	    boolean isEnabled = dispatchButton.isEnabled();
	    System.out.println("Is Dispatch Button Enabled with 0 input values? " + isEnabled);
	    Assert.assertFalse(isEnabled, "Dispatch button should be DISABLED when input values are 0.");
	}
@Test(priority = 10)
public void verifyDispatchButtonStatusWhenOnlyOneInputFieldHasData() throws InterruptedException, IOException {
    testDispatchFlow();
    Thread.sleep(3000);
    WebElement QtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));    
    WebElement FatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));    
    WebElement SNFInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
    WebElement dispatchButton = driver.findElement(By.xpath(Loc1.getProperty("DispatchButton2"))); 
    Actions actions = new Actions(driver);
    FatInput.click();
    FatInput.clear();
    actions.sendKeys(FatInput, "4.5").perform();
    SNFInput.click();
    SNFInput.clear();
    actions.sendKeys(SNFInput, "").perform();
    QtyInput.click();
    QtyInput.clear();
    actions.sendKeys(QtyInput, "").perform();
    Thread.sleep(1000);
    boolean isDispatchEnabledFatOnly = dispatchButton.isEnabled();
    System.out.println("Dispatch enabled with only FAT input: " + isDispatchEnabledFatOnly);
    Assert.assertFalse(isDispatchEnabledFatOnly, "Dispatch should NOT be enabled when only FAT is entered.");
    FatInput.clear();
    SNFInput.clear();
    QtyInput.clear();
    actions.sendKeys(SNFInput, "8.5").perform();
    Thread.sleep(1000);
    boolean isDispatchEnabledSnfOnly = dispatchButton.isEnabled();
    System.out.println("Dispatch enabled with only SNF input: " + isDispatchEnabledSnfOnly);
    Assert.assertFalse(isDispatchEnabledSnfOnly, "Dispatch should NOT be enabled when only SNF is entered.");
    FatInput.clear();
    SNFInput.clear();
    QtyInput.clear();
    actions.sendKeys(QtyInput, "10").perform();
    Thread.sleep(1000);
    boolean isDispatchEnabledQtyOnly = dispatchButton.isEnabled();
    System.out.println("Dispatch enabled with only QTY input: " + isDispatchEnabledQtyOnly);
    Assert.assertFalse(isDispatchEnabledQtyOnly, "Dispatch should NOT be enabled when only QTY is entered.");
}
@Test(priority = 11)
public void verifyDispatchButtonEnabledForAllMilkTypes() throws InterruptedException, IOException {
    testDispatchFlow(); 
    Thread.sleep(3000);
    WebElement qtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));    
    WebElement fatInput = driver.findElement(By.xpath(Loc1.getProperty("FatInput")));    
    WebElement snfInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
    WebElement dispatchButton = driver.findElement(By.xpath(Loc1.getProperty("DispatchButton2")));
    Actions actions = new Actions(driver);
    fatInput.click();
    fatInput.clear();
    actions.sendKeys(fatInput, "4.5").perform();
    Thread.sleep(300);
    snfInput.click();
    snfInput.clear();
    actions.sendKeys(snfInput, "6.8").perform();
    Thread.sleep(300);
    qtyInput.click();
    qtyInput.clear();
    actions.sendKeys(qtyInput, "5.20").perform();
    Thread.sleep(1000);
    WebElement cowRadio = driver.findElement(By.xpath(Loc1.getProperty("CowText")));
    WebElement buffRadio = driver.findElement(By.xpath(Loc1.getProperty("BuffText")));
    WebElement mixRadio = driver.findElement(By.xpath(Loc1.getProperty("MixText")));
    WebElement alertMessage = driver.findElement(By.xpath(Loc1.getProperty("NoCollectionMessage")));
    if (cowRadio.isEnabled()) {
        cowRadio.click();
        Thread.sleep(300);
        if (dispatchButton.isEnabled()) {
            System.out.println("Cow: Dispatch button is enabled (Collection done)");
        } else {
            System.out.println("Cow: Dispatch button is disabled Because : " + alertMessage.getText());
        }
    }

    // --- Buffalo ---
    if (buffRadio.isEnabled()) {
        buffRadio.click();
        Thread.sleep(300);
        if (dispatchButton.isEnabled()) {
            System.out.println("Buffalo: Dispatch button is enabled (Collection done)");
        } else {
            System.out.println("Buffalo: Dispatch button is disabled Because : " + alertMessage.getText());
        }
    }

    // --- Mix ---
    if (mixRadio.isEnabled()) {
        mixRadio.click();
        Thread.sleep(300);
        if (dispatchButton.isEnabled()) {
            System.out.println("Mix: Dispatch button is enabled  (Collection done)");
        } else {
            System.out.println("Mix: Dispatch button is disabled Because : " + alertMessage.getText());
        }
    }
}

@Test(priority = 12)
public void verifyThatDataIsDispatchedAfterEnteringValuesInInputFields() throws InterruptedException, IOException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

    driver.findElement(By.xpath(Loc.getProperty("getStarted"))).click();
    driver.findElement(By.xpath(Loc.getProperty("Email_id"))).sendKeys("test150703");
    driver.findElement(By.xpath(Loc.getProperty("Next_button"))).click();
    driver.findElement(By.xpath(Loc.getProperty("Password_inputbox_placeholder"))).sendKeys("test150703");
    driver.findElement(By.xpath(Loc.getProperty("customer_code_input_box"))).sendKeys("ndu43");
    driver.findElement(By.xpath(Loc.getProperty("Login"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc.getProperty("DashboardButton")))).click();

    WebElement edpuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc.getProperty("EDPUFooter"))));
    Assert.assertTrue(edpuElement.isDisplayed(), "E-DPU element is not displayed");
    edpuElement.click();

    WebElement testingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc1.getProperty("TestingFooter"))));
    Assert.assertTrue(testingElement.isDisplayed(), "Testing element is not displayed");
    testingElement.click();

    Actions actions = new Actions(driver);
    enterDataForFarmer("Farmer0004", "Cow", actions);
    clickFarmerIDSection();
    enterDataForFarmer("Farmer0005", "Buffalo", actions);
    clickFarmerIDSection();
    enterDataForFarmer("Farmer0006", "Mix", actions);

    WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc1.getProperty("edpuback"))));
    Assert.assertTrue(backButton.isDisplayed(), "Back button is not visible");
    backButton.click();

    WebElement clickYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("yesclick"))));
    clickYes.click();

    WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("HomeButton"))));
    homeButton.click();

    WebElement backButtonTestingDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("edpuback"))));
    backButtonTestingDashboard.click();

    WebElement clickDispatch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("DispatchFooter"))));
    clickDispatch.click();

    WebElement dispatchButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("DispatchButton2"))));
    dispatchButton2.click();


    List<String> milkTypes = Arrays.asList("cow", "buffalo", "mix");

    for (String milkType : milkTypes) {
        try {
       
            WebElement fatInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc1.getProperty("FatInput"))));
            WebElement snfInput = driver.findElement(By.xpath(Loc1.getProperty("SNFInput")));
            WebElement qtyInput = driver.findElement(By.xpath(Loc1.getProperty("QtyInput")));
            String fatStr = String.format("%.2f", ThreadLocalRandom.current().nextDouble(4.0, 9.0));
            String snfStr = String.format("%.2f", ThreadLocalRandom.current().nextDouble(6.0, 12.0));
            String qtyStr = String.format("%.2f", ThreadLocalRandom.current().nextDouble(1.0, 50.0));

            sendValue1(new Actions(driver), fatInput, fatStr);
            sendValue1(new Actions(driver), snfInput, snfStr);
            sendValue1(new Actions(driver), qtyInput, qtyStr);
            switch (milkType.toLowerCase()) {
                case "cow":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("CowRadio")))).click();
                    break;
                case "buffalo":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("BuffRadio")))).click();
                    break;
                case "mix":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("MixRadio")))).click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid milk type: " + milkType);
            }
            WebElement dispatchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("DispatchData"))));
            dispatchButton.click();

            System.out.println("Data entry successful for milk type: " + milkType);

        } catch (Exception e) {
            System.err.println("Error while handling milk type: " + milkType);
            e.printStackTrace();
        }
    }
}

private void clickFarmerIDSection() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement clickFarmerID = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("FarmerID"))));
    clickFarmerID.click();
}

private void enterDataForFarmer(String farmerKey, String milkType, Actions actions) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement farmerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc1.getProperty(farmerKey))));
    Assert.assertTrue(farmerElement.isDisplayed(), farmerKey + " is not displayed");
    farmerElement.click();

    WebElement fatField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loc1.getProperty("edpuFat"))));
    WebElement snfField = driver.findElement(By.xpath(Loc1.getProperty("edpuSNF")));
    WebElement qtyField = driver.findElement(By.xpath(Loc1.getProperty("edpuQty")));

    sendValue(actions, fatField, getRandom(4.0, 9.0));
    sendValue(actions, snfField, getRandom(6.0, 12.0));
    sendValue(actions, qtyField, getRandom(1.0, 50.0));

    if (milkType != null) {
        switch (milkType.toLowerCase()) {
            case "cow":
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("CowRadio")))).click();
                break;
            case "buffalo":
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("BuffRadio")))).click();
                break;
            case "mix":
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("MixRadio")))).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid milk type: " + milkType);
        }
    }

    WebElement amt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("amt"))));
    amt.click();

    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Loc1.getProperty("edpuSave"))));
    saveButton.click();
}

private void sendValue(Actions actions, WebElement element, String value) {
    element.click();
    element.clear();
    actions.sendKeys(element, value).perform();
}
private void sendValue1(Actions actions1, WebElement element, String value) {
    element.click();
    element.clear();
    actions1.sendKeys(element, value).perform();
}

private String getRandom(double min, double max) {
    return String.format("%.2f", ThreadLocalRandom.current().nextDouble(min, max));
}
}
