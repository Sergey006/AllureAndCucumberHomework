package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgagePage extends BasePage {

    public MortgagePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath="//input[@id='estateCost']")
    WebElement estateCost;
    @FindBy(xpath="//input[@id='initialFee']")
    WebElement initialFee;
    @FindBy(xpath="//input[@id='creditTerm']")
    WebElement creditTerm;
    @FindBy (xpath = "//div[contains(text(), 'зарплатная карта')]/..//input[@class='dcCalc_switch__input']")
    WebElement haveCardSwitch;

    @FindBy (xpath = "//span[@data-test-id='amountOfCredit']")
    WebElement amountOfCredit;
    @FindBy (xpath = "//span[@data-test-id='monthlyPayment']")
    WebElement monthlyPayment;
    @FindBy (xpath = "//span[@data-test-id='requiredIncome']")
    WebElement requiredIncome;
    @FindBy (xpath = "//span[@data-test-id='rate']")
    WebElement rate;
    @FindBy (xpath = "//iframe[@title='Основной контент']")
    WebElement panel;



    public void moveToInputs(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")));
        driver.switchTo().frame(panel);
    }

    public void switchHaveCard(){
        Actions actions = new Actions(driver);
        actions.moveToElement(haveCardSwitch).click().perform();
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Стоимость недвижимости":
                fillField(estateCost, value);
                break;
            case  "Первоначальный взнос":
                fillField(initialFee, value);
                break;
            case  "Срок кредита":
                fillField(creditTerm, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    public String getFieldValue(String fieldName){
        switch (fieldName){
            case  "Сумма кредита":
                return amountOfCredit.getAttribute("value");
            case  "Ежемесячный платёж":
                return monthlyPayment.getAttribute("value");
            case  "Необходимый доход":
                return requiredIncome.getAttribute("value");
            case "Процентная ставка":
                return rate.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
}
