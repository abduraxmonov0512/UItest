package pages.EShop;

import PPInfo.AdInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import pages.Base;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class RequestPage extends Base {
    private SelenideElement inputSearch = $(By.xpath("//input[@class='control']"));
    private SelenideElement dropDownChooseCategory = $(By.xpath("//div[@class='container']//*[text()='Выберите категорию']"));
    private SelenideElement dropDownParticipation = $(By.xpath("//div[@class='container']//*[text()='Участие']"));
    private SelenideElement dropDownAvailabilityOffer  = $(By.xpath("//div[@class='container']//*[text()='Наличие предложения']"));
    private SelenideElement dropDownStatus = $(By.xpath("//div[@class='container']//*[text()='Статус']"));
    private SelenideElement tabParticipate = $(By.xpath("//div[@class=\"tab-nav\"]//*[text()=\"Участвуем\"]"));
    private SelenideElement tabSubscription = $(By.xpath("//div[@class=\"tab-nav\"]//*[text()=\"Подписка\"]"));
    private SelenideElement buttonCloseRequest = $(By.xpath("//button//span[text()='Закрыть процедуру']"));

    private SelenideElement columnID = $(By.xpath("//table//th[text()='id']"));
    private SelenideElement columnDateRequest = $(By.xpath("//table//th[text()='Дата запроса']"));
    private SelenideElement columnVolume = $(By.xpath("//table//th[text()='Объем']"));
    private SelenideElement columnPrice = $(By.xpath("//table//th[text()='Цена']"));
    private SelenideElement columnSum = $(By.xpath("//table//th[text()='Сумма']"));
    private SelenideElement columnDateOfComplete = $(By.xpath("//table//th[text()='Дата завершения']"));
    private SelenideElement columnStatus = $(By.xpath("//table//th[text()='Статус']"));

    private List<SelenideElement> list;

    public RequestPage(){
        list = Arrays.asList(inputSearch,  columnID,
                columnDateRequest, columnVolume, columnPrice, columnSum, columnDateOfComplete, columnStatus);
    }

    public void requestPageIsDisplayed(){
        allElementsAreVisibleWithHeader(list);
    }


    public void searchRequestById(){
        $(By.xpath("//tbody/tr//td//div")).shouldHave(Condition.text(AdInfo.description));
        $(By.xpath("//tbody/tr//td//a")).shouldHave(Condition.text(AdInfo.nameProduct));
    }

    public void openCreatedRequest(){
        click($("[href=\"/procedure/"+AdInfo.requestId+"/core\"]"));

    }

    public void clickButtonCloseRequest(){
        click(buttonCloseRequest);
        try {
           Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkContractCreated(){
        $(By.xpath("//tr//*[text()="+AdInfo.requestId+"]")).scrollTo().waitUntil(Condition.visible, 10000);
        SelenideElement request = $(By.xpath("//tr//*[text()="+AdInfo.requestId+"]")).parent();
        System.out.println(request);
        request.shouldHave(Condition.text("Договор"));

    }

    public void openContract(){
        SelenideElement request = $(By.xpath("//tr//*[text()="+AdInfo.requestId+"]")).parent();
        request.find(By.className("ui-btn-primary")).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
