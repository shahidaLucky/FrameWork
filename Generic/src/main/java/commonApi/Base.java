package commonApi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shahida Lucky on 12/29/2015.
 */
public class Base {

    public WebDriver driver = null;

    @BeforeMethod
    public void setUp(String url)
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("http://www.amazon.com");
        driver.manage().window().maximize();
        driver.close();

    }
    @AfterMethod
    public void cleanUp()
    {
        driver.quit();
    }
    //Helping methods
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(1000*sec);
    }
    public void clickOnCss(String locator){

        driver.findElement(By.cssSelector(locator)).click();
    }
    public void typeOnCss(String locator, String value){

        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public List<String> getTextFromWebElements(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }

        return text;
    }
    public void clearInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void keysInput(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

}



