package homework.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.object.BaseFunc;


public class HomePageShop {
    private final By MENU = By.xpath(".//div[contains(@class, 'submenu-lvl1--index')]");
    private final By SUBMENU = By.xpath(".//a[@class = 'submenu-lvl2__list-item-link']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePageShop(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
    }

    public LaptopPage selectSubCategory(String category, String subcategory) {

        WebElement menuItem = null;
        for (WebElement we: baseFunc.findElement(MENU).findElements(By.tagName("li"))
        ) {
            if (we.getText().equals(category)) {
                menuItem = we;
                break;
            }
        }

        baseFunc.actions.moveToElement(menuItem).build().perform();

        for (WebElement we : menuItem.findElements(SUBMENU)
        ) { if (we.getText().equals(subcategory)) {
            we.click();
            break;
        }

        }
        return new LaptopPage(baseFunc);
    }

}








