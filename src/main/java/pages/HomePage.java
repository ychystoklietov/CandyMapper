package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://candymapper.com/";

    By JOIN_US_BTN = By.cssSelector("a[href='/join-us'].c2-g");

    By CONTACT_US_NAME_FIELD = By.id("input28");
    By CONTACT_US_EMAIL_FIELD = By.id("input28");


    public void clickJoinUsBTN() {
        driver.findElement(JOIN_US_BTN).click();
    }

    public void openURL() {
        driver.get(baseURL);
    }



}
