package wb.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import wb.PageObject.wbCardPage;
import wb.PageObject.wbMain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseWB {
    wbMain wbMain = new wbMain();
    wbCardPage wbCardPage = new wbCardPage();

    @BeforeAll
    public static void setConf() {
        Configuration.baseUrl = "https://www.wildberries.ru";
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
