import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CsCart implements CheckMenuToBeActive{
    SelenideElement button_Save = $(".btn.btn-primary.cm-submit");
    public SelenideElement menu_Addons = $("a[href$='dispatch=addons.manage'].main-menu-1__link");
    public SelenideElement section_DownloadedAddons = $("#addons_downloaded_add_ons");

    private void navigateTo_DownloadedAddonsPage() {
        checkMenuToBeActive("dispatch=addons.manage", menu_Addons);
        section_DownloadedAddons.click();
    }


    //Меню "Веб-сайт -- Темы -- Макеты"
    private SelenideElement menu_Website = $("a[href$='dispatch=themes.manage'].main-menu-1__link");
    private SelenideElement section_Themes = $("#website_themes");
    private SelenideElement sectionLayouts = $(".nav__actions-bar a[href$='block_manager.manage']");
    SelenideElement layout_Lightv2 = $("a[href$='block_manager.manage&s_layout=6']");
    SelenideElement gearwheelOfActiveLayout = $(".with-menu.active .dropdown-toggle");
    SelenideElement button_makeByDefault = $(".with-menu.active a[href*='block_manager.set_default_layout']");
    public void navigateToSection_WebsiteLayouts(){
        checkMenuToBeActive("dispatch=themes.manage", menu_Website);
        section_Themes.click();
        sectionLayouts.click();
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
        navigateTo_DownloadedAddonsPage();
        themeSectionsOnManagementPage.click();
        themeSettings.click();
    }
    public void navigateTo_ColorSchemeSettings(){
        navigateTo_DownloadedAddonsPage();
        themeSectionsOnManagementPage.click();
        colorSchemeSettings.click();
        ColorScheme.setActiveColorScheme();
    }

    private SelenideElement field_Search = $(".cm-autocomplete-off.search__input");
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
    public void setPrice(String price){
        field_Price.click();
        field_Price.clear();
        field_Price.sendKeys(price);
    }
    SelenideElement action_ZeroPrice = $("#elm_zero_price_action");
    private SelenideElement field_RecommendedPrice = $("#elm_list_price");
    public void setRecommendedPrice(String recommendedPrice){
        field_RecommendedPrice.click();
        field_RecommendedPrice.clear();
        field_RecommendedPrice.sendKeys(recommendedPrice);
    }

    //Меню "Товары -- Характеристики"
    SelenideElement menu_Products = $("a[href$='dispatch=products.manage'].main-menu-1__link");
    SelenideElement section_Features = $(By.id("products_features"));
    SelenideElement featureBrand = $("a[data-ca-external-click-id=\"opener_group18\"]");
    SelenideElement setting_showInProductList = $("input[id='elm_feature_display_on_catalog_18']");

    public void navigateToSection_Features(){
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Features.click();
    }


    //Меню "Товары --Товары"
    SelenideElement section_Products = $(By.id("products_products"));
    SelenideElement button_AddNewProduct = $("a[href$='dispatch=products.add']");
    SelenideElement field_ProductName = $(By.id("product_description_product"));

    public void navigateToSection_Products(){
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Products.click();
    }

    public void clickAndType_field_ProductName(String productName) {
        field_ProductName.click();
        field_ProductName.setValue(productName);
    }
    SelenideElement button_SelectCategory = $("a[id*='opener_picker_object_picker_advanced']");
    SelenideElement selectCategory_HTC_ForProduct = $("#input_cat_236");
    SelenideElement button_Save_InsidePopUp = $(".buttons-container-picker .cm-form-dialog-closer");
    SelenideElement button_CreateProduct = $(".cm-product-save-buttons");
}