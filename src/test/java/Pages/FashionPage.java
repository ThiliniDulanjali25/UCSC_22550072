package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FashionPage {
    WebDriver driver;

    // Locators
    @FindBy(xpath = "//*[@id=\"vl-flyout-nav\"]/ul/li[5]/a")
    WebElement fashion;

    @FindBy(xpath = "//*[@id=\"ifhItem0\"]")
    WebElement help;

    @FindBy(xpath = "//*[@id=\"ifhOverlayTitle\"]")
    WebElement helpWindow;

    // Constructor to initialize elements
    public FashionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void clickFashion() {
        fashion.click();
    }
    public void clickHelp() {
        help.click();
    }


}
