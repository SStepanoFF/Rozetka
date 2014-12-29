package pages;

import framework.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MobilPhonePage extends MainPage {

    public MobilPhonePage(WebDriver driver) {
        super(driver);
        WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(PropertyLoader.loadProperty("timeout")));
        wait.until(ExpectedConditions.visibilityOf(allPhones));
    }

    @FindBy(id = "sort_producer")
    public List<WebElement> phoneFirm;

    @FindBy(linkText = "Все мобильные телефоны")
    public WebElement allPhones;

    @FindBy (linkText = "Apple")
    public WebElement apple;

    @FindBy (linkText = "Acer")
    public WebElement acer;

    @FindBy (linkText = "HTC")
    public WebElement htc;

    @FindBy (linkText = "Nokia")
    public WebElement nokia;

    @FindBy(linkText = "по рейтингу")
    public WebElement sortRating;

    @FindBy(css = "div[name='goods_list']")
    private List<WebElement> resultList;

    public String selectTopAllPhoneRaiting(){
        clickOn(allPhones);
        //clickOn(sortRating);
        return resultList.get(1).toString();
    }

}
