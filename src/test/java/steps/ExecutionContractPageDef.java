package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
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

    @Тогда("назначит штрафные санкции на {string}")
    public void назначитШтрафныеСанкцииНа(String company) {
        executionContractPage.choosePenaltyFor(company);
    }

    @И("установить сумма штрафа {string}")
    public void установитьСуммаШтрафа(String summa) {
        executionContractPage.setAmountPenalty(summa);
    }

    @И("написать причина штрафных санкций как {string}")
    public void написатьПричинаШтрафныхСанкцийКак(String text) {
        executionContractPage.setReasonForPenalty(text);
    }
}
