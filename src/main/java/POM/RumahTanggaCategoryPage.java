package POM;

import basepackage.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RumahTanggaCategoryPage extends BaseObject {
    private WebDriver driver;

    @FindBy(id = "label-content-arrow")
    private WebElement promoList;

    public WebElement getPromoListByName(String promoName){
        return promoList.findElement(By.xpath("//label[text()='"+promoName+"']"));
    }


    public WebElement getHeaderByName(String name){
        return promoList.findElement(By.xpath("//h3[@class='card-subtitle' and text()='"+name+"']"));
    }


    public void scrollToTextElement(WebElement element){
        this.scrollToText(element);
    }

    public void clickPromoListByName(String promoName){
        WebElement element= this.getPromoListByName(promoName);
        element.click();
    }

    @FindBy(xpath = "//h3[@class='title' and text()='Urut Berdasarkan']")
    private WebElement urutLabel;

    @FindBy(xpath = "//select[@name='order']")
    private WebElement urutDropdown;


    public WebElement getUrutLabel(){
        return urutLabel;
    }

    public void clickUrutDropdown(){
        urutDropdown.click();
    }

    public WebElement getUrutListByName(String sortedName){
       return  urutDropdown.findElement(By.xpath("//option[text()='"+sortedName+"']"));
    }

    public void clickUrutListByName(String sortedName){
        Select dropdown= new Select(urutDropdown);
        dropdown.selectByVisibleText(sortedName);

    }

    public WebElement getProductByIndex(int index){
        return driver.findElement(By.xpath("(//div[@class='product-container  '])["+index+"]"));
    }

    public void clickFirstProduct(){
        WebElement element= this.getProductByIndex(1);
        element.click();
    }

    @FindBy(xpath = "(//div[@class='promotion'])[1]")
    private WebElement promotionTagLabelFirstProduct;


    public WebElement  getPromotionTagLabelFirstProduct(){
        return promotionTagLabelFirstProduct;
    }

    public RumahTanggaCategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);//initialize  all annotation
    }




}
