package page.object.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import page.object.BaseFunc;
import page.object.pages.ArticlePage;
import page.object.pages.CommentsPage;
import page.object.pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class PageObjectTests {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    @Test
    public void pageObjectTest() {
        LOGGER.info("This test will check article title  and comment count on Home, Article and Comment pages");

        baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(1);
        int homePageCommentCount = homePage.getCommentCountById(1);
        ArticlePage articlePage = homePage.openArticle(1);

        LOGGER.info("Checking home page title and article page title");

        assertEquals(homePageTitle, articlePage.getTitle(), "Wrong title on Article Page");

        LOGGER.info("Checking home page comment count and article comment count");

        assertEquals(homePageCommentCount, articlePage.getCommentCount(), "Wrong comment count on Article Page");

        LOGGER.info("Checking home page title and comments page title");

        CommentsPage commentsPage = articlePage.openComments();
        assertEquals(homePageTitle, commentsPage.getTitle(), "Wrong title on Comments Page");

        LOGGER.info("Checking home page title and comments page title");
        assertEquals(homePageCommentCount, commentsPage.getCommentCount(), "Wrong comment count on comments page");
    }

    @AfterEach
    public void close() {
        baseFunc.closeBrowser();
            }


}