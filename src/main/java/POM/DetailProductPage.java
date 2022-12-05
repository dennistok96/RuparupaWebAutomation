package POM;

import basepackage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailProductPage extends Base {
    private WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn-m kredivo__coachmark-close-button']")
    private WebElement cicilanPopupBtn;

    @FindBy(xpath = "//div[@class='form-button']/button")
    private WebElement tambahKeKeranjangBtn;

    @FindBy(xpath = "//div[@class='added-to-cart']/button[@class='btn btn-primary btn-cart bold']")
    private WebElement lanjutKeKeranjangBtn;

    public WebElement getLanjutKeKeranjangBtn() {
        return lanjutKeKeranjangBtn;
    }

    public void clickLanjutKeKeranjangBtn(){
        this.getLanjutKeKeranjangBtn().click();
    }

    public WebElement getTambahKeKeranjangBtn() {
        return tambahKeKeranjangBtn;
    }

    public WebElement getCicilanPopupBtn() {
        return cicilanPopupBtn;
    }

    public void clickCicilanPopupBtn(){
        this.getCicilanPopupBtn().click();
    }

    public void clickTambahKeKeranjangBtn(){
        this.getTambahKeKeranjangBtn().click();
    }


    public DetailProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);//initialize  all annotation
    }
}
