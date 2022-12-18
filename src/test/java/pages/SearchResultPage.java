package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    @Step("Verify Search Result")
    public SearchResultPage checkSearchResult(String item, int number) {
        $(".content #keyword").shouldHave(value(item));
        Assertions.assertTrue(Integer.valueOf($(".search_result_menu__count").getText()) > number);
        return this;
    }
}
