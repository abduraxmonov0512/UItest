package pages.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import static com.codeborne.selenide.Selenide.$;

public class RequestPriceModal extends Base {

    private SelenideElement requestPriceModal = $(".iac-dialog_modal_box-content");
    private SelenideElement inputCountProduct = $(By.xpath("//input[@type=\"float\"]"));
    private SelenideElement btnSend = $(By.xpath("//button[@class='ui-btn ui-btn-primary']"));

    public void requestPriceModalDisplayed(){
        requestPriceModal.shouldBe(Condition.visible);
    }

    public void setCountOfProduct(String count){
        editText(inputCountProduct, count);
    }

    public void clickBtnSend(){
        click(btnSend);
        ignoreEImzo();
    }

}
