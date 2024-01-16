package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Record.BaseTest.driver;

public class CatalogKpiPage {
    private Logger logger = LogManager.getLogger(CatalogKpiPage.class);

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default ant-btn-lg ant-btn-icon-only']") //Добавление нового списка КПЭ
    WebElement addPlusButton;

    @FindBy(xpath = "//input[@class='ant-input ant-input-lg']") //Поле наименование списка КПЭ
    WebElement namePlaseHolder;

    @FindBy(xpath = "//input[@id='period'] ") //Период От
    WebElement periodFrom;

    @FindBy(xpath = "(//input[@readonly=''])[4]") //Период До
    WebElement periodEnd;

    @FindBy(xpath = "//*[@class='ant-input']") //Описание списка КПЭ
    WebElement textAreaPlaceHolder;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-lg'] ") //Кнопка сохранить
    WebElement saveButton;

    @FindBy(xpath = "//span[text()= '123']") //Созаднный КПЭ лист
    WebElement newKpiList;

    @FindBy(xpath = "//div[@class='ant-tree-list-scrollbar ant-tree-list-scrollbar-vertical']")
    WebElement scroll;
    @FindBy(xpath = "//div[@class = 'ant-tree-list-scrollbar-thumb']")
    WebElement scrollAfterMove;

    @FindBy(xpath = "//span[text()='123']")
    WebElement addedKPIList;

    @FindBy(xpath = "//span[text() = 'Создать КПЭ']")
    WebElement CreateKpiButton;

    @FindBy(xpath = "//input[@placeholder = 'Введите наименование']")
    WebElement namePlaceHolderKpi;

    @FindBy(xpath = "//textarea[@placeholder = 'Текст']")
    WebElement textAreaPlaceHolderKpi;

    @FindBy(xpath = "//*[@id=\"baseForm_kpiTypeId\"]")
    WebElement kpiTypeField;


    @FindBy(xpath = "//*[@id = 'baseForm_kpiTypeId_list']")
    WebElement kpiTypeIdKPI;


    @FindBy(xpath = "//*[@id='baseForm_kpiTypeId_list_1']")
    WebElement kpiTypeId;



    public CatalogKpiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public CatalogKpiPage createNewKpiList(String name, String perFrom, String perEnd, String textArea) {
        namePlaseHolder.sendKeys(name);
        periodFrom.sendKeys(perFrom);
        periodEnd.sendKeys(perEnd);
        textAreaPlaceHolder.sendKeys(textArea);
        saveButton.click();
        return this;
    }

    public CatalogKpiPage createNewKpi(String name) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        namePlaceHolderKpi.sendKeys(name);

        Actions actions = new Actions(driver);

        kpiTypeField.sendKeys();

        //Select dropDown = new Select(kpiTypeIdKPI);

        //String str = dropDown.getFirstSelectedOption().getText();
        //System.out.println(str);

        //kpiTypeField.sendKeys("2");





        //actions.click(kpiTypeField).click(kpiTypeId);

        //kpiTypeField.click();

        //kpiTypeId.click();
        //kpiTypeField.click();
        //wait.until(ExpectedConditions.elementToBeClickable(kpiTypeId));
        //kpiTypeId.click();



        saveButton.click();
        return this;
    }


}
