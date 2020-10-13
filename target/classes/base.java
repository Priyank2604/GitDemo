package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver; //define it globally every time not required to define webdriver driver so it is golabbly defined so every where used driver only
//driver is public so we can use this driver outside this class
public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream("C:\\Users\\hp\\TestProject\\src\\main\\java\\resources\\data.properties");
        prop.load(file);
        System.out.println(prop.getProperty("browser"));
        String browserName=prop.getProperty("browser");
        if (browserName.equals("chrome")){
            //execute in chrome driver
            System.setProperty("webdriver.chrome.driver","E:\\Automation Practice\\BrowserDriver\\v85\\chromedriver.exe");
            driver=new ChromeDriver();
        }else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","E:\\Automation Practice\\geckodriver-v0.24.0-win64\\geckodriver.exe");
            driver=new FirefoxDriver();
        }else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver","E:\\Automation Practice\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }


}
