import org.junit.Test;
import pages.*;


public class MyRefactoringTest extends BaseTest{
    @Test
    public void newInsuranceTest(){
        driver.get(baseUrl);
       MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Все страховые программы");
        new InsuranceProgramPage(driver).chooseProgram.click();
        new InsuranceTravelPage(driver).arrangeOnlineProgram.click();
        new InsuranceTravelPage(driver).arrangeOnWebProgram.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        new EnterPageChoosePolicy(driver).chooseProgramPolicy.click();
        new EnterPageChoosePolicy(driver).sendButton1.click();

        EnterPageArrangePolicy enterPageArrangePolicy = new EnterPageArrangePolicy(driver);
        enterPageArrangePolicy.fillField("Фамилия Застрахованного", "Иванов");
        enterPageArrangePolicy.fillField("Имя Застрахованного", "Иван");
        enterPageArrangePolicy.fillField("Дата рождения Застрахованного", "24.10.1995");
        enterPageArrangePolicy.fillField("Фамилия", "Иванов");
        enterPageArrangePolicy.fillField("Имя", "Иван");
        enterPageArrangePolicy.fillField("Отчество", "Иванович");
        enterPageArrangePolicy.fillField("Дата рождения", "24.10.1995");
        enterPageArrangePolicy.selectGender("Женский");
        enterPageArrangePolicy.fillField("Серия паспорта", "4515");
        enterPageArrangePolicy.fillField("Номер паспорта", "123456");
        enterPageArrangePolicy.fillField("Дата выдачи", "24.10.2018");
        enterPageArrangePolicy.fillField("Кем выдан", "Кем-то");
        enterPageArrangePolicy.buttonNext.click();

    }
}
