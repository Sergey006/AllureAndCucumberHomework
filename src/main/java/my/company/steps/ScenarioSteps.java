package my.company.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^выбран подпункт меню \"(.+)\"$")
    public void selectMenuInsurance(String menuName){
        mainPageSteps.selectSubmenuItem(menuName);
    }
    @When("^выполнена прокрутка страницы до полей ввода$")
    public void scrollPageToFields(){
        mortgagePageSteps.scroollPageToFields();
    }
    @When("^выполнено переключение наличия зарплатной карты$")
    public void switchHaveCard(){
        mortgagePageSteps.switchHaveCard();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> mortgagePageSteps.fillField((String)field, (String)value));

    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> mortgagePageSteps.checkField((String)field, (String)value));
    }

}
