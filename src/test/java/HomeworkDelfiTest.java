import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkDelfiTest {

    private WebDriver driver;
    private final String EXPECTED_TITLE = "В Латвии за сутки выявлено три новых случая Covid-19";
    private final int EXPECTED_COMMENT_COUNT = 15;

    private final By FIRST_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    @BeforeEach
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }

    @Test
    public void homeDelfiTestTitle() {
        String actualTitle = driver.findElement(FIRST_TITLE).getText();
        System.out.println("Первый заголовок: " + actualTitle);
        Assertions.assertEquals(EXPECTED_TITLE, actualTitle, "First title is not correct!");
    }

    @Test
    public void homeDelfiTestCommentCount() {
        int actualCommentCount = 0;
        if (!driver.findElements(COMMENTS_COUNT).isEmpty()) {
            actualCommentCount = parseCommentCount(driver.findElement(COMMENTS_COUNT).getText());
        }
        System.out.println("Количество комментариев к первому заголовку: " + actualCommentCount);
        Assertions.assertEquals(EXPECTED_COMMENT_COUNT, actualCommentCount, "Comment count is not correct!");

    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

    @AfterEach
    private void closeBrowser() {
        driver.close();
    }
}