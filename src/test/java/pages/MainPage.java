package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

public class MainPage {

    private ElementsCollection mainMenu = $$(".mmenu li" );

    @Step("Verify Main Menu")
    public MainPage verifyMainMenu(String item) {
        $(".header_menu").$(byText(item)).click();
        $(".article").shouldHave(text(item));
    return this;
    }

    @Step("Search text")
    public MainPage searchText(String item) {
        $("#keyword").setValue(item).pressEnter();
        return this;
    }

    @Step("Open video")
    public MainPage openVideo(String videoURL) {
        open("/videos/" + videoURL);
        return this;
    }


}
