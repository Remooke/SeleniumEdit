package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy (xpath = "//nav[contains(@class, 'kitt-top-menu')]")
    WebElement mainMenu;

    @FindBy (xpath = "//div[contains(@class, 'menu__dropdown_icons')]")
   public WebElement subMenu;

    public  MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(text(), '"+menuItem+"')]")).click();
    }

    public void selectSubMenu(String menuItem){
        //Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.elementToBeClickable(subMenu.findElement(By.xpath(".//*[contains(text(), '"+menuItem+"')]")))).click();
       subMenu.findElement(By.xpath("//*[contains(text(), '"+menuItem+"')]")).click();
    }


}
