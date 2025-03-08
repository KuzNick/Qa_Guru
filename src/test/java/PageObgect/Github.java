package PageObgect;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import uiConfig.Credentials;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Github {
    public static final SelenideElement openSearchInput = $("[data-target='qbsearch-input.inputButton']");
    public static final SelenideElement searchInput = $(By.id("query-builder-test"));
    public static final SelenideElement firstRepo = $("div[data-testid='results-list'] a");
    public static final SelenideElement item = $("#repository-container-header");

    public void openSearch(){
        openSearchInput.shouldBe(visible).click();
    }

    public void searchSomeText(String someText){
        searchInput.shouldBe(visible).setValue(someText).pressEnter();
    }

    public void firstRepoClick(){
        firstRepo.shouldBe(visible).click();
    }

    public void checkItem() {
        item.shouldHave(text("selenide / selenide"));
    }
}
