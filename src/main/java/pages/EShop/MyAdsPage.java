package pages.EShop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyAdsPage extends Base {
    private SelenideElement btnAddAds = $(By.xpath("//button[text()=\"Создать объявление\"]"));
    private SelenideElement statusPublicated = $("#publicated");
    private SelenideElement statusDraft = $("#draft");
    private SelenideElement statusModerated = $("#moderated");
    private SelenideElement statusRejected = $("#rejected");
    private SelenideElement statusClose = $("#close");

    private List<SelenideElement> listElements;

    public MyAdsPage(){
        listElements = Arrays.asList(btnAddAds, statusClose, statusDraft, statusModerated, statusPublicated, statusRejected);
    }

    public void adsPageIsDisplayed(){
        allElementsAreVisibleWithHeader(listElements);
        $(".title", 1).shouldHave(Condition.text("Мои объявления"));
    }

    public void clickBtnAddAds(){
        click(btnAddAds);
    }


}
