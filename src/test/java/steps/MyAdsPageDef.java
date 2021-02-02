package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EShop.MyAdsPage;

public class MyAdsPageDef {

    private MyAdsPage myAdsPage = new MyAdsPage();

    @Then("страница Мои объявления отображено")
    public void adsPageIsDisplayed() {
        myAdsPage.adsPageIsDisplayed();
    }

    @When("нажать на кнопку Создать объявления")
    public void clickBtnCreateAd() {
        myAdsPage.clickBtnAddAds();
    }
}
