import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
    SelenideElement themeSectionsOnManagementPage = $x("//tr[@id='addon_abt__unitheme2']//button[@class='btn dropdown-toggle']");
    SelenideElement themeSettings = $("div[class='btn-group dropleft open'] a[href$='abt__ut2.settings']");
    SelenideElement colorSchemeSettings = $("div[class='btn-group dropleft open'] a[href$='abt__ut2.less_settings']");
    public void navigateTo_ThemeSettings(){
        navigateToAddonsPage();
        themeSectionsOnManagementPage.click();
        themeSettings.click();
    }
    public void navigateTo_ColorSchemeSettings(){
        navigateToAddonsPage();
        themeSectionsOnManagementPage.click();
        colorSchemeSettings.click();
        ColorScheme.setActiveColorScheme();
    }

    private SelenideElement field_Search = $(".search__group .search__input.search__input--collapse");
    public void searchProductByCode(String productCode){
        field_Search.click();
        field_Search.sendKeys(productCode);
        field_Search.pressEnter();
    }
    private SelenideElement field_InStock = $("#elm_in_stock");
    public void setOutOfStock(){
        field_InStock.click();
        field_InStock.clear();
        field_InStock.sendKeys("0");
    }
    SelenideElement action_outOfStock = $("#elm_out_of_stock_actions");
    private SelenideElement field_Price = $("#elm_price_price");
    public void setZeroPrice(){
        field_Price.click();
        field_Price.clear();
        field_Price.sendKeys("0");
    }
    SelenideElement action_ZeroPrice = $("#elm_zero_price_action");
    private SelenideElement field_RecommendedPrice = $("#elm_list_price");
    public void setRecommendedPrice(String recommendedPrice){
        field_RecommendedPrice.click();
        field_RecommendedPrice.clear();
        field_RecommendedPrice.sendKeys(recommendedPrice);
    }

    SelenideElement menu_Products = $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']");
    SelenideElement section_Features = $("a[href$='product_features.manage']");
    SelenideElement featureBrand = $("a[href$='feature_id=18'][data-ca-external-click-id]");
    SelenideElement setting_showInProductList = $("input[id='elm_feature_display_on_catalog_18']");

}