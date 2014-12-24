package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilPhonePage extends MainPage {

    public MobilPhonePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "h1")
    public WebElement phoneTitle;

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

}
