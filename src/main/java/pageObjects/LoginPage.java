package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

private @FindBy(id = "user_email") WebElement emailAddress;
private @FindBy(id = "user_password") WebElement password;
private @FindBy(xpath = "//*[@id=\"hero\"]/div/form/div[3]/input") WebElement lgnBtn;
//By login=By.cssSelector("a[href*='sign_in']");
    public LoginPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public WebElement loginEmail(){
    return emailAddress;
//        return driver.findElement(login);
    }
    public WebElement loginPassword(){
        return password;
    }
    public WebElement loginBtn(){
        return lgnBtn;
    }
}
