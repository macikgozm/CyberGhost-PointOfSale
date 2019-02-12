package com.briteerp.pages;

import com.briteerp.utilities.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class SessionsPage extends BasePage {

    //a[@name='user_id']
    @FindBy(name = "user_id")
    public WebElement userIDField;




    public SessionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(text(),'Tysons')]//parent::tr/td)[2]")
    public WebElement tysonsCorner;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(text(),'Whole')]//parent::tr/td)[7]")
    public WebElement wholeFoodsStoreStatus;

    @FindBy(xpath = "(//tbody[@class='ui-sortable']//td[contains(text(),'Main')]//parent::tr/td)[7]")
    public WebElement mainFoodsStoreStatus;

    @FindBy (name = "user_id")
    public WebElement POSUser3;

    @FindBy (xpath =  "//span[@name='start_at']\n")
    public WebElement openingDate;

    @FindBy (xpath =  "//thead//th[2]")
    public WebElement tHead1;

    @FindBy (xpath =  "//thead//th[1]")
    public WebElement allclick;

    @FindBy (xpath =  "//tbody//tr//td[4]")
    public WebElement zaram;

    @FindBy (xpath =  "//tbody//tr//td[3]")
    public WebElement zId;




    public WebElement getStore(String storeName){
        //tbody[@class='ui-sortable']//td[contains(text(),'Tysons corner mall')]
        String beforeXpath = "//tbody[@class='ui-sortable']//td[contains(text(),'";
        String afterXpath = "')]";
        String xpath = beforeXpath + storeName + afterXpath;

        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));

        return element;
    }


    /*public WebElement getStatus(String storeName){

        (//tbody[@class='ui-sortable']//td[contains(text(),'Sena')]//parent::tr/td)[7]

        String bxpath = "(//tbody[@class='ui-sortable']//td[contains(text(),'";
        String afterXpath = "')]//parent::tr/td)[7]";
        String xpath = bxpath + storeName + afterXpath;

        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));

        return element;
    }
*/







}
