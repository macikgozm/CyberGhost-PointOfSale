package com.briteerp.tests.smoke_tests;

import com.briteerp.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by macik on 1/29/2019.
 */
public class StartUpTests extends TestBase{


    private void getMeToPointOfSalesAs(String accessLevel){

        extentLogger.info("Open the homepage");
        pages.home().open();

        extentLogger.info("Open the Brite Erp App");
        pages.home().briteErpDemoLink.click();

        extentLogger.info("Logged in as " + accessLevel);

        if (accessLevel.equals("user"))
            pages.login().login(ConfigurationReader.getProperty("user-username"),
                ConfigurationReader.getProperty("user-password"));
        else
            pages.login().login(ConfigurationReader.getProperty("manager-username"),
                    ConfigurationReader.getProperty("manager-password"));


        extentLogger.info("Click on the Point of Sales page");
        BrowserUtils.waitForClickablility(pages.main().pointOfSaleLink, timeOutInSec);
        pages.main().pointOfSaleLink.click();

    }

    @Test
    public void checkProductPageHeader(){
        extentLogger = report.createTest("Product Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        BrowserUtils.wait(timeOutInSec);
        extentLogger.info("Verify that product page has the header " + ApplicationConstants.PRODUCTS_PAGE_HEADER );
        Assert.assertEquals(pages.products().tabTitle.getText(), ApplicationConstants.PRODUCTS_PAGE_HEADER);

        extentLogger.pass("Completed: Product Page Header Test");

    }

    @Test
    public void checkProductNameandPrice(){
        extentLogger = report.createTest("Product Name and Price Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        extentLogger.info("Getting the price of " + productName);
        String price = pages.products().getPrice(product);

        BrowserUtils.waitForClickablility(product, timeOutInSec);
        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);

        extentLogger.info("Verify that product name is the same as previous page");
        Assert.assertEquals(pages.products().productNameLabel.getText(), productName);

        extentLogger.info("Verify that product price  is the same as previous page");
        Assert.assertEquals(pages.products().productPriceLabel.getText(),price);

        extentLogger.pass("Completed: Product Name and Price Test");
    }

    @Test
    public void checkWhat(){
        extentLogger = report.createTest("Product Name and Price Test");
        getMeToPointOfSalesAs("manager");



    }


}
