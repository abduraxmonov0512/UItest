import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/test/resources/features",
        publish = true,
        glue = {"steps","helpers"},
        tags = "@new"
        )
public class RunCucumberTest {


    @BeforeClass
    public static void configuration(){
      //  Configuration.headless = true;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200,1100");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
       // Configuration.startMaximized = true;
    }
}