package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.InsuranceTravelPage;

public class ChoosePolicySteps {
    @Step("И оформляется онлайн")
    public void choosePolicy(){
        new InsuranceTravelPage(BaseSteps.getDriver()).arrangeOnlineProgram.click();
        new InsuranceTravelPage(BaseSteps.getDriver()).arrangeOnWebProgram.click();

    }
    @Step("заголовок страницы - Отправить заявку равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new InsuranceTravelPage(BaseSteps.getDriver()).title.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

}
