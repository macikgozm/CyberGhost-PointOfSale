package com.briteerp.tests.functional_tests;

import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderlistsPageTest extends TestBase {
    @Test
    public void checkOrderslistsPageHeader() {
        extentLogger = report.createTest("Orderslists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orderslists");
        pages.pointOfSale().ordersLink.click();

        BrowserUtils.wait(5);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.ORDERLISTS_PAGE_HEADER);
        assertEquals(pages.pricelist().tabTitle.getText(), ApplicationConstants.ORDERLISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Orderslists Page Header Test");

    }

    // Serkan Danisman 2- BRIT-695
    @Test
    public void checkOrderslistsPageTitle() {
        extentLogger = report.createTest("Orderlist Page Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orderlists link");
        pages.pointOfSale().ordersLink.click();
        BrowserUtils.wait(5);

        extentLogger.info("Verify that page title contains “Orderlists");
        String message = Driver.getDriver().getTitle();
        Assert.assertTrue(message.contains(ApplicationConstants.ORDERLISTS_PAGE_TITLE));

        extentLogger.pass("Completed: Orderlist Page Title Test");
    }

    //Serkan Danisman 3 BRIT-760
    @Test
    public void checkOrderlistsNameAfterSearchIt() {
        extentLogger = report.createTest("Orderlist name is on the page after search it.");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Order link");
        pages.pointOfSale().ordersLink.click();
        BrowserUtils.wait(5);

        WebElement ordersNameElement = pages.pricelist().selectAPricelistName();
        String ordersName = ordersNameElement.getText();
        extentLogger.info("Selecting the orders name randomly  : " + ordersName);
        extentLogger.info("Type the name of a orders into search box and hit ENTER.");
        pages.orders().searchInput.sendKeys(ordersName + Keys.ENTER);

        extentLogger.info("Verify that the orders is shown on the page.");
        BrowserUtils.wait(5);
        String availableOrders = pages.orders().OrderlistsNames.get(0).getText();
        System.out.println("available order = " + availableOrders);

        extentLogger.info("Verify that order name is displayed");
        Assert.assertEquals(ordersName, availableOrders);

        extentLogger.pass("Completed : order name is displayed when searched.");
    }


    // Serkan Danisman 5- BRIT-766
    @Test
    public void checkOrderNameHeader() {
        extentLogger = report.createTest("Orders Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.orders().ordersLink.click();

        WebElement orderlistNameElement = pages.orders().selectOrderlistName();
        String ordersName = orderlistNameElement.getText();
        extentLogger.info("Selecting the orders name randomly  : " + ordersName);

        BrowserUtils.waitForClickablility(orderlistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + ordersName);
        orderlistNameElement.click();

        String orderNameOnHeader = pages.orders().OrderlistNameHeader.getText();
        extentLogger.info("Verify that ordersname is displayed on heading");
        assertEquals(orderNameOnHeader, ordersName);

        extentLogger.pass("Completed : orders Page Header Test");
    }

    // Serkan Danisman 7- BRIT-766
    @Test
    public void checkOrderNameTitle() {
        extentLogger = report.createTest("Order Name Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Order link");
        pages.pointOfSale().ordersLink.click();


        WebElement ordersNameElement = pages.pricelist().selectAPricelistName();
        String ordersName = ordersNameElement.getText();
        extentLogger.info("Selecting the orders name randomly  : " + ordersName);
        System.out.println(ordersName);


        extentLogger.info("Clicking on the " + ordersName);
        ordersNameElement.click();

        BrowserUtils.wait(5);
        extentLogger.info("Verify that page title contains “order Name");
        String message = Driver.getDriver().getTitle();
        System.out.println(message);
        Assert.assertTrue(message.contains(ordersName));

        extentLogger.pass("orders Name Title Test");
    }


    // Serkan Danisman 8- 767
    @Test
    public void accessErrorAfterClickingArchive() {
        extentLogger = report.createTest("Access Error Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the order");
        pages.pointOfSale().ordersLink.click();


        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectAOrderNameCheckBox().click();

        extentLogger.info("Clicking on the action button");
        pages.pricelist().actionButton.click();

        extentLogger.info("Clicking on the archive button");
        pages.pricelist().archiveButton.click();

        String errorPageHeader = pages.pricelist().accessError.getText();
        System.out.println(errorPageHeader);
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertTrue(errorPageHeader.contains(ApplicationConstants.ERROR_SUBPAGE_HEADER));

        extentLogger.pass("Access Error Test");
    }

    //   Serkan Danisman 9 - BRIT-774
    @Test
    public void checkEditButton() {
        extentLogger = report.createTest("User check Edit button");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();

        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectOneofOrder.click();

        extentLogger.info(" Click on Edit");
        BrowserUtils.waitForClickablility(pages.orders().EditButton, timeOutInSec);
        pages.orders().EditButton.click();


    }
    ////button[@class='btn btn-default btn-sm o_form_button_cancel']

    //   Serkan Danisman 10 - BRIT-774
    @Test
    public void checkDiscardButton() {
        extentLogger = report.createTest("User check Edit button");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();

        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectOneofOrder.click();

        extentLogger.info(" Click on Edit");
        BrowserUtils.waitForClickablility(pages.orders().EditButton, timeOutInSec);
        pages.orders().EditButton.click();

        extentLogger.info(" Click on DicardButton");
        BrowserUtils.waitForClickablility(pages.orders().CheckDiscardButton, timeOutInSec);
        pages.orders().CheckDiscardButton.click();


    }

    //   Serkan Danisman 11 - BRIT-775
    @Test
    public void checkSaveButton() {
        extentLogger = report.createTest("User check Edit button");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();

        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectOneofOrder.click();

        extentLogger.info(" Click on Edit");
        BrowserUtils.waitForClickablility(pages.orders().EditButton, timeOutInSec);
        pages.orders().EditButton.click();

        extentLogger.info(" Click on SaveButton");
        BrowserUtils.waitForClickablility(pages.orders().CheckSaveButton, timeOutInSec);
        pages.orders().CheckSaveButton.click();


    }
    //   Serkan Danisman 12 - BRIT-775
    @Test
    public void checkPayment() {
        extentLogger = report.createTest("User check Edit button");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();

        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectOneofOrder.click();

        extentLogger.info(" Click on Edit");
        BrowserUtils.waitForClickablility(pages.orders().EditButton, timeOutInSec);
        pages.orders().EditButton.click();

        extentLogger.info(" Click on Payment Button");
        BrowserUtils.waitForClickablility(pages.orders().CheckPayment, timeOutInSec);
        pages.orders().CheckPayment.click();


    }

    //   Serkan Danisman 13 - BRIT-776
    @Test
    public void CheckProductTab() {
        extentLogger = report.createTest("User check Edit button");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();

        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectOneofOrder.click();



        extentLogger.info(" Check Product tab ");
        BrowserUtils.waitForClickablility(pages.orders().CheckProductTab, timeOutInSec);
        pages.orders().CheckProductTab.click();


    }
    //   Serkan Danisman 14 - BRIT-777
    @Test
    public void CheckExtraInfoTab() {
        extentLogger = report.createTest("User check Edit button");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();

        extentLogger.info("Clicking the order name box randomly");
        pages.orders().selectOneofOrder.click();


        extentLogger.info(" Check Notes  from orders costomers tab ");
        BrowserUtils.waitForClickablility(pages.orders().CheckNotes, timeOutInSec);
        pages.orders().CheckNotes.click();


    }


}