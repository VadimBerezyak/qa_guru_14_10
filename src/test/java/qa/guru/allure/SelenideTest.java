package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Link(value = "Testing", url = "https://github.com")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("eroshenkoam")
    @Story("Создание Issue")
    @Feature("Issue в репозитории")
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example");
        $(".header-search-input").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_80_link").shouldHave(Condition.text("e.sh"));
    }


}
