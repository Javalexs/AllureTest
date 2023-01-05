import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "� ����� ����� (2022)";
    @Test
    public void testLambdaTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("��������� ������� ��������", () -> {
            open("https://github.com/");
        });

        step("���� ����������� " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });

        step("������� �� ������ ����������� " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("��������� ��� Issues", () -> {
            $("#issues-tab").click();
        });

        step("��������� ������� ����� " + ISSUES, () -> {
            $(withText(ISSUES)).should(Condition.visible);
        });
    }

    @Test
    public void testAnnotatedSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openGitHub();
        webSteps.searchRepo(REPOSITORY);
        webSteps.clickOnLink(REPOSITORY);
        webSteps.openIssues();
        webSteps.checkIssuePhrase(ISSUES);

    }
}
