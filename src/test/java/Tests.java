import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MobilPhonePage;
import webDriver.Driver;

import java.util.concurrent.TimeUnit;


public class Tests {
    private WebDriver driver;
    private MainPage mainPage;
    private MobilPhonePage mobilPhonePage;

    @BeforeTest
    public void setUp() {
        driver = Driver.getInstance();
        driver.get(PropertyLoader.loadProperty("url"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyLoader.loadProperty("timeout")), TimeUnit.SECONDS);
        mainPage=new MainPage(driver);
        mobilPhonePage=new MobilPhonePage(driver);
    }

    @AfterTest
    public void tearDown() {
     //   driver.close();
    }

    @Test()
    public void openTelTest() {
        mainPage.selectTeleph();
        Assert.assertTrue(driver.getTitle().contains("Мобильные телефоны"));
    }
}
