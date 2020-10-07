package page.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.object.BaseFunc;

import java.util.List;

import static org.openqa.selenium.By.*;

public class CommentsPage {
    private final By TITLE = xpath(".//h1[@class = 'article-title']/a");
    private final By COMMENTS_COUNT = xpath(".//span[contains(@class, 'type-cnt')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public CommentsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting title on comments page");

        return baseFunc.getText(TITLE);
    }

    public int getCommentCount() {
        LOGGER.info("Getting comments count on comment page");

        List<WebElement> commentsCounts = baseFunc.findElements(COMMENTS_COUNT);

        int commentsCount = 0;
        for (WebElement cc : commentsCounts) {
            commentsCount += parseCommentCount(cc.getText());
        }
        return commentsCount;
    }

    public int parseCommentCount(String textToParse) {
        LOGGER.info("Removing round brackets from comment count and parsing it from string to int");

        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }
}