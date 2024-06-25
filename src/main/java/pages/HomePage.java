package pages;

//import junit.framework.Assert;
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

    By JOIN_US_BTN = By.cssSelector("a[href='/join-us'].c2-g");
    By HALLOWEEN_PARTY_BTN = By.cssSelector("a[href='/halloween-party'].c1-56");
    By CONTACT_US_NAME_FIELD = By.id("input28");
    By CONTACT_US_EMAIL_FIELD = By.id("input28");
//    By POPUP_CLOSE_BTN = By.id("popup-widget72915-close-icon");
    By POPUP_CLOSE_BTN = By.xpath("//div[@class='x-el x-el-div c1-1 c1-2 c1-r c1-49 c1-5h c1-5i c1-5f c1-12 c1-u c1-9m c1-an c1-b c1-c c1-d c1-e c1-f c1-g']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
    By POPUP_CLOSE = By.xpath("//div[@data-ux='Block']/a[text()='FIND MY CANDY!']");
    By SHARING_TO_SOCIAL_MEDIA_TITLE = By.xpath("//span[normalize-space()='Connect with us on Social Media']");
    By FACEBOOK_ICON = By.xpath("//a[@aria-label=\"Facebook Social Link\"]");
    By INSTAGRAM_ICON = By.xpath("//a[@aria-label=\"Instagram Social Link\"]");
    By LINKEDIN_ICON = By.xpath("//a[@aria-label=\"LinkedIn Social Link\"]");
    By PINTEREST_ICON = By.xpath("//a[@aria-label=\"Pinterest Social Link\"]");
    By TWITTER_ICON = By.xpath("//a[@aria-label=\"Twitter Social Link\"]");
    By YOUTUBE_ICON = By.xpath("//a[@aria-label=\"YouTube Social Link\"]");

    public boolean isLinkBroken(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            String url = element.getAttribute("href");

            if (url == null || url.isEmpty()) {
//                System.out.println("URL is either not configured for anchor tag or it is empty");
                throw new RuntimeException("URL is either not configured for anchor tag or it is empty");
            }

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode >= 400) {
//                System.out.println("Broken link: " + url + " - Response Code: " + responseCode);
                throw new RuntimeException("Link is broken. HTTP Status code: " + responseCode);
            } else {
                System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
                return true;
            }
        } catch (IOException e) {
//            System.out.println("Error checking link: " + e.getMessage());
            throw new RuntimeException("Error checking the link status", e);
        }
    }

    public void clickJoinUsBTN() {
        isElementPresent(JOIN_US_BTN);
        clickOnElement(JOIN_US_BTN);
    }
    public void clickHalloweenPartyBTN() {
        isElementPresent(HALLOWEEN_PARTY_BTN);
        clickOnElement(HALLOWEEN_PARTY_BTN);
    }

    public void openURL() {
        driver.get(baseURL);
    }

    public void closePopUpBTN() {
//        waitForElementToBeVisible(POPUP_CLOSE_BTN);
//        clickOnElement(POPUP_CLOSE_BTN);
        clickOnElement(POPUP_CLOSE);
    }

    public void checkSharingToSocialMediaTitle() {
        scrollToElement(SHARING_TO_SOCIAL_MEDIA_TITLE);
        isElementPresent(SHARING_TO_SOCIAL_MEDIA_TITLE);
        Assert.assertEquals(getText(SHARING_TO_SOCIAL_MEDIA_TITLE), "Connect with us on Social Media");
    }
    public void checkFacebookLink() {
        scrollToElement(FACEBOOK_ICON);
        isElementPresent(FACEBOOK_ICON);
        isLinkBroken(FACEBOOK_ICON);
    }
    public void checkInstagramLink() {
        scrollToElement(INSTAGRAM_ICON);
        isElementPresent(INSTAGRAM_ICON);
        isLinkBroken(INSTAGRAM_ICON);
    }

    public void checkLinkedinLink() {
        scrollToElement(LINKEDIN_ICON);
        isElementPresent(LINKEDIN_ICON);
        isLinkBroken(LINKEDIN_ICON);
    }
    public void checkTwitterLink() {
        scrollToElement(PINTEREST_ICON);
        isElementPresent(PINTEREST_ICON);
        isLinkBroken(PINTEREST_ICON);
    }
    public void checkPinterestLink() {
        scrollToElement(TWITTER_ICON);
        isElementPresent(TWITTER_ICON);
        isLinkBroken(TWITTER_ICON);
    }

    public void checkYoutubeLink() {
        scrollToElement(YOUTUBE_ICON);
        isElementPresent(YOUTUBE_ICON);
        isLinkBroken(YOUTUBE_ICON);
    }

    public List<WebElement> getDropdownList() {
        scrollToElement(SHARING_TO_SOCIAL_MEDIA_TITLE);
        WebElement iframe = driver.findElement(By.xpath("//div[@id='bs-6']/span/iframe"));
        driver.switchTo().frame(iframe);
        return driver.findElements(By.xpath("//option"));
    }

    public void selectCountryFromList(List<WebElement> dropdownList, String country) {
        boolean found = false;
        for (WebElement element : dropdownList) {
            if (element.getText().equals(country)) {
                element.click();
                found = true;
                break;
            }
        }

        if (!found) {

            throw new RuntimeException("Error: Country '" + country + "' not found in the dropdown list.");
        } else {
            System.out.println("Country selected successfully: " + country);
        }

        driver.switchTo().defaultContent();

    }

    public void selectDesiredCountry(String city) {
        selectCountryFromList(getDropdownList(), city);
    }
















}
