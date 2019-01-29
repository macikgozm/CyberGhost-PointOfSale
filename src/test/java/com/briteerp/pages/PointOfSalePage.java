package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by macik on 1/29/2019.
 */
public class PointOfSalePage extends BasePage{

    public PointOfSalePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
