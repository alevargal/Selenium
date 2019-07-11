package tech.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.awt.*;

public class Yandex {

    /*
    хотел использовать PageFactory(Искать элементы и производить
    необходимые действия с ними в этом классе, вызывая только методы
    в основном), но компилятор стал ругаться
    на несоответствие версий подгруженных зависимостей
    и я не смог с этим разобратся
    */

    public String shop = "//a[contains(@class, 'home-link home-link_blue_yes home-tabs__link home-tabs__search')][5]";
    public String search = "//input[@id='header-search']";
    public String price = "//input[@id='glpricefrom']";
    public String pricemax = "//input[@id='glpriceto']";
    public String all = "/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[1]";
    public String ourphone = "/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[1]/div[1]/a/img";
    public String ourheadphone = "/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[1]/div[1]/a/img";
    public String h = "//h1";
}
