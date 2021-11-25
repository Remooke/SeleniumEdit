import org.junit.Assert;
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
       // Assert.assertEquals("Страхование путешественников", InsuranceTravelPage.);
        InsuranceTravelPage insuranceTravelPage =new InsuranceTravelPage(driver);
        Assert.assertEquals("Страхование путешественников", insuranceTravelPage.title.getText());
        insuranceTravelPage.arrangeOnlineProgram.click();
        insuranceTravelPage.arrangeOnWebProgram.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        new EnterPageChoosePolicy(driver).chooseProgramPolicy.click();
        new EnterPageChoosePolicy(driver).sendButton1.click();

        EnterPageArrangePolicy enterPageArrangePolicy = new EnterPageArrangePolicy(driver);
        //Заполнение значений
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

        //Проверка значений
        Assert.assertEquals("Иванов",enterPageArrangePolicy.getFillField("Фамилия Застрахованного"));
        Assert.assertEquals("Иван",enterPageArrangePolicy.getFillField("Имя Застрахованного"));
        Assert.assertEquals("24.10.1995",enterPageArrangePolicy.getFillField("Дата рождения Застрахованного"));
        Assert.assertEquals("Иванов",enterPageArrangePolicy.getFillField("Фамилия"));
        Assert.assertEquals("Иван",enterPageArrangePolicy.getFillField("Имя"));
        Assert.assertEquals("Иванович",enterPageArrangePolicy.getFillField("Отчество"));
        Assert.assertEquals("24.10.1995",enterPageArrangePolicy.getFillField("Дата рождения"));
        Assert.assertEquals("4515",enterPageArrangePolicy.getFillField("Серия паспорта"));
        Assert.assertEquals("123456",enterPageArrangePolicy.getFillField("Номер паспорта"));
        Assert.assertEquals("24.10.2018",enterPageArrangePolicy.getFillField("Дата выдачи"));
        Assert.assertEquals("Кем-то",enterPageArrangePolicy.getFillField("Кем выдан"));
        //Проверка ошибок
        enterPageArrangePolicy.checkFieldErrorMessage("При заполнении данных произошла ошибка");
        enterPageArrangePolicy.checkFieldErrorMessage("Поле не заполнено.","Поле не заполнено." );

    }
}
