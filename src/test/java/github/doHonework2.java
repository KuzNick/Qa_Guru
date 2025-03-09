package github;

import PageObgect.Homework2;
import org.junit.jupiter.api.Test;
import uiConfig.Base;
import uiConfig.Credentials;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class doHonework2 extends Base {
    @Test
    void findJunitInExemples() {
        open(Credentials.SOLNTSEV_PAGE);
        Homework2 work2 = new Homework2();
        work2.checkItem();
        work2.clickWiki();
        work2.clickpageSoftAssertions();
        work2.checkExampleJunit5();
        //sleep(50_000);
    }

}
