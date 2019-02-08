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

public class PricelistsPageTest extends TestBase {

    // Mehmet Keles 1- BRIT-2063
    @Test
    public void checkPricelistsPageHeader() {
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        BrowserUtils.wait(5);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.PRICELISTS_PAGE_HEADER);
        assertEquals(pages.pricelist().tabTitle.getText(), ApplicationConstants.PRICELISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }

    // Mehmet Keles 2- BRIT-2067
    @Test
    public void checkPricelistsPageTitle() {
        extentLogger = report.createTest("Pricelist Page Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();
        BrowserUtils.wait(5);

        extentLogger.info("Verify that page title contains “Pricelists");
        String message = Driver.getDriver().getTitle();
        Assert.assertTrue(message.contains(ApplicationConstants.PRICELISTS_PAGE_TITLE));

        extentLogger.pass("Completed: Pricelist Page Title Test");
    }

    // Mehmet Keles 3- BRIT-2069
    @Test
    public void checkPricelistsNameAfterSearchIt() {
        extentLogger = report.createTest("Pricelist name is on the page after search it.");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();
        BrowserUtils.wait(5);

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);
        extentLogger.info("Type the name of a pricelist into search box and hit ENTER.");
        pages.pricelist().searchInput.sendKeys(pricelistName + Keys.ENTER);

        extentLogger.info("Verify that the pricelist is shown on the page.");
        BrowserUtils.wait(5);
        //String availablePricelist = BrowserUtils.getElementsText(pages.pricelist().pricelistsNames).toString();
        String availablePricelist = pages.pricelist().pricelistsNames.get(0).getText();
        System.out.println("available Pricelist = " + availablePricelist);

        extentLogger.info("Verify that pricelist name is displayed");
        Assert.assertEquals( pricelistName, availablePricelist);

        extentLogger.pass("Completed : Pricelist name is displayed when searched.");
    }

    // Mehmet Keles 4- BRIT-2086
    @Test
    public void checkSelectableMenuDisabled() {
        extentLogger = report.createTest("Selectable menu is disabled");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        BrowserUtils.waitForClickablility(pricelistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        BrowserUtils.waitForVisibility(pages.pricelist().selectableMenu, timeOutInSec);
        extentLogger.info("Checking selectable menu is disabled");
        boolean isEnabled = pages.pricelist().selectableMenu.isEnabled();

        extentLogger.info("Verify that pricelist name is displayed");
        Assert.assertFalse(isEnabled);

        extentLogger.pass("Completed : Selectable menu is disabled");
    }

    // Mehmet Keles 5- BRIT-2092
    @Test
    public void checkPricelistNameHeader() {
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        BrowserUtils.waitForClickablility(pricelistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        String pricelistNameOnHeader = pages.pricelist().pricelistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(pricelistNameOnHeader, pricelistName);

        extentLogger.pass("Completed : Pricelists Page Header Test");
    }

    // Mehmet Keles 6- BRIT-2095
    @Test
    public void checkLanguage() {
        extentLogger = report.createTest("Check Localhost Page Twitter Account Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        System.out.println(pricelistName);
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        BrowserUtils.waitForVisibility(pages.pricelist().localhostLink, timeOutInSec);
        extentLogger.info("Clicking on localhost link");
        pages.pricelist().localhostLink.click();

        BrowserUtils.waitForVisibility(pages.localhost().language, timeOutInSec);
        extentLogger.info("Verify that twitter account is: " + ApplicationConstants.LOCALHOST_PAGE_LANGUAGE);
        String message = pages.localhost().language.getText();
        System.out.println(message);
        Assert.assertEquals(message, (ApplicationConstants.LOCALHOST_PAGE_LANGUAGE));

        extentLogger.pass("Check Localhost Page Twitter Account Test");
    }

    // Mehmet Keles 7- BRIT-2096
    @Test
    public void checkPricelistsNameTitle() {
        extentLogger = report.createTest("Pricelist Name Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        System.out.println(pricelistName);
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        BrowserUtils.wait(5);
        extentLogger.info("Verify that page title contains “Pricelist Name");
        String message = Driver.getDriver().getTitle();
        System.out.println(message);
        Assert.assertTrue(message.contains(pricelistName));

        extentLogger.pass("Pricelist Name Title Test");
    }

    // Mehmet Keles 8- BRIT-2103
    @Test
    public void accessErrorAfterClickingArchive() {
        extentLogger = report.createTest("Access Error Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();


        extentLogger.info("Clicking the Pricelist name box randomly");
        pages.pricelist().selectAPricelistNameCheckBox().click();

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

    // Mehmet Keles 9- BRIT-2106
    @Test
    public void localhostPageTitle() {
        extentLogger = report.createTest("Localhost Page Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        System.out.println(pricelistName);
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        BrowserUtils.waitForVisibility(pages.pricelist().localhostLink, timeOutInSec);
        extentLogger.info("Clicking on localhost link");
        pages.pricelist().localhostLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that page title contains “localhost");
        String message = Driver.getDriver().getTitle();
        System.out.println(message);
        Assert.assertTrue(message.contains(ApplicationConstants.LOCALHOST_PAGE_TITLE));

        extentLogger.pass("Localhost Page Title Test");
    }

    // Mehmet Keles 10- BRIT-2110
    @Test
    public void checkTwitterAccount() {
        extentLogger = report.createTest("Check Localhost Page Twitter Account Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        System.out.println(pricelistName);
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        BrowserUtils.waitForVisibility(pages.pricelist().localhostLink, timeOutInSec);
        extentLogger.info("Clicking on localhost link");
        pages.pricelist().localhostLink.click();

        BrowserUtils.waitForVisibility(pages.localhost().twitter, timeOutInSec);
        extentLogger.info("Verify that twitter account is: " + ApplicationConstants.LOCALHOST_PAGE_TWITTER);
        String message = pages.localhost().twitter.getText();
        System.out.println(message);
        Assert.assertEquals(message, (ApplicationConstants.LOCALHOST_PAGE_TWITTER));

        extentLogger.pass("Check Localhost Page Twitter Account Test");
    }

}
