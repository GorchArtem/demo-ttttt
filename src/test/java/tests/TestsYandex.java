package tests;

import Pages.YandexPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestsYandex extends TestBase{
    static YandexPage yandexPage = new YandexPage();


    @Test
    @Tag("yandexTest")
    @Owner("GorchArtem")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Сборка в Jenkins")
    @Story("Создание новой сборки в Jenkins")
    @DisplayName("Fill out the registration form")
    void searchTest() throws InterruptedException {
        String value = "Геральт из Ривии";

        step("Открыть страницу в яндекс", () -> {
            yandexPage.openURL("https://yandex.ru/");
        });
        step("Ввести значение для поиска", () -> {
            yandexPage.fillSearchField(value);
        });
        step("Проверить выдачу результата", () -> {
            yandexPage.assertThatValuesIsTrue(value);
        });

    }
}
