package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    AllInsuranseSteps allInsuranseSteps = new AllInsuranseSteps();
    ChoosePolicySteps choosePolicySteps = new ChoosePolicySteps();
    EnterStep1 enterPage1 = new EnterStep1();
    EnterStep2 enterPage2 = new EnterStep2();


    @When("выбран пункт меню\"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.selectMenuItem(menuItem);
    }

    @When("выбран вид страхование - \"(.*)\"$")
    public void stepSelectSubMenu(String menuItem){
        mainSteps.selectSubItem(menuItem);
    }

    @When("выполнено нажатие на все страховые программы")
    public void setAllInsuranseSteps(){
        allInsuranseSteps.chooseInsProgram();
    }

    @When("выполнено нажатие на страховую программу")
    public void setChoosePolicySteps(){
        choosePolicySteps.choosePolicy();
    }

    @When("проверяет заголовок страницы на соответствие *Страхование Путешественников*")
    public void checkChoosePolicySteps(){
        choosePolicySteps.checkPageTitle("Страхование путешественников");
    }

    @When("выбирает программу минимум")
    public void setEnterPage1(){
        enterPage1.enterPage1();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> enterPage2.stepFillField(field, value));
    }
    @Then("^заполненые поля равны:$")
    public void checkFillFields(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> enterPage2.checkFillField(field, value));
    }

    @When("нажимает далее")
    public void nextButton(){
        enterPage2.nextButton();
    }
    @Then("^есть сообщение об ошибке 1: \"(.*)\"$")
    public void getError1(String errorMessage){
        enterPage2.getError1(errorMessage);
    }
    @Then("^есть сообщение об ошибке 2: \"(.*)\"$")
    public void getError2(String errorMessage){
        enterPage2.getError2("Поле не заполнено.", errorMessage);
    }

}
