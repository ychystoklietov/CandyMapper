package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HalloweenPartyPage extends BasePage {

    public HalloweenPartyPage(WebDriver driver) {
        super(driver);
    }

    By HALLOWEEN_PARTY_TITLE_TEXT = By.xpath("//h1[@role='heading']");
    By HOSTING_PARTY_BTN = By.xpath("//a[text()=\"I Am Hosting A Party\"]");
    By ATTENDING_PARTY_BTN = By.xpath("//a[text()=\"I Am Attending A Party\"]");

    public String getHalloweenPartyTitleText() {
        isElementPresent(HALLOWEEN_PARTY_TITLE_TEXT);
        return getText(HALLOWEEN_PARTY_TITLE_TEXT);
    }

    public void clickOnHostingBtn() {
        isElementPresent(HOSTING_PARTY_BTN);
        clickOnElement(HOSTING_PARTY_BTN);
    }
    public void clickOnAttendingBtn() {
        isElementPresent(ATTENDING_PARTY_BTN);
        clickOnElement(ATTENDING_PARTY_BTN);
    }






}
