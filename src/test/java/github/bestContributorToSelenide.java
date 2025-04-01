package github;

import PageObgect.selenideSolntsev;
import com.codeborne.selenide.Config;
import org.junit.jupiter.api.Test;
import uiConfig.Base;
import uiConfig.Credentials;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class bestContributorToSelenide extends Base {

    @Test
    void solntsevShouldBeTheTopContributor () {
        open(Credentials.SOLNTSEV_PAGE);
        selenideSolntsev solntsev = new selenideSolntsev();
        solntsev.hoverLiOfContributors();
        solntsev.checkBestContributor(Credentials.SOLNTSEV);
    }
}
