package PomClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass extends BaseClass{

    public PageClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "twotabsearchtextbox")
    public WebElement TxtSearchBox;

    @FindBy(xpath = "(//*[.='Galaxy S25 Plus 5G (12GB RAM + 256GB Storage) Silver Shadow'])[1]")
    public WebElement lnkIphone;

    @FindBy(id="add-to-cart-button")
    public WebElement BtnAddToCart;

    @FindBy(id="nav-search-submit-button")
    public WebElement BtnSearch;

    @FindBy(id="productTitle")
    public WebElement txtTitle;

    public void searchProduct(){
        sendKeysOnElement(TxtSearchBox,"iphone");
        clickElement(BtnSearch);
    }

    public void selectProduct(){
        clickElement(lnkIphone);
        switchTabs();
    }

}
