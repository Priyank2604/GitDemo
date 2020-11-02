package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class validateNavBar extends base {
    public WebDriver driver;

    public static Logger Log= LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        Thread.sleep(5500);
        driver=initializeDriver(); //initializeDriver method return the driver so putting it in driver object
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validatePageNavigation() throws IOException, InterruptedException {

        Thread.sleep(2500);
        LandingPage l=new LandingPage(driver);
//        l.close().click();
        Assert.assertTrue(l.navigationBar().isDisplayed());
//        Assert.assertFalse(l.navigationBar().isDisplayed());
//        driver.quit();
        Log.info("Navigation bar is displayed");
        System.out.println("Test1");
        System.out.println("Test2");
        System.out.println("Test3");
        System.out.println("Test4");
        System.out.println("Test5");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver=null;
    }

}