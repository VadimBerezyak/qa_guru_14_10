package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueLambdaTest {
    public static final String REPO = "eroshenkoam/allure-example";
    public static final String ISSUE = "e.sh";

    @Test
    @DisplayName("Check issue by lambda")
    @Owner("Vadim")
    @Story("Issue is available")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    public void checkIssueTest() {


        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {

            open("https://github.com");
        });
        step("Search repository" + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("Click by link of repository -" + REPO, () -> {
            $(linkText(REPO)).click();
        });
        step("Click by issue", () -> {
            $("#issues-tab").click();
        });
        step("Check that issues's name is" + ISSUE, () -> {
            $("#issue_80_link").shouldHave(Condition.text(ISSUE));
        });


    }

}

