package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

/**
 * Created by macik on 1/29/2019.
 */
public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[@class='oe_kanban_global_click o_kanban_record']")
    public List<WebElement> products;

    @FindBy(xpath = "//div[@class='oe_title']//span[@name='name']")
    public WebElement productNameLabel;

    @FindBy(xpath = "//div[@class='o_notebook']//span[@name='list_price']")
    public WebElement productPriceLabel;

    @FindBy(xpath = "//a[text()='Notes']")
    public WebElement NotesTab;

    @FindBy(xpath = "//div[text()='Description for Customers']")
    public WebElement descriptionForCustomer;

    @FindBy(xpath = "//div[text()='Description for Internal']")
    public WebElement descriptionForInternal;

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String selectAnyProduct(){
        int rnd = new Random().nextInt( products.size() );
        WebElement element = products.get(rnd).findElement(By.className("o_kanban_record_title"));
        BrowserUtils.waitForVisibility(element, timeOutInSec);
//        String productName = element.getText().trim();
        String productName = products.get(rnd).findElement(By.cssSelector("strong[class='o_kanban_record_title']>span")).getText();

        return productName;
    }


    public void clickOnProduct(WebElement product){
        BrowserUtils.waitForClickablility(product, timeOutInSec);
        product.click();
    }

    public String getPrice(WebElement product){
        WebElement price = product.findElement(
                           By.xpath("..//following-sibling::ul//span[@name='lst_price']"));
        return price.getText();
    }

    public WebElement selectProduct(String productname){
        String beforeXpath = "//*[text() ='";
        String afterXpath = "']";
        String xpath = beforeXpath + productname + afterXpath;
        return  Driver.getDriver().findElement(By.xpath(xpath));
    }
}
