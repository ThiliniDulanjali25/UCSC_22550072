package TestCases;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SearchResultsPage;
import Utils.ExcelHandler;
import Utils.TakeScreenShot;
import org.testng.annotations.Test;

public class SearchItem extends BaseTest {
    @Test
    public void searchItem() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        // Initialize Excel Information
        String excelFilePath = prop.getProperty("excelFilePath");
        String sheetName = prop.getProperty("sheetName");

        // Initialize ExcelUtils
        ExcelHandler excel = new ExcelHandler(excelFilePath, sheetName);

        // Read data
        String searchItem = excel.getCellData(1, 1);

        //Report Name
        setReportName("Test Case 5 - Search an Item");
        startTest("Test Case 5 - Search an Item");

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
        excel.setCellData(1, 3, "Selected Item: " + itemDetails, excelFilePath);


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

        // Close workbook
        excel.closeWorkbook();

    }}
