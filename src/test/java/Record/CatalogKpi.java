package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class CatalogKpi {
    private Logger logger = LogManager.getLogger(CatalogKpi.class);

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-lg ant-btn-icon-only'] ") //Добавление нового списка КПЭ
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

    @FindBy(xpath = "//span[text()= 'Новый тестовый список КПЭ1']") //Созаднный КПЭ лист
    WebElement newKpiList;

    @FindBy(xpath = "//div[@class = 'ant-tree-list-scrollbar-thumb']")
    WebElement scrollMini;

    public CatalogKpi(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public CatalogKpi createNewKpiList(String name, String perFrom, String perEnd, String textArea) {
        namePlaseHolder.sendKeys(name);
        periodFrom.sendKeys(perFrom);
        periodEnd.sendKeys(perEnd);
        textAreaPlaceHolder.sendKeys(textArea);
        saveButton.click();
        return this;
    }

}
