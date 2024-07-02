package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }



    String baseURL = "https://candymapper.com/";

    By JOIN_US_BTN = By.cssSelector("a[href='/join-us'].c2-x");
    By HALLOWEEN_PARTY_BTN = By.cssSelector("a[href='/halloween-party'].c1-56");
    By CONTACT_US_NAME_FIELD = By.id("input28");
    By CONTACT_US_EMAIL_FIELD = By.id("input28");

//    By POPUP_CLOSE_BTN = By.id("popup-widget72915-close-icon");
    By POPUP_CLOSE_BTN = By.xpath("//*[contains(@id, \"close-icon\")]");
    By FIND_MY_CANDY_BTN = By.xpath("//div[@data-ux='Block']/a[text()='FIND MY CANDY!']");
    By SHARING_TO_SOCIAL_MEDIA_TITLE = By.xpath("//span[normalize-space()='Connect with us on Social Media']");
    By VALIDATE_RANDOM_DOLLAR_TITLE = By.xpath("//span[normalize-space()='Validate Random Dollar Amounts']");
    By FACEBOOK_ICON = By.xpath("//a[@aria-label=\"Facebook Social Link\"]");
    By INSTAGRAM_ICON = By.xpath("//a[@aria-label=\"Instagram Social Link\"]");
    By LINKEDIN_ICON = By.xpath("//a[@aria-label=\"LinkedIn Social Link\"]");
    By PINTEREST_ICON = By.xpath("//a[@aria-label=\"Pinterest Social Link\"]");
    By TWITTER_ICON = By.xpath("//a[@aria-label=\"Twitter Social Link\"]");
    By YOUTUBE_ICON = By.xpath("//a[@aria-label=\"YouTube Social Link\"]");

    public boolean isLinkBroken(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            log.info("Pobieram link");
            String url = element.getAttribute("href");

            log.info("Sprawdzam, że link nie jest null");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL is either not configured for anchor tag or it is empty");
            }

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            log.info("Sprawdzam request");
            connection.setRequestMethod("HEAD");
            connection.connect();
            log.info("Pobieram kod odpowiedzi");
            int responseCode = connection.getResponseCode();

            if (responseCode >= 400) {
                throw new RuntimeException("Link is broken. HTTP Status code: " + responseCode);
            } else {
                System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error checking the link status", e);
        }
    }

    public void clickJoinUsBTN() {
        log.info("Klikam `Joun us`");
        waitForElementToBeVisible(JOIN_US_BTN);
        isElementPresent(JOIN_US_BTN);
        clickOnElement(JOIN_US_BTN);
    }
    public void clickHalloweenPartyBTN() {
        log.info("Klikam `Halloween party`");
        isElementPresent(HALLOWEEN_PARTY_BTN);
        clickOnElement(HALLOWEEN_PARTY_BTN);
    }

    public void openURL() {
        log.info("Otwieram strone CandyMapper");
        driver.get(baseURL);
    }

    public void closePopUpBTN() {
        log.info("Zamykam popup");
        waitForElementToBeVisible(POPUP_CLOSE_BTN);
        clickOnElement(POPUP_CLOSE_BTN);
//        waitForElementToBeVisible(FIND_MY_CANDY_BTN);
//        clickOnElement(FIND_MY_CANDY_BTN);
    }

    public void checkSharingToSocialMediaTitle() {
        log.info("Sprawdzam tytul `Sharing to social media`");
        scrollToElement(SHARING_TO_SOCIAL_MEDIA_TITLE);
        isElementPresent(SHARING_TO_SOCIAL_MEDIA_TITLE);
        Assert.assertEquals(getText(SHARING_TO_SOCIAL_MEDIA_TITLE), "Connect with us on Social Media");
    }
    public void checkFacebookLink() {
        log.info("Sprawdzam link facebook");
        scrollToElement(FACEBOOK_ICON);
        isElementPresent(FACEBOOK_ICON);
        isLinkBroken(FACEBOOK_ICON);
    }
    public void checkInstagramLink() {
        log.info("Sprawdzam link instgram");
        scrollToElement(INSTAGRAM_ICON);
        isElementPresent(INSTAGRAM_ICON);
        isLinkBroken(INSTAGRAM_ICON);
    }

    public void checkLinkedinLink() {
        log.info("Sprawdzam link linkedin");
        scrollToElement(LINKEDIN_ICON);
        isElementPresent(LINKEDIN_ICON);
        isLinkBroken(LINKEDIN_ICON);
    }
    public void checkTwitterLink() {
        log.info("Sprawdzam link twitter");
        scrollToElement(TWITTER_ICON);
        isElementPresent(TWITTER_ICON);
        isLinkBroken(TWITTER_ICON);
    }
    public void checkPinterestLink() {
        log.info("Sprawdzam link pinterest ");
        scrollToElement(PINTEREST_ICON);
        isElementPresent(PINTEREST_ICON);
        isLinkBroken(PINTEREST_ICON);
    }

    public void checkYoutubeLink() {
        log.info("Sprawdzam link youtube");
        scrollToElement(YOUTUBE_ICON);
        isElementPresent(YOUTUBE_ICON);
        isLinkBroken(YOUTUBE_ICON);
    }

    public List<WebElement> getDropdownList() {
        scrollToElement(VALIDATE_RANDOM_DOLLAR_TITLE);
        log.info("Szukam iframe na stronie");
        WebElement iframe = driver.findElement(By.xpath("//div[@id='bs-6']/span/iframe"));
        log.info("Robię swticha na iframe");
        driver.switchTo().frame(iframe);
        log.info("Pobieram listę dropdown");
        return driver.findElements(By.xpath("//option"));
    }

    public void selectCountryFromList(List<WebElement> dropdownList, String country) {
        boolean found = false;
        log.info("Sprawdzam listę krajów");
        for (WebElement element : dropdownList) {
            if (element.getText().equals(country)) {
                log.info("Kraj " + country + " znajduje się na liście");
                element.click();
                log.info("Wybrano kraj: " + country);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("Error: Country '" + country + "' not found in the dropdown list.");
        } else {
            System.out.println("Country selected successfully: " + country);
        }

        log.info("Robię switcha na web");
        driver.switchTo().defaultContent();

    }

    public void selectDesiredCountry(String country) {
        log.info("Wybieram odpowiedni kraj z listy ");
        selectCountryFromList(getDropdownList(), country);
    }
















}
