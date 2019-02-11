package com.briteerp.tests.functional_tests;

import com.briteerp.pages.SessionsPage;
import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionsPageTests extends TestBase {

//Eyup Savas-1

    @Test
    public void validSessionsPageTitle() {
        extentLogger = report.createTest("Page Title Test");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions link");
        pages.pointOfSale().sessionsLink.click();
        BrowserUtils.wait(10);

        extentLogger.info("Verify that page title contains “Sessions");
        String actual = Driver.getDriver().getTitle();
        Assert.assertEquals(actual, ApplicationConstants.SESSIONS_PAGE_TITLE);

        extentLogger.pass("Completed: Page Title Test");
    }


//Eyup Savas-2
    @Test
    public void allStoresResponsiblePerson(){
        extentLogger = report.createTest("Responsible person for all stores");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                                                 ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);

        // click on any of the stores by name
        WebElement element = pages.sessions().getStore("Tysons corner mall");
        int fromIndex = element.getText().indexOf("(")+1;
        int toIndex = element.getText().indexOf(")");
        String expectedUserID = element.getText().substring(fromIndex,toIndex);
        element.click();

        //Verify that responsible person is POsUser3
        BrowserUtils.waitUntilTextToBePresentInElement(element, expectedUserID, timeOutInSec);
        String actualUserID = pages.sessions().userIDField.getText().trim();
        Assert.assertEquals(actualUserID, expectedUserID);

        extentLogger.pass("Completed: All stores responsible person");
    }

    //Eyup Savas-3
    @Test
    public void ResponsablePerson() {
        extentLogger = report.createTest("Responsible person test ");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions link");
        pages.pointOfSale().sessionsLink.click();
        BrowserUtils.wait(10);

        extentLogger.info("Click on the Tysons corner mall in the table");
        pages.sessions().tysonsCorner.click();

        extentLogger.info("Verify that responsible person is POSUser3");
        String responsible = pages.sessions().POSUser3.getText().trim();
        Assert.assertEquals(responsible, ApplicationConstants.RESPONSIBLE_PERSON);

        extentLogger.pass("Completed: Responsible Person Test");

    }




//Eyup Savas-4

    @Test
    public void WholeFoodStoreStatus() {
        extentLogger = report.createTest("Whole Food Store Status");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);


        extentLogger.info("Verify that Whole Foods Store is in progress");
        String statusActual = pages.sessions().wholeFoodsStoreStatus.getText().trim();
        String statusExpected = "In Progress";
        Assert.assertEquals(statusActual, statusExpected);

        extentLogger.pass("Completed: Whole Foods Store status Test");

    }



//Eyup Savas-5
        @Test
        public void mainStoreStatus(){

        extentLogger = report.createTest("Main Store Status");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Verify that Main Store's status is Closed & Posted");
        String statusActual = pages.sessions().mainFoodsStoreStatus.getText().trim();
        String statusExpected = "Closed & Posted";
        Assert.assertEquals(statusActual, statusExpected);

            extentLogger.pass("Completed: Main Store status Test");
        }

//Eyup Savas-6
    @Test
    public void taysonsMallOpeningDate(){
        extentLogger = report.createTest("Tysons Mall Opening Date");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Click on the Tysons corner mall in the table");
        pages.sessions().tysonsCorner.click();

        extentLogger.info("Verify that Taysons Mall opening date is 01/28/2019 14:32:36 ");
        String openingDateActual = pages.sessions().openingDate.getText().trim();
        String openingDateExpected = "01/28/2019 14:32:36";
        Assert.assertEquals(openingDateActual, openingDateExpected);

        extentLogger.pass("Completed: Opening date test");


        }

//Eyup Savas-7
    @Test
        public void TableHeader1(){
        extentLogger = report.createTest("Table Header 1");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Verify that first table headers is Point of Sale ");
        String headerActual = pages.sessions().tHead1.getText().trim();
        String headerExpected = "Point of Sale";
        Assert.assertEquals(headerActual, headerExpected);

        extentLogger.pass("Completed: Table header 1 Test");


        }

//Eyup Savas-8
    @Test
    public void zaramStoreId(){
        extentLogger = report.createTest("Table Headers Order");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Verify that Id for zaram store is  ");
        String idActual = pages.sessions().zId.getText().trim();
        String idExpected = "POS/2019/02/09/50";
        Assert.assertEquals(idActual, idExpected);

        extentLogger.pass("Completed: Zaram store id test");



    }
//Eyup Savas-9
    @Test
    public void ZARAmStoreResponsiblePerson (){
        extentLogger = report.createTest("Store Id");
        extentLogger.info("Open the browser and goto address and login as 'manager' and click ....");getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions");
        pages.pointOfSale().sessionsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                ApplicationConstants.SESSIONS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Verify that ZARAm store responsible person is POSUser6 ");
       String zrActual = pages.sessions().zaram.getText().trim();
       String zrExpected = "POSUser6";
       Assert.assertEquals(zrActual, zrExpected);

        extentLogger.pass("Completed: Zaram store responsible person test");

    }




}
