package pages;

import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey on 22.12.2014.
 */
public class MainPage {
    protected WebDriver driver;
    protected Actions action;

    public MainPage(WebDriver driver){
        this.driver=driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait=new WebDriverWait(driver, Integer.parseInt(PropertyLoader.loadProperty("timeout")));
        wait.until(ExpectedConditions.visibilityOf(tel_mp3_tab));
    }

    @FindBy(className="m-main-t")
    private WebElement mainMenu;

    @FindBy(id="phones-mp3-gps")
    private WebElement tel_mp3_tab;

    @FindBy(xpath= "//a.m-main-fat-link3[contains(text(),'Мобильные телефоны')]")
    private WebElement telephones;

    public void selectTeleph(){
        mouseoverTab(tel_mp3_tab);
        clickOn(telephones);
    }

    public void clickOn(WebElement tab){
        tab.click();
    }

    public void mouseoverTab(WebElement tab){
        action.moveToElement(tab).build().perform();
    }

    public boolean isElementPresent(WebElement element){
        if (element.isDisplayed()) return true;
        else return false;
    }
}
