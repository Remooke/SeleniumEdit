package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage(driver).selectMainMenu(menuItem);
    }
    @Step("выбрано меню {0}")
    public void selectSubItem(String menuItem){
        new MainPage(driver).selectSubMenu(menuItem);
    }
}
