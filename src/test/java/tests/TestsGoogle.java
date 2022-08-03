package tests;

import Pages.GooglePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class TestsGoogle {
    static GooglePage googlePage = new GooglePage();


    @Test
    @Tag("googleTest")
    @Owner("GorchArtem")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Сборка в Jenkins")
    @Story("Создание новой сборки в Jenkins")
    @Link(name = "Demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Fill out the registration form")
    void searchTest() {
        String value = "Геральт из Ривии";

        step("Открыть страницу в гугл", () -> {
            googlePage.openURL("https://www.google.com/");
        });
        step("Ввести значение для поиска", () -> {
            googlePage.fillSearchField(value);
        });
        step("Проверить выдачу результата", () -> {
            googlePage.assertThatValuesIsTrue(value);
        });

    }
}
