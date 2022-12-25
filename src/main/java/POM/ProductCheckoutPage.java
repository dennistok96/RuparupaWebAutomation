package POM;

import basepackage.BaseObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCheckoutPage extends BaseObject {
    private WebDriver driver;


    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(id = "user-password")
    private WebElement passwordTextField;

    @FindBy(id = "submit-btn")
    private WebElement signInBtn;

    @FindBy(id = "login-error-alert")
    private WebElement loginErrorMsg;

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(String email) {
        this.getEmailTextField().sendKeys(email);
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(String pass) {
        this.getPasswordTextField().sendKeys(pass);
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public void clickSignInBtn() {
        this.getSignInBtn().click();
    }

    public WebElement getLoginErrorMsg() {
        return loginErrorMsg;
    }

    public String getLoginErrorMsgText() {
        return this.getLoginErrorMsg().getText();
    }

    public ProductCheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);//initialize  all annotation
    }
}
