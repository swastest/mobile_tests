package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class GettingStartedOnboardingScreenTest extends TestBase {

    @Test
    @AllureId("10925")
    @DisplayName("Позитивная проверка онбординга")
    void SearchPositiveTest() {
        step("Открыть первую страницу онбординга, проверить контент", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The Free Encyclopedia …in over 300 languages")));

        step("Перейти на вторую страницу", () ->
                $(AppiumBy.xpath("//android.widget.LinearLayout[2]")).click());

        step("Проверка контента на второй странице", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
                $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. " +
                            "Customize the feed to your interests – whether it’s learning about historical events On this day, " +
                            "or rolling the dice with Random."));
        });

        step("Перейти на третью страницу онбординга", () ->
                $(AppiumBy.xpath("//android.widget.LinearLayout[3]")).click());

        step("Проверка контента на третей странице", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
                $(AppiumBy.xpath("//android.widget.LinearLayout[4]")).click();
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }
}
