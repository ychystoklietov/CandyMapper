package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class CountryDropdownTest extends BaseTest {

    @Test
    public void setCountryFromDropdown() {
        HomePage homePage = new HomePage(driver);
        homePage.openURL();
        homePage.closePopUpBTN();
        homePage.selectDesiredCountry("Rutland");

    }
}
