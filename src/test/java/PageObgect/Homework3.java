package PageObgect;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Homework3 {
    public static final SelenideElement navMenusolutions = $(".HeaderMenu-nav").$(byText("Solutions"));
    public static final SelenideElement enterpisesElemOfSolutions = $(".list-style-none").$(byText("Enterprises"));
    public static final SelenideElement h1OfPageEnterprise = $("#hero-section-brand-heading");

    public void hoverNavMenusolutions(){
        navMenusolutions.shouldBe(visible).hover();
    }

    public void clickEnterpisesElemOfSolutions(){
        enterpisesElemOfSolutions.shouldBe(visible).click();
    }

    public void checkH1TextOnPageEnterprise(String h1Text){
        h1OfPageEnterprise.shouldBe(visible).shouldHave(text(h1Text));
    }
}
