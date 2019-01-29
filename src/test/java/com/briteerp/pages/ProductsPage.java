package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by macik on 1/29/2019.
 */
public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
