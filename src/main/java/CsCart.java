import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CsCart {
    SelenideElement button_Save = $(".cm-submit.btn-primary");
    SelenideElement addonsDropDown = $("#elm_menu_addons");
    SelenideElement addonsManagementPage = $("#elm_menu_addons_downloaded_add_ons");
    private void navigateToAddonsPage() {
        addonsDropDown.hover();
        addonsManagementPage.click();
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