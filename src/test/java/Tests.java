import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import webDriver.Driver;

import java.util.concurrent.TimeUnit;


/**
 * Created by sstep on 12/18/2014.
 */
public class Tests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp() {
        driver = Driver.getInstance();
        driver.get(PropertyLoader.loadProperty("url"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyLoader.loadProperty("timeout")), TimeUnit.SECONDS);
        mainPage=new MainPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test()
    public void openTelMP3TabTest() {
        mainPage.openTab(mainPage.tel_mp3_tab);
    }
}
