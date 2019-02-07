package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

/**
 * Created by macik on 1/29/2019.
 */
public class PricelistPage extends BasePage{

    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public List<WebElement> pricelistsNames;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement pricelistNameHeader;

    @FindBy(xpath = "//input[contains(@id,'o_field_input')]")
    public WebElement selectableMenu;

    public PricelistPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement selectAPricelistName(){
        int rnd = new Random().nextInt( pricelistsNames.size() );
        WebElement pricelistName = pricelistsNames.get(rnd);
        return pricelistName;
    }
}
