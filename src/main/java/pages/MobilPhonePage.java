package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobilPhonePage extends MainPage {

    public MobilPhonePage(WebDriver driver) {
        super(driver);
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

    @FindBy(tagName = "a[class='xhr lightblue sprite dropdown']")
    public WebElement sortRating;

}
