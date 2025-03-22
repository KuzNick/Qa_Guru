package github;

import com.codeborne.selenide.CollectionCondition;
import github.data.Locale;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class JUnitSimpleTestLocale {

    //Если название совпадает с названием метода теста
    static Stream<Arguments> selenideSiteShouldContainAllOfButtonsForGivenLocale(){
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    //Название совпадает с методом статического стрима выше
    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    @Tag("BLOCKER")
    void selenideSiteShouldContainAllOfButtonsForGivenLocale(
            Locale locale,
            List<String> buttons
    ){
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(texts(buttons));
    }

    /**
    ** Если название НЕ совпадает с названием метода теста
    **/

    static Stream<Arguments> selenideLocalDataProvider(){
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    //Название НЕ совпадает с методом статического стрима выше
    @MethodSource("selenideLocalDataProvider") // Вписываем сюда название метода со стримом аргументов
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    @Tag("BLOCKER")
    void selenideSiteShouldContainAllOfButtonsForGivenLocale2(
            Locale locale,
            List<String> buttons
    ){
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(texts(buttons));
    }
}
