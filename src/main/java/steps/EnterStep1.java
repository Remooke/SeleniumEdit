package steps;

import io.qameta.allure.Step;
import pages.EnterPageChoosePolicy;

public class EnterStep1 extends BaseSteps{
    @Step("И выбирает минимальную программу")
    public void enterPage1(){
        new EnterPageChoosePolicy(driver).chooseProgramPolicy.click();
        new EnterPageChoosePolicy(driver).sendButton1.click();
    }
}
