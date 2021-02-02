package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EShop.EditAdPage;

public class EditAdPageDef {

    private EditAdPage editAdPage = new EditAdPage();

    @Then("страница создания объявления отоброжено")
    public void editAdPageIsDisplayed() {
        editAdPage.editAdPageIsDisplayed();
    }

    @And("ввод Марка как {string}")
    public void setBrandProductAs(String brand) {
        editAdPage.setBrand(brand);
    }

    @And("ввод Производитель как {string}")
    public void setManufactureAs(String manufacture) {
        editAdPage.setManufacture(manufacture);
    }

    @And("ввод Страна производства как {string}")
    public void setCountryOriginAs(String country) {
        editAdPage.setCountryOrigin(country);
    }

    @And("ввод Срок годности год {string} месяц {string} день {string}")
    public void setShelfLiferProductYearMonthDay(String year, String month, String day) {
        editAdPage.setShelfLife(year, month, day);
    }

    @And("ввод Гарантии {string} единиц измерения как {string}")
    public void setWarrantyAsAmount(String countDate, String amount) {
        editAdPage.setWarranty(countDate, amount);
    }

    @And("ввод Год производства как {string}")
    public void setProductionYearAs(String year) {
        editAdPage.setProductionYear(year);
    }

    @And("ввод Описание как {string}")
    public void setDescriptionAs(String description) {
        editAdPage.setDescription(description);
    }

    @And("назначить лицензию как {string}")
    public void setLicenseAs(String licence) {
        editAdPage.setLicence(licence);
    }

    @And("ввод срок доставки как {string} единиц измерения как {string}")
    public void setDeliveryTimeAsAmount(String time, String amount) {
        editAdPage.setDeliveryTime(time, amount);
    }

    @And("ввод Цена как {string}")
    public void setPriceAs(String price) {
        editAdPage.setPrice(price);
    }

    @And("ввод Количество на складе как {string}")
    public void setQuantityInStockAs(String count) {
        editAdPage.setQuantityInStock(count);
    }

    @And("ввод Минимальное количество как {string}")
    public void setMinCountForRequestAs(String count) {
        editAdPage.setMinAmountProduct(count);
    }

    @And("ввод Максимальное количество как {string}")
    public void setMaxCountForRequestAs(String count) {
        editAdPage.setMaxAmountProduct(count);
    }

    @And("назначит Единица измерения как {string}")
    public void setUnitOfMeasurementAs(String measurement) {
        editAdPage.setUnitMeasurement(measurement);
    }

    @And("загрузит фото для объявления")
    public void uploadPhoto() {
        editAdPage.uploadPhoto();
    }

    @Then("нажать на кнопку Отправить на модерацию")
    public void clickBtnSendToModerate() {
        editAdPage.sendToModerate();
    }

//    @And("set bargain term as {string} amount {string}")
//    public void setBargainTermAsAmount(String bargain, String unit) {
//        editAdPage.setBargainingTerm(bargain, unit);
//    }

    @And("set delivery region as {string}")
    public void setDeliveryRegionAs(String regions) {
        editAdPage.setDeliveryRegion(regions);
    }
}
