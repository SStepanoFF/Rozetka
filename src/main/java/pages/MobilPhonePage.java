package pages;

import framework.Loader;
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
        WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(Loader.loadProperty("timeout")));
        wait.until(ExpectedConditions.visibilityOf(sortRating));
    }

    @FindBy(id = "sort_producer")
    public List<WebElement> phoneFirm;

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

    @FindBy(linkText = "от дорогих к дешевым")
    public WebElement sortExpensive;

    @FindBy(css = ".gtile-i-title")
    private List<WebElement> resultList;

    @FindBy(css=".g-price-uah")
    private List<WebElement> priceList;

    public void selectTopAllPhoneRaiting(){
        clickOn(sortRating);
        writeToFile("First in TopAll by RAITING: "+resultList.get(0).getText()+"  Price="+priceList.get(0).getText());
    }

    public void selectTopAllPhoneExpensive(){
        clickOn(sortExpensive);
        writeToFile("The most expensive phone is: "+resultList.get(0).getText()+"  Price="+priceList.get(0).getText());
    }

}
