package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utilities.LogUIListener;

import static com.codeborne.selenide.Selenide.open;

@Listeners({LogUIListener.class})
public abstract class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        //Раскомментируй для запуска тестов в докер контейнере
        //Configuration.remote = "http://localhost:4444/wd/hub";
        //Configuration.browser = "firefox";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.screenshots = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Step("Открываю - {0}")
    public void openBrowser(String ref) {
        open(ref);
    }
}