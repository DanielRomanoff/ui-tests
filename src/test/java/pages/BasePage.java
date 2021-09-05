package pages;

import com.codeborne.selenide.SelenideElement;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected BaseTest test;

    public BasePage(BaseTest test) {
        this.test = test;
    }

    public SelenideElement body() {
        return $("body").as("тело страницы");
    }
}