package gun07.xml3;

import org.testng.annotations.*;

public class Test3xml {

@BeforeSuite
@Parameters("version")
public void beforeSuite(@Optional("safari") String browser){
        System.out.println(browser);
}
    @BeforeTest()
    @Parameters("browser")
    public void beforeTest(@Optional("firefox") String browser1){
        System.out.println(browser1);
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
