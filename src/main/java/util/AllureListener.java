package util;

import io.qameta.allure.Attachment;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.BaseSteps;

public class AllureListener extends io.qameta.allure.junit4.AllureJunit4{

    @Override
    public void testFailure(Failure failure){
       takeScreenShot();
       super.testFailure(failure);
    }



    @Attachment(type = "image/png", value = "Скриншот ошибки")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
