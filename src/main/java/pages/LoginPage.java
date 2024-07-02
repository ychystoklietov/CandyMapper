package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By SIGN_IN_EMAIL_INPUT = By.xpath("//input[@name=\"email\"]");
    By SIGN_IN_PASSWORD_INPUT = By.xpath("//input[@name=\"password\"]");
    By SIGN_IN_SUBMIT_BTN = By.xpath("//button[@type='submit']");
    By RESET_PASSWORD_BTN = By.xpath("//a[normalize-space()='Reset password']");
    By CREATE_ACCOUNT_BTN = By.xpath("//a[normalize-space()='Create account.']");
    By ERROR_MESSAGE_EMAIL = By.xpath("//p[normalize-space()='Enter a valid email address.']");
    By ERROR_MESSAGE_PASSWORD = By.xpath("//p[contains(text(),'Passwords can’t be nothing.')]");
    By ERROR_MESSAGE_COMBO = By.xpath("//p[@role='alertdialog']");

    public void setSignInEmail(String email) {
        log.info("Wpisuję email");
        driver.findElement(SIGN_IN_EMAIL_INPUT).sendKeys(email);
    }
    public void setSignInPassword(String password) {
        log.info("Wpisuję hasło");
        driver.findElement(SIGN_IN_PASSWORD_INPUT).sendKeys(password);
    }
    public void clickOnSignInSubmitBtn() {
        log.info("Klikam submit");
        driver.findElement(SIGN_IN_SUBMIT_BTN).click();
    }
    public void clickOnResetPasswordBtn() {
        log.info("Klikam reset hasła");
        driver.findElement(RESET_PASSWORD_BTN).click();
    }
    public void clickOnCreateAccountBtn() {
        log.info("Klikam `Create account`");
        driver.findElement(CREATE_ACCOUNT_BTN).click();
    }

    public void checkErrorMessageEmail() {
        log.info("Sprawdzam komunikat walidacyjny dla maila");
        waitForElementToBeVisible(ERROR_MESSAGE_EMAIL);
        Assert.assertEquals(getText(ERROR_MESSAGE_EMAIL), "Enter a valid email address.");
    }

    public void checkErrorMessagePassword() {
        log.info("Sprawdzam komunikat walidacyjny dla hasła");
        waitForElementToBeVisible(ERROR_MESSAGE_PASSWORD);
        Assert.assertEquals(getText(ERROR_MESSAGE_PASSWORD), "Passwords can’t be nothing.");
    }

    public void checkErrorMessageCombo() {
        log.info("Sprawdzam ogólny komunikat walidacyjny");
        waitForElementToBeVisible(ERROR_MESSAGE_COMBO);
        Assert.assertEquals(getText(ERROR_MESSAGE_COMBO), "The password/email address combo is incorrect.");
    }



























}
