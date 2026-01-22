package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Baseclass {

    protected AndroidDriver thisdriver;
    protected AppiumDriver driver;
    private Properties prop;
    public static Properties Logins;
    public static Properties Loc;
    public static Properties Loc1;
    public static Properties EDPU;
    public static Properties Delivery_address;
    public static Properties Registration;
    public static Properties FarmerRegistration;

    // Extent Report
    public static ExtentReports extent;
    public static ExtentTest test;

    private String reportPath;

    @BeforeMethod
    public void setUp(Method method) throws IOException {

        /* ================== EXTENT REPORT SETUP ================== */
        String testName = method.getName();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

        new File(System.getProperty("user.dir") + "/reports").mkdirs();
        new File(System.getProperty("user.dir") + "/screenshots").mkdirs();

        reportPath = System.getProperty("user.dir") + "/reports/" + testName + "_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Test Case : " + testName);
        spark.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Bechan Shukla");
        extent.setSystemInfo("Environment", "QA");

        test = extent.createTest(testName);

        /* ================== LOAD CONFIG ================== */
        prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/config/config.properties"));

        /* ================== LOAD LOCATORS ================== */
        Logins = new Properties();
        Logins.load(new FileInputStream("src/test/resources/locators/loginlocators.txt"));

        Loc = new Properties();
        Loc.load(new FileInputStream("src/test/resources/locators/dashboard.txt"));

        EDPU = new Properties();
        EDPU.load(new FileInputStream("src/test/resources/locators/edpu.txt"));

        Delivery_address = new Properties();
        Delivery_address.load(new FileInputStream("src/test/resources/locators/delivery_address.txt"));
        //For Registration 
        Registration=new Properties();
        Registration.load(new FileInputStream("src/test/resources/locators/farmer_Registration.txt"));
        //farmer_Registration_new_ui
        FarmerRegistration=new Properties();
        FarmerRegistration.load(new FileInputStream("src/test/resources/locators/farmer_registration_new_ui.txt"));
        //for Milk Testing Transporter
        Loc1=new Properties();
        Loc1.load(new FileInputStream("src/test/resources/locators/milk_testing_for_transporter.txt"));
        
        

        /* ================== DESIRED CAPABILITIES ================== */
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.getProperty("platformName"));
        caps.setCapability("appium:automationName", prop.getProperty("automationName"));
        caps.setCapability("appium:deviceName", prop.getProperty("deviceName"));
        caps.setCapability("appium:app", prop.getProperty("app"));
        caps.setCapability("appium:newCommandTimeout", 3000);
        caps.setCapability("appium:endSessionWaitTimeout", 900);
        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:dontStopAppOnReset", true);

        try {
            URL appiumServerUrl = new URL(prop.getProperty("serverurl"));
            driver = new AndroidDriver(appiumServerUrl, caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
            test.pass("Appium Driver initialized successfully");
        } catch (Exception e) {
            test.fail("Driver initialization failed : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /* ================== AFTER METHOD ================== */
    @AfterMethod
    public void tearDown(ITestResult result) {

        String screenshotPath = captureScreenshot(result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed");
            test.fail(result.getThrowable());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }

        if (driver != null) {
            driver.quit();
            test.info("Application Closed");
        }

        extent.flush();
    }

    /* ================== SCREENSHOT METHOD ================== */
    public String captureScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (IOException e) {
            test.warning("Screenshot failed : " + e.getMessage());
            return null;
        }
    }
}
