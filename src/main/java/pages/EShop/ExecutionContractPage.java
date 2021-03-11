package pages.EShop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import static com.codeborne.selenide.Selenide.$;

public class ExecutionContractPage extends Base {

    private SelenideElement chooseActionDropDown = $(By.xpath("//div[@class=\"container\"]//*[text()='Выберите основание']"));
    private SelenideElement dropdownPenaltiesFor = $(By.xpath("//div[@class=\"container\"]//*[text()='Кто платит']"));
    private SelenideElement amountPenalty = $(By.xpath("//input[@class='control']"));
    private SelenideElement reasonForPenalty = $(By.tagName("textarea"));
    private SelenideElement btnSign = $(By.xpath("//button[text()='Подписать']"));

    public void chooseActionDropDown(String action) {
        click(chooseActionDropDown.parent());

        click($(By.xpath("//div[@class=\"display\"][text()='" + action + "']")));

    }

    public void choosePenaltyFor(String text){
        click(dropdownPenaltiesFor.parent());
        click($(By.xpath("//div[@class=\"display\"][text()='" + text + "']")));
    }

    public void setAmountPenalty(String amountOfPenalty){
        editText(amountPenalty, amountOfPenalty);
    }

    public void setReasonForPenalty(String text){
        editText(reasonForPenalty, text);
    }

    public void clickBtnSign(){
        click(btnSign);

        if($(".iac-dialog_modal_box-content").getText().contains("Да")){
            $(".iac-dialog_modal_box-content").waitUntil(Condition.visible, 10000);
            click($(By.xpath("//div[@class=\"iac-dialog_modal_box-content\"]//button[text()='Да']")));
            ignoreEImzo();
        }

    }
}
