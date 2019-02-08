package com.briteerp.tests.functional_tests;

import com.briteerp.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionsPageTests extends TestBase {

//Eyup Savas-1 BRIT-

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


/*
  Example
1-Open browser
2-Go to http://52.39.162.23/web/login
            3-Enter Email in_pos_manager10@info.com
4-Enter Password KjKtfgrs38
5-Click on the Log in button
6-Click Point of Sale on the top menu bar
7-Click on the Sessions
8-Click on the  1st point of sale (Tyson ) corner mall (POSUser3)
            9 Verify that responsible person is POsUser3
*/

    @Test
    public void example(){
        extentLogger = report.createTest("Example");
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
    }

//Eyup Savas-2 BRIT-

//Eyup Savas-3 BRIT-

//Eyup Savas-4 BRIT-

//Eyup Savas-5 BRIT-

//Eyup Savas-6 BRIT-

//Eyup Savas-7 BRIT-

//Eyup Savas-8 BRIT-


}
