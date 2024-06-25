package pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BringingGuestsPage extends BasePage {

    public BringingGuestsPage(WebDriver driver) {
        super(driver);
    }

    By BRINGING_GUESTS_TITLE_TEXT = By.xpath("//span[text()=\"Are you bringing any guests?\"]");
    By GET_NOTIFIED_TITLE_TEXT = By.xpath("//h2[@role='heading']");

    By EMAIL_NOTIFIED_INPUT = By.xpath("//input[@role=\"textbox\"]");
    By REMIND_ME_BTN = By.xpath("//button[@type='submit']");
    By SUCCESS_INFO_NOTIFIED = By.xpath("//p[@data-aid=\"CONFIRM_TEXT_REND\"]");




    public void checkBringingGuestsTitle() {
        isElementPresent(BRINGING_GUESTS_TITLE_TEXT);
        Assert.assertEquals(getText(BRINGING_GUESTS_TITLE_TEXT), "Are you bringing any guests?");
    }

    public void checkGetNotifiedTitle() {
        isElementPresent(BRINGING_GUESTS_TITLE_TEXT);
        Assert.assertEquals(getText(GET_NOTIFIED_TITLE_TEXT), "Get Notified About Your Party!");
    }

    public void checkSuccessInfoNotified() {
        isElementPresent(SUCCESS_INFO_NOTIFIED);
        Assert.assertEquals(getText(SUCCESS_INFO_NOTIFIED), "If you supplied a real email we just send a validation to it.");
    }

    public void setEmail(String mail) {
        scrollToElement(EMAIL_NOTIFIED_INPUT);
        driver.findElement(EMAIL_NOTIFIED_INPUT).sendKeys(mail);
    }

    public void clickOnRemindMeBTN() {
        isElementPresent(REMIND_ME_BTN);
        clickOnElement(REMIND_ME_BTN);
    }





















}
