package Base;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends BaseTest {
    protected WebDriverWait wait;
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage() {
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public void clickElement(By by){
        findElement(by).click();
    }

    public void clickWebElement(WebElement element){
        element.click();
    }

    public void hoverElement(By by){
        Actions action;
        action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void hoverUsingElement(WebElement element){
        Actions action;
        action = new Actions(driver);
        action.moveToElement(element);
    }

    public void fillTextBox(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void waitLoad(By by){
        WebDriverWait wait01 = new WebDriverWait(driver, 10);
        wait01.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    public void verticalScrollDown(int scrollLength){
        String scrollString = ("scroll(0," + String.valueOf(scrollLength) + ")");
        ((JavascriptExecutor)driver).executeScript(scrollString);
        //"scroll(0,10000)"
    }

    public List<WebElement> findAll(By by){
        return driver.findElements(by);
    }
}
