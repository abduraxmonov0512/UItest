package pages.EShop;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import static com.codeborne.selenide.Selenide.$;

public class AdPage extends Base {

    private SelenideElement btnRequestPrice = $("[class=\"ui-btn item ui-btn-primary\"]");
    private SelenideElement adTitle = $(".iac-section-header .title");
    private SelenideElement adStatus = $(".status .value");
    private SelenideElement btnPostAd = $(".ui-btn-primary");
    private SelenideElement btnOffertPrice = $(By.xpath("//button//span[text()='Предложить цену']"));

    public void inTitleHasId (int id){
        String titleId = Integer.toString(id);
        adTitle.shouldBe(Condition.visible).shouldHave(Condition.text(titleId));
    }

    public void adStatusIs (String status){
        adStatus.waitUntil(Condition.visible, 10000);
        adStatus.shouldHave(Condition.text(status));
        String str = $(".title", 1).getText();
        String id = str.replaceAll("[^0-9]", "");
        AdInfo.requestId = Integer.parseInt(id);
    }

    public void clickButtonPostAd(){
        click(btnPostAd);
        adStatusIs("Одобрено");
    }

    public void checkAdData(){
        $("[title=\"Марка\"]").shouldHave(Condition.text(AdInfo.brand));
        $("[title=\"Производитель\"]").shouldHave(Condition.text(AdInfo.manufacturer));
        $("[title=\"Страна производства\"]").shouldHave(Condition.text(AdInfo.countryOrigin));
        $("[title=\"Год производства\"]").shouldHave(Condition.text(AdInfo.productionYear));
        $("[title=\"Описание\"]").shouldHave(Condition.text(AdInfo.description));
        $("[title=\"Лицензия\"]").shouldHave(Condition.text(AdInfo.license));
        $("[title=\"Срок гарантии\"]").shouldHave(Condition.text(AdInfo.warranty));
        $("[title=\"Количество на складе\"]").shouldHave(Condition.text(AdInfo.quantityInStock));
       // $("[title=\"-Цена\"]").shouldHave(Condition.text(AdInfo.price));
    }

    public void clickButtonRequestPrice(){
        click(btnRequestPrice);
    }

    public void clickButtonOfferPrice(){
        click(btnOffertPrice);
    }
}
