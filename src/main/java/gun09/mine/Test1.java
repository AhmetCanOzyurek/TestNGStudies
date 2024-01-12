package gun09;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.awt.event.ActionListener;

public class Test1 {
    HomePageBellatrix hp = new HomePageBellatrix();

    @Test
    public void initial(){
        hp.goToUrl();
    }
    @Test(dependsOnMethods = {"initial"})
    public void clicks(){
        hp.clickHome();
        hp.clickFirstItem();
    }
    @Test(dependsOnMethods = {"clicks"})
    public void verifyNBack(){
        hp.verifyItemName();
        hp.backHome();
    }
    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }
}
