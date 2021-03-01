package steps;

import PPInfo.AdInfo;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.И;
import pages.EShop.AdPage;

public class AdPageDef {

    private AdPage adPage = new AdPage();

    @Then("проверить ид объявления правильно")
    public void checkCreatedAd() {
        adPage.inTitleHasId(AdInfo.idAd);
    }


    @Then("статус объявлении равно на {string}")
    public void checkCreatedAdStatusEquals(String status) {
        adPage.adStatusIs(status);
    }

    @Then("проверить объявления на правильность")
    public void checkAdDataIsTrue() {
        adPage.checkAdData();
    }

    @И("нажать на кнопку Запросить цену")
    public void нажатьНаКнопкуЗапроситьЦену() {
        adPage.clickButtonRequestPrice();
    }

    @И("нажать на кнопку Предложить цену")
    public void нажатьНаКнопкуПредложитьЦену() {
        adPage.clickButtonOfferPrice();
    }
}
