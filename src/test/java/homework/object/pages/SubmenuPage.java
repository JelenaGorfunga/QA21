package homework.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.object.BaseFunc;

import java.util.List;

public class SubmenuPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    private final By LAPTOP = By.xpath(".//span[contains(@class, 'cat-title')]");

    public SubmenuPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getLaptopId(int id) {
        LOGGER.info("Finding submenu by ID");

        List<WebElement> allSubmenu = baseFunc.findElements(LAPTOP);
        return allSubmenu.get(id);
    }

    public LaptopPage openLaptop(int id) {
        LOGGER.info("Opening submenu by id and clicking on it");

        baseFunc.click(getLaptopId(id));
        return new LaptopPage(baseFunc);
    }



}
