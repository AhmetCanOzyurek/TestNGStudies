package gun09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;
import java.util.stream.Collectors;

public class HomePageBellatrix {
    WebDriver driver;
    WebDriverWait wait;

    public HomePageBellatrix(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
String url = "https://demos.bellatrix.solutions/";
    public void goToUrl(){
        driver.get(url);
    }
    public void clickHome(){
        WebElement eTopbarHome = driver.findElement(By.xpath("(//div[@class = 'menu']//li[.='Home'])[1]"));
        eTopbarHome.click();
    }
    public WebElement firstItem(){
       return driver.findElement(By.xpath("(//li[contains(@class,'product type-product')])[1]"));
    }
    public void clickFirstItem(){
        firstItem().click();
    }
    public String getProductName(){
      String productTitle = driver.findElement(By.xpath("(//li[contains(@class,'product type-product')])[1]//*[text()='Falcon 9']")).getText();
      return productTitle;
    }
    public void verifyItemName(){
        String sItemName= driver.findElement(By.xpath("//h1[contains(@class,'title')]")).getText();
        Assert.assertEquals(getProductName(),sItemName);
    }

    public void backHome(){
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'title')]")));
    }
    public void clickMenu(String text){
        By menuToggleButton = By.cssSelector("#site-navigation-menu-toggle");
        By locator = By.xpath("//a[text()='"+text+"']");
        if (driver.findElements(menuToggleButton).size()>0 && driver.findElement(menuToggleButton).isDisplayed()){
            driver.findElement(menuToggleButton).click();
        }
        driver.findElements(locator)
                .stream()
                .filter(e->e.isDisplayed())
                .collect(Collectors.toList())
                .get(0)
                .click();
    }


}
