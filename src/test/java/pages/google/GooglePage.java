package pages.google;

import pages.BasePage;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage extends BasePage {
    public GooglePage(BaseTest test) {
        super(test);
    }

    public void search(String query) {
        $(".gLFyf")
                .setValue(query)
                .pressEnter();
    }

    public void openPageWithText(String text) {
        $x(".//h3[contains(text(), " + text + ")]")
                .click();
    }
}
