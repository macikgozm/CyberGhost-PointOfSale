package com.briteerp.tests.functional_tests;

import com.briteerp.pages.SessionsPage;
import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionsPageTests extends TestBase {

//Eyup Savas-1 BRIT-

    @Test
    public void validSessionsPageTitle(){
        extentLogger = report.createTest("Page Title Test");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Sessions link");
        pages.pointOfSale().sessionsLink.click();
        BrowserUtils.wait(10);

        extentLogger.info("Verify that page title contains “Sessions");
        String actual =  Driver.getDriver().getTitle();
        Assert.assertEquals(actual, ApplicationConstants.SESSIONS_PAGE_TITLE);

        extentLogger.pass("Completed: Page Title Test");
    }



//Eyup Savas-2 BRIT-






//Eyup Savas-3 BRIT-

//Eyup Savas-4 BRIT-

//Eyup Savas-5 BRIT-

//Eyup Savas-6 BRIT-

//Eyup Savas-7 BRIT-

//Eyup Savas-8 BRIT-



}
