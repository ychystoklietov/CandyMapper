package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class CreateAccountTest extends BaseTest {

    @Test
    public void SignIn() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.openURL();
        homePage.closePopUpBTN();
        homePage.clickJoinUsBTN();
        loginPage.clickOnCreateAccountBtn();
        Assert.assertEquals(createAccountPage.getCreateAccountTitleText(), "Create Account");
        createAccountPage.setFirstName("TestName");
        createAccountPage.setLastName("TestLastName");
        createAccountPage.setEmail("testowy@mail.com");
        createAccountPage.setPhone("1231231231");
        createAccountPage.clickOnCheckboxMailing();
        createAccountPage.clickOnCreateAccountBtn();
        Assert.assertEquals(createAccountPage.getSuccessMessage(), "Check your email");

    }
}
