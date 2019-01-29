package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by macik on 1/29/2019.
 */
public class MainPage {

    @FindBy(xpath = "//li//a//span[contains(text(),'Point of Sale')]")
    public WebElement pointOfSaleLink;

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
