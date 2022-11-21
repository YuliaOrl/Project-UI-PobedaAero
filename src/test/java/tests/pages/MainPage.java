package tests.pages;

import com.codeborne.selenide.CollectionCondition;
import tests.Lang;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {

    public MainPage openMainPage() {
        step("Открытие главной страницы сайта \"Победа\"", () ->
                open(""));
        return this;
    }

    public MainPage goToPage(String testData) {
        step(String.format("Переход на страницу раздела \"%s\"", testData), () ->
                $$(".offer_title").find(text(testData)).click());
        return this;
    }

    public MainPage checkPageTitle(String testData) {
        step(String.format("Проверка заголовка на странице раздела \"%s\"", testData), () ->
                $(".title-inner").shouldHave(text(testData)));
        return this;
    }

    public MainPage choiceLanguages(String lang) {
        step(String.format("Выбор языка \"%s\"", lang), () -> {
            $("#idLanguageSelector").pressEnter();
            $$(".ui-dropdown_item_option_name").find(text(lang)).click();
        });
        return this;
    }

    public MainPage choiceLanguage(Lang lang) {
        step(String.format("Выбор языка \"%s\"", lang), () -> {
            $("#idLanguageSelector").pressEnter();
            $$(".ui-dropdown_item_option_name").find(text(lang.name())).click();
        });
        return this;
    }

    public MainPage checkPageContent(String lang, List<String> expectedTitle) {
        step(String.format("Проверка отображения разделов %s", expectedTitle), () ->
                $$(".offer_title").filter(visible).shouldHave(CollectionCondition.texts(expectedTitle)));
        return this;
    }

    public MainPage checkButtonExist(List<String> expectedButtons) {
        step(String.format("Проверка отображения кнопок меню %s", expectedButtons), () ->
                $$(".button_label").filter(visible).shouldHave(CollectionCondition.texts(expectedButtons)));
        return this;
    }

    public MainPage searchInput(String testData) {
        step(String.format("Ввод поискового запроса \"%s\"", testData), () -> {
            $(".web-search_trigger_button").click();
            $("#webSearchId").setValue(testData).pressEnter();
        });
        return this;
    }

    public MainPage checkSearchResult(String expectedResult) {
        step(String.format("Проверка, что результат поиска содержит ответ \"%s\"", expectedResult), () ->
                $$("li.searchresults_list_item").first().shouldHave(text(expectedResult)));
        return this;
    }

    public MainPage checkEmailEnter() {
        step("Проверка сообщения обязательности заполнения Email", () -> {
            $(".newsletter_form_button").click();
            $(".newsletter_feedback_message").shouldBe(visible);
        });
        return this;
    }
}
