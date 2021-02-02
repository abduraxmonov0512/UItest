package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.ClearingPage;

public class ClearingPageDef {

    private ClearingPage clearingPage = new ClearingPage();

    @Тогда("страница Клиринг отображается")
    public void страницаКлирингОтображается() {
        clearingPage.clearingPageIsDisplayed();
    }


    @И("в биллинге сумма заблокирована задатка по электронному магазину {string} комиссионного сбора по электронному магазину {string}")
    public void вБиллингеСуммаЗаблокирована(String deposit, String commission) {
        clearingPage.checkBillings(deposit, commission);
    }
}
