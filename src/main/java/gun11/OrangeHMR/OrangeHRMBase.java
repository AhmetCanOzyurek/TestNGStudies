package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMBase {
    WebDriver driver;
    WebDriverWait wait;
    public  void click(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public  void click(WebElement element){
        element.click();
    }
    public void sendKeys(By locator, String txt){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(txt);

    }
    public void sendKeys(WebElement element, String txt){
        element.clear();
        element.sendKeys(txt);
    }
    public void verifyVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

