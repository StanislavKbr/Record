package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    private Logger logger = LogManager.getLogger(MainPage.class);
    @FindBy(xpath = "//div[text() = 'Все']")
    WebElement tabAll;

    @FindBy(xpath = "//div[text() = 'Управление эффективностью']")
    WebElement tabPerformanceManagement;

    @FindBy(xpath = "//div[text() = 'Обучение и развитие']")
    WebElement tabEducationAndDevelopment;

    @FindBy(xpath = "//div[text() = 'Карьера и преемственность']")
    WebElement tabCareerAndSuccession;

    @FindBy(xpath = "//div[text() = 'Сотрудник']")
    WebElement tabEmployee;

    @FindBy(xpath = "//div[text() = 'Руководитель']")
    WebElement tabManager;

    @FindBy(xpath = "//div[text() = 'СУП']")
    WebElement tabSUP;

    @FindBy(xpath = "//h4[text() = 'Оценка эффективности']")
    WebElement placeholderEfficiencyMark;

    @FindBy(xpath = "//span[text() = 'Ежегодная оценка']")
    WebElement Backgroundtile;//Плитка ?

    @FindBy(xpath = "//h4[text() = 'Обучение']")
    WebElement placeholderEducation;

    @FindBy(xpath = "//span[text() = 'План развития']")
    WebElement BackgroundtileEducation;

    @FindBy(xpath = "//h4[text() = 'Карьерное развитие']")
    WebElement placeholderCareerDevelopment;

    @FindBy(xpath = "//span[text() = 'Карьерный план']")
    WebElement BackgroundtileCareerDevelopment;

    @FindBy(xpath = "//span[text() = 'Мои преемники']")
    WebElement BackgroundtileMySuccessors;

    @FindBy(xpath = "//h4[text() = 'Подбор персонала']")
    WebElement placeholderRecruitment;

    @FindBy(xpath = "//span[text() = 'Адаптация']")
    WebElement BackgroundtileAdaptation;

    @FindBy(xpath = "//h4[text() = 'Моя команда']")
    WebElement placeholderMyComand;

    @FindBy(xpath = "//span[text()= 'Каталог КПЭ']")
    WebElement BackgroundtileCatalogKPI;



    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}


