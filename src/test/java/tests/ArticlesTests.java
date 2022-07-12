package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static com.codeborne.selenide.Selenide.*;

@Tag("android")
@DisplayName("Проверка статей")
public class ArticlesTests extends TestBase {
    DateFormat df = new SimpleDateFormat("MMMMM d", Locale.ENGLISH);
    String requiredDate = df.format(new Date());

    @Test
    @AllureId("10922")
    @DisplayName("Дата избранной статьи, на главной поисковой странице, соответствует актуальной дате")
    void selectedArticleTodayTest() {
        back();
        $(AppiumBy.id("org.wikipedia.alpha:id/day_header_text"))
                .shouldHave(Condition.text(requiredDate));
    }

    @Disabled("Баг: Нет кнопки сегодняшних статей (33432)")
    @Test
    @AllureId("10923")
    @DisplayName("Кнопка сегодняшних статей открывает страницу свежих статей")
    void TodayOnWikipediaArticlesTest() {
        back();
        $(AppiumBy.id("org.wikipedia.alpha:id/footerActionButton")).
                $(AppiumBy.id("mp-tfa-h2")).shouldHave(Condition.text("From today's featured article"));
    }
}
