package TestCases;

import Base.BaseTest;
import Pages.HomePage;
import Utils.TakeScreenShot;
import org.testng.annotations.Test;

public class CheckCart extends BaseTest {
    @Test
    public void checkCart() {
        HomePage homePage = new HomePage(driver);

        //Report Name
        setReportName("Test Case 4 - Check the Cart");
        startTest("Test Case 4 - Check the Cart");

        // Step 1: Click Cart
        test = extent.createTest("Check Cart", "Checking the Cart");
        try {
            homePage.clickCart();

            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ClickCart");
            test.pass("Successfully clicked on cart icon").addScreenCaptureFromPath(screenshotPath1);

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ClickCartError");
            test.fail("Failed to click on cart icon").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
        }
}}
