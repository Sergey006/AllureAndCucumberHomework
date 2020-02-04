package my.company.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import my.company.steps.BaseSteps;
import my.company.steps.MainPageSteps;
import my.company.steps.MortgagePageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

public class SberbankTest  extends BaseSteps {

    MainPageSteps mainPageSteps;
    MortgagePageSteps mortgagePageSteps;

    /*@Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        mainPageSteps = new MainPageSteps();
        mortgagePageSteps = new MortgagePageSteps();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.sberbank.ru/ru/person");
    }*/
    @Test
    public void Test() throws InterruptedException {
        HashMap<String, String> data = new LinkedHashMap<>();
        data.put("Стоимость недвижимости", "5180000");
        data.put("Первоначальный взнос", "3058000");
        data.put("Срок кредита", "30");

        mainPageSteps = new MainPageSteps();
        mortgagePageSteps = new MortgagePageSteps();

        mainPageSteps.selectMenuItem("Ипотека");
        mainPageSteps.selectSubmenuItem("Ипотека на готовое жильё");

        mortgagePageSteps.scroollPageToFields();
        mortgagePageSteps.fillFields(data);
        mortgagePageSteps.switchHaveCard();

    }

}
