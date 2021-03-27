package pages.EShop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class EShopPublicPage extends Base {
    SelenideElement searchInput = $(By.xpath("//div[@class=\"container\"]//label[text()='Найти']"));
    SelenideElement dropDownCategory = $(By.xpath("//div[@class=\"container\"]//label[text()='Выберите категорию']"));
    SelenideElement dropDownProduct = $(By.xpath("//div[@class=\"container\"]//label[text()='Выберите товар']"));
    SelenideElement dropDownCountry = $(By.xpath("//div[@class=\"container\"]//label[text()='Выберите страну']"));

    private List<SelenideElement> list;

    public EShopPublicPage() {
        list = Arrays.asList(searchInput, dropDownCategory, dropDownCountry);
    }

    public void eShopPublicPageIsDisplayed() {
        allElementsAreVisibleWithHeader(list);
    }

    public void chooseAdById(int id) {

        while (!adExpected(id)){
            $(By.xpath("//button[@class=\"ui-btn content ui-btn-info\"]")).waitUntil(Condition.visible, 10000);
            click($(By.xpath("//button[@class=\"ui-btn content ui-btn-info\"]")));
            System.out.println("sikl in test");
        }
      //  $("[href='/ad/" + id + "/core']").shouldBe(Condition.visible);
        click($("[href='/ad/" + id + "/core']"));
    }
}
