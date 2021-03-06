package pages;

import framework.Operations;
import framework.Loader;
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
public class MainPage extends Operations{

    public MobilPhonePage mobilPhonePage;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait=new WebDriverWait(driver, Integer.parseInt(Loader.loadProperty("timeout")));
        wait.until(ExpectedConditions.visibilityOf(tel_mp3_tab));
    }

    @FindBy(className="m-main-t")
    private WebElement mainMenu;

    @FindBy(id="phones-mp3-gps")
    private WebElement tel_mp3_tab;

    @FindBy(linkText= "Мобильные телефоны")
    private WebElement telephones;

    @FindBy(linkText = "Все мобильные телефоны")
    public WebElement allPhones;

    public MobilPhonePage openMobilPhonePage(){
        mouseoverTab(tel_mp3_tab);
        clickOn(telephones);
        clickOn(allPhones);
        return new MobilPhonePage(driver);
    }
}
