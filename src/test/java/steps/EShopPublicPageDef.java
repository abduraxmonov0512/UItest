package steps;

import PPInfo.AdInfo;
import io.cucumber.java.en.And;
import pages.EShop.EShopPublicPage;

public class EShopPublicPageDef {

    private EShopPublicPage eShopPublicPage = new EShopPublicPage();

    @And("публичная страница ЭМ отоброжено")
    public void eshopPublicPageIsDisplayed() {
        eShopPublicPage.eShopPublicPageIsDisplayed();
    }

    @And("нажать объявления по ID")
    public void clickCreatedAdById() {
        eShopPublicPage.chooseAdById(AdInfo.idAd);
    }
}
