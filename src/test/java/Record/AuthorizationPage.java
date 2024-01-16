package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    private Logger logger = LogManager.getLogger(AuthorizationPage.class);
    @FindBy(xpath = "//input[@placeholder = 'Логин']")
    WebElement login;

    @FindBy(xpath = "//input[@placeholder = 'Пароль']")
    WebElement password;

    @FindBy(xpath = "//span[text()='Войти в систему']")
    WebElement enterButton;

    @FindBy(xpath = "//span[@class = 'ant-tag ant-tag-blue']")
    WebElement toolTipRoleLoginPasswor;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void authorization(String value, String value2) {
        login.sendKeys(value);
        password.sendKeys(value2);
        enterButton.click();
    }

}







