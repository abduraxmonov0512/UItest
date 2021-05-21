package pages.common;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.Base;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddProductsAdsModal extends Base {

    private SelenideElement modal = $(".iac-dialog_modal_box-content");
    private SelenideElement categoryDropDown = modal.find(By.className("toolbar"));
    private SelenideElement templateDropDown = $(".control", 3);
    private SelenideElement productDropDown = modal.find(By.className("toolbar"), 1);
    private SelenideElement btnSend = $(By.xpath("//button[text()='Отправить']"));
    private SelenideElement btnCancel = $(By.xpath("//button[text()='Отмена']"));

    private SelenideElement input = $(By.xpath("//input[@placeholder=\"Найти\"]"));


    private List<SelenideElement> list;

    public AddProductsAdsModal() {
        list = Arrays.asList(modal, categoryDropDown, btnCancel, btnSend);
    }

    public void addProductsAdsModalIsDisplayed() {
        allElementsAreVisible(list);
    }

    public void seCategory(String category) {
        click(categoryDropDown);
        editText(input, category);
        $(By.xpath("//div[@class=\"ui-list-item\"]//*[text()='" + category + "']"))
                .waitUntil(Condition.appear, 2000);
        click($(By.xpath("//div[@class=\"ui-list-item\"]//*[text()='" + category + "']")));
        AdInfo.categoryProduct = category;
    }

    public void setProduct(String product) {
        click(productDropDown);
        editText(input, product);
        // input.sendKeys(Keys.BACK_SPACE);
        click($(By.xpath("//div[@class=\"display\"][text()='" + product + "']")));
        AdInfo.nameProduct = product;
    }

    public void setTemplate(String template) {
        click(templateDropDown);
        // editText(input, template);
        click($(".display"));
    }

    public void clickBtnSend() {
        click(btnSend);
    }
}
