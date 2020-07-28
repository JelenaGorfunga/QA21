import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeworkDelfiTest {

    private WebDriver driver;
    private final String EXPECTED_TITLE = "В Латвии за сутки выявлено три новых случая Covid-19";
    private final int EXPECTED_COMMENT_COUNT = 15;

    @BeforeEach
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }

    @Test
    public void homeDelfiTestTitle() {
        String actualTitle = driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();
        System.out.println("Первый заголовок: " + actualTitle);
        Assertions.assertEquals(EXPECTED_TITLE, actualTitle, "First title is not correct!");
    }

    @Test
    public void homeDelfiTestCommentCount() {
        String commentsCount = driver.findElement(By.xpath(".//a[contains(@class, 'comment-count')]")).getText();
        String commentsCountWithoutSymbols = commentsCount.substring(1, commentsCount.length() - 1);
        System.out.println("Количество комментариев у первого заголовка: " + commentsCount);
        int actualCommentCount = Integer.valueOf(commentsCountWithoutSymbols);
        Assertions.assertEquals(EXPECTED_COMMENT_COUNT, actualCommentCount, "Comment count is not correct!");
    }

    @AfterEach
    private void closeBrowser() {
        driver.close();
    }
}