package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sstep on 12/22/2014.
 */
public class ChromeWebDriver {
    public static WebDriver getInstance(){
        return new ChromeDriver();
    }
}
