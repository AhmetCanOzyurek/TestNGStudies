package gun03;

import gun02.TestOrnekBAse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static gun02.Locators.*;

public class DataProvidertest extends TestOrnekBAse {

    @BeforeTest
    public void toTheSite(){
        driver.get(url);
    }
    @Test(dataProvider = "getUsers")
    public void login(String username, String password,boolean pass){
        sendKeys(lUsername,username);
        sendKeys(lPassword,password);
        click(lSubmit);
    }
    @DataProvider
    public Object[][] getUsers(){
        return new Object[][]{
                {"Admin1","admin123",false},
                {"Admin2","admin1234",false},
                {"Admin3","admin12345",false},
                {"Admin4","admin123567",false},
                {"Admin5","admin123456",false},
                {"Admin6","admin1235677",false},
                {"Admin7","admin123132",false},
                {"Admin8","admin1232",false},
                {"Admin9","admin123234",false},
                {"Admin","admin123",true},
        };
    }

}
