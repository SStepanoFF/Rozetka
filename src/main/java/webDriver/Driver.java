package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sstep on 12/22/2014.
 */
public class Driver {
    public static WebDriver getInstance(){
        WebDriver webDriver=new ChromeDriver(); // must change
        return webDriver;
    }
}
