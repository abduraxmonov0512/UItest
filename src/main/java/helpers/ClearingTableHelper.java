package helpers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ClearingTableHelper {

    private List<SelenideElement> listBillings = $$(By.xpath("//tbody//tr"));

    private SelenideElement raw1 = listBillings.get(0);
    private SelenideElement raw2 = listBillings.get(1);
    private SelenideElement raw3 = listBillings.get(2);
    private SelenideElement raw4 = listBillings.get(3);

    private List<SelenideElement> raws;

    public ClearingTableHelper(){
        raws = Arrays.asList(raw1, raw2, raw3, raw4);
    }


    public SelenideElement getRawWithText(String text){
        for(SelenideElement element  : raws){
            System.out.println(element.getText());
            if(element.getText().contains(text)){
                return element;
            }
        }
        return  null;
    }

}
