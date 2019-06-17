package tech.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tech.pages.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Metods {

    @Before
    public void setUp() {

        //start
        System.setProperty("webdriver.chrome.driver", "/Users/user/Cucumber/drivers/chromedriver75");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        waitWithMessage = new WebDriverWait(driver, 50).withMessage("Элемент не найден");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

    }

    @Тогда("^Welcome: Mercury Tours$")
    public void Welcome_Mercury_Tours(DataTable arg) {

        MainForm mainForm = new MainForm();

        loadPage("http://newtours.demoaut.com/");
        checkingTitlePage("Welcome: Mercury Tours");
        WebElement login = checkingItemName(mainForm.login);
        WebElement password = checkingItemName(mainForm.password);

        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        login.sendKeys(table.get(0).get("логин"));
        password.sendKeys(table.get(0).get("пароль"));

        checkingItemXpath(mainForm.goon).click();

    }

    @Тогда("^Find a Flight: Mercury Tours:$")
    public void Find_a_Flight_Mercury_Tours() {

        SecondForm secondForm = new SecondForm();

        checkingTitlePage("Find a Flight: Mercury Tours:");
        checkingItemXpath(secondForm.type).click();

        selectionFromTheList(secondForm.passengers, 1);
        selectionFromTheList(secondForm.departingfrom, 4);
        selectionFromTheList(secondForm.onMonth, 10);
        selectionFromTheList(secondForm.onDay, 19);
        selectionFromTheList(secondForm.arrivingIn, 7);
        selectionFromTheList(secondForm.returningMonth, 11);
        selectionFromTheList(secondForm.returningDay, 18);

        checkingItemXpath(secondForm.serviceclass).click();
        selectionFromTheList(secondForm.airline, 3);

        checkingItemXpath(secondForm.futher).click();

    }

    @Тогда("^Select a Flight: Mercury Tours$")
    public void Select_a_Flight_Mercury_Tours() {

        ThirdForm thirdForm = new ThirdForm();

        checkingTitlePage("Select a Flight: Mercury Tours");

        checkingText(checkingItemXpath(thirdForm.depart).getText(), "Paris to Seattle");
        depart = checkingItemXpath(thirdForm.depart).getText();
        checkingText(checkingItemXpath(thirdForm.departData).getText(), "11/20/2019");
        departData = checkingItemXpath(thirdForm.departData).getText();
        checkingItemXpath(thirdForm.selectUnifiedAirlines).click();
        selectUnifiedAirlinesName = checkingItemXpath(thirdForm.selectUnifiedAirlinesName).getText();
        departPrice = checkingItemXpath(thirdForm.departPrice).getText();

        checkingText(checkingItemXpath(thirdForm.retur).getText(), "Seattle to Paris");
        retur = checkingItemXpath(thirdForm.retur).getText();
        checkingText(checkingItemXpath(thirdForm.returnData).getText(), "12/19/2019");
        returnData = checkingItemXpath(thirdForm.returnData).getText();
        checkingItemXpath(thirdForm.selectBlueSkiesAirlines).click();
        selectBlueSkiesAirlinesName = checkingItemXpath(thirdForm.selectBlueSkiesAirlinesName).getText();
        returnPrice = checkingItemXpath(thirdForm.returnPrice).getText();

        checkingItemXpath(thirdForm.further).click();

    }

    @Тогда("^Book a Flight: Mercury Tours$")
    public void Book_a_Flight_Mercury_Tours() {

        FourthForm fourthForm = new FourthForm();

        checkingTitlePage("Book a Flight: Mercury Tours");

        checkingText(checkingItemXpath(fourthForm.summaryDepart).getText(), depart);
        checkingText(checkingItemXpath(fourthForm.summaryDepartData).getText(), departData);
        checkingText(checkingItemXpath(fourthForm.summaryDepartFlyght).getText(), selectUnifiedAirlinesName);
        checkingText(checkingItemXpath(fourthForm.summaryDepartClass).getText(), airClass);
        List<WebElement> listDepart = driver.findElements(By.xpath(fourthForm.summaryDepartPrice));
        checkingText(departPrice, listDepart.get(1).getText());

        checkingText(checkingItemXpath(fourthForm.summaryReturn).getText(), retur);
        checkingText(checkingItemXpath(fourthForm.summaryReturnData).getText(), returnData);
        checkingText(checkingItemXpath(fourthForm.summaryReturnFlyght).getText(), selectBlueSkiesAirlinesName);
        checkingText(checkingItemXpath(fourthForm.summaryReturnClass).getText(), airClass);
        List<WebElement> listReturn = driver.findElements(By.xpath(fourthForm.summaryReturnPrice));
        checkingText(returnPrice, listReturn.get(1).getText());

        checkingText(checkingItemXpath(fourthForm.totalPrice).getText(), totalPrice);

        // Passengers
        // first
        checkingItemXpath(fourthForm.firstNameFirstPassengers).sendKeys("Ivan");
        checkingItemXpath(fourthForm.lastNameFirstPassengers).sendKeys("Ivanov");
        selectionFromTheList(fourthForm.maelFirstPassengers, 3);
        // second
        checkingItemXpath(fourthForm.firstNameSecondPassengers).sendKeys("Irina");
        checkingItemXpath(fourthForm.lastNameSecondPassengers).sendKeys("Ivanova");
        selectionFromTheList(fourthForm.maelSecondPassengers, 1);
        // credit card
        selectionFromTheList(fourthForm.creditCardType, 2);
        checkingItemXpath(fourthForm.creditCardNumber).sendKeys("5479540454132487");
        selectionFromTheList(fourthForm.creditCardMonth, 5);
        selectionFromTheList(fourthForm.creditCardYear, 9);
        checkingItemXpath(fourthForm.creditCardFirstName).sendKeys("Ivan");
        checkingItemXpath(fourthForm.creditCardMiddle).sendKeys("Ivanovich");
        checkingItemXpath(fourthForm.creditCardLast).sendKeys("Ivanov");
        // billing address
        checkingItemXpath(fourthForm.billingAddressAddress).sendKeys("1085 Borregas Ave.");
        checkingItemXpath(fourthForm.billingAddressCity).sendKeys("Albuquerque");
        checkingItemXpath(fourthForm.billingAddressState).sendKeys("New Mexico");
        checkingItemXpath(fourthForm.billingAddressCode).sendKeys("94089");
        selectionFromTheList(fourthForm.billingAddressContry, 214);
        // delivery address
        checkingItemXpath(fourthForm.deliveryAddressSameAsBillingAddress).click();
        checkingItemXpath(fourthForm.deliveryAddressAddress).sendKeys("1225 Borregas Ave.»");
        checkingItemXpath(fourthForm.deliveryAddressCity).sendKeys("Boston");
        checkingItemXpath(fourthForm.deliveryAddressState).sendKeys("Massachusetts");
        checkingItemXpath(fourthForm.deliveryAddressCode).sendKeys("91089");
        selectionFromTheList(fourthForm.deliveryAddressContry, 214);

        checkingItemXpath(fourthForm.further).click();

    }

    @Тогда("^Flight Confirmation: Mercury Tours$")
    public void Flight_Confirmation_Mercury_Tours(){

        FifthForm fifthForm = new FifthForm();

        checkingTitlePage("Flight Confirmation: Mercury Tours");

        // departing
        checkingText(checkingItemXpath(fifthForm.departingInfo).getText(), depart);
        checkingText(checkingItemXpath(fifthForm.departingInfo).getText(), departData);
        checkingText(checkingItemXpath(fifthForm.departingInfo).getText(), departPrice.replaceAll("[^0-9]", ""));
        // returning
        checkingText(checkingItemXpath(fifthForm.returnInfo).getText(), retur);
        checkingText(checkingItemXpath(fifthForm.returnInfo).getText(), returnData);
        checkingText(checkingItemXpath(fifthForm.returnInfo).getText(), returnPrice.replaceAll("[^0-9]",""));
        // passengers
        checkingText(checkingItemXpath(fifthForm.passengers).getText(), "2");
        // billed to
        checkingText(checkingItemXpath(fifthForm.biledTo).getText(), "Ivan Ivanovich Ivanov");
        checkingText(checkingItemXpath(fifthForm.biledTo).getText(), "1325 Borregas Ave.1085 Borregas Ave.");
        checkingText(checkingItemXpath(fifthForm.biledTo).getText(), "SunnyvaleAlbuquerque, CANew Mexico, 9408994089");
        // delivery address
        checkingText(checkingItemXpath(fifthForm.deliveryAddress).getText(), "1325 Borregas Ave.1225 Borregas Ave.");
        checkingText(checkingItemXpath(fifthForm.deliveryAddress).getText(), "SunnyvaleBoston, CAMassachusetts, 9408991089");
        // checking total
        String totalPrice = checkingItemXpath(fifthForm.totalPrice).getText().replaceAll("[^0-9]","");
        String totalTaxi = checkingItemXpath(fifthForm.totalTaxi).getText().replaceAll("[^0-9]","");
        int total = Integer.parseInt(totalPrice); int taxi = Integer.parseInt(totalTaxi);
        String departingPrice = checkingItemXpath(fifthForm.departingInfo).getText().substring(checkingItemXpath(fifthForm.departingInfo).getText().lastIndexOf("$"));
        String depart = departingPrice.replaceAll("[^0-9]",""); int departing = Integer.parseInt(depart);
        String returnPrice = checkingItemXpath(fifthForm.returnInfo).getText().substring(checkingItemXpath(fifthForm.returnInfo).getText().lastIndexOf("$"));
        String retur = returnPrice.replaceAll("[^0-9]",""); int returning = Integer.parseInt(retur);
        int check = (departing * 2 + returning * 2) + taxi;
        if (check == total) {
            try {
            } catch (NullPointerException e) {
                System.out.println("Итоговая сумма не верна");
            }
        }

        checkingItemXpath(fifthForm.goHome).click();

    }

    @After
    public void closeBrowser(){

        driver.quit();

    }

    WebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> waitWithMessage;
    String depart, departData, departPrice, selectUnifiedAirlinesName;
    String retur, returnData, returnPrice, selectBlueSkiesAirlinesName;
    String airClass= "Business";
    String totalPrice = "1199";



    public void loadPage(String url){ driver.get(url); }

    public void checkingTitlePage(String title){ assertTrue("Наименование страницы указано неверно", driver.getTitle().contains(title)); }

    public void checkingText(String textOne, String textTwo){ assertTrue("Наименование обьектов неверно", textOne.contains(textTwo)); }

    public void selectionFromTheList(String list, int index){
        List<WebElement> weblist = driver.findElements(By.xpath(list));
        weblist.get(index).click();
    }

    public WebElement checkingItemName(String way){
        WebElement name = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name(way))));
        return name;
    }

    public WebElement checkingItemXpath(String way){
        WebElement xpath = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(way))));
        return xpath;
    }
}
