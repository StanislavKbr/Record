package Record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;


public class Test1Test extends BaseTest {
    private Logger logger = LogManager.getLogger(Test1Test.class);

    @Test
    public void checkTabsDKP() {

        String login = "p129";
        String password = "123";

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        authorizationPage.authorization(login, password); //Поля Логин, пароль заполнены осуществлена авторизация
        logger.info("Авторизация в системе под ДКП");

        MainPage mainPage = new MainPage(driver);

        Boolean resultEmployeeTab = mainPage.tabEmployee.isDisplayed();
        Boolean resultManagerTab = mainPage.tabManager.isDisplayed();
        Boolean resultSUPTab = mainPage.tabSUP.isDisplayed();

        Assertions.assertTrue(resultEmployeeTab, "Вкладка Сотрудник не отображена на форме");
        Assertions.assertTrue(resultManagerTab, "Вкладка Руководитель не отображена на форме");
        Assertions.assertTrue(resultSUPTab, "Вкладка СУП не отображена на форме");

        logger.info("Тест завершен");

    }

    @Test
    public void checkTabsSUP() {

        String login = "p161";
        String password = "123";

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под СУП");

        MainPage mainPage = new MainPage(driver);

        Boolean resultEmployeeTab = mainPage.tabEmployee.isDisplayed();
        Boolean resultSUPTab = mainPage.tabSUP.isDisplayed();

        Assertions.assertTrue(resultEmployeeTab, "Вкладка Сотрудник не отображена на форме");
        Assertions.assertTrue(resultSUPTab, "Вкладка СУП не отображена на форме");

        logger.info("Тест завершен");
    }

    @Test
    public void checkTabsEmployee(){
        String login = "p179";
        String password = "123";

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под Сотрудником");

        MainPage mainPage = new MainPage(driver);

        Boolean resultEmployeeTab = mainPage.tabEmployee.isDisplayed();

        Assertions.assertTrue(resultEmployeeTab, "Вкладка Сотрудник не отображена на форме");

        logger.info("Тест завершен");
    }
    @Test
    public void createKpiList() { //Создание Списка КПЭ в Каталоге
        String login = "p129";
        String password = "123";

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization(login, password);
        logger.info("Авторизация в системе под ДКП");

        MainPage mainPage = new MainPage(driver);
        mainPage.tabSUP.click();
        //Добавить явное ожидание

        String name = "Новый тестовый список КПЭ1";
        String periodFrom = "2022";
        String periodEnd = "2023";
        String textArea = "Описание списка КПЭ";

        mainPage.BackgroundtileCatalogKPI.click();

        CatalogKpi catalogKpi = new CatalogKpi(driver);
        catalogKpi.addPlusButton.click();

        catalogKpi.createNewKpiList(name, periodFrom, periodEnd, textArea);
        logger.info("Обязательные поля создания списка КПЭ - заполнены");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        js.executeScript("window.scrollBy(0, 500);");

        Boolean resultCreated = catalogKpi.newKpiList.
        );

        Assertions.assertTrue(resultCreated, "Новый КПЭ лист не добавлен в список");

        logger.info("Тест завершен");


    }
}
