package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    By CREATE_ACCOUNT_TITLE = By.xpath("//span[text()=\"Create Account\"]");
    By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='First name']");
    By LAST_NAME_INPUT = By.xpath("//input[@placeholder='Last name']");
    By EMAIL_INPUT = By.xpath("//input[@placeholder='Email']");
    By PHONE_INPUT = By.xpath("//input[@placeholder='Phone (optional)']");

//    By CHECKBOX_MAILING = By.xpath("//input[@data-ux='InputCheckbox']/following-sibling::div[@data-ux='Element']");
    By CREATE_ACCOUNT_BTN = By.xpath("//button[normalize-space()='Create Account']");
    By CREATE_ACCOUNT_SUCCESS_SCREEN = By.xpath("//h4[@role='heading']");



    public void checkCreateAccountTitleMessage() {
        log.info("Sprawdzam, że `Create account` title jest widoczny");
        isElementPresent(CREATE_ACCOUNT_TITLE);
        Assert.assertEquals(getText(CREATE_ACCOUNT_TITLE), "Create Account");
    }


    public void setFirstName(String name) {
        log.info("Wpusuję first name");
        driver.findElement(FIRST_NAME_INPUT).sendKeys(name);
    }
    public void setLastName(String lastname) {
        log.info("Wpisuję last name");
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastname);
    }
    public void setEmail(String email) {
        log.info("Wpisuję email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }
    public void setPhone(String phone) {
        log.info("Wpisuję telefon");
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }

//    public void clickOnCheckboxMailing() {
//        isElementPresent(CHECKBOX_MAILING);
//        clickOnElement(CHECKBOX_MAILING);
//    }

    public void clickOnCreateAccountBtn() {
        log.info("Klikam `Create account`");
        isElementPresent(CREATE_ACCOUNT_BTN);
        clickOnElement(CREATE_ACCOUNT_BTN);
    }

    public void checkSuccessMessage() {
        log.info("Sprawdzam, że `Create account succes screen` jest widoczny");
        isElementPresent(CREATE_ACCOUNT_SUCCESS_SCREEN);
        Assert.assertEquals(getText(CREATE_ACCOUNT_SUCCESS_SCREEN), "Check your email");
    }









}
