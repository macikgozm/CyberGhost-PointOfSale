package com.briteerp.tests.functional_tests;
import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import com.mongodb.operation.BaseWriteOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Date;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;

public class ProductDetailsPageTest extends TestBase {
//      Yilmaz Usta
    //      1. BriteERP BRIT-3660
    //      Description: Product Details Functionality-Verify that user can see Description of the product in Notes tab.


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
    //      Yilmaz Usta
    //      2. BriteERP BRIT-3662
    //      Description: Verify that user can see Description for Internal title in Notes tab.


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




    //      Yilmaz Usta
    //      3. BriteERP BRIT-3665
    //      Description: Verify that user can see details of Product Type when hover over it in General Information tab.

    @Test
    public void checkProductType(){

        extentLogger = report.createTest("Product Type Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();
        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[21] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);
        WebElement general = driver.findElement(By.xpath("//a[contains(text(), 'General Information')]"));
        WebElement productType = driver.findElement(By.xpath("//td[@class='o_td_label']//label[contains(text(),'Product Type')]"));

        extentLogger.info("Clicking on the General Information Tab");
        BrowserUtils.waitForClickablility(general, timeOutInSec);
        driver.findElement(By.xpath("//a[contains(text(),'General Information')]")).click();
        BrowserUtils.waitForVisibility(productType, 3);
        Actions act = new Actions(driver);
        act.moveToElement(productType).perform();
        BrowserUtils.wait(3);
        String toolTipText= productType.getAttribute("aria-describedby");

        extentLogger.info("Verify that user can see details of Product Type when hover over it in Product Type in General Information Tab.");
        if(toolTipText.contains("tooltip")){
            extentLogger.pass("Completed: Product Type Test");
        }else{
            extentLogger.pass("Failed: Product Type Test");
        }
    }



    //      Yilmaz Usta
    //      4. BriteERP BRIT-3669
    //      Description: Verify that manager can switch between products by clicking forward/backward buttons.
    //      assert command should be used; page number should be got and compared in assert
    @Test
    public void checkSwitchForward(){

        extentLogger = report.createTest("Switching Forward Test");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();
        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[21] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);
        BrowserUtils.wait(5);   // make sure that the products list page are loaded.
        WebElement pageLoaded = driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[@class='active']"));
        BrowserUtils.waitForVisibility(pageLoaded, 3); //another check to make sure that product detail page is loaded.
        // get current index number...
        WebElement itemIndex = driver.findElement(By.xpath("(//span[@class='o_pager_counter']//span[@class='o_pager_value'])[1]"));
        // convert the index number to integer to manipulate...
        Integer itemIndexNumber = Integer.parseInt(itemIndex.getText());
        System.out.println("current item index number: " + itemIndex.getText());

        extentLogger.info("Clicking on the forward button");
        int currentPageNumber = itemIndexNumber + 1;
        System.out.println("current index number: " + currentPageNumber);
        WebElement button = driver.findElement(By.cssSelector("button[accesskey='n']"));
        BrowserUtils.waitForClickablility(button, timeOutInSec);
        button.click();
        BrowserUtils.wait(5);

        extentLogger.info("Verify that the page number increased by 1 after clicking forward button.");
        System.out.println("current index number of the page: " + itemIndex.getText());

        extentLogger.info("Verify that manager can switch between products by clicking forward buttons");
        Assert.assertEquals(Integer.toString(currentPageNumber),itemIndex.getText());

