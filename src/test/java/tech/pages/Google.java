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

public class Google {

    /*
    хотел использовать PageFactory(Искать элементы и производить
    необходимые действия с ними в этом классе, вызывая только методы
    в основном), но компилятор стал ругаться
    на несоответствие версий подгруженных зависимостей
    и я не смог с этим разобратся
    */

    // поисковая строка
    public String search_bar = "q";
    // все значения поиска
    public String search_values = "//*[@id='rso']//h3/a";
    // информация для записи в ФАЙЛ
    public String date = "//*[@id=\"content\"]/div[2]/div/div[1]";
}
