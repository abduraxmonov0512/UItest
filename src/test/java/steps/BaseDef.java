package steps;

import io.cucumber.java.en.Then;
import pages.Base;

public class BaseDef extends Base {
    @Then("нажать на выйти")
    public void logoutBtn() {
        logout();
    }
}
