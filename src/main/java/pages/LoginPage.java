package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By SignInEmailInput = By.xpath("//input[@name=\"email\"]");
    By SignPasswordInput = By.xpath("//input[@name=\"password\"]");
    By SignInSubmitBTN = By.xpath("//button[@type='submit']");

}
