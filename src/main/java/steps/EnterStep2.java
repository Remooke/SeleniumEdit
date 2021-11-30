package steps;

import io.qameta.allure.Step;
import pages.EnterPageArrangePolicy;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class EnterStep2 {
    @Step("И заполняет данные")
    public void stepFillField(String field,String value){
         new EnterPageArrangePolicy(BaseSteps.getDriver()).fillField(field,value);
    }

    @Step("заполняются поля:")
    public void enterPage2(HashMap<String,String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new EnterPageArrangePolicy(BaseSteps.getDriver()).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("И выбирается пол")
    public void chooseGender(String menuItem){
        new EnterPageArrangePolicy(BaseSteps.getDriver()).selectGender(menuItem);
    }



    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }
    @Step("И нажимает далее")
    public void nextButton(){
        new EnterPageArrangePolicy(BaseSteps.getDriver()).buttonNext.click();
    }
    @Step("И появляется ошибка {0}")
    public void getError1(String errorMessage){
        new EnterPageArrangePolicy(BaseSteps.getDriver()).checkFieldErrorMessage(errorMessage);
    }

    @Step("И появляется ошибка {0}")
    public void getError2(String errorSearch, String errorMessage){
        new EnterPageArrangePolicy(BaseSteps.getDriver()).checkFieldErrorMessage(errorSearch,errorMessage);
    }



}
