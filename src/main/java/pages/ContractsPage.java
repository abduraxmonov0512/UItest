package pages;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ContractsPage extends Base {

    private SelenideElement tabByTender = $(By.ByXPath.xpath("//div[@class='item '][text()='По тендерам']"));
    private SelenideElement tabByContest = $(By.ByXPath.xpath("//div[@class='item '][text()='По конкурсам']"));
    private SelenideElement tabByEShop = $(By.ByXPath.xpath("//div[@class='item '][text()='По магазину']"));
    private SelenideElement tabByAuction = $(By.ByXPath.xpath("//div[@class='item '][text()='По аукционам']"));


    private List<SelenideElement> listElements;

    public ContractsPage() {
        listElements = Arrays.asList(tabByAuction, tabByContest, tabByEShop);
    }

    public void contractPageDisplayed() {
        allElementsAreVisible(listElements);
    }

    public void clickTabEShop() {
        click(tabByEShop);
    }

    public void goToLastCreatedContract() {

        click($("[href=\"/workspace/contract/" + AdInfo.requestId + "." + AdInfo.countResets + ".1\"]"));
    }
}
