package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.common.OfferPriceModal;

public class OfferPriceModalDef {

    private OfferPriceModal offerPriceModal = new OfferPriceModal();

    @Тогда("появится модалка для предложения цены")
    public void появитсяМодалкаДляПредложенияЦены() {
        offerPriceModal.offerPriceModalIsDisplayed();
    }

    @Когда("предлагаем цену {string}")
    public void предлагаемЦену(String price) {
        offerPriceModal.setPrice(price);
        offerPriceModal.clickButtonSend();
    }
}
