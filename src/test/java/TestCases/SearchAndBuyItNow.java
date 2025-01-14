package TestCases;

import Base.BaseTest;
import Utils.ExcelHandler;
import Utils.TakeScreenShot;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SearchResultsPage;
import Pages.ProductPage;

public class SearchAndBuyItNow extends BaseTest {

    @Test
    public void searchAndBuyItem() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        // Initialize Excel Information
        String excelFilePath = prop.getProperty("excelFilePath");
        String sheetName = prop.getProperty("sheetName");

        // Initialize ExcelUtils
        ExcelHandler excel = new ExcelHandler(excelFilePath, sheetName);

        // Read data
        String searchItem = excel.getCellData(3, 1);
        String expectedValue = excel.getCellData(3, 2);

        //Report Name
        setReportName("Test Case 3 - Purchase an Item");
        startTest("Test Case 3 - Purchase an Item");

        // Step 1: Search for Item
        test = extent.createTest("Search the item", "System searched for given item");
        try {
            homePage.searchFor(searchItem);

            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ItemSearch");
            test.pass("Successfully searched and displaying " + searchItem).addScreenCaptureFromPath(screenshotPath1);

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ItemSearchError");
            test.fail("Failed to search the given item").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
        }

        // Write data back to the Excel file
        String itemDetails = searchResultsPage.getItemDetails();
        excel.setCellData(3, 3, "Selected Item: " + itemDetails, excelFilePath);


        // Step 2: Select the item
        test = extent.createTest("Select the Item", "System selecting the item");
        try {
            searchResultsPage.selectProduct();

            String screenshotPath2 = TakeScreenShot.takeScreenshot(driver, "SelectedItem");
            test.pass("Successfully selected the item " + itemDetails).addScreenCaptureFromPath(screenshotPath2);

        } catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath2 = TakeScreenShot.takeScreenshot(driver, "SelectedItemError");
            test.fail("Failed to select the item").addScreenCaptureFromPath(screenshotPath2).fail(e.getMessage());
        }


        // Step 3: Assertion comparison
        String actualValue = productPage.checkItemCondition();
        test = extent.createTest("Compare the item condition", "Item condition is comparing");

        try {
            Assert.assertEquals(actualValue,expectedValue, "Compared actual condition with expected condition. ");

            String screenshotPath3 = TakeScreenShot.takeScreenshot(driver, "Comparison");
            test.pass( "Assertion comparison successful.").addScreenCaptureFromPath(screenshotPath3);
        } catch (AssertionError e) {
            // Capture screenshot on failure
            String screenshotPath3 = TakeScreenShot.takeScreenshot(driver, "ComparisonError");
            test.fail("Assertion failed: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath3);
            throw e; // Rethrow to terminate the test
        }



        // Step 4: Proceed to Buy It Now
        test = extent.createTest("Click on Buy It Now", "System clicking on Buy It Now button");
        try {
            productPage.buyItNow();

            String screenshotPath4 = TakeScreenShot.takeScreenshot(driver, "BuyItNow");
            test.pass("Successfully clicked on Buy It Now").addScreenCaptureFromPath(screenshotPath4);
        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath4 = TakeScreenShot.takeScreenshot(driver, "BuyItNowError");
            test.fail("Failed to click on Buy It Now").addScreenCaptureFromPath(screenshotPath4).fail(e.getMessage());
        }



        // Close workbook
        excel.closeWorkbook();
    }


}
