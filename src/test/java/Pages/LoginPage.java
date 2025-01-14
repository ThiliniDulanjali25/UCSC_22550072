package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Locators
    @FindBy(xpath = "//*[@id=\"gh-ug\"]/a")
    WebElement signInLink;

    @FindBy(xpath = "//*[@id=\"signin-form\"]/div/div[1]/div/div[1]/div/div/div")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"signin-continue-btn\"]")
    WebElement btnContinue;

    @FindBy(xpath = "//*[@id=\"signin-form\"]/div/div[2]/div/div[2]/div/div")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"sgnBt\"]")
    WebElement btnSignIn;

    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods Used in Login Page
    public void clickSignInLink(){
        signInLink.click();
    }

    public void enterUsername(String Username){
        username.sendKeys(Username);
    }

    public void enterPassword(String Password){
        password.sendKeys(Password);
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public void clickSignIn(){
        btnSignIn.click();
    }

}

