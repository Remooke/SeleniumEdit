/*import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class MyTestForAllureReportTest extends BaseSteps {

    @Test
    @Title("Страхование")
    public void textInsurance(){
        MainSteps mainSteps = new MainSteps();
        AllInsuranseSteps allInsuranseSteps = new AllInsuranseSteps();
        ChoosePolicySteps choosePolicySteps = new ChoosePolicySteps();
        EnterStep1 enterPage1 = new EnterStep1();
        EnterStep2 enterPage2 = new EnterStep2();

        HashMap<String,String> testData = new HashMap<String, String>();
        testData.put("Фамилия Застрахованного", "Иванов");
        testData.put("Имя Застрахованного", "Иван");
        testData.put("Дата рождения Застрахованного", "24.10.1995");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иван");
        testData.put("Дата рождения", "24.10.1995");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "123456");
        testData.put("Дата выдачи", "24.10.2020");
        testData.put("Кем выдан", "кем-то");


        mainSteps.selectMenuItem("Страхование");
        mainSteps.selectSubItem("Все страховые программы");
        allInsuranseSteps.chooseInsProgram();
        choosePolicySteps.checkPageTitle("Страхование путешественников");
        choosePolicySteps.choosePolicy();
        enterPage1.enterPage1();
        enterPage2.enterPage2(testData);
        enterPage2.chooseGender("Женский");
        enterPage2.checkFillFields(testData);
        enterPage2.nextButton();
        enterPage2.getError1("При заполнении данных произошла ошибка");
        enterPage2.getError2("Поле не заполнено.","Поле не заполнено.");

    }


}
*/