import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by sstep on 12/18/2014.
 */
public class Tests {

    @BeforeTest
    public void setUp() {
        WebDriver driver = new FirefoxDriver();
        driver.get(PropertyLoader.loadProperty("url"));
    }

    @AfterTest
    public void tearDown() {

    }

    @Test()
    public void openTest() {

    }
}
