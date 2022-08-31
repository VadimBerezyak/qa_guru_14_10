package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LablsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Link(value = "Testing", url = "https://github.com")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("eroshenkoam")
    @Story("Создание Issue")
    @Feature("Issue в репозитории")
    public void testLambaSteps() {

    }

    @Test
    public void testAnnotatedStep() {


    }


}
