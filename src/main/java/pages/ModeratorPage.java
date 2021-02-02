package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.EShop.AdPage;

import static com.codeborne.selenide.Selenide.$;

public class ModeratorPage extends Base {
    private AdPage adPage = new AdPage();

    private SelenideElement eShop = $(By.xpath("//li[@class=\"left-nav__item dropdown\"]//*[text()='Модерация']"));
    private SelenideElement moderate = $("[href=\"/workspace/moderate/electronic_shop\"]");


    public void moderatePageIsDisplayed() {
        $("[href=\"/workspace\"]").shouldHave(Condition.text("Nurilloev Izzat F"));
    }

    public void clickButtonEShop() {
        click(eShop);
    }

    public void clickButtonModerate() {
        click(moderate);
    }

    public void moderateAd(int adId) {
        click($("[href=\"/procedure/" + adId + "/core\"]"));
        adPage.inTitleHasId(adId);
        adPage.clickButtonPostAd();
    }
}
