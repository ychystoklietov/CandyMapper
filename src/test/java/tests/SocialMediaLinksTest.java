package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SocialMediaLinksTest extends BaseTest {

    @Test
    public void checkSocialMediaLinks() {
        HomePage homePage = new HomePage(driver);

        homePage.openURL();
        homePage.closePopUpBTN();
        homePage.checkSharingToSocialMediaTitle();
        homePage.checkFacebookLink();
        homePage.checkInstagramLink();
        homePage.checkLinkedinLink();
        homePage.checkPinterestLink();
        homePage.checkTwitterLink();
        homePage.checkYoutubeLink();

    }
}
