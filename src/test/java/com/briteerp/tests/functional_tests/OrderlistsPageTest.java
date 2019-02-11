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

public class OrderlistsPage extends TestBase {
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
        //String availablePricelist = BrowserUtils.getElementsText(pages.pricelist().pricelistsNames).toString();
        String availableOrders = pages.orders().OrderlistsNames.get(0).getText();
        System.out.println("available Pricelist = " + availableOrders);

        extentLogger.info("Verify that pricelist name is displayed");
        Assert.assertEquals( ordersName, availableOrders);

        extentLogger.pass("Completed : Pricelist name is displayed when searched.");
    }

    // Serkan Danisman 4- BRIT-720
   /* @Test
    public void checkSelectableMenuDisabled() {
        extentLogger = report.createTest("Selectable menu is disabled");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders link");
        pages.pointOfSale().ordersLink.click();

        WebElement ordersNameElement = pages.orders().selectOrderlistName();
        String orderName = ordersNameElement.getText();
        extentLogger.info("Selecting the orders name randomly  : " + orderName);

        BrowserUtils.waitForClickablility(ordersNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + orderName);
        ordersNameElement.click();

        BrowserUtils.waitForVisibility(pages.orders().selectableMenu, timeOutInSec);
        extentLogger.info("Checking selectable menu is disabled");
        boolean isEnabled = pages.orders().selectableMenu.isEnabled();

        extentLogger.info("Verify that orders name is displayed");
        Assert.assertFalse(isEnabled);

        extentLogger.pass("Completed : Selectable menu is disabled");
    }
*/
    // Serkan Danisman 5- BRIT-706
    @Test
    public void checkOrderNameHeader() {
        extentLogger = report.createTest("Orders Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orders");
        pages.orders().ordersLink.click();

        WebElement orderlistNameElement = pages.orders().selectOrderlistName();
        String ordersName =orderlistNameElement.getText();
        extentLogger.info("Selecting the Pricelist name randomly  : " + ordersName);

        BrowserUtils.waitForClickablility(orderlistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + ordersName);
        orderlistNameElement.click();

        String orderNameOnHeader = pages.pricelist().OrderlistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(orderNameOnHeader, ordersName);

        extentLogger.pass("Completed : Pricelists Page Header Test");
    }


}
