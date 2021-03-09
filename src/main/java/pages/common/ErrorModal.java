package pages.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import static com.codeborne.selenide.Selenide.$;

public class ErrorModal extends Base {
    private SelenideElement errorModal = $(".iac-dialog_modal_box-content");
    private SelenideElement errorBody = $(By.xpath("//div[@class=\"iac-dialog-body error\"]"));
    private SelenideElement btnClose = $(By.xpath("//button[text()='Закрыть']"));

    public void checkErrorBodyHaveText(String text){
        errorBody.shouldHave(Condition.text(text));
    }

    public void clickButtonClose(){
        click(errorModal.find(By.tagName("button")));
    }
}
