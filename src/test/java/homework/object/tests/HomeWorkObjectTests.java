package homework.object.tests;

import homework.object.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.object.BaseFunc;

public class HomeWorkObjectTests {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By POPUP_SUBMIT_BUTTON = By.id("CybotCookiebotDialogBodyButtonAccept");

    @Test
    public void homePageObjectTests() {
        LOGGER.info("This test will check notebook purchase on 1a.lv");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("1a.lv");

        HomePageShop homePageShop = new HomePageShop(baseFunc);
        baseFunc.click(POPUP_SUBMIT_BUTTON);

        LaptopPage laptopPage = homePageShop.selectSubCategory("Datortehnika, preces birojam", "Portatīvie datori");
        laptopPage.clickOnItem();





    }




}
