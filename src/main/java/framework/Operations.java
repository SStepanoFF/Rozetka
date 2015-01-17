package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergey on 27.12.2014.
 */
public class Operations {

    protected Actions action;
    protected WebDriver driver;
    private File resultFile = new File("resultFile.txt");
    private FileWriter fileWriter = null;

    public Operations(WebDriver driver){
        this.driver=driver;
        this.action=new Actions(driver);
    }

    public void clickOn(WebElement webElement){
        webElement.click();
    }

    public void waitAndClick(WebElement webElement){
        WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(Loader.loadProperty("timeout")));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void mouseoverTab(WebElement tab){
        action.moveToElement(tab).build().perform();
    }

    public void writeToFile(String text) {
        try {
            fileWriter = new FileWriter(resultFile, true);
            fileWriter.append(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clearResultFile(){
        try{
            fileWriter=new FileWriter(resultFile);
            fileWriter.write("");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(WebElement element){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
            if (element.isDisplayed()) return true;
            else return false;
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(Loader.loadProperty("timeout")),TimeUnit.SECONDS);
        }

    }
}
