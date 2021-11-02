
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Практическое задание 1
 */


public class firstSeleniumTest extends BaseTest{

    @Test
    @Ignore
    public void testSberbank() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item')]/*[contains(text(), 'Страхование')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Все страховые программы')]")).click();
        driver.findElement(By.xpath("//div[contains(@data-product,'Страхование путешественников')]")).click();
        WebElement title = driver.findElement(By.xpath("//h1[contains(text(), 'Страхование путешественников')]"));

        Assert.assertEquals("Страхование путешественников", title.getText());
        driver.findElement(By.xpath("//span[contains(text(), 'Оформить онлайн')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Оформить на сайте')]")).click();
        //переключение на новое окно
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        //Wait<WebDriver> wait = new WebDriverWait(driver, 10, 3000);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//h3[contains(text(), 'Минимальная')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary btn-large')]")))).click();
        //driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary btn-large')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(), 'Женский')]"))));
        driver.findElement(By.xpath("//*[contains(text(), 'Женский')]")).click();

        driver.findElement(By.id("birthDate_vzr_ins_0")).sendKeys("24.10.1995");
        driver.findElement(By.id("person_birthDate")).sendKeys("24.10.1995");
        driver.findElement(By.id("documentDate")).sendKeys("24.10.2019");

        driver.findElement(By.xpath("//*[contains(text(), 'Женский')]")).click();

        //застрахованное лицо
        fillField(By.id("surname_vzr_ins_0"), "Петров");//фамилия
        fillField(By.id("name_vzr_ins_0"), "Петр");//имя
        //страхователь
        fillField(By.id("person_firstName"), "Анна");//имя
        fillField(By.id("person_middleName"), "Жанович");//отчество
        fillField(By.id("person_lastName"), "Оковый");//фамилия
        driver.findElement(By.id("person_birthDate")).sendKeys("24.10.1995");
        driver.findElement(By.id("documentDate")).sendKeys("24.10.2019");
        //паспортные данные
        fillField(By.id("passportNumber"), "415415");//номер
        fillField(By.id("documentIssue"), "Кем-то выдан");//выдан
        fillField(By.id("passportSeries"), "1234");//серия


//застраховнное лицо
        Assert.assertEquals("Петров", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("24.10.1995", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        //страхователь
        Assert.assertEquals("Анна", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Жанович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("Оковый", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("24.10.1995", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
//паспортные данные
        Assert.assertEquals("415415", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("Кем-то выдан", driver.findElement(By.id("documentIssue")).getAttribute("value"));
        Assert.assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));

        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//*[contains(@class, 'container')]/alert-form/div")).getText());
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//span[contains(text(),'Поле не заполнено')]")).getText());
    }




}