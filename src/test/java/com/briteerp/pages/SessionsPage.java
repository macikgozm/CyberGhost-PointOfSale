package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionsPage extends BasePage {
    public SessionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tbody//tr/td[2]")
    public WebElement tysonsCorner;

    @FindBy (id = "o_field_input_487")
    public WebElement POSUser3;


}
