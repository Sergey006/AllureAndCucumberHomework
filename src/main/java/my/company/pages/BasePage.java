package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        this.driver = BaseSteps.getDriver();
    }

    public void fillField(WebElement field, String value){
        //new Actions(driver).moveToElement(field).perform();
        field.clear();
        field.sendKeys(value);
        field.sendKeys(Keys.ENTER);

        /*new WebDriverWait(driver,15).until(ExpectedConditions.textToBePresentInElement(field,value));*/
    }
}
