package gun08.ThradLocalRun;

import org.testng.annotations.Test;

public class TestParallel extends TestParallelBase {
HomePage1 hp;
@Test
    public void test1(){
    hp = new HomePage1();
    hp.goToUrl();
}
@Test(dependsOnMethods = {"test1"})
    public void test2(){
    hp.login();
}
@Test(dependsOnMethods = {"test2"})
    public void test3(){
    hp.logout();
}
}
