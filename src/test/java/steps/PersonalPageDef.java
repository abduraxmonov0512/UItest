package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import pages.PersonalPage;

public class PersonalPageDef {

    private final PersonalPage personalPage = new PersonalPage();

    @Then("личный кабинеть отоброжена")
    public void personalPageIsDisplayed() {
        personalPage.personalPageIsDisplayed();
    }

    @When("нажать на раздель ЭМ")
    public void clickSectionEShop() {
        personalPage.clickSectionEShop();
    }

    @And("нажать на под раздель Мои объявления")
    public void clickSubSectionMyAds() {
        personalPage.clickSubSectionMyAds();
    }

    @And("нажать под раздель Запросы")
    public void clickSubSectionRequests() {
        personalPage.clickSubSectionRequests();
    }

    @И("нажать на раздель Организация")
    public void нажатьНаРаздельОрганизация() {
        personalPage.clickSectionOrganization();
    }

    @И("нажать на под раздель Клиринг")
    public void нажатьНаПодРаздельКлиринг() {
        personalPage.clickSubSectionClearing();
    }

    @Когда("нажать на раздель Договоры")
    public void нажатьНаРаздельДоговоры() {
        personalPage.clickSectionContracts();
    }
}
