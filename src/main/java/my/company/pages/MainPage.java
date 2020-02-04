package my.company.pages;
import my.company.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        driver.findElement(By.xpath("//ul[@class='lg-menu__list']//span[contains(text(), '"+itemName+"')]/..")).click();
    }
    public void selectSubmenuItem(String itemName){
        WebElement element = driver.findElement(By.xpath("//ul[@class='lg-menu__sub-list']//a[contains(text(), '"+itemName+"')]"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
