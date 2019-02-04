package com.briteerp.pages;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by macik on 1/29/2019.
 */
public class HomePage extends BasePage{

    @FindBy(linkText = "Sign in")
    public WebElement signInBtn;

    @FindBy(linkText = "BriteErpDemo")
    public WebElement briteErpDemoLink;

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void open(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
}
