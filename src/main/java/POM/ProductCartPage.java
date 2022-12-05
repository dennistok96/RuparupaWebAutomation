package POM;

import basepackage.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCartPage extends Base {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='joyride-tooltip__buttons']/button")
    private WebElement catatanPopupBtn;


    @FindBy(xpath = "//button[@class='btn btn-m btn-primary btn-full btn-payment']")
    private WebElement lanjutKePembayaranBtn;


    public WebElement getLanjutKePembayaranBtn() {
        return lanjutKePembayaranBtn;
    }

    public void clickLanjutKePembayaranBtn() {
        this.getLanjutKePembayaranBtn().click();
    }

    public WebElement getCatatanPopupBtn() {
        return catatanPopupBtn;
    }

    public void clickCatatanPopupBtn() {
        this.getCatatanPopupBtn().click();
    }


    public ProductCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);//initialize  all annotation
    }
}
