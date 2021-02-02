package pages.common;

import PPInfo.AdInfo;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddProductsAdsModal extends Base {

    private SelenideElement dialogHeader = $(".iac-dialog-header");
    private SelenideElement categoryDropDown = $(".control", 1);
    private SelenideElement templateDropDown = $(".control", 3);
    private SelenideElement productDropDown = $(".control", 2);
    private SelenideElement btnSend = $(By.xpath("//button[text()='Отправить']"));
    private SelenideElement btnCancel = $(By.xpath("//button[text()='Отмена']"));

    private SelenideElement input = $(By.xpath("//input[@placeholder=\"Найти\"]"));


    private List<SelenideElement> list;

    public AddProductsAdsModal() {
        list = Arrays.asList(dialogHeader, categoryDropDown, btnCancel, btnSend);
    }

    public void addProductsAdsModalIsDisplayed() {
        allElementsAreVisible(list);
    }

    public void seCategory(String category) {
        click(categoryDropDown);
        editText(input, category);
        click($(".display"));
        AdInfo.categoryProduct = category;
    }

    public void setProduct(String product){
        click(productDropDown);
        editText(input, product);
        click($(".display"));
        AdInfo.nameProduct = product;
    }

    public void setTemplate(String template){
        click(templateDropDown);
       // editText(input, template);
        click($(".display"));
    }

    public void clickBtnSend(){
        click(btnSend);
    }
}
