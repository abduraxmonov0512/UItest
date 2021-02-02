package pages.EShop;

import PPInfo.AdInfo;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Base;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditAdPage extends Base {

    private SelenideElement btnSendToModerate = $(By.xpath("//button[@class='ui-btn item ui-btn-primary']//*[text()='Отправить на модерацию']"));
    private SelenideElement categoryProduct = $(".control", 0);
    private SelenideElement nameProduct = $(".control", 1);
    private SelenideElement brandProduct = $(".control", 2);
    private SelenideElement manufactureProduct = $(".control", 3);
    private SelenideElement countryOriginProduct = $(".control", 4);
    private SelenideElement shelfLifeProduct = $(".control", 6);
    private SelenideElement warrantyProduct = $(".control", 7);
    private SelenideElement warrantyUnitProduct = $(".control", 8);
    private SelenideElement productionYearProduct = $(".control", 9);
    private SelenideElement descriptionProduct = $(".control", 10);
    private SelenideElement licenceProduct = $(".control", 11);
    private SelenideElement deliveryTimeProduct = $(".control", 12);
    private SelenideElement deliveryUnitProduct = $(".control", 13);
//    private SelenideElement bargainingTerm = $(".control", 14);
//    private SelenideElement bargainingTermUnit = $(".control", 15);
    private SelenideElement priceProduct = $(".control", 14);
    private SelenideElement priceUnitProduct = $(".control", 15);
    private SelenideElement quantityInStock = $(".control", 16);
    private SelenideElement minAmountProduct = $(".control", 17);
    private SelenideElement maxAmountProduct = $(".control", 18);
    private SelenideElement unitMeasurementProduct = $(".control", 19);
    private SelenideElement uploadPhoto = $(By.xpath("//input[@type=\"file\"]"));
    private SelenideElement deliveryRegion = $(".control", 20);


    public void editAdPageIsDisplayed() {
        $(".status .value").shouldHave(Condition.text("Черновик"));
        $$(".content .control").shouldHave(CollectionCondition.size(22));
        String str = $(".title", 1).getText();
        String id = str.replaceAll("[^0-9]", "");
        AdInfo.idAd = Integer.parseInt(id);
        categoryProduct.shouldHave(Condition.text(AdInfo.categoryProduct));
        nameProduct.shouldHave(Condition.text(AdInfo.nameProduct));
    }

    public void setBrand(String brand) {
        editText(brandProduct, brand);
        AdInfo.brand = brand;
    }

    public void setManufacture(String manufacture) {
        editText(manufactureProduct, manufacture);
        AdInfo.manufacturer = manufacture;
    }

    public void setCountryOrigin(String countryOrigin) {
        click(countryOriginProduct);
        editText($(By.xpath("//input[@placeholder=\"Найти\"]")), countryOrigin);
        $(".display").shouldHave(Condition.text(countryOrigin)).click();
        AdInfo.countryOrigin = countryOrigin;
    }

    public void setShelfLife(String year, String month, String day) {
        $(".ui-input-date").shouldBe(Condition.visible).click();
        setDate(year, month, day);
        AdInfo.shelfLife = year + " " + month + " " + day;
    }

    public void setWarranty(String numb, String unit) {
        editText(warrantyProduct, numb);
        click(warrantyUnitProduct);
        $(By.xpath("//div[@class='items']//div[text()='" + unit + "']")).shouldBe(Condition.visible).click();
        AdInfo.warranty = numb;
        AdInfo.warrantyUnit = unit;
    }

    public void setProductionYear(String year) {
        editText(productionYearProduct, year);
        AdInfo.productionYear = year;
    }

    public void setDescription(String description) {
        editText(descriptionProduct, description);
        AdInfo.description = description;
    }

    public void setLicence(String licence) {
        click(licenceProduct);
        $(By.xpath("//div[@class='content']//div[text()='" + licence + "']")).shouldBe(Condition.visible).click();
        AdInfo.license = licence;
    }

    public void setDeliveryTime(String days, String unit) {
        editText(deliveryTimeProduct, days);
        click(deliveryUnitProduct);
        $(By.xpath("//div[@class='content']//div[text()='" + unit + "']")).shouldBe(Condition.visible).click();
        AdInfo.deliveryTime = days;
        AdInfo.deliveryUnit = unit;
    }

//    public void setBargainingTerm(String term, String unit) {
//        editText(bargainingTerm, term);
//        click(bargainingTermUnit);
//        $(By.xpath("//div[@class='content']//div[text()='" + unit + "']")).shouldBe(Condition.visible).click();
//        AdInfo.bargainTerm = term;
//        AdInfo.bargainTermUnit = unit;
//    }


    public void setPrice(String price) {
        editText(priceProduct, price);
        priceUnitProduct.shouldHave(Condition.text("Узбекский сум"));
        AdInfo.price = price;
    }

    public void setQuantityInStock(String count) {
        editText(quantityInStock, count);
        AdInfo.quantityInStock = count;
    }

    public void setMinAmountProduct(String count) {
        editText(minAmountProduct, count);
        AdInfo.minAmount = count;
    }

    public void setMaxAmountProduct(String count) {
        editText(maxAmountProduct, count);
        AdInfo.maxAmount = count;
    }

    public void setUnitMeasurement(String measurement) {
        unitMeasurementProduct.click();
        $(By.xpath("//div[@class='items']//div[text()='" + measurement + "']")).shouldBe(Condition.visible).click();
        AdInfo.unitMeasurement = measurement;
    }

    public void setDeliveryRegion(String regions) {
        String[] regionList = regions.split(",");
        click(deliveryRegion);
        for (String region : regionList) {
            //$(By.xpath("//div[@class='display'][text()='" + region + "']")).click();
            click($(By.xpath("//div[@class='display'][text()='" + region + "']")));
        }

        if ($(".entity-dropdown").isDisplayed()) {
            $(By.xpath("//div[@class='display'][text()='" + regionList[regionList.length - 1] + "']")).hover();
            $(By.xpath("//div[@class='display'][text()='" + regionList[regionList.length - 1] + "']")).parent().$(".select").click();
        }

    }

    public void uploadPhoto() {
        uploadPhoto.uploadFile(new File("src/test/resources/pictures/for_test.png"));
        //$(".file").shouldBe(Condition.visible);
        $(".file").waitUntil(Condition.visible, 3000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void sendToModerate() {
        click(btnSendToModerate);
        $(".iac-dialog_modal_box-content").waitUntil(Condition.visible, 5000);
        ignoreEImzo();
    }

    private void setDate(String year, String month, String day) {
        while (!$(".year").getText().equals(year)) {
            $(By.xpath("//div[@class='year']//span"), 2).shouldBe(Condition.visible).click();
        }

        while (!$(".month").getText().equals(month)) {
            $(By.xpath("//div[@class='month']//span"), 2).shouldBe(Condition.visible).click();
        }

        $(By.xpath("//div[@class='days']//span[text()=" + day + "]")).shouldBe(Condition.visible).click();

    }
}
