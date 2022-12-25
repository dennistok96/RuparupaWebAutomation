package POM;

import basepackage.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseObject {
    private WebDriver driver;

    public WebElement getKategoryByName(String kategoryName){
        return driver.findElement(By.xpath("//div[@class='category-text category-text__ruparupa ui-text-3'][text()='"+kategoryName+"']"));
    }
    public void clickKategoryByName(String kategoryName){
        this.getKategoryByName(kategoryName).click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);//initialize  all annotation
    }
}
