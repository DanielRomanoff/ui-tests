package tests.google;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.duckduck.DuckDuckPage;
import pages.google.GooglePage;
import tests.BaseTest;

@Test(groups = {"UI", "Google"})
@Owner(value = "Романов Даниил")
@Epic("Практика")
@Feature("Поисковики")
@Story("Проверка работы поисковых систем")
public class GoogleTestFailure extends BaseTest {
    GooglePage google = new GooglePage(this);
    DuckDuckPage duckduck = new DuckDuckPage(this);

    @Test(description = "Проверка отображения заявок согласно календарю")
    public void testSearch() {
        openBrowser("https://google.com");
        googleSearch("duckduckgo");
        openDuckDuckGo("DuckDuckGo");
        duckduckGoSearch("Да здравствует приватность!");
    }

    @Step("Ищу в Google - \"{0}\" ")
    private void googleSearch(String query) {
        google.search(query);
    }

    @Step("Открываю ссылку с текстом - \"{0}\"")
    private void openDuckDuckGo(String ref) {
        google.openPageWithText(ref);
    }

    @Step("Ищу в DuckDuckGo - \"{0}\" ")
    private void duckduckGoSearch(String query) {
        duckduck.search(query);
        duckduck.results.shouldBe(Condition.checked);
    }
}

