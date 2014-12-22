package pages;

import com.oracle.webservices.internal.api.message.PropertySet;
import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey on 22.12.2014.
 */
public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        WebDriverWait wait=new WebDriverWait(driver, Integer.parseInt(PropertyLoader.loadProperty("timeout")));
        wait.until(ExpectedConditions.visibilityOf(mainMenu));
    }

    @FindBy(className="m-main-t")
    public WebElement mainMenu;

    @FindBy(css="m-main-title-text")
    public WebElement tel_mp3_tab;

    public void openTab(WebElement tab){
        tab.click();
    }
}
