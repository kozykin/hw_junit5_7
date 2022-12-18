package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VideoPage {
    @Step("Check Video Content")
    public VideoPage checkVideoContent(String title) {
        $(".article__title").shouldHave(text(title));
        return this;
    }
}

