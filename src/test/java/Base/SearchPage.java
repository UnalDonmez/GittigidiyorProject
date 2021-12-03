package Base;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.beans.Expression;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
    public class SearchPage extends BasePage {

        By products = By.xpath("(//*[@data-cy='product-favorite'])");

        //"(//div[@data-cy=\"product-favorite\"])["+result+"]"

        List<WebElement> allItems = findAll(products);
        int productCount = allItems.size();
        Random r = new Random();

        public List<WebElement> getAllSearchedItemsByLocator(By by) {
            return findAll(by);
        }

        /*public void favBoxesInit(){
            selectedItem = getAllSearchedItemsByLocator(products);
        }*/


        public SearchPage(WebDriver driver) {
            super(driver);
        }

        public void SearchMyWord() throws InterruptedException {
            WebElement seachBoxItem = driver.findElement(By.cssSelector("input[data-cy='header-search-input']"));
            TimeUnit.SECONDS.sleep(2);
            seachBoxItem.sendKeys("atkı");
            TimeUnit.SECONDS.sleep(1);
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
            searchButton.click();
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Actions actions = new Actions(driver);

            for (int i = 0; i < 4; i++) {
                int result = 1 + r.nextInt(31);
                System.out.println(result);
                By productsItem = By.xpath("(//div[@data-cy=\"product-favorite\"])[" + result + "]");
                System.out.println(productsItem);
                //findElement(productsItem).click();
                Thread.sleep(1000);
                actions.moveToElement(driver.findElement(productsItem)).click().build().perform();
                Thread.sleep(1000);
            }

        }

        public void BackToHomePage() {
            WebElement HoomeButton = driver.findElement(By.xpath("//div[@class='sc-1o6eogh-1 drryHP'][1]"));
            clickWebElement(HoomeButton);
        }

        public void SearchCanta() throws InterruptedException {
            WebElement canta = driver.findElement(By.cssSelector("input[data-cy='header-search-input']"));
            canta.sendKeys("çanta");
            WebElement cantaButton = driver.findElement(By.cssSelector("button[data-cy='search-find-button']"));
            cantaButton.click();
           // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            //JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("scroll(0, 550);");
            //List<WebElement> urunler = driver.findElements(By.xpath("(//header[@class='sc-1n49x8z-2 eIQPKN'])["+7+"]"));
            List<WebElement> urunler = driver.findElements(By.cssSelector("li[class='sc-1nx8ums-0 dyekHG']"));
            /*JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 100)");*/
            if (driver.findElement(By.cssSelector("section[class='tyj39b-4 gAqqOR']")).isDisplayed()) {
                driver.findElement(By.cssSelector("section[class='tyj39b-4 gAqqOR']")).click();
                TimeUnit.SECONDS.sleep(2);
            }
            Actions action = new Actions(driver);
            action.moveToElement(urunler.get(6)).perform();
            TimeUnit.SECONDS.sleep(2);
            List<WebElement> urunlerBtn = driver.findElements(By.cssSelector("footer>button[class='qjixn8-0 sc-1bydi5r-0 dGNqQc pXiHf sc-1n49x8z-3 bhXnM']"));
            urunlerBtn.get(6).click();
            WebElement sepetHover = driver.findElement(By.linkText("Sepetim"));
            action.moveToElement(sepetHover).perform();
            TimeUnit.SECONDS.sleep(2);
            WebElement sepeteGit = driver.findElement(By.cssSelector("div[class='sc-1nx8ums-0 iqjFHT']>a"));
            sepeteGit.click();
            Select drpMount = new Select(driver.findElement(By.cssSelector("div[class='gg-input gg-input-select ']>select[class='amount']")));
            drpMount.selectByValue("2");

            WebElement TamamlaBtn = driver.findElement(By.xpath("//input[@class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']"));
            TamamlaBtn.click();
            TimeUnit.SECONDS.sleep(1);

            WebElement FavEkle = driver.findElement(By.linkText("Sepeti Düzenle"));
            FavEkle.click();


        }
    }