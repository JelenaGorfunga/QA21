import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomeworkThird {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By ARTICLE_PAGE_COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'd-print-none')]");

    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private final By COMMENTS_PAGE_COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'type-cnt')]");

    private WebDriver driver;

    @BeforeEach
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }

    @Test
    public void checkThirdArticle() {
        List<WebElement> articles = driver.findElements(ARTICLE);

        WebElement article = articles.get(2);
        String mainPageTitle = article.findElement(TITLE).getText();

        int mainPageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            mainPageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }

        article.findElement(TITLE).click();

        WebDriverWait wait =  new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        int articlePageCommentsCount = 0;
        if (!driver.findElements(ARTICLE_PAGE_COMMENTS_COUNT).isEmpty()) {
            articlePageCommentsCount = parseCommentCount(driver.findElement(ARTICLE_PAGE_COMMENTS_COUNT).getText());
        }

        Assertions.assertEquals(mainPageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(mainPageCommentsCount, articlePageCommentsCount, "Wrong comments count");

        driver.findElement(ARTICLE_PAGE_COMMENTS_COUNT).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENTS_PAGE_TITLE));
        String commentsPageTitle = driver.findElement(COMMENTS_PAGE_TITLE).getText();

        List<WebElement> commentsPageCommentsCounts = driver.findElements(COMMENTS_PAGE_COMMENTS_COUNT);
        int commentsPageCommentsCount = 0;
        for (WebElement cc : commentsPageCommentsCounts) {
          commentsPageCommentsCount += parseCommentCount(cc.getText());
        }

        Assertions.assertEquals(mainPageTitle, commentsPageTitle, "Wrong title on the comments page!");
        Assertions.assertEquals(mainPageCommentsCount, commentsPageCommentsCount, "Wrong comments count on the comments page");
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

    @AfterEach
    public void close() {
        driver.close();
    }
}