package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by macik on 1/29/2019.
 */
public class LoginPage {

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password){
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }
}
