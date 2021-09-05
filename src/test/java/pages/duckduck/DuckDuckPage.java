package pages.duckduck;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class DuckDuckPage extends BasePage {
    public SelenideElement results = $(".results--main");

    public DuckDuckPage(BaseTest test) {
        super(test);
    }

    public void search(String query) {
        $("#search_form_input_homepage")
                .setValue(query)
                .pressEnter();
    }
}
