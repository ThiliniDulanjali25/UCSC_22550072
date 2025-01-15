package Base;

import Utils.TakeScreenShot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private String reportFileName;
    protected Properties prop;

    @BeforeSuite
    public void readConfig(){
        try {
            prop = new Properties();
            FileInputStream Config = new FileInputStream("C:/Users/asus/IdeaProjects/Assignment03_22550072/src/test/java/Config/Config.properties");
            prop.load(Config);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUp() {
        // Create a unique file name for the Extent Report
        String timestamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(new Date());
        reportFileName = "ExtentReport_" + timestamp + ".html"; // Default report name

        // Set up ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    /**
     * Set a custom name for the Extent Report.
     * @param customName The custom name for the report.
     */
    public void setReportName(String customName) {
        String timestamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(new Date());
        reportFileName = customName + "_" + timestamp + ".html";

        // Reinitialize ExtentSparkReporter with the new name
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    /**
     * Start a test in Extent Report with a given name.
     *
     * @param testName Name of the test case.
     */
    public void startTest(String testName) {
        test = extent.createTest(testName);
    }

    @BeforeClass
    public void setUpBrowser() {
        String browserName = prop.getProperty("browserType");
        String url = prop.getProperty("url");
        int maxWait = Integer.parseInt(prop.getProperty("maxWait"));

        if(browserName.equals("chrome")){
//            driver = new ChromeDriver();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
            driver = new ChromeDriver(chromeOptions);

        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }else{
            System.out.println("Invalid browser name");
            return;
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxWait));



    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakeScreenShot.takeScreenshot(driver, result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();

    }

}