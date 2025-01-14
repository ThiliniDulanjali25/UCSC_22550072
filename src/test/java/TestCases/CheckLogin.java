package TestCases;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.TakeScreenShot;
import org.testng.annotations.Test;

public class CheckLogin extends BaseTest {
    @Test
    public void signIn(){
        LoginPage loginPage = new LoginPage(driver);

        //Report Name
        setReportName("Test Case 1 - Sign In");
        startTest("Test Case 1 - Sign In");

        // Step 1: Click on Sign In Link
        test = extent.createTest("Navigate to Login page", "clicking on SignIn link");
        try {
            loginPage.clickSignInLink();

            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ClickSignIn");
            test.pass("Successfully clicked on SignIn").addScreenCaptureFromPath(screenshotPath1);

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "ClickSignInError");
            test.fail("Failed to click on SignIn").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
        }

        // Step 2: Enter username
                test = extent.createTest("Enter Username", "Typing username");
        try {
            loginPage.enterUsername(prop.getProperty("username"));

            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "EnterUsername");
            test.pass("Successfully entered the Username").addScreenCaptureFromPath(screenshotPath1);
            loginPage.clickContinue();

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "EnterUsernameError");
            test.fail("Failed to enter the Username").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
        }

        // Step 2: Enter password
        test = extent.createTest("Enter Password", "Typing password");
        try {
            loginPage.enterUsername(prop.getProperty("password"));

            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "EnterPassword");
            test.pass("Successfully entered the Password").addScreenCaptureFromPath(screenshotPath1);
            loginPage.clickSignIn();

        }catch (Exception e) {
            // Log the error and attach the screenshot to the Extent Report
            String screenshotPath1 = TakeScreenShot.takeScreenshot(driver, "EnterPasswordError");
            test.fail("Failed to enter the Password").addScreenCaptureFromPath(screenshotPath1).fail(e.getMessage());
        }


    }
}
