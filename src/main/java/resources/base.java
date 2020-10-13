package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver; //define it globally every time not required to define webdriver driver so it is globally defined so every where used driver only
//driver is public so we can use this driver outside this class
public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(file);
        System.out.println(prop.getProperty("browser"));
        String browserName=System.getProperty("browser");
//        String browserName=prop.getProperty("browser");
        if (browserName.contains("chrome")){
            //execute in chrome driver
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
            ChromeOptions chromeoptions=new ChromeOptions();
            if (browserName.contains("headless")){
                chromeoptions.addArguments("--headless");
            }
            driver=new ChromeDriver(chromeoptions);
        }else if (browserName.contains("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
            FirefoxOptions firefoxoption=new FirefoxOptions();
            if (browserName.contains("headless")){
            firefoxoption.addArguments("--headless");}

            driver=new FirefoxDriver(firefoxoption);
        }else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
            InternetExplorerOptions ieoption=new InternetExplorerOptions();
            driver=new InternetExplorerDriver(ieoption);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destinationFIle = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        File finalDestination = new File(destinationFIle);
        FileUtils.copyFile(source,finalDestination);
        return destinationFIle;

    }
}
