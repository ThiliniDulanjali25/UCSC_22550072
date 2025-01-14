package TestCases;

import Base.BaseTest;
import Pages.FashionPage;
import Utils.TakeScreenShot;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckFashionPage extends BaseTest {
    @Test
    public void checkFashion() {
        FashionPage fashionPage = new FashionPage(driver);

        //Report Name
        setReportName("Test Case 2 - Check Fashion Page");
        startTest("Test Case 2 - Check Fashion Page");



        // Step 1: Navigate to Fashion page
        test = extent.createTest("Navigate to Fashion page", "Navigating to Fashion page");
        try {
            fashionPage.clickFashion();

            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ClickFashionTab");
            test.pass("Successfully clicked on Fashion Tab").addScreenCaptureFromPath(screenshotPath1);

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ClickFashionTabError");
            test.fail("Failed to click on Fashion Tab").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
        }



        // Step 2: Scroll down
        test = extent.createTest("Scroll down", "Scrolling down");
        try {
            //scrolling down the page
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo (0, document.body.scrollHeight);");

            String screenshotPath2 = TakeScreenShot.takeScreenshot(driver, "ScrollDown");
            test.pass("Successfully scrolled down").addScreenCaptureFromPath(screenshotPath2);

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath2 = TakeScreenShot.takeScreenshot(driver, "ScrollDownError");
            test.fail("Failed to scroll down").addScreenCaptureFromPath(screenshotPath2).fail(e.getMessage());
        }


        // Step 3: Navigate to Help
        test = extent.createTest("Navigate to Help", "Navigating to Help window");
        try {
            fashionPage.clickHelp();

            String screenshotPath3 = TakeScreenShot.takeScreenshot(driver, "ClickHelp");
            test.pass("Successfully clicked on Help").addScreenCaptureFromPath(screenshotPath3);

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath3 = TakeScreenShot.takeScreenshot(driver, "ClickClickHelpError");
            test.fail("Failed to click on Help").addScreenCaptureFromPath(screenshotPath3).fail(e.getMessage());
        }
}}
