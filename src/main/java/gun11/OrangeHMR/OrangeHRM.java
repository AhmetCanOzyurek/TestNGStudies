package gun11;

import gun02.TestOrnekBAse;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class OrangeHRM extends OrangeHRMBase {
    By lusernameOHRM = By.xpath("//input[@name = 'username']");
    By lpasswordOHRM = By.xpath("//input[@name = 'password']");
    By lSubmitOHRM = By.xpath("//button[@type = 'submit']");
    By lTopBarUser = By.xpath("//span[@class='oxd-userdropdown-tab']");

    @BeforeTest
    public void beforeTEst(){
        String browser = ConfigReader.get("browser");
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }

    @Test
    public void login(){
        String username = ConfigReader.get("orangehrm.username");
        String password = ConfigReader.get("orangehrm.pass");
        String url = ConfigReader.get("orangehrm.url");

        driver.get(url);

        sendKeys(lusernameOHRM,username);
        sendKeys(lpasswordOHRM,password);
        click(lSubmitOHRM);
        verifyVisibility(lTopBarUser);
    }
}
