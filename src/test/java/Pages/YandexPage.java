package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexPage {



    private final SelenideElement
            searchField =  $("#text"),
            resultsOnPage = $(".main__center");


    //actions
    public void openURL(String value) {
        open(value);
    }

    public void fillSearchField(String value) {
        searchField.setValue(value).pressEnter();
    }

    //assertions
    public void assertThatValuesIsTrue(String value) {
        resultsOnPage.shouldHave(text(value));
    }

}
