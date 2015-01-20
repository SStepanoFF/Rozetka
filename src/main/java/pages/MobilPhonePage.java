package pages;

import framework.Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MobilPhonePage extends MainPage {

    public MobilPhonePage(WebDriver driver) {
        super(driver);
        WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(Loader.loadProperty("timeout")));
        wait.until(ExpectedConditions.visibilityOf(sortRating));
    }

    //region Phone producer
    @FindBy(css = "#sort_producer .filter-parametrs-i-l-i-text")
    private List<WebElement> phoneFirm;

    @FindBy (linkText = "Apple")
    private WebElement apple;

    @FindBy (linkText = "Acer")
    private WebElement acer;

    @FindBy (linkText = "HTC")
    private WebElement htc;

    @FindBy (linkText = "Nokia")
    private WebElement nokia;

    @FindBy (css = "a[class='lightblue underline filter-active-reset-link']")
    private WebElement resetFilter;
    //endregion

    //region Sorting Type
    @FindBy(css = ".m-sort-i")
    private List<WebElement> sortList;

    @FindBy(linkText = "по рейтингу")
    private WebElement sortRating;

    @FindBy(linkText = "от дорогих к дешевым")
    private WebElement sortExpensive;

    @FindBy(linkText = "от дешевых к дорогим")
    private WebElement sortChiper;

    @FindBy(css = ".xhr.lightblue.sprite.dropdown>i")
    private WebElement dropDownSort;
    //endregion

    @FindBy(css = ".gtile-i-title")
    private List<WebElement> resultList;

    @FindBy(css=".g-price-uah")
    private List<WebElement> priceList;

    public void selectTopAllPhoneRaiting(){
        clickOn(dropDownSort);
        clickOn(sortRating);
        writeToFile("First phone by RAITING in TopAll: " + resultList.get(0).getText() + "  Price=" + priceList.get(0).getText());
    }

    public void selectTopAllPhoneExpensive(){
        clickOn(dropDownSort);
        clickOn(sortExpensive);
        writeToFile("The most expensive phone is: " + resultList.get(0).getText() + "  Price=" + priceList.get(0).getText());
    }

    public void allSorting(){
        for (int i=0; i<sortList.size();i++){
            clickOn(dropDownSort);
            clickOn(sortList.get(i));
            driver.navigate().refresh();
            Assert.assertTrue(driver.findElement(By.cssSelector(".xhr.lightblue.sprite.dropdown")).getText().contains(sortList.get(i).getText()));
            writeToFile(sortList.get(i).getText() + ": " + resultList.get(0).getText() + "  Price=" + priceList.get(0).getText());
        }
    }

    public void allPhoneProduser(){
        for (int i=0; i<5; i++){
            if (isElementPresent(resetFilter)){
                resetFilter.click();
            }
            phoneFirm.get(i).click();
            writeToFile(phoneFirm.get(i).getText() + " raiting: " + resultList.get(0).getText() + "  Price=" + priceList.get(0).getText());
        }
    }

}
