package homework.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import page.object.BaseFunc;


public class LaptopPage {
    private final By LAPTOP = By.xpath(".//div[contains(@class, 'catalog-taxons-products-container')]");
    private final By BUY_BUTTON = By.xpath(".//button[contains(@class, 'catalog-taxons-buy-button__button')]");
    private final By PUT = By.tagName("a");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public LaptopPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

}
