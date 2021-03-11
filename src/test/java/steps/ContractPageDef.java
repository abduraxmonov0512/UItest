package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.ContractsPage;

public class ContractPageDef {

    private ContractsPage contractPage = new ContractsPage();

    @Тогда("страница Договора отоброжено")
    public void страницаДоговораОтоброжено() {
        contractPage.contractPageDisplayed();
    }

    @Когда("нажать на таб По Магазину")
    public void нажатьНаТабПоМагазину() {
        contractPage.clickTabEShop();
    }

    @И("зайти в последный договор")
    public void зайтиВПоследныйДоговор() {
        contractPage.goToLastCreatedContract();
    }
}
