package page.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.BaseFunc;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS_COUNT = xpath(".//a[contains(@class, 'comment-count')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
            }

    public WebElement getArticleById(int id) {
        LOGGER.info("Finding article by ID, checking list of articles");

        List<WebElement> articles = baseFunc.findElements(ARTICLE);

        Assertions.assertFalse(articles.isEmpty(), "There is no articles");

        return articles.get(id);
    }

    public String getTitleById(int id) {
        LOGGER.info("Finding article's title by article id");

        return getArticleById(id).findElement(TITLE).getText().trim();
    }

    public int getCommentCountById(int id) {
        LOGGER.info("Finding article's comment count by article id");

       int commentCountById = 0;
        if (!getArticleById(id).findElements(COMMENTS_COUNT).isEmpty()) {
            commentCountById = parseCommentCount(getArticleById(id).findElement(COMMENTS_COUNT).getText());
      }
      return commentCountById;
    }

    public ArticlePage openArticle(int id) {
        LOGGER.info("Opening article by id and clicking on it");

        baseFunc.click(getArticleById(id));
        return new ArticlePage(baseFunc);
    }


    public int parseCommentCount(String textToParse) {
        LOGGER.info("Removing round brackets from comment count and parsing it from string to int");

        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

}