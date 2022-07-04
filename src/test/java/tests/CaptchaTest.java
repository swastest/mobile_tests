package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class CaptchaTest extends TestBase {

    @Test
    @AllureId("10924")
    @DisplayName("Проверка капчи при регистрации")
    void captchaTestAtRegistration() {
        back();
        step("Перейти к форме регистрации", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Edits']")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/positiveButton")).click();
        });

        step("Убедиться, что открылась форма Регистрации", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Create an account']"))
                    .shouldHave(text("Create an account"));
        });

        step("Заполнить форму Регистрации", () -> {
            $(AppiumBy.xpath("//android.widget.EditText[@text='Username']"))
                    .sendKeys("QaGuruHello");

            $(AppiumBy.xpath("//android.widget.EditText[@text='Password']"))
                    .sendKeys("12345678");

            $(AppiumBy.xpath("//android.widget.EditText[@text='Repeat password']"))
                    .sendKeys("12345678");

            $(AppiumBy.xpath("//android.widget.EditText[@text='Email (Optional)']"))
                    .sendKeys("qaGurur123@google.com");
        });

        step("Нажать на кнопку 'Next'", () -> {
            $(AppiumBy.xpath("//android.widget.Button[@text='NEXT']")).click();
        });

        step("Проверка, что капча и ее отрибуты отображаются корректно", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/request_account_text"))
                    .shouldHave(text("Can't see the image? Request an account"));
            $(AppiumBy.id("org.wikipedia.alpha:id/captcha_image"))
                    .shouldBe(Condition.visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/captcha_submit_button"))
                    .shouldBe(Condition.visible);
        });
    }
}
