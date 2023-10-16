package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    protected JavascriptExecutor js = (JavascriptExecutor) driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        logger.info("Драйвер запущен");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://dev.drec.rosatom.local/auth");
        logger.info("Открыта страница - " + "https://dev.drec.rosatom.local/auth");

    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            //driver.quit();
            //logger.info("Драйвер остановлен!");
        }
    }

    public WebDriver getDriver() {
        logger.info("Драйвер для браузера Chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }


}
