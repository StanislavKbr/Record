package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Test1Test extends BaseTest {
    private Logger logger = LogManager.getLogger(Test1Test.class);



    @Test
    public void checkTabsDKP() {
        //Arrange
        String login = "p129";
        String password = "123";

        //Act
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        authorizationPage.authorization(login, password); //Поля Логин, пароль заполнены осуществлена авторизация
        logger.info("Авторизация в системе под ДКП");

        MainPage mainPage = new MainPage(driver);

        Boolean resultEmployeeTab = mainPage.tabEmployee.isDisplayed();
        Boolean resultManagerTab = mainPage.tabManager.isDisplayed();
        Boolean resultSUPTab = mainPage.tabSUP.isDisplayed();
        logger.info("Поверка отображения вкладок на форме");

        //Assert
        Assertions.assertTrue(resultEmployeeTab, "Вкладка Сотрудник не отображена на форме");
        Assertions.assertTrue(resultManagerTab, "Вкладка Руководитель не отображена на форме");
        Assertions.assertTrue(resultSUPTab, "Вкладка СУП не отображена на форме");

        logger.info("Тест завершен");

    }

    @Test
    public void checkTabsSUP() {
        //Arrange
        String login = "p161";
        String password = "123";

        //Act
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под СУП");

        MainPage mainPage = new MainPage(driver);

        Boolean resultEmployeeTab = mainPage.tabEmployee.isDisplayed();
        Boolean resultSUPTab = mainPage.tabSUP.isDisplayed();
        logger.info("Поверка отображения вкладок на форме");

        //Assert
        Assertions.assertTrue(resultEmployeeTab, "Вкладка Сотрудник не отображена на форме");
        Assertions.assertTrue(resultSUPTab, "Вкладка СУП не отображена на форме");

        logger.info("Тест завершен");
    }

    @Test
    public void checkTabsEmployee() {
        //Arrange
        String login = "p179";
        String password = "123";

        //Act
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под Сотрудником");

        MainPage mainPage = new MainPage(driver);

        Boolean resultEmployeeTab = mainPage.tabEmployee.isDisplayed();

        //Assert
        Assertions.assertTrue(resultEmployeeTab, "Вкладка Сотрудник не отображена на форме");

        logger.info("Тест завершен");
    }

    @Test
    public void createKpiList() throws InterruptedException { //Создание Списка КПЭ в Каталоге
        //Arrange
        String login = "p129";
        String password = "123";

        //Act
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под ДКП");

        MainPage mainPage = new MainPage(driver);
        mainPage.tabSUP.click();
        mainPage.BackgroundtileCatalogKPI.click();

        CatalogKpiPage catalogKpi = new CatalogKpiPage(driver);
        catalogKpi.addPlusButton.click();
        //Добавить явное ожидание

        String name = "123";
        String periodFrom = "2022";
        String periodEnd = "2023";
        String textArea = "Описание списка КПЭ";

        catalogKpi.createNewKpiList(name, periodFrom, periodEnd, textArea);
        logger.info("Обязательные поля создания списка КПЭ - заполнены");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogKpi.scroll);

        //Assert
        Boolean resultCreated = catalogKpi.newKpiList.isDisplayed();
        Assertions.assertTrue(resultCreated, "Новый КПЭ лист не добавлен в список КПЭ1");

        logger.info("Тест завершен");

    }

    @Test

    public void createNewKpi() {

        //Arrange
        String login = "p129";
        String password = "123";

        //Act
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под ДКП");

        MainPage mainPage = new MainPage(driver);
        mainPage.tabSUP.click();
        mainPage.BackgroundtileCatalogKPI.click();
        logger.info("Переход на форму Каталог КПЭ");

        CatalogKpiPage catalogKpiPage = new CatalogKpiPage(driver);
        catalogKpiPage.addedKPIList.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable((catalogKpiPage.CreateKpiButton)));
        logger.info("Выбран список КПЭ для добавления КПЭ");

        catalogKpiPage.CreateKpiButton.click();

        String name = "Новое КПЭ 1";


        catalogKpiPage.createNewKpi(name);
        logger.info("Обязательные поля создания КПЭ - заполнены");





        //Assert


    }

}
