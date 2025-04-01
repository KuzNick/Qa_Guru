package github;

import PageObgect.Homework3;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import uiConfig.Base;
import uiConfig.Credentials;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class doHonework3 extends Base {

    @Test
    void checkTextOnEnterprisePage() {
        open("/");
        Homework3 work3 = new Homework3();
        work3.hoverNavMenusolutions();
        work3.clickEnterpisesElemOfSolutions();
        work3.checkH1TextOnPageEnterprise(Credentials.H1_PAGE_ENTERPRISE);
        //sleep(50_000);
    }

    @Test
    void actions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Подвинуть курсор к элементу, кликнуть и держать, передвинуть по X и Y, отпустить кнопку мыши
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(Selenide.$("#column-a")).clickAndHold().moveByOffset(150,0).release().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
        //sleep(50_000);
    }

    /*
    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Берем и переносим квадрат(div) А на квадрат(div) B
        $("#column-a").dragAndDropTo($("#column-b"));
        // option 2: actions().moveToElement($(byText("A"))).clickAndHold().moveByOffset(250, 0).release().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
        sleep(50_000);
    }
    */
}
