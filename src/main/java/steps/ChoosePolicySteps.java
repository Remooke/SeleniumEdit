package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.InsuranceTravelPage;

public class ChoosePolicySteps extends BaseSteps{
    @Step("И оформляется онлайн")
    public void choosePolicy(){
        new InsuranceTravelPage(driver).arrangeOnlineProgram.click();
        new InsuranceTravelPage(driver).arrangeOnWebProgram.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
    @Step("заголовок страницы - Отправить заявку равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new InsuranceTravelPage(driver).title.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

}
