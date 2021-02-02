package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.common.SignInModal;

public class SignInModalDef {

    private static SignInModal signInModal = new SignInModal();

    @Then("модалка для авторизации отоброжено")
    public void signInModalIsDisplayed() {
        signInModal.loginModalIsDisplayed();
    }

    @Then("вводится логин как {string} и пароль как {string}")
    public void editLoginAndPassword(String login, String password) {
        signInModal.editLogin(login);
        signInModal.editPassword(password);
    }

    @When("нажать на кнопку войти")
    public void clickButtonSigIn() {
        signInModal.clickBtnLogin();
    }
}
