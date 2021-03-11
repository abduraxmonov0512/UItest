package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public class Hooks {

    private SelenideElement languageDropDown = $(By.xpath("//icon[@class='iac-language__icon']"));
    private SelenideElement languageRu = $(By.xpath("//button[@class=\"button-inherit item\"]"));
    private SelenideElement language = $(".iac-language__title");

    @Before
    public void openUrl(){
        open("https://demo.xt-xarid.uz/");
        Selenide.localStorage().setItem("access_debug", "true");
        if(language.getText().equals("UZ")){

            languageDropDown.click();
            languageRu.click();
        }
    }

    public static ChromeOptions chromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", "true");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-canvas-aa");
        chromeOptions.addArguments("--disable-2d-canvas-clip-aa");
        // Это опция ломает бравзер
//        chromeOptions.addArguments("--disable-gl-drawing-for-tests");
        chromeOptions.addArguments("--no-zygote");
        chromeOptions.addArguments("--use-gl=swiftshader");
        chromeOptions.addArguments("--enable-webgl");
        chromeOptions.addArguments("--hide-scrollbars");
        chromeOptions.addArguments("--mute-audio");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--disable-breakpad");
        chromeOptions.addArguments("--disable-setuid-sandbox");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--proxy-server='direct://'");
        chromeOptions.addArguments("--proxy-bypass-list=*");
        chromeOptions.addArguments("--window-size=1900, 920");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chromeOptions;
    }
}
