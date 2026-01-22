package Testcases;

import java.io.IOException;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Collection_center_login extends Baseclass {

    @Test(dataProvider = "testdata")
    public void login(String user_name, String password, String Customer_Code) throws IOException {
        try {
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
          //  try {
            if (isElementDisplayed(By.xpath(Logins.getProperty("address")))) {
                System.out.println("Login Successful");
            }
        }
        catch (Exception e) {
        	System.out.println("Invalid Credentials");
        }
        }
    @DataProvider(name = "testdata")
    public Object[][] tdata() {
        return new Object[][] {
            {"jite201546","jite201547","or19"},
            {"jite201547","jite2015","or19"},
            {"jite201547","jite201547","or12"},
            {"jite2004","jite2020","o19"},
            {"","",""},
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
}
