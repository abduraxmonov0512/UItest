package pages.EShop;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class EShopContractPage extends Base {
    private SelenideElement btnChat = $(".page-contract__chat-btn");
    private SelenideElement contractStatus = $(".row", 0);
    private SelenideElement nameProduct = $(".row", 3);
    private SelenideElement brand = $(".row", 4);
    private SelenideElement manufacture = $(".row", 5);
    private SelenideElement countryOrigin = $(".row", 6);
    private SelenideElement characters = $(".row", 10);
    private SelenideElement license = $(".row", 11);
    private SelenideElement count = $(".row", 12);
    private SelenideElement deliverTime = $(".row", 13);
    private SelenideElement price = $(".row", 14);
    private SelenideElement btnExecutionContract = $("[href=\"/workspace/contract/917.1.1/execution\"]");
    private SelenideElement btnMoneyTransfer = $(By.xpath("//button[text()='Денежные средства перечислены']"));
    private SelenideElement btnRepeatContract = $(By.xpath("//button[text()='Сбрасывать финальные состояния']"));

    private SelenideElement btnSubscribe = $(".ui-btn-primary");

    private List<SelenideElement> list;

    public EShopContractPage() {
        list = Arrays.asList(btnChat, contractStatus, nameProduct, brand, manufacture, countryOrigin,
                characters, license, count, deliverTime, price);
    }

    public void eShopContractPageIsDisplayed() {
        allElementsAreVisibleWithHeader(list);
    }

    public void checkContractData() {
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

    public void clickButtonSubscribe() {
        click(btnSubscribe);
        $(".iac-dialog_modal_box-content").shouldBe(Condition.visible);
        click($(By.xpath("//div[@class='iac-dialog-footer']//button[@class=\"ui-btn ui-btn-primary\"]")));
        ignoreEImzo();
    }

    public void contractStatusIs(String status) {
        contractStatus.waitUntil(Condition.visible, 5000);
        contractStatus.find(By.tagName("span")).waitUntil((Condition.text(status)), 5000);
        //contractStatus.shouldHave(Condition.text(status));
    }

    public void clickBtnExecutionContract() {
        click($(By.xpath("//a[text()='Исполнение договорных обязательств']")));

    }

    public void clickButtonMoneyTransfer() {
        click(btnMoneyTransfer);
        click($(By.xpath("//div[@class=\"iac-dialog_modal_box-content\"]//button[@class=\"ui-btn ui-btn-primary\"]")));
    }

    public void clickButtonRepeatContract() {
        btnRepeatContract.waitUntil(Condition.visible, 4000);
        btnRepeatContract.scrollTo();
        click(btnRepeatContract);
        AdInfo.countResets++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
