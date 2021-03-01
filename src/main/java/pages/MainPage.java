package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Base {

    private SelenideElement logoIcon = $(By.cssSelector("[src=\"/img/logotype.svg\"]"));
    private SelenideElement btnSignIn = $(By.xpath("//button[text()='Войти']"));
    private SelenideElement registers = $(By.xpath("//*[text()='Реестры']"));
    private SelenideElement info = $(By.xpath("//*[text()='Информация']"));
    private SelenideElement contestsList = $(By.xpath("//div[@class=\"tab-nav\"]//*[text()=\"Конкурс\"]"));
    private SelenideElement tenderList = $(By.xpath("//div[@class=\"tab-nav\"]//*[text()=\"Тендер\"]"));
    private SelenideElement esList = $(By.xpath("//div[@class=\"tab-nav\"]//*[text()=\"Магазин\"]"));
    private SelenideElement btnGoToListAds = $("[href=\"/procedure/ad\"]");
    private SelenideElement workspaceLink = $("[href=\"/workspace\"]");

    private List<SelenideElement> listElements;

    public MainPage() {
        listElements = Arrays.asList( info, registers, btnSignIn, contestsList, tenderList, esList);
    }

    public void mainPageIsDisplayed(){
        allElementsAreVisibleWithHeader(listElements);
    }

    public void clickBtnSignIn(){
        btnSignIn.shouldBe(Condition.visible).click();
    }

    public void clickTabEShop(){
        click(esList);
    }

    public void clickButtonGoToListAds(){
        click(btnGoToListAds);
    }

    public void clickLogoIcon(){
        click(logoIcon);
    }

    public void clickWorkspaceLink(){
        workspaceLink.waitUntil(Condition.visible,5000);
        click(workspaceLink);
    }
}
