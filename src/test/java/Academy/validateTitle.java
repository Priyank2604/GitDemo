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

public class validateTitle extends base {
    public WebDriver driver;
    public static Logger Log= LogManager.getLogger(base.class.getName());
    LandingPage l;
    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        Thread.sleep(5500);
        driver=initializeDriver(); //initializeDriver method return the driver so putting it in driver object
        Log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        Log.info("Navigated to Home page1");
    }

    @Test
    public void validatePageTitle(){
       l=new LandingPage(driver);
        Assert.assertEquals(l.getTitle().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        Log.info("Successfully validated Text message");
        System.out.println("Tested1");
        System.out.println("Tested2");
        System.out.println("Tested3");
        System.out.println("Tested4");
        System.out.println("Tested5");
        System.out.println("Tested6");
        System.out.println("Tested7");
    }

    @Test
    public void validateHeader(){
        l=new LandingPage(driver);
        Assert.assertEquals(l.getHeader().getText(),"FEATURED COURSES");
        System.out.println("Testing one");
        System.out.println("Testing two");
        System.out.println("Testing three");
        System.out.println("Testing four");
    }
    @Test
    public void Test(){
        System.out.println("T1");
        System.out.println("T2");
        System.out.println("T3");
        System.out.println("T4");
        System.out.println("T5");
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}