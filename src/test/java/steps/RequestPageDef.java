package steps;

import PPInfo.AdInfo;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.EShop.RequestPage;


public class RequestPageDef {

    private RequestPage requestPage = new RequestPage();
    @Then("страница Запросы отоброжена")
    public void requestPageIsDisplayed() {
        requestPage.requestPageIsDisplayed();
    }

    @Тогда("проверить существование запроса")
    public void проверитьПоИдСуществованиеЗапроса() {
        requestPage.searchRequestById();
    }

    @Когда("открыт запрос созданный запрос")
    public void открытЗапросСозданныйЗапрос() {
        requestPage.openCreatedRequest();
    }

    @И("нажать кнопку закрыт процедуру")
    public void нажатьКнопкуЗакрытПроцедуру() {
        requestPage.clickButtonCloseRequest();
    }

    @Тогда("проверить что Договор создан")
    public void договорСоздан() {
        requestPage.checkContractCreated();
    }

    @Когда("нажать на договор")
    public void нажатьНаДоговор() {
        requestPage.openContract();
    }
}
