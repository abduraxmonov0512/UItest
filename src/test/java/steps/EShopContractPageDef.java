package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.EShop.EShopContractPage;

public class EShopContractPageDef {

    private EShopContractPage eShopContractPage = new EShopContractPage();

    @И("страница Договора отоброжено")
    public void страницаДоговораОтоброжено() {
        eShopContractPage.eShopContractPageIsDisplayed();
    }

    @Тогда("проверит что все данные договора правильны")
    public void проверитЧтоВсеДанныеДоговораПравильны() {
        eShopContractPage.checkContractData();
    }

    @Тогда("подписать договор")
    public void подписатьДоговор() {
        eShopContractPage.clickButtonSubscribe();
    }

    @Тогда("статус Договора {string}")
    public void статусДоговора(String status) {
        eShopContractPage.contractStatusIs(status);
    }
}
