package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import tests.pages.MainPage;
import java.util.List;
import java.util.stream.Stream;

@Owner("yuliaorlova")
@Feature("UI тесты")
@DisplayName("UI тесты для сайта Pobeda.aero")
public class PobedaSiteTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Проверка перехода в разделы сайта.")
    @ValueSource(strings = {"Ручная кладь", "Багаж", "Выбор места", "Страхование"})
    @ParameterizedTest(name = "Выполняется переход в раздел \"{0}\"")
    void sitePobedaPageTest(String testData) {

        mainPage.openMainPage();
        mainPage.goToPage(testData);
        mainPage.checkPageTitle(testData);
    }


    static Stream<Arguments> pobedaSiteMenuTest() {
        return Stream.of(
                Arguments.of("English", List.of("Hand baggage", "Baggage", "Seats", "Insurance", "Hotels", "Auto", "Transfer", "Excursions")),
                Arguments.of("Русский", List.of("Ручная кладь", "Багаж", "Выбор места", "Страхование", "Отели", "Авто", "Трансфер", "Экскурсии"))
        );
    }

    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Проверка наличия разделов сайта.")
    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаются разделы {1}")
    void pobedaSiteMenuTest(String lang, List<String> expectedTitle) {

        mainPage.openMainPage();
        mainPage.choiceLanguages(lang);
        mainPage.checkPageContent(lang, expectedTitle);
    }


    static Stream<Arguments> sitePobedaMenuEnumTest() {
        return Stream.of(
                Arguments.of(Lang.ENGLISH, List.of("Online check-in", "Manage my booking", "Info/Rules")),
                Arguments.of(Lang.РУССКИЙ, List.of("Забронировать билет", "Управление бронированием", "Онлайн-регистрация", "Информация"))
        );
    }

    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Проверка наличия кнопок меню сайта.")
    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки меню {1}")
    void sitePobedaMenuEnumTest(Lang lang, List<String> expectedButtons) {

        mainPage.openMainPage();
        mainPage.choiceLanguage(lang);
        mainPage.checkButtonExist(expectedButtons);
    }


    @CsvSource(value = {
            "вылет, Онлайн-табло",
            "возврат, Возврат и обмен авиабилетов",
            "выбор места, Выбор места",
            "способ оплаты, Способы оплаты"
    })

    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Проверка работы поиска.")
    @ParameterizedTest(name = "Результаты поиска содержат текст \"{1}\" для запроса \"{0}\"")
    void sitePobedaSearchTest(String testData, String expectedResult) {

        mainPage.openMainPage();
        mainPage.searchInput(testData);
        mainPage.checkSearchResult(expectedResult);
    }


    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Проверка нотификации обязательности заполнение поля ввода Email для подписки.")
    @EnumSource(Lang.class)
    @ParameterizedTest(name = "Для локали {0} проверяется заполнение Email")
    void pobedaSiteEmailTest(Lang lang) {

        mainPage.openMainPage();
        mainPage.choiceLanguage(lang);
        mainPage.checkEmailEnter();
    }
}
