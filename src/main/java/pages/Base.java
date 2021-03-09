package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

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
       // element.waitUntil(Condition.visible, 25000);
        element.scrollTo().shouldBe(Condition.visible).click();
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

    public boolean elementExpected(int id) {
        try {

            $("[href='/ad/" + id + "/core']").shouldBe(Condition.visible);
        } catch (ElementNotFound e) {

            return false;

        }
        return true;
    }

}
