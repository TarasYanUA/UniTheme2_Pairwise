import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ColorScheme extends CsCart implements Condition_Colorscheme{
    public ColorScheme(){super();}

    SelenideElement fieldOfActiveColorScheme = $("a[id^='sw_select_'][id$='_wrap_currency']");
    SelenideElement activeColorScheme = $x("//div[@class='language-wrap']//a[contains(text(),'CS-Cart')]");
    SelenideElement tab_General = $(".nav-tabs #general");

    //Вкладка "Общее"
    SelenideElement select_General_RoundCornersForInterfaceElements = $((By.id("settings.abt__ut2.general.use_rounding")));
    public void ColSch_RCFIE_Dont(){
        if(!$x("//span[@class='title__part-end'][text()='Настройки цветосхемы']").exists()) {
            navigateTo_ColorSchemeSettings();
        }
        select_General_RoundCornersForInterfaceElements.selectOptionByValue("do_not_use");
    }
    public void ColSch_RCFIE_Little(){
        select_General_RoundCornersForInterfaceElements.selectOptionByValue("little");
    }
    public void ColSch_RCFIE_Fully(){
        select_General_RoundCornersForInterfaceElements.selectOptionByValue("full");
    }
}
