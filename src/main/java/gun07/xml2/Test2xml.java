package gun07.xml2;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1xml {

    @BeforeTest
    public void beforeTest(String browser){
        System.out.println(browser);
    }
    @BeforeClass
    public void beforeClass(){

    }

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }

    @Test
    public void test3(){
        System.out.println("Test3");
    }

    @Test
    public void test4(){
        System.out.println("Test4");
    }

}
