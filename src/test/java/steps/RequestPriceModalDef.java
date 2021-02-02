package steps;

import PPInfo.AdInfo;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.common.RequestPriceModal;

public class RequestPriceModalDef {

    private RequestPriceModal requestPriceModal = new RequestPriceModal();

    @Тогда("появится модалка для запроса цены")
    public void появитсяМодалкаДляЗапросаЦены() {
        requestPriceModal.requestPriceModalDisplayed();
    }

    @Тогда("указать количество закупаемого товара как {string}")
    public void указатьКоличествоЗакупаемогоТовараКак(String count) {
        requestPriceModal.setCountOfProduct(count);
        AdInfo.requestCount = count;
    }


    @Когда("нажать на кнопку отправить на модалке")
    public void нажатьНаКнопкуОтправитьНаМодалке() {
        requestPriceModal.clickBtnSend();
    }
}
