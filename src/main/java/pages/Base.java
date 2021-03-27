package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public abstract class Base {

    private SelenideElement linkCatalogs = $(By.cssSelector("[href=\"http://tasniflagich.mf.uz/\"]"));
    private SelenideElement linkAboutSystem = $(By.cssSelector("[href=\"/info/system\"]"));
    private SelenideElement linkNews = $(By.cssSelector("[href=\"/news\"]"));
    private SelenideElement linkTraffics = $(By.cssSelector("[href=\"/info/tariffs\"]"));
    private SelenideElement logout = $(".logout");

    protected void allElementsAreVisibleWithHeader(List<SelenideElement> list) {
        addHeaderLinks(list);
        for (SelenideElement element : list) {
            element.shouldBe(Condition.visible);
        }
    }

    protected void allElementsAreVisible(List<SelenideElement> list) {

        for (SelenideElement element : list) {
            element.shouldBe(Condition.visible);
        }

    }

    private void addHeaderLinks(List<SelenideElement> list) {

        list = new ArrayList<>(list);

        list.add(linkAboutSystem);
        list.add(linkCatalogs);
        list.add(linkNews);
        list.add(linkTraffics);

    }

    public void click(SelenideElement element) {
        int countRefresh = 0;
        boolean flag = true;
        do{
            try {
                element.scrollTo().waitUntil(Condition.visible, 5000);
                flag = element.is(Condition.appear);
                element.scrollTo().shouldBe(Condition.visible).click();
            }catch (ElementNotFound e){
                refresh();
                countRefresh++;
            }
        }while (!flag && countRefresh < 3);
//        element.scrollTo().waitUntil(Condition.appear, 5000);
//        element.scrollTo().shouldBe(Condition.appear).click();
    }

    public void editText(SelenideElement element, String txt) {
        element.scrollTo().shouldBe(Condition.visible).sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(txt);
    }

    protected void logout() {
        click(logout);
    }

    public void ignoreEImzo() {
        $(".iac-dialog_modal_box-content").shouldBe(Condition.visible);
        $(By.xpath("//button[@class=\"ui-btn ui-btn-primary\"][text()='Да']")).shouldBe(Condition.visible).click();

    }

    public void clickButtonBack(){
        Selenide.back();
    }

    public boolean elementVisible(SelenideElement element){
        if(element.is(Condition.exist)){
            return true;
        }
        return element.isDisplayed();
    }

    public boolean adExpected(int id) {
        try {

            $("[href='/ad/" + id + "/core']").shouldBe(Condition.visible);
        } catch (ElementNotFound e) {

            return false;

        }
        return true;
    }

}
