package com.briteerp.tests.functional_tests;

import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import com.mongodb.operation.BaseWriteOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ProductsPageTest extends TestBase {


    // Mehmet Acikgoz - BRIT-854
    @Test
    public void validProductsPageTitle(){
        extentLogger = report.createTest("Page Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the products link");
        pages.pointOfSale().productsLink.click();
        BrowserUtils.wait(10);

        extentLogger.info("Verify that page title contains “Products - Odoo");
        String message =  Driver.getDriver().getTitle();
        Assert.assertEquals(message, ApplicationConstants.PRODUCTS_PAGE_TITLE);

        extentLogger.pass("Completed: Page Title Test");
    }


//    Mehmet Acikgoz - BRIT-919
    @Test()
    public void hasProductHaveNameAndPrice(){
        extentLogger = report.createTest("Product has name and price");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the products link");
        pages.pointOfSale().productsLink.click();
        BrowserUtils.wait(5);


        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Verify that the selected product " + productName + "has a name" );
        Assert.assertFalse(productName.isEmpty());

        extentLogger.info("Verify that the selected product " + productName + "has a price" );
        String price = pages.products().getPrice(productName);
        Assert.assertFalse(price.isEmpty());

        extentLogger.info("Completed: Product has name and price");
    }

//    Mehmet Acikgoz - BRIT-925
    @Test
    public void hasProductWithThumbnailPictureHavePictureWhenClicked(){
        extentLogger = report.createTest("The Product which has a thumbnail picture has alos medium size Picture");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        extentLogger.info("Click on any product with a picture.");
        WebElement product;
        do {
            String productName = pages.products().selectAnyProduct();
            product = pages.products().selectProduct(productName);
//            System.out.println("test : " + pages.products().hasThumbnailPicture(product));
        } while ( !pages.products().hasThumbnailPicture(product) );
        product.click();

        extentLogger.info("Verify that product has a picture.");
        BrowserUtils.waitForVisibility(pages.products().detailsMediumImg, 30);
        Assert.assertTrue(pages.products().detailsMediumImg.isDisplayed() );

        extentLogger.pass("Completed: The Product which has a thumbnail picture has alos medium size Picture");
    }

    //    Mehmet Acikgoz - BRIT-929
    @Test
    public void checkProductPrice(){
        extentLogger = report.createTest("Product Price Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        extentLogger.info("Getting the price of " + productName);
        String expectedPrice = pages.products().getPrice(product);

        BrowserUtils.waitForClickablility(product, timeOutInSec);
        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);

        extentLogger.info("Verify that product price  is the same as previous page");
        assertEquals(pages.products().detailsGenInfSalesPrice.getText(),expectedPrice);

        extentLogger.pass("Completed: Product Price Test");
    }

//    Mehmet Acikgoz  - BRIT-932
    @Test
    public void isProductDisplayedWhenSearched(){
        extentLogger = report.createTest("Product is displayed when searched.");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        extentLogger.info("Select a product");
        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Type the name of a product into search box and hit ENTER.");
        pages.products().searchInput.sendKeys(productName + Keys.ENTER);

        extentLogger.info("Verify that the product is shown on the page.");
        BrowserUtils.wait(5);
        String availableProducts = BrowserUtils.getElementsText(pages.products().products).toString();
        System.out.println("availableProducts = " + availableProducts);

        extentLogger.pass("Completed : Product is displayed when searched.");
    }

//    Mehmet Acikgoz  - BRIT-934
    @Test
    public void canUserPutNotes(){
        extentLogger = report.createTest("User can put Notes on product");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        extentLogger.info("Click on any product");
        String productName = pages.products().selectAnyProduct();
        WebElement product = pages.products().selectProduct(productName);
        product.click();

        extentLogger.info(" Click on 'Log note' link");
        BrowserUtils.waitForClickablility(pages.products().detailsLogNoteTab, timeOutInSec);
        pages.products().detailsLogNoteTab.click();


        extentLogger.info("Write some notes and click on Log link.");
        BrowserUtils.wait(10);
        String noteToAdd = "CyberGhost team member updated at " + new Date().toString();
        pages.products().detailsLogNoteMessage.sendKeys(noteToAdd);
        pages.products().detailsLogNoteLogBtn.click();

        extentLogger.info("Verify that “Log note’’ is displayed on the page");
        BrowserUtils.wait(10);
        String submittedNotes = BrowserUtils.getElementsText(pages.products().detailsSubmittedNoteList).toString();

        Assert.assertTrue(submittedNotes.contains(noteToAdd));

        extentLogger.pass("Completed: User can put Notes on product");
    }


}
