package gun08.ThradLocalRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class HomePage1 {
    String url = "https://opencart.abstracta.us/";
    String myMail = "deneme@deneme.com";
    String myPassword = "deneme";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//div[@id='top-links']//a[contains(.,'My Account')]")
    public WebElement eMyAccount;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Login')]")
    public WebElement eLogin;
    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Logout')]")
    public WebElement eLogout;
    @FindBy(id="input-email")
    public WebElement eLoginFormUN;
    @FindBy(id="input-password")
    public WebElement eLoginFormPassword;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement eloginSubmit;

    @FindBy(xpath="//aside//a[.='My Account']")
    public WebElement eRightMenuMyAccount;
    @FindBy(xpath="//aside//a[.='Logout']")
    public WebElement eRightMenuLogout;
    @FindBy(xpath="//aside//a[.='Login']")
    public WebElement eRightMenuLogin;
    public HomePage1(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public HomePage1(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendKeys(WebElement element, String text){
        WebElement element1 = waitUntilVisible(element);
        element1.clear();
        element1.sendKeys(text);
    }
    public WebElement waitUntilVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void goToUrl(){
        driver.get(url);
    }
    public void login(){
        click(eMyAccount);
        waitUntilVisible(eLogin);
        click(eLogin);
        sendKeys(eLoginFormUN,myMail);
        sendKeys(eLoginFormPassword,myPassword);
        click(eloginSubmit);
        waitUntilVisible(eRightMenuLogout);
    }
    public void logout(){
        click(eMyAccount);
        waitUntilVisible(eLogout);
        click(eLogout);

        click(eMyAccount);
        waitUntilVisible(eLogin);
    }
}
