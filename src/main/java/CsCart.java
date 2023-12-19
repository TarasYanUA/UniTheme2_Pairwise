import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CsCart {
    SelenideElement button_Save = $(".cm-submit.btn-primary");
    SelenideElement addonsDropDown = $("#elm_menu_addons");
    SelenideElement addonsManagementPage = $("#elm_menu_addons_downloaded_add_ons");
    private void navigateToAddonsPage() {
        addonsDropDown.hover();
        addonsManagementPage.click();
    }


    SelenideElement menuDesign = $("#elm_menu_design");
    SelenideElement section_Layouts = $("#elm_menu_design_layouts");
    SelenideElement layout_Lightv2 = $("a[href$='block_manager.manage&s_layout=6']");
    SelenideElement gearwheelOfActiveLayout = $(".with-menu.active .dropdown-toggle");
    SelenideElement button_makeByDefault = $(".with-menu.active a[href*='block_manager.set_default_layout']");
    public void navigateToSection_DesignLayouts(){
        menuDesign.hover();
        section_Layouts.click();
        layout_Lightv2.click();
        gearwheelOfActiveLayout.hover().click();
        if(!$$(".with-menu.active a[href*='block_manager.set_default_layout']").isEmpty()){
            button_makeByDefault.click();
            Selenide.sleep(1500);
        }
    }



    SelenideElement storefrontMainPage = $(".cs-icon.icon-shopping-cart");
    public Storefront navigateToStorefront(){
        storefrontMainPage.click();
        return new Storefront();
    }

    SelenideElement themeSectionsOnManagementPage = $x("//tr[@id='addon_abt__unitheme2']//button[@class='btn dropdown-toggle']");
    SelenideElement colorSchemeSettings = $("div[class='btn-group dropleft open'] a[href$='abt__ut2.less_settings']");
    public void navigateTo_ColorSchemeSettings(){
        navigateToAddonsPage();
        themeSectionsOnManagementPage.click();
        colorSchemeSettings.click();
        ColorScheme.setActiveColorScheme();
    }
}