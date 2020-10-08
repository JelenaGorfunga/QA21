package page.object;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BaseFunc {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private ChromeOptions options;
    private Alert alert;

    public BaseFunc() {
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String url) {
        LOGGER.info("Trying to open page: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Getting list of web elements");

        return driver.findElements(locator);
    }

    public void click(WebElement element) {
        LOGGER.info("Clicking on Web Element");
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(elementToBeClickable(element));
        element.click();
    }

    public void click(By locator) {
        LOGGER.info("Clicking by locator");

        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(elementToBeClickable(locator));
        findElement(locator).click();
    }

    public String getText(By locator) {
        LOGGER.info("Getting text");

        return findElement(locator).getText();
    }

    public WebElement findElement(By locator) {
        LOGGER.info("Finding element by locator");

        wait.until(visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }



    public boolean isElementPresents(By locator) {
        try {
            wait.until(presenceOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closePopUp(By locator) {
        LOGGER.info("Closing pop-up window");

        wait.until(visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void closeBrowser() {
        LOGGER.info("Closing page browser");

        driver.close();
    }


}
