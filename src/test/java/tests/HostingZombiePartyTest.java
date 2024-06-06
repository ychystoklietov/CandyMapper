package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        Assert.assertEquals(halloweenPartyPage.getHalloweenPartyTitleText(), "Halloween Party");
        halloweenPartyPage.clickOnHostingBtn();
        Assert.assertEquals(partyThemePage.getPartyThemeTitleText(), "Party Theme");
        partyThemePage.clickOnZombiesBtn();
        Assert.assertEquals(bringingGuestsPage.getBringingGuestsTitleText(), "Are you bringing any guests?");
        bringingGuestsPage.checkDropdown(driver);

    }





}
