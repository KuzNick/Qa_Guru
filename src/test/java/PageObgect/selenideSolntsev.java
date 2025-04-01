package PageObgect;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class selenideSolntsev {
    public static final SelenideElement liOfContributors = $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row").$$("ul li").first();
    public static final ElementsCollection topOfContributors = $$(".Popover .Popover-message");

    public void hoverLiOfContributors () {
        liOfContributors.shouldBe(visible).hover();
    }


    public void checkBestContributor (String contributor) {
        topOfContributors.findBy(visible).shouldHave(text(contributor));
    }

}
