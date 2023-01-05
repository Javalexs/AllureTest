import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("��������� ������� ��������")
    public void openGitHub(){
        open("https://github.com/");
    }

    @Step("���� ����������� {repository}")
    public void searchRepo(String repository){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("������� �� ������ ����������� {repository}")
    public void clickOnLink(String repository){
        $(linkText(repository)).click();
    }

    @Step("��������� ��� Issues")
    public void openIssues(){
        $("#issues-tab").click();
    }

    @Step("��������� ������� ����� {ISSUES}")
    public void checkIssuePhrase(String issues){
        $(withText(issues)).should(Condition.visible);
    }
}
