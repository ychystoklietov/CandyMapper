package pages;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BringingGuestsPage extends BasePage {

    public BringingGuestsPage(WebDriver driver) {
        super(driver);
    }

    By BRINGING_GUESTS_TITLE_TEXT = By.xpath("//span[text()=\"Are you bringing any guests?\"]");

    By DROPDOWN = By.id("guests");


    public String getBringingGuestsTitleText() {
        Assert.
        isElementPresent(BRINGING_GUESTS_TITLE_TEXT);
        return getText(BRINGING_GUESTS_TITLE_TEXT);
    }














}
