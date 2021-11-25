package steps;

import io.qameta.allure.Step;
import pages.InsuranceProgramPage;

public class AllInsuranseSteps extends BaseSteps{
    @Step("выбрана страховая программа")
    public void chooseInsProgram(){
        new InsuranceProgramPage(driver).chooseProgram.click();
    }
}
