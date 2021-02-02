package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import pages.MainPage;

public class MainPagDef {

    private MainPage mainPage = new MainPage();

    @When("главная страница отоброжена")
    public void mainPageIsDisplayed() {
        mainPage.mainPageIsDisplayed();
    }

    @Then("нажать на кнопку Войти")
    public void clickBtnSigIn() {
        mainPage.clickBtnSignIn();
    }

    @And("нажать на таб ЭМ в главной странице")
    public void clickTabEShop() {
        mainPage.clickTabEShop();
    }

    @And("нажать на копку Перейти в список объявлений")
    public void clickButtonGoToListOfAds() {
        mainPage.clickButtonGoToListAds();
    }

    @Когда("нажать на лого компании")
    public void нажатьНаЛогоКомпании() {
        mainPage.clickLogoIcon();
    }

    @Когда("перейти в личный кабинет")
    public void перейтиВЛичныйКабинет() {
        mainPage.clickWorkspaceLink();
    }
}
