package pages.common;

import TestContext.TestContext;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;


import java.util.Arrays;
import java.util.List;

import static TestContext.UserRoles.BUYER_COMPANY_ADMIN;
import static com.codeborne.selenide.Selenide.$;

public class SignInModal extends Base {
    private SelenideElement etLogin = $(By.cssSelector("[name='login']"));
    private SelenideElement etPassword = $(By.cssSelector("[name='password']"));
    private SelenideElement btnLogin = $(By.xpath("//div[@class=\"content\"]//button[text()=\"Войти\"]"));
    private SelenideElement btnLoginWithETSP = $(By.xpath("//div[@class=\"content\"]//button[text()=\"Войти через ЭЦП\"]"));
    private SelenideElement linkAccountRegister = $(By.cssSelector("[href=\"/account/register\"]    "));
    private SelenideElement linkForgivePassword = $(By.xpath("//div[@class='iac-dialog-footer']//*[text()=\"Забыли пароль?\"]"));

    List<SelenideElement> listElements;


    public SignInModal() {
        listElements = Arrays.asList(etLogin, etPassword, btnLogin, btnLoginWithETSP, linkAccountRegister, linkForgivePassword);
    }

    public void loginModalIsDisplayed() {
        allElementsAreVisible(listElements);

    }

    public void editLogin(String login) {
        editText(etLogin, login);
        TestContext.setUserRoleByLogin(login);
    }

    public void editPassword(String psw) {
        editText(etPassword, psw);
    }

    public void clickBtnLogin() {
        click(btnLogin);
    }
}
