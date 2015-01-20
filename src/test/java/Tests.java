import framework.Loader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MobilPhonePage;
import webDriver.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Tests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp() {
        driver = Driver.getInstance();
        driver.get(Loader.loadProperty("url"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Loader.loadProperty("timeout")), TimeUnit.SECONDS);
        mainPage=new MainPage(driver);
        mainPage.clearResultFile();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openPhonePage() {
        mainPage.mobilPhonePage=mainPage.openMobilPhonePage();
        Assert.assertTrue(driver.getTitle().contains("мобильные телефоны"));
    }

    @Test
    private void selectTopRaitingTest(){
        mainPage.writeToFile("\n------------------\nselectTopRaitingTest:");
        mainPage.mobilPhonePage.selectTopAllPhoneRaiting();
    }

    @Test
    private void selectExpensivePhoneTest(){
        mainPage.writeToFile("\n------------------\nselectExpensivePhoneTest:");
        mainPage.mobilPhonePage.selectTopAllPhoneExpensive();
    }

    @Test
    private void sortAllTest(){
        mainPage.writeToFile("\n------------------\nsortAllTest");
        mainPage.mobilPhonePage.allSorting();
    }

    @Test
    private void popularByFirmTest(){
        mainPage.writeToFile("\n------------------\npopularByFirmTest");
        mainPage.mobilPhonePage.allPhoneProduser();
    }

}
