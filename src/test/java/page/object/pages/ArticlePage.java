package page.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import page.object.BaseFunc;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class ArticlePage {
    private final By TITLE = xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS = xpath(".//a[contains(@class, 'd-print-none')]");
    private final By TIME = xpath(".//time[contains(@class, 'd-block')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        assertTrue(baseFunc.isElementPresents(TIME), "There is no time on page");
        LOGGER.info("We are on article page");
    }

    public String getTitle() {
        LOGGER.info("Getting article title");

        return baseFunc.getText(TITLE).trim();
    }

    public int getCommentCount() {
        LOGGER.info("Getting comments count on article page");

        int commentsCount = 0;
        if (!baseFunc.findElements(COMMENTS).isEmpty()) {
            commentsCount = parseCommentCount(baseFunc.findElement(COMMENTS).getText());
        }
        return commentsCount;
    }

    public CommentsPage openComments() {
        LOGGER.info("Try to open comments page");

        baseFunc.click(COMMENTS);
        return new CommentsPage(baseFunc);
    }

    public int parseCommentCount(String textToParse) {
        LOGGER.info("Removing round brackets from comment count and parsing it from string to int");

        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }
}