        extentLogger.pass("Completed: Switching Forward Test");
    }

    //      Yilmaz Usta
    //      5. BriteERP BRIT-3669
    //      Description: Verify that manager can switch between products by clicking forward/backward buttons.

    @Test
    public void checkSwitchBackWard(){
        extentLogger = report.createTest("Switching Backward Test");
        getMeToPointOfSalesAs("manager");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();
        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[21] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);
        BrowserUtils.wait(5);   // make sure that the products list page are loaded.
        WebElement pageLoaded = driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[@class='active']"));
        BrowserUtils.waitForVisibility(pageLoaded, 3); //another check to make sure that product detail page is loaded.
        // get current index number...
        WebElement itemIndex = driver.findElement(By.xpath("(//span[@class='o_pager_counter']//span[@class='o_pager_value'])[1]"));
        int currentPageNumber = Integer.parseInt(itemIndex.getText());
        System.out.println("current index number: " + currentPageNumber);
        BrowserUtils.wait(5);

        extentLogger.info("Verify that the page number increased by 1 after clicking fowward button.");
        System.out.println("current index number of the page: " + itemIndex.getText());
        Assert.assertEquals(Integer.toString(currentPageNumber),itemIndex.getText());
        WebElement backwardButton =  driver.findElement(By.cssSelector("button[accesskey='p']"));
        BrowserUtils.wait(3);

        extentLogger.info("Clicking on the backward button");
        backwardButton.click();
        BrowserUtils.waitForClickablility(backwardButton, timeOutInSec);
        currentPageNumber = currentPageNumber - 1;

        extentLogger.info("Verify that manager can switch between products by clicking forward buttons");
        Assert.assertEquals(Integer.toString(currentPageNumber),itemIndex.getText());

        extentLogger.pass("Completed: Switching Forward Test");
    }

    //      Yilmaz Usta
    //      6. BriteERP BRIT-3657
    //      Description: Verify that user should be able to send messages.
    //      it send messages, but assert/verify part is missing,
    @Test
    public void checkSendMessages(){
        extentLogger = report.createTest("Send Messages Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[22] "));
        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);
        BrowserUtils.wait(2);

        extentLogger.info("Clicking on the Send Message");
        driver.findElement(By.cssSelector("button[class='btn btn-sm btn-link o_chatter_button_new_message']")).click();
        extentLogger.info("Send the message 'This is a test message'");
        driver.findElement(By.cssSelector("textarea[class='o_input o_composer_text_field']")).sendKeys("This is a message test");
        BrowserUtils.wait(3);
        extentLogger.info("Click the 'Send' button");
        driver.findElement(By.cssSelector("button[class='btn btn-sm btn-primary o_composer_button_send hidden-xs']")).click();
        BrowserUtils.wait(5);
        WebElement message = driver.findElement(By.xpath("//div/p[contains(text(),'This is')]"));

        extentLogger.info("Verify that user should be able to send messages.");
        Assert.assertEquals(message.getText(), "This is a message test");
        extentLogger.pass("Completed: Send Messages Test");
    }

    //      Yilmaz Usta
    //      7. BriteERP BRIT-3647
    //      Description: Verify that corresponding features are checked in product page.

    @Test
    public void checkCorrespondingFeaturesAreChecked(){
        extentLogger = report.createTest("Corresponding Features Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[21] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);
        WebElement checkbox = driver.findElement(By.xpath("//div[@name='sale_ok']//input[@type='checkbox']"));

        extentLogger.info("Verify that corresponding features of the check boxes on the left upper corner are checked in product page.");
        Assert.assertEquals(checkbox.isSelected(), true );
        extentLogger.pass("Completed: Corresponding Features Test");
    }


    //      Yilmaz Usta
    //      8. BriteERP BRIT-3634
    //      Description: Verify that in general information tab the product has a cost price.

    @Test
    public void checkProductCostPrice(){
        extentLogger = report.createTest("Product Cost Price Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[24] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);

        extentLogger.info("Clicking on the General Information Tab");
        driver.findElement(By.xpath("//a[contains(text(),'General Information')]")).click();

        BrowserUtils.wait(1);

        extentLogger.info("Verify that in general information tab, the product has a cost price.");
        String costPrice = driver.findElement(By.xpath("//span[contains(@name, 'standard_price')]")).getText();
        System.out.println("costPrice :" + costPrice);
        BrowserUtils.wait(1);
        Assert.assertEquals(costPrice, "$ 0.32");

        extentLogger.pass("Completed:  ProductCostPrice Test");
    }



    //      Yilmaz Usta
    //      9. BriteERP BRIT-36332
    //      Description: Verify that product page has the information tab.

    @Test
    public void checkProductInformationTab(){
        extentLogger = report.createTest("Product Information Tab Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[21] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);
        WebElement generaltab = driver.findElement(By.xpath("//a[contains(@data-toggle,'tab')]"));

        extentLogger.info("Verify that a product page has the information tab.");
        BrowserUtils.waitForVisibility(generaltab, 2);
        Assert.assertEquals(generaltab.getText(), "General Information");
        extentLogger.pass("Completed: General Information Test");
    }

    //      Yilmaz Usta
    //      10. BriteERP BRIT-3631
    //      Description: Verify that product page has a picture/icon that represents the product.

    @Test
    public void checkProductHasIcon(){
        extentLogger = report.createTest("Product Icon Check Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();
        String productName = pages.products().selectAnyProduct();

        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);
        WebElement product1 = driver.findElement(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])[12] "));

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product1);

        extentLogger.info("Verify that product page has a picture/icon that represents the product.");
        WebElement ImageFile = driver.findElement(By.xpath("//img[@class='img img-responsive']"));
        BrowserUtils.waitForVisibility(ImageFile, 4);
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        BrowserUtils.wait(4);
        Assert.assertTrue(ImagePresent);
        extentLogger.pass("Completed: Invoicing Policy Test");
    }

    //      Yilmaz Usta
    //      11. BriteERP BRIT-36330
    //      Description: Verify that total number of items are equal to the number after slash sign.

    @Test
    public void checkTotalNumberOfItems(){
        extentLogger = report.createTest("Total Number of Items Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();
        WebElement productPage = driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[@class='active']"));
        BrowserUtils.waitForVisibility(productPage,10);

        extentLogger.info("Get the total number of products");
        WebElement totalNumber = driver.findElement(By.xpath("//span[@class='o_pager_limit']"));

        extentLogger.info("Verify that total number of items are equal to 283");
        Assert.assertEquals(totalNumber.getText(), "283");
        extentLogger.pass("Completed: Total Number Of Items Test");
    }





}
