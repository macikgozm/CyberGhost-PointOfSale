package com.briteerp.tests.smoke_tests;

import com.briteerp.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by macik on 1/29/2019.
 */
public class StartUpTests extends TestBase{

//    Mehmet Acikgoz
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

//    Mehmet Acikgoz
    @Test
    public void checkProductPageHeader(){
        extentLogger = report.createTest("Product Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that product page has the header " + ApplicationConstants.PRODUCTS_PAGE_HEADER );
        assertEquals(pages.products().tabTitle.getText(), ApplicationConstants.PRODUCTS_PAGE_HEADER);

        extentLogger.pass("Completed: Product Page Header Test");

    }

//    Mehmet Acikgoz
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
        assertEquals(pages.products().productNameLabel.getText(), productName);

        extentLogger.info("Verify that product price  is the same as previous page");
        assertEquals(pages.products().productPriceLabel.getText(),price);

        extentLogger.pass("Completed: Product Name and Price Test");
    }

<<<<<<< HEAD
//    Mehmet Keles
    @Test
    public void checkPricelistsPageHeader(){
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.PRICELISTS_PAGE_HEADER );
        assertEquals(pages.pricelist().tabTitle.getText(), ApplicationConstants.PRICELISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }



//    Mehmet Keles
    @Test
    public void checkPricelistNameHeader(){
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement=pages.pricelist().selectAPricelistName();
        String pricelistName =pricelistNameElement.getText();
        extentLogger.info("Selecting the Product randomly  : " + pricelistName);

        BrowserUtils.waitForClickablility(pricelistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        String pricelistNameOnHeader=pages.pricelist().pricelistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(pricelistNameOnHeader, pricelistName);

    }

//    Serkan Danisman
    @Test
    public void checkOrderlistsPageHeader(){
        extentLogger = report.createTest("Orderlists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orderlists");
        pages.pointOfSale().ordersLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.ORDERLISTS_PAGE_HEADER);
        assertEquals(pages.orders().tabTitle.getText(), ApplicationConstants.ORDERLISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }

//    Serkan Danisman
    @Test
    public void checkOrdersNameHeader(){
        extentLogger = report.createTest("Order Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the OrdersLists");
        pages.pointOfSale().ordersLink.click();

        WebElement OrdersNameElement=pages.orders().selectOrderlistName();
        String OrderlistName =OrdersNameElement.getText();
        extentLogger.info("Selecting the Order randomly  : " + OrderlistName);

        BrowserUtils.waitForClickablility(OrdersNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + OrderlistName);
        OrdersNameElement.click();

        String OrderlistNameHeader=pages.orders().OrderlistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(OrderlistNameHeader, OrderlistName);
    }

//    Yilmaz USTA
    @Test
    public void checkDescriptionForCustomersInNotes(){
        extentLogger = report.createTest("Description for Customers in Notes Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);

        extentLogger.info("Clicking on the Notes Tab");
        BrowserUtils.waitForClickablility(pages.products().NotesTab, timeOutInSec);
        pages.products().NotesTab.click();

        extentLogger.info("Verify that user can see Description for Customer in Notes tab.");
        Assert.assertEquals(pages.products().descriptionForCustomer.getText(), "Description for Customers");
        extentLogger.pass("Completed: Description for Customers in Notes Test");

    }

//    Yilmaz USTA
    @Test
    public void checkDescriptionForInternalInNotes(){
        extentLogger = report.createTest("Description for Internal in Notes Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);

        extentLogger.info("Clicking on the Notes Tab");
        BrowserUtils.waitForClickablility(pages.products().NotesTab, timeOutInSec);
        pages.products().NotesTab.click();

        extentLogger.info("Verify that user can see Description for Internal in Notes tab.");
        WebElement element = pages.products().descriptionForInternal;
        BrowserUtils.waitForVisibility(element, timeOutInSec);
        Assert.assertEquals(element.getText(), "Description for Internal");
        extentLogger.pass("Completed: Description for Internal in Notes Test");
    }



||||||| merged common ancestors
=======
    @Test
    public void checkPricelistsPageHeader(){
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.PRICELISTS_PAGE_HEADER );
        assertEquals(pages.pricelist().tabTitle.getText(), ApplicationConstants.PRICELISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }




    @Test
    public void checkPricelistNameHeader(){
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement=pages.pricelist().selectAPricelistName();
        String pricelistName =pricelistNameElement.getText();
        extentLogger.info("Selecting the Product randomly  : " + pricelistName);

        BrowserUtils.waitForClickablility(pricelistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        String pricelistNameOnHeader=pages.pricelist().pricelistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(pricelistNameOnHeader, pricelistName);

    }

    @Test
    public void checkOrderlistsPageHeader(){
        extentLogger = report.createTest("Orderlists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orderlists");
        pages.pointOfSale().ordersLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.ORDERLISTS_PAGE_HEADER);
        assertEquals(pages.orders().tabTitle.getText(), ApplicationConstants.ORDERLISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }
    @Test
    public void checkOrdersNameHeader(){
        extentLogger = report.createTest("Order Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the OrdersLists");
        pages.pointOfSale().ordersLink.click();

        WebElement OrdersNameElement=pages.orders().selectOrderlistName();
        String OrderlistName =OrdersNameElement.getText();
        extentLogger.info("Selecting the Order randomly  : " + OrderlistName);

        BrowserUtils.waitForClickablility(OrdersNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + OrderlistName);
        OrdersNameElement.click();

        String OrderlistNameHeader=pages.orders().OrderlistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(OrderlistNameHeader, OrderlistName);
    }


    @Test
    public void checkDescriptionForCustomersInNotes(){

        extentLogger = report.createTest("Description for Customers in Notes Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();
        pages.products().ProductClick.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting  a random product:" + productName);
        WebElement product = pages.products().selectProduct(productName);


        BrowserUtils.waitForClickablility(product, timeOutInSec);
        //  extentLogger.info("Clicking on the " + productName);

        //   System.out.println("Clicking on the " + productName);
        //  pages.products().clickOnProduct(product);
        //   extentLogger.info("random product " + productName + " clicked");

        //   System.out.println("random product " + productName + " clicked");


        BrowserUtils.waitForClickablility(pages.products().NotesTab, timeOutInSec);
        extentLogger.info("Clicking on the Notes Tab");
        pages.products().NotesTab.click();
        //  extentLogger.info(productName + " of Notes tab clicked");


        extentLogger.info("Verify that user can see Description for Customer in Notes tab.");
        Assert.assertEquals(pages.products().descriptionForCustomer.getText(), "Description for Customers");
        extentLogger.pass("Completed: Description for Customers in Notes Test");
    }

    @Test
    public void checkDescriptionForInternalInNotes(){
        extentLogger = report.createTest("Description for Internal in Notes Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();
        pages.products().ProductClick.click();
        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting  a random product:" + productName);
        WebElement product = pages.products().selectProduct(productName);


        BrowserUtils.waitForClickablility(product, timeOutInSec);
        //  extentLogger.info("Clicking on the " + productName);

        //   System.out.println("Clicking on the " + productName);
        //  pages.products().clickOnProduct(product);
        //   extentLogger.info("random product " + productName + " clicked");

        //   System.out.println("random product " + productName + " clicked");


        BrowserUtils.waitForClickablility(pages.products().NotesTab, timeOutInSec);
        extentLogger.info("Clicking on the Notes Tab");
        pages.products().NotesTab.click();
        //  extentLogger.info(productName + " of Notes tab clicked");

        extentLogger.info("Verify that user can see Description for Internal in Notes tab.");
        Assert.assertEquals(pages.products().descriptionForInternal.getText(), "Description for Internal");
        extentLogger.pass("Completed: Description for Internal in Notes Test");
    }


    @Test
    public void sessions1(){

    }
>>>>>>> refs/remotes/origin/master

}
