package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class ValidContactUs extends BaseTest {

    @Test
    public void randomTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openURL();
    }



}
