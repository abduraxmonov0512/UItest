package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.common.AddProductsAdsModal;

public class AdsAddProductModalDef {

    private AddProductsAdsModal addProductsAdsModal = new AddProductsAdsModal();

    @Then("модалка для создания объявления отоброжена")
    public void adsCreateProductModalIsDisplayed() {
        addProductsAdsModal.addProductsAdsModalIsDisplayed();
    }

    @When("назначается категоря как {string}")
    public void setCategoryAs(String category) {
        addProductsAdsModal.seCategory(category);
    }

    @And("назначается продукт как {string}")
    public void setProductAs(String product) {
        addProductsAdsModal.setProduct(product);
    }

    @And("назначается Шаблон как {string}")
    public void setTemplateAs(String template) {
        addProductsAdsModal.setTemplate(template);
    }

    @Then("нажать кнопку Отправить")
    public void clickBtnSend() {
        addProductsAdsModal.clickBtnSend();
    }
}
