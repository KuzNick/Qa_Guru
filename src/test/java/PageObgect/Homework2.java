package PageObgect;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import uiConfig.Credentials;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Homework2 {
    public static final SelenideElement item = $("#repository-container-header");
    public static final SelenideElement linkWiki = $("#wiki-tab");
    public static final SelenideElement pageSoftAssertions = $("#wiki-body").$(byText("Soft assertions"));
    public static final SelenideElement exampleJunit5 = $("#wiki-body");
    //public static final SelenideElement exampleJunit5 = $("#wiki-body").$(byText("JUnit5"));

    public void checkItem() {
        item.shouldHave(text("selenide / selenide"));
    }

    public void clickWiki() {
        linkWiki.shouldBe(visible).click();
    }

    public void clickpageSoftAssertions() {
        pageSoftAssertions.shouldBe(visible).click();
    }

    public void checkExampleJunit5() {
        exampleJunit5.shouldHave(partialText(Credentials.Junit5));
    }

}
