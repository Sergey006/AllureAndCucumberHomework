package my.company.steps;

import io.qameta.allure.Step;
import my.company.pages.BasePage;
import my.company.pages.MainPage;
import my.company.pages.MortgagePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MortgagePageSteps extends BaseSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new MortgagePage().fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach(this::fillField);
    }

    @Step("выполняется прокрутка страницы до полей ввода")
    public void scroollPageToFields(){
        new MortgagePage().moveToInputs();
    }

    @Step("выполнено переключение наличия зарплатной карты")
    public void switchHaveCard(){
        new MortgagePage().switchHaveCard();
    }

    @Step("проверка, что поле {0} заполнено значением {1}")
    public void checkValues(String field, String value) {
        Assert.assertEquals(new MortgagePage().getFieldValue(field), value);
    }
}
