package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class SearchResultsPage {
    WebDriver driver;

    // Locator for the search item in the search results
    @FindBy(xpath = "//*[@id=\"item220ac16e18\"]/div/div[2]/a/div/span")
    WebElement searchItem;

    @FindBy(xpath = "//*[@id=\"item220ac16e18\"]/div/div[2]/div[4]/div[1]/div[1]/span")
    WebElement itemPrice;

    // Constructor to initialize elements
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method Used
    public void selectProduct() {

        String mainWindowHandle = driver.getWindowHandle();
        searchItem.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public String getItemDetails(){
        String itemDetails = searchItem.getText();
        System.out.println("Item condition: " + itemDetails);
        return itemDetails;
    }

    public double assertPrice (){
        String priceText = itemPrice.getText();
        System.out.println("Price of the first item: " + priceText);
        double actualPrice = Double.parseDouble(priceText.replace("$", "").replace(",", ""));
        System.out.println("Parsed Price: " + actualPrice);
        return actualPrice;
        }
    }

