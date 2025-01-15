package TestCases;

import Base.BaseTest;
import Pages.ProductPage;
import Utils.TakeScreenShot;
import org.testng.annotations.Test;

public class BuyItem extends BaseTest {

    @Test
    public void searchItem() {
    ProductPage productPage = new ProductPage(driver);

    //Report Name
    setReportName("Test Case 6 - Purchase an Item");
    startTest("Test Case 6 - Purchase an Item");


    // Step 1: Proceed to Buy It Now
    test = extent.createTest("Click on Buy It Now", "System clicking on Buy It Now button");
        try {
        productPage.buyItNow();

        String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "BuyItNow");
        test.pass("Successfully clicked on Buy It Now").addScreenCaptureFromPath(screenshotPath1);
    }catch (Exception e) {
        // Log the error and attach the screenshot to the Extent Report
        String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "BuyItNowError");
        test.fail("Failed to click on Buy It Now").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
    }

    }
}
