package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.ru.И;
import pages.Base;

public class BaseDef extends Base {
    @Then("нажать на выйти")
    public void logoutBtn() {
        logout();
    }

    @И("нажать на кнопку назад браузера")
    public void нажатьНаКнопкуНазадБраузера() {
        clickButtonBack();
    }
}
