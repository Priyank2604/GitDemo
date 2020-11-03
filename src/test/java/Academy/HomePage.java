package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import java.io.IOException;

public class HomePage extends base {
    public WebDriver driver;

    public static Logger Log= LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException{
        driver=initializeDriver(); //initializeDriver method return the driver so putting it in driver object

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username,String Password,String Text) throws InterruptedException{
        Thread.sleep(2500);
        driver.get(prop.getProperty("url"));



        LandingPage l=new LandingPage(driver);
//        l.close().click();
        LoginPage lg=l.getLogin();
        Thread.sleep(2500);
        lg.loginEmail().sendKeys(Username);
        lg.loginPassword().sendKeys(Password);
        Log.info(Text);
        lg.loginBtn().click();
        System.out.println("test1");
        System.out.println("test2");
        System.out.println("test3");


//        driver.quit();
    }
    @AfterTest
    public void tearDown(){
        driver.close();
        driver=null;
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[2][3];
        data[0][0]="abc@xyz.com";
        data[0][1]="123";
        data[0][2]="ddd";
        data[1][0]="xyz@abc.com";
        data[1][1]="345";
        data[1][2]="kkk1";
        return data;
    }

}