package pages.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import static com.codeborne.selenide.Selenide.$;

public class OfferPriceModal extends Base {
    private SelenideElement offerPriceModal = $(".iac-dialog_modal_box-content");
    private SelenideElement inputPrice = $(By.tagName("input"));
    private SelenideElement btnSend = $(By.xpath("//button[text()='Отправить']"));
    private SelenideElement btnCancel = $(By.xpath("//button[text()='Отмена']"));

    public void offerPriceModalIsDisplayed(){
        offerPriceModal.shouldBe(Condition.visible);
        inputPrice.shouldBe(Condition.visible);
        btnSend.shouldBe(Condition.visible);
        btnCancel.shouldBe(Condition.visible);
    }

    public void setPrice(String price){
        editText(inputPrice, price);
    }

    public void clickButtonSend(){
        click(btnSend);
        ignoreEImzo();
    }

    public void clickButtonCancel(){
        click(btnCancel);
    }
}
