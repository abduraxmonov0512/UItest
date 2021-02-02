package pages.EShop;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class EShopContractPage extends Base {
    private SelenideElement btnChat = $(".page-contract__chat-btn");
    private SelenideElement status = $(".row", 0);
    private SelenideElement nameProduct = $(".row", 3);
    private SelenideElement brand = $(".row", 4);
    private SelenideElement manufacture = $(".row", 5);
    private SelenideElement countryOrigin = $(".row", 6);
    private SelenideElement characters = $(".row", 10);
    private SelenideElement license = $(".row", 11);
    private SelenideElement count = $(".row", 12);
    private SelenideElement deliverTime = $(".row", 13);
    private SelenideElement price = $(".row", 14);

    private List<SelenideElement> list;

    public EShopContractPage() {
        list = Arrays.asList(btnChat,status,nameProduct,brand,manufacture,countryOrigin,
                characters,license,count,deliverTime,price);
    }

    public void eShopContractPageIsDisplayed(){
        allElementsAreVisibleWithHeader(list);
    }

    public void checkContractData(){
        nameProduct.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.nameProduct));
        brand.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.brand));
        manufacture.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.manufacturer));
        countryOrigin.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.countryOrigin));
        characters.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.description));
        license.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.license));
        count.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.requestCount));
        deliverTime.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.deliveryTime));
//        price.find(By.className("col-sm-5")).shouldHave(Condition.text(AdInfo.price));
    }
}