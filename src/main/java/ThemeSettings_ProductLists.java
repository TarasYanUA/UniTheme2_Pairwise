import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ThemeSettings_ProductLists extends CsCart {
    public ThemeSettings_ProductLists(){super();}

    SelenideElement tab_Category = $(".nav-tabs #category");
    SelenideElement tab_ProductLists = $(".nav-tabs #product_list");

    public void condition_ThemeSettings_tabCategory() {
        if (!$x("//span[@class='title__part-end'][text()='Настройки темы']").exists()) {
            if (button_Save.exists()) {
                button_Save.click();
            }
            navigateTo_ThemeSettings();
        }
        if (!$("#category.cm-js.active").exists()) {
            tab_Category.hover().click();
        }
    }
    public void condition_ThemeSettings_tabProductLists() {
        if (!$x("//span[@class='title__part-end'][text()='Настройки темы']").exists()) {
            if (button_Save.exists()) {
                button_Save.click();
            }
            navigateTo_ThemeSettings();
        }
        if (!$("#product_list.cm-js.active").exists()) {
            tab_ProductLists.hover().click();
        }
    }

    SelenideElement checkbox_Category_ShowSubcategoriesOnCategoryPages = $(By.id("settings.abt__ut2.category.show_subcategories"));
    public void Theme_SSOCP_On(){
        condition_ThemeSettings_tabCategory();
        if(!checkbox_Category_ShowSubcategoriesOnCategoryPages.isSelected()){
            checkbox_Category_ShowSubcategoriesOnCategoryPages.click();
        }
    }
    public void Theme_SSOCP_Off(){
        condition_ThemeSettings_tabCategory();
        if(checkbox_Category_ShowSubcategoriesOnCategoryPages.isSelected()){
            checkbox_Category_ShowSubcategoriesOnCategoryPages.click();
        }
    }

    SelenideElement select_Category_DisplayCategoryDescription = $(By.id("settings.abt__ut2.category.description_position"));
    public void Theme_DCD_After(){
        condition_ThemeSettings_tabCategory();
        select_Category_DisplayCategoryDescription.selectOptionByValue("bottom");
    }
    public void Theme_DCD_Before(){
        condition_ThemeSettings_tabCategory();
        select_Category_DisplayCategoryDescription.selectOptionByValue("top");
    }
    public void Theme_DCD_Dont(){
        condition_ThemeSettings_tabCategory();
        select_Category_DisplayCategoryDescription.selectOptionByValue("none");
    }

    SelenideElement checkbox_DecolorizeOutOfStockProducts = $(By.id("settings.abt__ut2.product_list.decolorate_out_of_stock_products"));
    public void Theme_DOOSP_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_DecolorizeOutOfStockProducts.isSelected()){
            checkbox_DecolorizeOutOfStockProducts.click();
        }
    }
    public void Theme_DOOSP_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_DecolorizeOutOfStockProducts.isSelected()){
            checkbox_DecolorizeOutOfStockProducts.click();
        }
    }
}