package tests;

import Pages.GooglePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class TestsGoogle extends TestBase{
    static GooglePage googlePage = new GooglePage();


    @Test
    @Tag("googleTest")
    @Owner("GorchArtem")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Сборка в Jenkins")
    @Story("Создание новой сборки в Jenkins")
    @DisplayName("Fill out the registration form")
    void searchTest() throws InterruptedException {
        String value = "Геральт из Ривии";

        step("Открыть страницу в гугл", () -> {
            googlePage.openURL("https://www.google.com/");
        });
        Thread.sleep(10000);//убрать после дебага
        step("Ввести значение для поиска", () -> {
            googlePage.fillSearchField(value);
        });
        step("Проверить выдачу результата", () -> {
            googlePage.assertThatValuesIsTrue(value);
        });

    }
}
