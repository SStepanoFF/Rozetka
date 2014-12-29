package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Sergey on 27.12.2014.
 */
public class Operations {

    protected Actions action;
    protected WebDriver driver;

    public Operations(WebDriver driver){
        this.driver=driver;
        this.action=new Actions(driver);
    }

    public void clickOn(WebElement tab){
        tab.click();
    }

    public void mouseoverTab(WebElement tab){
        action.moveToElement(tab).build().perform();
    }
}
