package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage(BaseSteps.getDriver()).selectMainMenu(menuItem);
    }
    @Step("выбрано подменю {0}")
    public void selectSubItem(String menuItem){
        new MainPage(BaseSteps.getDriver()).selectSubMenu(menuItem);
    }


}
