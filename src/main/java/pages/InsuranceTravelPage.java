package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsuranceTravelPage {
    @FindBy(xpath="//span[contains(text(), 'Оформить онлайн')]")
    public WebElement arrangeOnlineProgram;
    @FindBy(xpath="//*[contains(text(), 'Оформить на сайте')]")
    public WebElement arrangeOnWebProgram;
    @FindBy (xpath="//h1[contains(text(), 'Страхование путешественников')]")
    public WebElement title;

    public  InsuranceTravelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(arrangeOnlineProgram));
        wait.until(ExpectedConditions.visibilityOf(arrangeOnWebProgram));
    }
}
