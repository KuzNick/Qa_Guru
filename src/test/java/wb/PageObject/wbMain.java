package wb.PageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class wbMain {

    public wbMain openMain(){
        open("/");
        return this;
    }

    public wbMain inputArticleInSearch(String article){
        $("#searchInput").shouldBe(visible).setValue(article).pressEnter();
        return this;
    }

}
