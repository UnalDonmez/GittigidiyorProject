package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BaseTest
{

    protected WebDriver driver;
    protected WebDriverWait wait;
    final static Logger logger = Logger.getLogger(BaseTest.class.getName());

    /*public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }*/

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/");

    }

    @After
    public void tearDown() throws InterruptedException {
        //driver.quit();

    }
}
