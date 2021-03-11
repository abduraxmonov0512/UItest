package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ClearingPage extends Base{

    private SelenideElement tabBalance = $(By.xpath("//div[@class='item active']"));
    private SelenideElement tabOutMoney = $(By.xpath("//div[@class='item ']"));
    private SelenideElement inputDateFrom = $(By.xpath("//div[@title=\"От\"]//div[@class=\"ui-input-date\"]"));
    private SelenideElement inputDateTo = $(By.xpath("//div[@title=\"До\"]//div[@class=\"ui-input-date\"]"));
    private SelenideElement operationType = $(By.xpath("//div[@class=\"ui-control ui-entity icon\"]"));
    private SelenideElement table = $(By.xpath("//div[@class=\"table-wrapper\"]"));

    private List<SelenideElement> listElements;

    public ClearingPage(){
        listElements = Arrays.asList(tabBalance, tabOutMoney, inputDateFrom, inputDateTo, operationType, tabOutMoney, table);
    }

    public void clearingPageIsDisplayed(){
        allElementsAreVisibleWithHeader(listElements);
    }


    public void checkBillings(String deposit, String commission){

        List <SelenideElement> listBillings = $$(By.xpath("//tbody//tr"));
        listBillings.get(0).shouldHave(Condition.or("text", Condition.text(deposit), Condition.text(commission)));
        listBillings.get(1).shouldHave(Condition.or("text", Condition.text(deposit), Condition.text(commission)));
        Selenide.refresh();
        Selenide.refresh();
       // listBillings.get(1).shouldHave(Condition.text(commission));
    }

}
