package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

@Tag("android")
public class SearchTests extends TestBase{

    String searchWord = System.getProperty("searchWord","Dota 2");

    @Test
    @DisplayName("Проверка заголовка статьи, что он соответствует запросу поиска")
    void checkingArticleTitle(){
        back();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchWord);
        $$(AppiumBy.className("android.widget.TextView"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text='"+searchWord+"']"))
                .shouldHave(Condition.text(searchWord));
    }

}
