package github;

import PageObgect.Github;
import org.junit.jupiter.api.Test;
import uiConfig.Base;
import uiConfig.Credentials;

import static com.codeborne.selenide.Selenide.*;

public class repositorySearch extends Base {

    @Test
    void shouldFindSelenideRepositorySearch() {
        open("/");
        Github Github = new Github();
        Github.openSearch();
        Github.searchSomeText(Credentials.INPUT_TEXT);
        Github.firstRepoClick();
        Github.checkItem();
        //sleep(50000);
    }
}
