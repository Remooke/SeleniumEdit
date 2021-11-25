package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterPageChoosePolicy {
    @FindBy(xpath="//h3[contains(text(), 'Минимальная')]")
    public WebElement chooseProgramPolicy;

    @FindBy(xpath="//button[contains(@class, 'btn btn-primary btn-large')]")
    public WebElement sendButton1;

    public  EnterPageChoosePolicy(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, (10));
        wait.until(ExpectedConditions.visibilityOf(chooseProgramPolicy));
        wait.until(ExpectedConditions.elementToBeClickable(sendButton1));
    }
}
