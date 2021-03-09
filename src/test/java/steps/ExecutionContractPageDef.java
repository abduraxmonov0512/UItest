package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import pages.EShop.ExecutionContractPage;

public class ExecutionContractPageDef {

    private ExecutionContractPage executionContractPage = new ExecutionContractPage();

    @И("нажать подписать на исполнение")
    public void нажатьПодписатьНаИсполнение() {
        executionContractPage.clickBtnSign();
    }

    @Когда("выбрать основание как {string}")
    public void выбратьОснованиеКак(String action) {
        executionContractPage.chooseActionDropDown(action);
    }
}
