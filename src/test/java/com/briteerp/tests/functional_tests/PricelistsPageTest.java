package com.briteerp.tests.functional_tests;

import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PricelistsPageTest extends TestBase {

    // Mehmet Keles - BRIT-2067
    @Test
    public void checkPricelistsPageTitle(){
        extentLogger = report.createTest("Page Title Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();
        BrowserUtils.wait(10);

        extentLogger.info("Verify that page title contains “Pricelists");
        String message =  Driver.getDriver().getTitle();
        Assert.assertTrue(message.contains(ApplicationConstants.PRICELISTS_PAGE_TITLE));

        extentLogger.pass("Completed: Page Title Test");
    }

    // Mehmet Keles - BRIT-2069
    @Test
    public void checkPricelistsNameAfterSearchIt(){
        extentLogger = report.createTest("Pricelist name is on the page after search it.");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists link");
        pages.pointOfSale().priceListLink.click();
        BrowserUtils.wait(10);

        WebElement pricelistNameElement=pages.pricelist().selectAPricelistName();
        String pricelistName =pricelistNameElement.getText();
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);
        extentLogger.info("Type the name of a pricelist into search box and hit ENTER.");
        pages.pricelist().searchInput.sendKeys(pricelistName + Keys.ENTER);

        extentLogger.info("Verify that the pricelist is shown on the page.");
        BrowserUtils.wait(5);
        String availablePricelist = BrowserUtils.getElementsText(pages.pricelist().pricelistsNames).toString();
        System.out.println("available Pricelist = " + availablePricelist);

        extentLogger.info("Verify that pricelist name is displayed");
        Assert.assertEquals("["+pricelistName+"]",availablePricelist);

        extentLogger.pass("Completed : Pricelist name is displayed when searched.");
    }
}
