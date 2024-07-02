package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    protected static final Logger log = LogManager.getLogger();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToBeClickable(By by) {
        log.info("Czekam aż można będzie kliknąć element: " + by);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisible(By by) {
        log.info("Czekam na element: " + by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForTextToBePresentInElement(By by, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public String getText(By by) {
        log.info("Pobieram teskt elementu: " + by);
        waitForElementToBeVisible(by);
        WebElement element = driver.findElement(by);
        log.info("Pobralem tekst elementu: " + by);
        return element.getText();
    }

    public void scrollToElement(By by) {
        log.info("Scrolluje do elementu: " + by);
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickOnElement(By by) {
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
        log.info("Klikam w: " + by);
    }
    public boolean isElementPresent(By by) {
        try {
            log.info("Emelent widoczny: " + by);
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            log.info("Emelent nie widać: " + by);
            return false;
        }
    }



























}
