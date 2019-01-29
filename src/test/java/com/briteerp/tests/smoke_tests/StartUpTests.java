package com.briteerp.tests.smoke_tests;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by macik on 1/29/2019.
 */
public class StartUpTests extends TestBase{

    @Test
    public void startUp(){
        extentLogger = report.createTest("Start Up Test");

        extentLogger.info("Open the homepage");
        pages.home().open();

        extentLogger.info("Open the Brite Erp App");
        pages.home().briteErpDemoLink.click();

        extentLogger.info("Login");
        pages.login().login(ConfigurationReader.getProperty("user-username"),
                            ConfigurationReader.getProperty("user-password"));

        extentLogger.info("Login to Point of Sales page");
        BrowserUtils.waitForClickablility(pages.main().pointOfSaleLink, 40);
        pages.main().pointOfSaleLink.click();

        extentLogger.info("Click on the Orders");
        pages.pointOfSale().ordersLink.click();


        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        extentLogger.info("Click on the PriceList");
        pages.pointOfSale().priceListLink.click();




        extentLogger.info("Click on the DashBoard");
        pages.pointOfSale().dashboardLink.click();

        extentLogger.info("Verify that user name");
        String user = "POSUser4";
        Assert.assertEquals(pages.pointOfSale().topUsername.getText(),user );
//        System.out.println(pages.pointOfSale().topUsername.getText());
        extentLogger.pass("Completed: Start Up Test");



    }
}
