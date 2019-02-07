package com.briteerp.tests.functional_tests;

import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;

public class ProductsPageTest extends TestBase {

    // Mehmet Acikgoz - BRIT-854
<<<<<<< HEAD
    @Test
    public void validProductsPageTitle() {
=======
    @Test (priority = 1)
    public void validProductsPageTitle(){
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        extentLogger = report.createTest("Page Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the products link");
        pages.pointOfSale().productsLink.click();

<<<<<<< HEAD
        extentLogger.info("Verify that page title contains “Products - Odoo");
        String message = Driver.getDriver().getTitle();
=======
        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle,
                                                       ApplicationConstants.PRODUCTS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Verify that page title "+ ApplicationConstants.PRODUCTS_PAGE_TITLE);
        String message =  Driver.getDriver().getTitle();
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        Assert.assertEquals(message, ApplicationConstants.PRODUCTS_PAGE_TITLE);

        extentLogger.pass("Completed: Page Title Test");
    }


<<<<<<< HEAD
    //    Mehmet Acikgoz - BRIT-919
    @Test()
    public void hasProductHaveNameAndPrice() {
=======
//    Mehmet Acikgoz - BRIT-919
    @Test (priority = 2)
    public void hasProductHaveNameAndPrice(){
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        extentLogger = report.createTest("Product has name and price");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the products link");
        pages.pointOfSale().productsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle,
                                                       ApplicationConstants.PRODUCTS_PAGE_HEADER, timeOutInSec);

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Verify that the selected product " + productName + "has a name");
        Assert.assertFalse(productName.isEmpty());

        extentLogger.info("Verify that the selected product " + productName + "has a price");
        String price = pages.products().getPrice(productName);
        Assert.assertFalse(price.isEmpty());

        extentLogger.info("Completed: Product has name and price");
    }

<<<<<<< HEAD
    //    Mehmet Acikgoz - BRIT-925
    @Test
    public void hasProductWithThumbnailPictureHavePictureWhenClicked() {
=======
//    Mehmet Acikgoz - BRIT-925
    @Test (priority = 3)
    public void hasProductWithThumbnailPictureHavePictureWhenClicked(){
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        extentLogger = report.createTest("The Product which has a thumbnail picture has alos medium size Picture");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        extentLogger.info("Click on any product with a picture.");
        WebElement product;
        String productName;
        do {
            productName = pages.products().selectAnyProduct();
            product = pages.products().selectProduct(productName);
//            System.out.println("test : " + pages.products().hasThumbnailPicture(product));
<<<<<<< HEAD
        } while (!pages.products().hasThumbnailPicture(product));
=======
        } while ( !pages.products().hasThumbnailPicture(product) );
        extentLogger.info("Click on " + productName);
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        product.click();

        extentLogger.info("Verify that product has a picture.");
        BrowserUtils.waitForVisibility(pages.products().detailsMediumImg, 30);
<<<<<<< HEAD
        Assert.assertTrue(pages.products().detailsMediumImg.isDisplayed());
=======
        BrowserUtils.scrollToElement(pages.products().detailsMediumImg);
        Assert.assertTrue(pages.products().detailsMediumImg.isDisplayed() );
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a

        extentLogger.pass("Completed: The Product which has a thumbnail picture has alos medium size Picture");
    }

    //    Mehmet Acikgoz - BRIT-929
<<<<<<< HEAD
    @Test
    public void checkProductPrice() {
=======
    @Test (priority = 4)
    public void checkProductPrice(){
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
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
<<<<<<< HEAD
        assertEquals(pages.products().detailsGenInfSalesPrice.getText(), expectedPrice);
=======
        Assert.assertEquals(pages.products().detailsGenInfSalesPrice.getText(),expectedPrice);
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a

        extentLogger.pass("Completed: Product Price Test");
    }

<<<<<<< HEAD
    //    Mehmet Acikgoz  - BRIT-932
    @Test
    public void isProductDisplayedWhenSearched() {
=======
//    Mehmet Acikgoz  - BRIT-932
    @Test (priority = 5)
    public void isProductDisplayedWhenSearched(){
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        extentLogger = report.createTest("Product is displayed when searched.");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        extentLogger.info("Select a product");
        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Type " + productName + " into search box and hit ENTER.");
        pages.products().searchInput.sendKeys(productName + Keys.ENTER);

        extentLogger.info("Verify that the product is shown on the page.");
        BrowserUtils.hover(pages.products().selectProduct(productName));
        Assert.assertTrue(pages.products().products.size() > 0);
        extentLogger.pass("Completed : Product is displayed when searched.");
    }

<<<<<<< HEAD
    //    Mehmet Acikgoz  - BRIT-934
    @Test
    public void canUserPutNotes() {
=======
//    Mehmet Acikgoz  - BRIT-934
    @Test (priority = 6)
    public void canUserPutNotes(){
>>>>>>> e53ee4b6b10c03fe2d6fefb1fe5df5864426c10a
        extentLogger = report.createTest("User can put Notes on product");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Click on " + productName);
        WebElement product = pages.products().selectProduct(productName);
        product.click();

        extentLogger.info(" Click on 'Log note' link");
        BrowserUtils.waitForClickablility(pages.products().detailsLogNoteTab, timeOutInSec);
        pages.products().detailsLogNoteTab.click();


        extentLogger.info("Write some notes and click on Log link.");
        BrowserUtils.waitForVisibility(pages.products().detailsLogNoteLogBtn, timeOutInSec);
        String noteToAdd = "CyberGhost team member updated at " + new Date().toString();
        pages.products().detailsLogNoteMessage.sendKeys(noteToAdd);
        pages.products().detailsLogNoteLogBtn.click();

        extentLogger.info("Verify that “Log note’’ is displayed on the page");
        BrowserUtils.wait(3);
        String submittedNotes = BrowserUtils.getElementsText(pages.products().detailsSubmittedNoteList).toString();
        Assert.assertTrue(submittedNotes.contains(noteToAdd));

        extentLogger.pass("Completed: User can put Notes on product");
    }

//    Mehmet Acikgoz - BRIT-938
    @Test (priority = 7)
    public void isCostLessThanSalesPrice(){
        extentLogger = report.createTest("The cost of a product is less than the sales price.");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Click on " + productName);
        WebElement product = pages.products().selectProduct(productName);
        product.click();

        BrowserUtils.waitForVisibility(pages.products().detailsGenInfSalesPrice, timeOutInSec);
        extentLogger.info("Verify that cost is less than sales price");
        String priceStr = pages.products().detailsGenInfSalesPrice.getText().trim().substring(1)
                                          .trim().replace(",","");
        double price = Double.parseDouble(priceStr);

        String costStr = pages.products().detailsGenInfCost.getText().trim().substring(1)
                                                           .trim().replace(",","");
        double cost = Double.parseDouble(costStr);

        Assert.assertTrue(price >= cost);

        extentLogger.pass("Completed: The cost of a product is less than the sales price.");
    }

//    Mehmet Acikgoz- BRIT-941
    @Test (priority = 8)
    public void IsProductNameSeenAtTheTop(){
        extentLogger = report.createTest("Product name is seen at the top of the page");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Click on " + productName);
        WebElement product = pages.products().selectProduct(productName);
        product.click();

        extentLogger.info("Verify that the name of the product is displayed on the top of the page.");
        BrowserUtils.waitForVisibility(pages.products().detailsGenInfSalesPrice, timeOutInSec);
        String productNameAtTheTop = pages.products().detailsProductNameAtTheTop.getText().trim();
        Assert.assertTrue(productNameAtTheTop.contains(productName));

        extentLogger.pass ("Product name is seen at the top of the page");
    }


//    Mehmet Acikgoz - BRIT 1861
    @Test (priority = 9)
    public void canManagerUpdateTheSalesPrice(){
        extentLogger = report.createTest("Manager can update the sales price of the product.");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Click on " + productName);
        WebElement product = pages.products().selectProduct(productName);
        product.click();

        extentLogger.info(" Click the Edit button on the left top corner of the menu.");
        pages.products().detailsEditBtn.click();

        extentLogger.info("Change the sales price");
        WebElement element = pages.products().detailsEditSalesPriceInput;
        String priceStr = element.getAttribute("value").replace(",","").replace(",","");
        element.clear();
        double price = Double.parseDouble(priceStr);
        String newPriceStr = "" + (price+1);

        element.sendKeys(newPriceStr);
        BrowserUtils.waitUntilTextToBePresentInElementValue(element, newPriceStr, timeOutInSec);

        extentLogger.info("Click on the Save button");
        pages.products().detailsSaveBtn.click();

        extentLogger.info("Verify that sales price is changed.");
        BrowserUtils.waitForVisibility(pages.products().detailsGenInfSalesPrice, timeOutInSec);
        String actualValue = pages.products().detailsGenInfSalesPrice.getText().trim().substring(1).trim();
        Assert.assertEquals(Double.parseDouble(actualValue), Double.parseDouble(newPriceStr), 0.001);

        extentLogger.pass("Manager can update the sales price of the product");
    }


}
