import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openGitHub(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepo(String repository){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repository}")
    public void clickOnLink(String repository){
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssues(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие фразы {ISSUES}")
    public void checkIssuePhrase(String issues){
        $(withText(issues)).should(Condition.visible);
    }
}
