package steps;

import io.cucumber.java.ru.Тогда;
import pages.common.ErrorModal;

public class ErrorModalDef {

    private ErrorModal errorModal = new ErrorModal();

    @Тогда("появляется ошибка с текстом {string}")
    public void появляетсяОшибкаСТекстом(String text) {
        errorModal.checkErrorBodyHaveText(text);
        errorModal.clickButtonClose();
    }
}
