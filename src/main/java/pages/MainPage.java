package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sergey on 22.12.2014.
 */
public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
//        WebDriverWait wait=new WebDriverWait(driver, Integer.parseInt(PropertyLoader.loadProperty("timeout")));
//        wait.until(ExpectedConditions.visibilityOf(mainMenu));
    }

    @FindBy(className="m-main-t")
    public WebElement mainMenu;

    @FindBy(id="phones-mp3-gps")
    public WebElement tel_mp3_tab;

    @FindBy(linkText = "Мобильные  телефоны")
    public WebElement telephones;

    public void openTab(WebElement tab){
        tab.click();
    }

    public boolean isElementPresent(WebElement element){
        if (element.isDisplayed()) return true;
        else return false;
    }
}
