package my.company.steps;

import io.qameta.allure.Step;
import my.company.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends BaseSteps {

    @Step("выбран пункт меню {itemName}")
    public void selectMenuItem(String itemName){
        new MainPage().selectMenuItem(itemName);
    }

    @Step("выбран подпункт меню Ипотека на готовое жильё ")
    public void selectSubmenuItem(String itemName) {
        new MainPage().selectSubmenuItem(itemName);
    }
}
