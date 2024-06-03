package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://candymapper.com/";

    public void openURL() {
        driver.get(baseURL);
    }



}
