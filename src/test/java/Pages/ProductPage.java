package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    // Locators
    @FindBy(xpath = "//*[@id=\"null\"]/div/span/span[1]/span")
    WebElement itemCondition;

//    @FindBy(id = "atcBtn_btn_1") // Add to Cart button
//    WebElement addToCartButton;
//
//    @FindBy(id = "watchBtn_btn_1") // Proceed to checkout button
//    WebElement addToWatchList;

    @FindBy(id = "binBtn_btn_1") // Proceed to Buy It Now
    WebElement buyItNow;


    // Constructor to initialize elements
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods Used in Products Page

    public String checkItemCondition(){
        String shippingText = itemCondition.getText();
        System.out.println("Shipping method: " + shippingText);
        return shippingText;
    }

    public void buyItNow() {
        buyItNow.click();
    }

//    public void addToCart() {
//        addToCartButton.click();
//    }
//
//    public void addToWatchList() {
//        addToWatchList.click();
//    }

}
