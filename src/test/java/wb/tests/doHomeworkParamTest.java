package wb.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import github.data.Locale;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class doHomeworkParamTest extends BaseWB {

    @CsvSource({
        "206775008",
        "143657307"
    })
    @ParameterizedTest(name = "При вводе в поиск артикула {0} открывается карточка с артикулом {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI")})
    @DisplayName("Параметризованный тест @CsvSource с 1 параметром")
    void checkArticleInCard(String article) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        wbMain.openMain().inputArticleInSearch(article);
        wbCardPage.chekArcticleOnPageArticle(article);
    }


    @CsvSource({
            "206775008, Блузка нарядная с открытыми плечами",
            "143657307, Брюки бананы укороченные на резинке трикотажные"
    })
    @ParameterizedTest(name = "При вводе в поиск артикула {0} открывается карточка с названием {1}")
    @Tags({@Tag("BLOCKER"), @Tag("UI")})
    @DisplayName("Параметризованный тест @CsvSource с 2мя параметрами")
    void checkArticleInCard2(String article, String title) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        wbMain.openMain().inputArticleInSearch(article);
        wbCardPage.chekTitleOnPageArticle(title);
    }


    @ValueSource(
            strings = {"206775008","143657307"}
    )
    @ParameterizedTest(name = "При вводе в поиск артикула {0} открывается карточка с артикулом {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI")})
    @DisplayName("Параметризованный тест @ValueSource с 1м параметром")
    void checkArticleInCard3(String article) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        wbMain.openMain().inputArticleInSearch(article);
        wbCardPage.chekArcticleOnPageArticle(article);
    }


    @CsvFileSource( resources = "/wbData.csv")
    @ParameterizedTest(name = "При вводе в поиск артикула {0} открывается карточка с названием {1}")
    @Tags({@Tag("BLOCKER"), @Tag("UI")})
    @DisplayName("Параметризованный тест @CsvFileSource с 2мя параметрами")
    void checkArticleInCard4(String article, String title) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        wbMain.openMain().inputArticleInSearch(article);
        wbCardPage.chekTitleOnPageArticle(title);
    }

    @Disabled
    @CsvSource("SQL")
    @ParameterizedTest
    void checkArticleInCard4(String category) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://stepik.org/catalog");
        $(".search-form__input ").shouldBe(visible).setValue(category);
        $(".menu-burger__main-list li").$(byText(category)).click();
        //sleep(50_000);
        //wbCardPage.chekTitleOnPageArticle(subCategory);
    }

    static Stream<Arguments> checkValet(){
        return Stream.of(
                Arguments.of("BYNЕ", "Белорусский рубль"),
                Arguments.of("KZT", "Казахстанский тенге"),
                Arguments.of("AMD", "Армянский драм"),
                Arguments.of("KGS", "Кыргызский сом"),
                Arguments.of("UZS", "Узбекский сум")
        );
    }

    //Название совпадает с методом статического стрима выше
    @MethodSource
    @DisplayName("Проверка локали и валюты")
    @ParameterizedTest(name = "При выборе локали {0} отображается валюта {1}")
    @Tag("BLOCKER")
    void checkValet(
            String value,
            String description
    ){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.wildberries.ru/");
        $(".simple-menu__currency").shouldBe(visible).hover();
        $(".country__wrap").$(byText(value)).ancestor(".radio-with-text__text").shouldHave(text(description));
    }

    static Stream<Arguments> checkSubcategory(){
        return Stream.of(
                Arguments.of("Женщинам", List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of("KZT", "Казахстанский тенге"),
                Arguments.of("AMD", "Армянский драм"),
                Arguments.of("KGS", "Кыргызский сом"),
                Arguments.of("UZS", "Узбекский сум")
        );
    }

    //Название совпадает с методом статического стрима выше
    @Disabled
    @MethodSource("checkSubcategory")
    @ParameterizedTest(name = "При выборе локали {0} отображается валюта {1}")
    @Tag("BLOCKER")
    void checkSubcategoryInCategory(
            String value,
            String description
    ){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.wildberries.ru/");
        $("data-wba-header-name=Catalog").shouldBe(visible).click();
        $(".menu-burger__main-list").$(byText(value)).click();
        $(".country__wrap").$(byText(value)).ancestor(".radio-with-text__text").shouldHave(text(description));
    }
}
