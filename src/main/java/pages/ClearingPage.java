package pages;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ShouldHave;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import helpers.ClearingTableHelper;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ClearingPage extends Base {

    private SelenideElement tabBalance = $(By.xpath("//div[@class='item active']"));
    private SelenideElement tabOutMoney = $(By.xpath("//div[@class='item ']"));
    private SelenideElement inputDateFrom = $(By.xpath("//div[@title=\"От\"]//div[@class=\"ui-input-date\"]"));
    private SelenideElement inputDateTo = $(By.xpath("//div[@title=\"До\"]//div[@class=\"ui-input-date\"]"));
    private SelenideElement operationType = $(By.xpath("//div[@class=\"ui-control ui-entity icon\"]"));
    private SelenideElement table = $(By.xpath("//div[@class=\"table-wrapper\"]"));

    private ClearingTableHelper clearingTableHelper;

    private List<SelenideElement> listElements;

    public ClearingPage() {
        listElements = Arrays.asList(tabBalance, tabOutMoney, inputDateFrom, inputDateTo, operationType, tabOutMoney, table);
    }

    public void clearingPageIsDisplayed() {
        allElementsAreVisibleWithHeader(listElements);
    }


    public void checkBillings(String deposit, String commission) {

        List<SelenideElement> listBillings = $$(By.xpath("//tbody//tr"));
        listBillings.get(0).shouldHave(Condition.or("text", Condition.text(deposit), Condition.text(commission)));
        listBillings.get(1).shouldHave(Condition.or("text", Condition.text(deposit), Condition.text(commission)));
        Selenide.refresh();
        Selenide.refresh();
        // listBillings.get(1).shouldHave(Condition.text(commission));
    }

    public void debitSumWith(String text, String sum) {

        SelenideElement raw = null;
        int countRefresh = 0;
        do {
            try {
                clearingTableHelper = new ClearingTableHelper();
                if (AdInfo.countResets >0) {
                    raw = clearingTableHelper.getRawWithText(text + " №" + AdInfo.requestId);
                } else {
                    raw = clearingTableHelper.
                            getRawWithText(text + " №" + AdInfo.requestId + "." + AdInfo.countResets + ".1");
                }

                raw.find(By.xpath("td"), 1).shouldHave(Condition.text(sum));
            } catch (NullPointerException  | ElementShould e) {
                refresh();
                countRefresh++;
            }
        } while (raw == null && countRefresh < 5);
    }


    public void creditSumWith(String text, String sum) {
        SelenideElement raw = null;
        int countRefresh = 0;
        do {
            try {
                clearingTableHelper = new ClearingTableHelper();

                if (AdInfo.countResets > 0) {
                    raw = clearingTableHelper.getRawWithText(text + " №" + AdInfo.requestId);
                    System.out.println("TESSSSSSSSSSSSST" + raw);
                } else {
                    raw = clearingTableHelper.
                            getRawWithText(text + " №" + AdInfo.requestId + "." + AdInfo.countResets + ".1");
                }

                raw.find(By.xpath("td"), 2).shouldHave(Condition.text(sum));
            } catch (NullPointerException | ElementShould e) {
                refresh();
                countRefresh++;
            }
        } while (raw == null && countRefresh < 5);

    }

    public void test() {
        SelenideElement e = clearingTableHelper.getRawWithText("Комиссионный сбор по электронному магазину №1321");
        System.out.println(e.getText());
    }

}
