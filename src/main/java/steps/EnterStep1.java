package steps;

import io.qameta.allure.Step;
import pages.EnterPageChoosePolicy;

public class EnterStep1 {
    @Step("И выбирает минимальную программу")
    public void enterPage1(){
        for(String winHandle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(winHandle);
        }
        new EnterPageChoosePolicy(BaseSteps.getDriver()).chooseProgramPolicy.click();
        new EnterPageChoosePolicy(BaseSteps.getDriver()).sendButton1.click();
    }
}
