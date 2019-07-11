package tech.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tech.pages.*;

import java.io.*;
import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.aspectj.bridge.MessageUtil.fail;

public class Metods {

    @Before
    public void setUp() {


        System.setProperty("webdriver.chrome.driver", "/Users/user/Cucumber/drivers/chromedriver75");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        waitWithMessage = new WebDriverWait(driver, 50).withMessage("Элемент не найден");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        jse = (JavascriptExecutor)driver;
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cap = ((RemoteWebDriver) driver).getCapabilities();

        // соединяем все атрибуты для имени файла
        file_name = dateFormat.format(date) + " " + cap.getBrowserName().toLowerCase() + " " + "google.txt";
        // компилятор ругается на / я решил заменить на подчеркивание
        file_name = file_name.replaceAll("\\/","_");

    }


    @Тогда("^фильтрация записей из файла$")
    public void фильтрация_записей_из_файла() throws IOException {

        FilterMas filter = new FilterMas();
        filter.filter_file();

    }

    @Тогда("^фильтр по яндекс$")
    public void фильтр_по_яндекс(DataTable arg) throws InterruptedException {
        loadPage("https://yandex.ru");

        Yandex ya = new Yandex();

        List<Map<String, String>> table = arg.asMaps(String.class, String.class);

        checkingItemXpath(ya.shop).click();
        checkingItemXpath(ya.search).sendKeys(table.get(0).get("Наименование"));
        checkingItemXpath(ya.search).sendKeys(Keys.ENTER);
        checkingItemXpath(ya.price).sendKeys(table.get(0).get("Стоимость от"));

        Thread.sleep(4000);

        List<WebElement> e = driver.findElements(By.xpath(ya.all));
        String[] ms = e.get(0).getText().split(" ");
        String r = ms[0]+" "+ms[1]+" "+ms[2]+" "+ms[3];

        checkingItemXpath(ya.ourphone).click();
        checkingText(r, ya.h);

        loadPage("https://market.yandex.ru/");

        checkingItemXpath(ya.search).sendKeys(table.get(1).get("Наименование"));
        checkingItemXpath(ya.search).sendKeys(Keys.ENTER);
        checkingItemXpath(ya.price).sendKeys(table.get(1).get("Стоимость от"));
        checkingItemXpath(ya.pricemax).sendKeys(table.get(1).get("Стоимость до"));

        Thread.sleep(4000);

        List<WebElement> w = driver.findElements(By.xpath(ya.all));
        String[] ms2 = w.get(0).getText().split(" ");
        String rs = ms2[1]+" "+ms2[2]+" "+ms2[3];

        checkingItemXpath(ya.ourheadphone).click();
        checkingText(rs, ya.h);

    }

    @Тогда("^job_alfabank$")
    public void job_alfabank(DataTable arg) throws Exception {

        loadPage("https://google.com");

        Google google = new Google();

        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        checkingItemName(google.search_bar).sendKeys(table.get(0).get("Банк"));
        checkingItemName(google.search_bar).sendKeys(Keys.ENTER);

        // из результатов поиска переходим по первому значению
        selectionFromTheList(google.search_values, 0);

        // прокручиваем страницу в самый низ
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // ищем раздел Вакансии
        driver.findElement(By.linkText(table.get(0).get("Значения"))).click();
        // ищем раздел О нас
        driver.findElement(By.linkText(table.get(1).get("Значения"))).click();

        // создаем файл
        file = new FileWriter(file_name);
        // записываем информацию в фаил
        file.write(checkingItemXpath(google.date).getText());
        // закрываем поток
        file.close();

    }

    @After
    public void closeBrowser(){

        driver.quit();
    }


    // драйвер для работы с библиотеками Selenium
    WebDriver driver;
    // явные ожидание
    WebDriverWait wait;
    Wait<WebDriver> waitWithMessage;


    // интерфейс Selenium который будет работать с driver
    JavascriptExecutor jse;
    // используем FileWriter для записи в файл
    FileWriter file;
    // используем Date для записи времени
    Date date;
    // для взятия информации о браузере
    Capabilities cap;
    // для работы с датой
    DateFormat dateFormat;
    String file_name;

    //загружаем страницу
    public void loadPage(String url){ driver.get(url); }
    // сверяем наименования
    public void checkingText(String textsecond, String text){ assertTrue("Наименование обьектов неверно", driver.findElement(By.xpath(text)).getText().contains(textsecond)); }

    // работаем со списком элементов Xpath
    public void selectionFromTheList(String list, int index){
        List<WebElement> weblist = driver.findElements(By.xpath(list));
        weblist.get(index).click();
    }

    // проверяем элемент Name
    public WebElement checkingItemName(String way){
        WebElement name = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name(way))));
        return name;
    }

    // проверяем элемент Xpath
    public WebElement checkingItemXpath(String way){
        WebElement xpath = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(way))));
        return xpath;
    }
}
