package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "gh-ac") // Search input field
    WebElement searchBox;

    @FindBy(id = "gh-search-btn") // Search button
    WebElement searchButton;

    @FindBy(id = "//*[@id=\"gh-minicart-hover\"]") // Search button
    WebElement cartIcon;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void searchFor(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    public void clickCart() {
        cartIcon.click();
    }
}
