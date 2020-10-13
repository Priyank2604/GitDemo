package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;

//    @FindBy(xpath = "/html/body/header/div[1]/div/nav/ul/li[4]/a") WebElement Login;
//@FindBy(xpath = "//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a") WebElement login;
private @FindBy(xpath = "//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button") WebElement close;
private By login=By.cssSelector("a[href*='sign_in']");
private @FindBy(xpath = "//*[@id=\"myCarousel\"]/div/div/div/div/div[1]/h3") WebElement title;
private @FindBy(xpath = "//*[@id=\"homepage\"]/header/div[2]/div/nav/ul") WebElement navBar;
private @FindBy(xpath = "//*[@id=\"content\"]/div/div/h2") WebElement header;
//By login=By.cssSelector("a[href*='sign_in']");
    public LandingPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement close(){
        return close;
    }
    public LoginPage getLogin(){
        driver.findElement(login).click();
        LoginPage lg=new LoginPage(driver);
    return lg;
//        return driver.findElement(login);
    }
    public WebElement getTitle(){
        return title;
    }
    public WebElement navigationBar(){
        return navBar;
    }
    public WebElement getHeader(){
        return header;
    }

}
