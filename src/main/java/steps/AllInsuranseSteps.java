package steps;

import io.qameta.allure.Step;
import pages.InsuranceProgramPage;

public class AllInsuranseSteps {
    @Step("выбрана страховая программа")
    public void chooseInsProgram(){
        new InsuranceProgramPage(BaseSteps.getDriver()).chooseProgram.click();
    }
}
