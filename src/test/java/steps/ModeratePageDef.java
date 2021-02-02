package steps;

import PPInfo.AdInfo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ModeratorPage;

public class ModeratePageDef {

    private ModeratorPage moderatorPage = new ModeratorPage();

    @And("перейти в страницу модерация")
    public void goToTheModeratePage() {
        moderatorPage.clickButtonEShop();
        moderatorPage.clickButtonModerate();
    }

    @Then("опубликовать объявления")
    public void moderateAd() {
        moderatorPage.moderateAd(AdInfo.idAd);
    }
}
