import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by sstep on 12/18/2014.
 */
public class MainClass {
    private WebDriver driver;
    // public WebElement text=driver.findElement(By.id("gbqfq"));

    public MainClass() {
        driver = new FirefoxDriver();
    }

    public void openBrowser(String text) {
        driver.get(text);
    }

    boolean isElementPresent(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    /*@Test
    public void open()
    {
        driver.get("http://google.com");
    }*/
}
