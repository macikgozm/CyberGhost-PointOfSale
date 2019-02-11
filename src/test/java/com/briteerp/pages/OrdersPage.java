package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;
import java.util.Random;


public class OrdersPage extends BasePage {


    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public List<WebElement> OrderlistsNames;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement OrderlistNameHeader;

    @FindBy(xpath = "//input[contains(@id,'o_field_input')]")
    public WebElement selectableMenu;


    @FindBy(xpath = "(//a[contains(@id,'o_field_input')])[2]")
    public WebElement localhostLink;

    @FindBy(xpath = "//td[@class='o_list_record_selector']")
    public List<WebElement> OrdersNameCheckBoxes;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight']")
    public List<WebElement> payment;

    @FindBy(xpath = "//div//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement EditButton;

    ////a[contains(text(),'Extra Info')]

    @FindBy(xpath = "//button[@class='ç']")
    public WebElement actionButton;

    @FindBy(xpath = "//div[@class='o_notebook']//span[@name='order']")
    public WebElement orderinfo;

    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public WebElement selectOneofOrder;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public WebElement CheckDiscardButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement CheckSaveButton;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    public WebElement CheckProductTab;

    @FindBy(xpath = "//a[contains(text(),'Extra Info')]")
    public WebElement CheckExtraInfoTab;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight']")
    public WebElement CheckPayment;

    @FindBy(xpath = "//a[contains(text(),'Notes')]")
    public WebElement CheckNotes;

    public OrdersPage() {


        PageFactory.initElements(Driver.getDriver(), this);

    }

    public WebElement selectOrderlistName() {
        int rnd = new Random().nextInt(OrderlistsNames.size());
        WebElement orderlistName = OrderlistsNames.get(rnd);
        return orderlistName;
    }
    public WebElement selectAOrderNameCheckBox() {
        int rnd = new Random().nextInt(OrdersNameCheckBoxes.size());
        WebElement OrdersNameCheckBox = OrdersNameCheckBoxes.get(rnd);
        return OrdersNameCheckBox;
    }
}


