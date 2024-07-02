package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;


    @BeforeClass
    public void setUp() {
        System.out.println("Start Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Delete all cookies");
        driver.manage().deleteAllCookies();
        System.out.println("End of the tests");
        driver.quit();
    }







}
