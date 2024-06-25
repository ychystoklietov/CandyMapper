package tests;

import org.testng.annotations.Test;
import pages.BringingGuestsPage;
import pages.HalloweenPartyPage;
import pages.HomePage;
import pages.PartyThemePage;

public class HostingZombiePartyTest extends BaseTest {

    @Test
    public void hostingZombiePartyWay() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        HalloweenPartyPage halloweenPartyPage = new HalloweenPartyPage(driver);
        PartyThemePage partyThemePage = new PartyThemePage(driver);
        BringingGuestsPage bringingGuestsPage = new BringingGuestsPage(driver);

        homePage.openURL();
        homePage.closePopUpBTN();
        homePage.clickHalloweenPartyBTN();
        halloweenPartyPage.checkHalloweenPartyTitleText();
        halloweenPartyPage.clickOnHostingBtn();
        partyThemePage.checkPartyThemeTitle();
        partyThemePage.clickOnZombiesBtn();
        bringingGuestsPage.checkBringingGuestsTitle();
        bringingGuestsPage.setEmail("test@mail.com");
        bringingGuestsPage.clickOnRemindMeBTN();
        bringingGuestsPage.checkSuccessInfoNotified();

    }





}
