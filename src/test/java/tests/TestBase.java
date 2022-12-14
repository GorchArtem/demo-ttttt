package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class TestBase extends Attach {

    static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = credentialsConfig.baseUrl();
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("version", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.holdBrowserOpen = true;
        String remoteDriverUrl = System.getProperty("remoteDriverUrl","selenoid.autotests.cloud/wd/hub");
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.remote = String.format("https://%s:%s@%s", credentialsConfig.login(), credentialsConfig.password(), remoteDriverUrl);

    }

    @AfterEach
    void addAttach() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }
}
