package homework.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.BaseFunc;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePageShop {
    // private final By SUBMENU = By.xpath(".//a[contains(@class, 'submenu-lvl1')]");
    private final By SUBMENU = By.xpath(".//p[contains(@class, 'slide-title')]");
    //private final By SUBMENU = By.xpath(".//a[contains(@href, 'https://www.1a.lv/c/datortehnika-preces-birojam/portativie-datori-un-aksesuari/2sv')]");
    // private final By POPUP = By.id("cookiebanner");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;
    private WebDriverWait wait;

    public HomePageShop(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public WebElement getSubmenuById(int id) {
        LOGGER.info("Finding submenu by ID");

        List<WebElement> allSubmenu = baseFunc.findElements(SUBMENU);
        return allSubmenu.get(id);
    }

    public void closePopUp(By id) {
        LOGGER.info("Closing pop-up window");
        wait.until(visibilityOfElementLocated(id));
        baseFunc.findElement(id).click();
    }


    public SubmenuPage openSubmenu(int id) {
        LOGGER.info("Opening submenu by id and clicking on it");

        baseFunc.click(getSubmenuById(id));
        return new SubmenuPage(baseFunc);
    }

}







