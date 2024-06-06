package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartyThemePage extends BasePage {

    public PartyThemePage(WebDriver driver) {
        super(driver);
    }

    By PARTY_THEME_TITLE_TEXT = By.xpath("//h1[@role='heading']");
    By ZOMBIES_BTN = By.xpath("//a[text()=\"Zombies\"]");
    By GHOSTS_BTN = By.xpath("//a[text()=\"Ghosts\"]");


    public void checkPartyThemeTitle() {
        waitForElementToBeVisible(PARTY_THEME_TITLE_TEXT);
        Assert.assertEquals(getText(PARTY_THEME_TITLE_TEXT), "Party Theme");
    }

    public void clickOnZombiesBtn() {
        isElementPresent(ZOMBIES_BTN);
        clickOnElement(ZOMBIES_BTN);
    }
    public void clickOnGhostsBtn() {
        isElementPresent(GHOSTS_BTN);
        clickOnElement(GHOSTS_BTN);
    }






}
