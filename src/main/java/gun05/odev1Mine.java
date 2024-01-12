package gun05;

import gun02.TestOrnekBAse;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static gun02.Locators.*;
public class odev1 extends TestOrnekBAse {
@BeforeTest
    public void goToUrl(){
    driver.get(url);
}
    @Test
    public void login(){
        sendKeys(lUsername,"Admin");
        sendKeys(lPassword,"admin123");
        click(lSubmit);
    }
    @Test(dependsOnMethods = {"login"})
    public void choseAdmin(){
    click(lSidePanelADmin);
    click(lAddAdmin);
    }
    @Test(dependsOnMethods = {"choseAdmin"})
    public void addAdmin(){
    click(lUserRole);
    click(lUserRoleAdmin);
    click(lStatus);
    click(lStatusEnabled);
        WebElement etypeForhints = driver.findElement(lTypeforHints);
        new Actions(driver)
                .sendKeys(etypeForhints,"cec")
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();
        sendKeys(lUserNameAdmin,"cqqq");
        sendKeys(lPaswordAdmin,"aA1234#");
        sendKeys(lPaswordAgainAdmin,"aA1234#");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        
    }


}
