package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class EnterPageArrangePolicy {

    private final WebDriver driver;
    @FindBy(id = "surname_vzr_ins_0")
    WebElement surname_vzr_ins_0;

    @FindBy(id = "name_vzr_ins_0")
    WebElement name_vzr_ins_0;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate_vzr_ins_0;

    @FindBy(id = "person_lastName")
    WebElement person_lastName;

    @FindBy(id = "person_firstName")
    WebElement person_firstName;

    @FindBy(id = "person_middleName")
    WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    WebElement person_birthDate;

    @FindBy (xpath="//div[contains(@class, 'btn-group')]")
    WebElement chooseGender;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy (xpath="//button[contains(text(), 'Продолжить')]")
    public WebElement buttonNext;


    public  EnterPageArrangePolicy(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        if ("Фамилия Застрахованного".equals(fieldName)) {
            fillField(surname_vzr_ins_0, value);
        } else if ("Имя Застрахованного".equals(fieldName)) {
            fillField(name_vzr_ins_0, value);
        } else if ("Дата рождения Застрахованного".equals(fieldName)) {
            fillField(birthDate_vzr_ins_0, value);
            birthDate_vzr_ins_0.sendKeys(Keys.TAB);
        } else if ("Фамилия".equals(fieldName)) {
            fillField(person_lastName, value);
        } else if ("Имя".equals(fieldName)) {
            fillField(person_firstName, value);
        } else if ("Отчество".equals(fieldName)) {
            fillField(person_middleName, value);
        } else if ("Дата рождения".equals(fieldName)) {
            fillField(person_birthDate, value);
            person_birthDate.sendKeys(Keys.TAB);
        } else if ("Номер паспорта".equals(fieldName)) {
            fillField(passportNumber, value);
        } else if ("Серия паспорта".equals(fieldName)) {
            fillField(passportSeries, value);
        } else if ("Кем выдан".equals(fieldName)) {
            fillField(documentIssue, value);
        } else if ("Дата выдачи".equals(fieldName)) {
            fillField(documentDate, value);
            documentDate.sendKeys(Keys.TAB);
        }
    }

    public String getFillField(String fieldName) {
        if ("Фамилия Застрахованного".equals(fieldName)) {
            return surname_vzr_ins_0.getAttribute("value");
        } else if ("Имя Застрахованного".equals(fieldName)) {
            return name_vzr_ins_0.getAttribute("value");
        } else if ("Дата рождения Застрахованного".equals(fieldName)) {
            return birthDate_vzr_ins_0.getAttribute("value");
        } else if ("Фамилия".equals(fieldName)) {
            return person_lastName.getAttribute("value");
        } else if ("Имя".equals(fieldName)) {
            return person_firstName.getAttribute("value");
        } else if ("Отчество".equals(fieldName)) {
            return person_middleName.getAttribute("value");
        } else if ("Дата рождения".equals(fieldName)) {
            return person_birthDate.getAttribute("value");
        } else if ("Номер паспорта".equals(fieldName)) {
            return passportNumber.getAttribute("value");
        } else if ("Серия паспорта".equals(fieldName)) {
            return passportSeries.getAttribute("value");
        } else if ("Кем выдан".equals(fieldName)) {
            return documentIssue.getAttribute("value");
        } else if ("Дата выдачи".equals(fieldName)) {
            return documentDate.getAttribute("value");
        }
        else throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String errorSearch, String errorMessage) {
        String xpath = "//span[contains(text(),'"+errorSearch+"')]";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(errorMessage, actualValue);
    }
    public void checkFieldErrorMessage(String errorMessage) {
        String xpath = "//*[contains(@class, 'container')]/alert-form/div";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(errorMessage, actualValue);
    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void selectGender(String menuItem){
        chooseGender.findElement(By.xpath("//*[contains(text(), '"+menuItem+"')]")).click();
    }



}
