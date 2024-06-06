package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.openURL();
        homePage.closePopUpBTN();
        homePage.clickJoinUsBTN();
        loginPage.clickOnSignInSubmitBtn();
        Assert.assertEquals(loginPage.getErrorMessageEmail(), "Enter a valid email address.");
        Assert.assertEquals(loginPage.getErrorMessagePassword(), "Passwords can’t be nothing.");
   }






}
