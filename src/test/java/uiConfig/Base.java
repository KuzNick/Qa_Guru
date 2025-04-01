package uiConfig;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class Base {
    @BeforeAll
    public static void setConf() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 50000;
        Configuration.timeout = 50000;
        Configuration.screenshots = false;
        Configuration.savePageSource =false;
    }

    @AfterEach
    public void clearData() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
