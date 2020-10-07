package homework.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.object.BaseFunc;

import java.util.List;

public class CatalogPage {
    private final By BUTTON_BUY = By.xpath(".//button[contains(@class, 'catalog-taxons-buy-button')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public CatalogPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getButtonById(int id) {
        LOGGER.info("Finding buy button by id");

        List<WebElement> allButtons = baseFunc.findElements(BUTTON_BUY);
        return allButtons.get(id);
    }

    //public BasketPage openBuyPageById(int id) {
     //   LOGGER.info("Opening buy page by id and clicking on it");

      //  baseFunc.click(getButtonById(id));
       // return new BasketPage;
    //}




}
