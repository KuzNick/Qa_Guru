package wb.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class wbCardPage {
    public static final SelenideElement articleOnPageArticle = $("#productNmId");
    public static final SelenideElement titleOnPageArticle =  $(".product-page__title");


    public wbCardPage chekArcticleOnPageArticle(String article){
        articleOnPageArticle.shouldHave(text(article));
        return this;
    };

    public wbCardPage chekTitleOnPageArticle(String title){
        titleOnPageArticle.shouldHave(text(title));
        return this;
    };
}
