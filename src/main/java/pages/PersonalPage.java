package pages;

import TestContext.TestContext;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static TestContext.UserRoles.BUYER_COMPANY_ADMIN;
import static TestContext.UserRoles.SELLER;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalPage extends Base {

    private SelenideElement sectionOrganization = $(By.xpath("//div[@class=\"primary\"]//*[text()=\"Организация\"]"));
    private SelenideElement sectionSchedule = $(By.xpath("//div[@class=\"primary\"]//*[text()=\"План график\"]"));
    private SelenideElement sectionAffiliation = $(By.cssSelector("[href=\"/workspace/affiliation\"]"));
    private SelenideElement sectionClaims = $(By.cssSelector("[href=\"/workspace/claim\"]"));
    private SelenideElement sectionAgreement = $(By.xpath("//div[@class=\"primary\"]//*[text()=\"Согласование\"]"));
    private SelenideElement sectionContract = $("[href=\"/workspace/contract\"]");
    private SelenideElement sectionTypePurchase = $(By.xpath("//div[@class=\"primary\"]//*[text()=\"Виды закупок\"]"));
    private SelenideElement sectionEShop = $(By.xpath("//div[@class=\"primary\"]//*[text()=\"Магазин\"]"));
 //   private SelenideElement btnBindDigitalKey = $(".ui-btn");
    private SelenideElement freeMoney = $(".account-summary [href=\"/workspace/billing\"]");
    private SelenideElement username = $("[href=\"/workspace\"]");
    private SelenideElement btnLogout = $(".logout");
    private SelenideElement subSectionEShopAds = $("[href=\"/workspace/ad\"]");
    private SelenideElement subSectionEShopRequests = $("[href=\"/workspace/request\"]");
    private SelenideElement subSectionClearing = $("[href=\"/workspace/billing\"]",0);
 //   private SelenideElement haveGraphs = $$(".iac-dashboard .chart-pie").shouldHave(size(12));

    private List<SelenideElement> listElements;

    public PersonalPage() {

    }

    public void personalPageIsDisplayed(){
        if(TestContext.userRole == BUYER_COMPANY_ADMIN){
            listElements = Arrays.asList(sectionAffiliation, sectionAgreement, sectionClaims, sectionContract,
                    sectionOrganization, sectionSchedule, sectionTypePurchase,  btnLogout,
                    username);
        } else if(TestContext.userRole == SELLER){
            listElements = Arrays.asList(sectionContract, sectionEShop,
                    sectionOrganization,  sectionTypePurchase,  btnLogout,
                    username);
        }
        allElementsAreVisibleWithHeader(listElements);
        $$(".iac-dashboard .chart-pie").shouldHave(size(12));
    }

    public void clickSectionEShop(){
        click(sectionEShop);
        subSectionEShopAds.shouldBe(Condition.visible).shouldHave(Condition.text("Мои объявления"));
        subSectionEShopRequests.shouldBe(Condition.visible).shouldHave(Condition.text("Запросы"));
    }

    public void clickSubSectionMyAds(){
        click(subSectionEShopAds);
    }

    public void clickSubSectionRequests(){
        click(subSectionEShopRequests);
    }

    public void clickSectionOrganization(){
        click(sectionOrganization);
    }

    public void clickSubSectionClearing(){
        if(!subSectionClearing.isDisplayed()){
            click(sectionOrganization);
        }
        click(subSectionClearing);
    }

    public void clickSectionContracts(){
        click(sectionContract);
    }
}
