package tests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.MainPage;
import pages.SearchResultPage;
import pages.VideoPage;
import tests.TestBase;

import java.util.stream.Stream;

public class TheFlowTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    VideoPage videoPage = new VideoPage();

    @ValueSource(strings = {"Новости", "Тексты", "Альбомы", "Клипы"})
    @ParameterizedTest(name = "Проверка главного меню {0}")
    void verifyMainMenuTest(String items) {
        mainPage.verifyMainMenu(items);
    }

    @CsvSource({
            "Oxxxymiron, 300",
            "ATL, 100",
            "Noize, 200"
    })
    @ParameterizedTest(name = "Проверка что поиск по значению {0} выдает более {1} результатов")
    void searchTest(String item, int number) {
        mainPage.searchText(item);
        searchResultPage.checkSearchResult(item, number);
    }

    static Stream<Arguments> checkVideoTest() {
        return Stream.of(
                Arguments.of("kendrick-lamar-count-me-out","Kendrick Lamar \"Count Me Out\": рэп как сеанс психотерапии"),
                Arguments.of("asap-rocky-shittin-me","A$AP Rocky выпустил клип \"Shittin' Me\"")
                );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия видео {1} по ссылке {0}")
    void checkVideoTest(String videoURL, String title) {
        mainPage.openVideo(videoURL);
        videoPage.checkVideoContent(title);

    }
}
