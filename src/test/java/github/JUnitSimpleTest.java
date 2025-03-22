
package github;

import com.codeborne.selenide.CollectionCondition;
import github.data.Locale;
import net.bytebuddy.description.annotation.AnnotationDescription;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitSimpleTest {
    @BeforeEach
    void setup() {
        open("https://ya.ru");
    }

    // Тестовые данные берутся прямо из аннотации
    @CsvSource({
            "Allure testops, qameta.io",
            "Selenide, selenide.org"
    })

    // Тестовые данные из файла
    @CsvFileSource(resources =  "/testData.csv")
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче по запросу {0}")
    @DisplayName("Типа тест")
    @Tags({@Tag("Blocker"), @Tag("UI_Test")})
    void simpleTest(
            String productName,
            String productUrl
    ) {
        $(".search3__input").setValue(productName).pressEnter();
        //$("[aria-label='Нет, спасибо']").click();
        $("#search-result").shouldHave(text(productUrl));
    }

    // Передаём по 1му параметру
    @ValueSource(
            strings = {"Allure testops", "Selenide"}
    )
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче по запросу {0}")
    @DisplayName("Типа тест")
    @Tags({@Tag("Blocker"), @Tag("UI_Test")})
    void simpleTest2( String productName) {
        $(".search3__input").setValue(productName).pressEnter();
        $$("#search-result").shouldHave(CollectionCondition.sizeGreaterThan(5));
    }
}
