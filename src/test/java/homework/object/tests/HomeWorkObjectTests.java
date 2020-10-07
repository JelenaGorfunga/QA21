package homework.object.tests;

import homework.object.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.object.BaseFunc;

public class HomeWorkObjectTests {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By POPUP = By.id("cookiebanner");

    @Test
    public void homePageObjectTests() {
        LOGGER.info("This test will check notebook purchase on 1a.lv");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("1a.lv");

        HomePageShop homePageShop = new HomePageShop(baseFunc);
        homePageShop.closePopUp(POPUP);
        SubmenuPage submenuPage = homePageShop.openSubmenu(1);
        LaptopPage laptopPage = submenuPage.openLaptop(0);
        CatalogPage catalogPage = laptopPage.openCatalogById(0);
        //BasketPage basketPage = catalogPage.openBuyPageById(0);





    }




}
