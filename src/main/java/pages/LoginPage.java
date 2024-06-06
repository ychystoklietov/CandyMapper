package pages;

import junit.framework.Assert;
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
        driver.findElement(SIGN_IN_EMAIL_INPUT).sendKeys(email);
    }
    public void setSignInPassword(String password) {
        driver.findElement(SIGN_IN_PASSWORD_INPUT).sendKeys(password);
    }
    public void clickOnSignInSubmitBtn() {
        driver.findElement(SIGN_IN_SUBMIT_BTN).click();
    }
    public void clickOnResetPasswordBtn() {
        driver.findElement(RESET_PASSWORD_BTN).click();
    }
    public void clickOnCreateAccountBtn() {
        driver.findElement(CREATE_ACCOUNT_BTN).click();
    }

    public void checkErrorMessageEmail() {
        waitForElementToBeVisible(ERROR_MESSAGE_EMAIL);
        Assert.assertEquals(getText(ERROR_MESSAGE_EMAIL), "Enter a valid email address.");
    }

    public void checkErrorMessagePassword() {
        waitForElementToBeVisible(ERROR_MESSAGE_PASSWORD);
        Assert.assertEquals(getText(ERROR_MESSAGE_PASSWORD), "Passwords can’t be nothing.");
    }

    public void checkErrorMessageCombo() {
        waitForElementToBeVisible(ERROR_MESSAGE_COMBO);
        Assert.assertEquals(getText(ERROR_MESSAGE_COMBO), "The password/email address combo is incorrect.");
    }



























}
