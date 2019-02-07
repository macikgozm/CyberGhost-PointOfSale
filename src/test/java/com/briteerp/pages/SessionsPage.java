package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class SessionsPage extends BasePage {
    public SessionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
