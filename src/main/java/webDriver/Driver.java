package webDriver;

import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sstep on 12/22/2014.
 */
public class Driver {
    public static WebDriver getInstance(){
        WebDriver webDriver = null;
        if (PropertyLoader.loadProperty("browser.name").isEmpty()){
            webDriver=new FirefoxDriver();
        }
        if (PropertyLoader.loadProperty("browser.name").equalsIgnoreCase("chrome")){
            webDriver=ChromeWebDriver.getInstance();
        }
        if (PropertyLoader.loadProperty("browser.name").equalsIgnoreCase("IE")){
           webDriver=IEWebDriver.getInstance();
        }
        return webDriver;
    }
}
