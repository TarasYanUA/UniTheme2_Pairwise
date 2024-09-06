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

    SelenideElement checkbox_ShowSubcategoriesOnCategoryPages = $(By.id("settings.abt__ut2.category.show_subcategories"));
    public void ThemeProductLists_SSOCP_Off(){
        condition_ThemeSettings_tabCategory();
        if(checkbox_ShowSubcategoriesOnCategoryPages.isSelected()){
            checkbox_ShowSubcategoriesOnCategoryPages.click();
        }
    }

    SelenideElement select_DisplayCategoryDescription = $(By.id("settings.abt__ut2.category.description_position"));
    public void ThemeProductLists_DCD_Dont(){
        condition_ThemeSettings_tabCategory();
        select_DisplayCategoryDescription.selectOptionByValue("none");
    }

    SelenideElement checkbox_DecolorizeOutOfStockProducts = $(By.id("settings.abt__ut2.product_list.decolorate_out_of_stock_products"));
    public void ThemeProductLists_DOOSP_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_DecolorizeOutOfStockProducts.isSelected()){
            checkbox_DecolorizeOutOfStockProducts.click();
        }
    }
    public void ThemeProductLists_DOOSP_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_DecolorizeOutOfStockProducts.isSelected()){
            checkbox_DecolorizeOutOfStockProducts.click();
        }
    }

    SelenideElement select_PriceDisplayFormat = $(By.id("settings.abt__ut2.product_list.price_display_format"));
    public void ThemeProductLists_PDF_1(){
        condition_ThemeSettings_tabProductLists();
        select_PriceDisplayFormat.selectOptionByValue("col");
    }
    public void ThemeProductLists_PDF_2(){
        condition_ThemeSettings_tabProductLists();
        select_PriceDisplayFormat.selectOptionByValue("row");
    }
    public void ThemeProductLists_PDF_3(){
        condition_ThemeSettings_tabProductLists();
        select_PriceDisplayFormat.selectOptionByValue("mix");
    }
    public void ThemeProductLists_PDF_4(){
        condition_ThemeSettings_tabProductLists();
        select_PriceDisplayFormat.selectOptionByValue("row-mix");
    }

    SelenideElement checkbox_ShowPriceAtTheTop = $(By.id("settings.abt__ut2.product_list.price_position_top"));
    public void ThemeProductLists_SPATT_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_ShowPriceAtTheTop.isSelected()){
            checkbox_ShowPriceAtTheTop.click();
        }
    }
    public void ThemeProductLists_SPATT_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_ShowPriceAtTheTop.isSelected()){
            checkbox_ShowPriceAtTheTop.click();
        }
    }

    SelenideElement checkbox_DisplayEmptyStarsOfProductRating = $(By.id("settings.abt__ut2.product_list.show_rating"));
    public void ThemeProductLists_DESOPR_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_DisplayEmptyStarsOfProductRating.isSelected()){
            checkbox_DisplayEmptyStarsOfProductRating.click();
        }
    }
    public void ThemeProductLists_DESOPR_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_DisplayEmptyStarsOfProductRating.isSelected()){
            checkbox_DisplayEmptyStarsOfProductRating.click();
        }
    }

    SelenideElement checkbox_DisplayCommonValueOfProductRating = $(By.id("settings.abt__ut2.product_list.show_rating_num"));
    public void ThemeProductLists_DCVOPR_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_DisplayCommonValueOfProductRating.isSelected()){
            checkbox_DisplayCommonValueOfProductRating.click();
        }
    }
    public void ThemeProductLists_DCVOPR_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_DisplayCommonValueOfProductRating.isSelected()){
            checkbox_DisplayCommonValueOfProductRating.click();
        }
    }

    SelenideElement select_NumberOfLinesInTheProductName = $(By.id("settings.abt__ut2.product_list.products_multicolumns.lines_number_in_name_product.desktop"));
    public void ThemeProductLists_NOLITPN_1(){
        condition_ThemeSettings_tabProductLists();
        select_NumberOfLinesInTheProductName.selectOptionByValue("1");
    }
    public void ThemeProductLists_NOLITPN_2(){
        condition_ThemeSettings_tabProductLists();
        select_NumberOfLinesInTheProductName.selectOptionByValue("2");
    }
    public void ThemeProductLists_NOLITPN_3(){
        condition_ThemeSettings_tabProductLists();
        select_NumberOfLinesInTheProductName.selectOptionByValue("3");
    }
    public void ThemeProductLists_NOLITPN_4(){
        condition_ThemeSettings_tabProductLists();
        select_NumberOfLinesInTheProductName.selectOptionByValue("4");
    }

    SelenideElement checkbox_ShowProductCode = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_sku.desktop"));
    public void ThemeProductLists_SPC_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_ShowProductCode.isSelected()){
            checkbox_ShowProductCode.click();
        }
    }
    public void ThemeProductLists_SPC_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_ShowProductCode.isSelected()){
            checkbox_ShowProductCode.click();
        }
    }

    SelenideElement checkbox_DisplayAvailabilityStatus = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_amount.desktop"));
    public void ThemeProductLists_DAS_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_DisplayAvailabilityStatus.isSelected()){
            checkbox_DisplayAvailabilityStatus.click();
        }
    }
    public void ThemeProductLists_DAS_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_DisplayAvailabilityStatus.isSelected()){
            checkbox_DisplayAvailabilityStatus.click();
        }
    }

    SelenideElement checkbox_ShowQuantityChanger = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_qty.desktop"));
    public void ThemeProductLists_SQC_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_ShowQuantityChanger.isSelected()){
            checkbox_ShowQuantityChanger.click();
        }
    }
    public void ThemeProductLists_SQC_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_ShowQuantityChanger.isSelected()){
            checkbox_ShowQuantityChanger.click();
        }
    }

    SelenideElement select_ShowAddToCartButton = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_button_add_to_cart.desktop"));
    public void ThemeProductLists_SATCB_Dont(){
        condition_ThemeSettings_tabProductLists();
        select_ShowAddToCartButton.selectOptionByValue("none");
    }
    public void ThemeProductLists_SATCB_Simplified(){
        condition_ThemeSettings_tabProductLists();
        select_ShowAddToCartButton.selectOptionByValue("icon");
    }
    public void ThemeProductLists_SATCB_Icon(){
        condition_ThemeSettings_tabProductLists();
        select_ShowAddToCartButton.selectOptionByValue("icon_button");
    }
    public void ThemeProductLists_SATCB_Text(){
        condition_ThemeSettings_tabProductLists();
        select_ShowAddToCartButton.selectOptionByValue("text");
    }
    public void ThemeProductLists_SATCB_Both(){
        condition_ThemeSettings_tabProductLists();
        select_ShowAddToCartButton.selectOptionByValue("icon_and_text");
    }

    SelenideElement select_AdditionalProductInformation = $(By.id("settings.abt__ut2.product_list.products_multicolumns.grid_item_bottom_content.desktop"));
    public void ThemeProductLists_API_Dont(){
        condition_ThemeSettings_tabProductLists();
        select_AdditionalProductInformation.selectOptionByValue("none");
    }
    public void ThemeProductLists_API_Desc(){
        condition_ThemeSettings_tabProductLists();
        select_AdditionalProductInformation.selectOptionByValue("description");
    }
    public void ThemeProductLists_API_Features(){
        condition_ThemeSettings_tabProductLists();
        select_AdditionalProductInformation.selectOptionByValue("features");
    }
    public void ThemeProductLists_API_Variations(){
        condition_ThemeSettings_tabProductLists();
        select_AdditionalProductInformation.selectOptionByValue("variations");
    }
    public void ThemeProductLists_API_DescAndVar(){
        condition_ThemeSettings_tabProductLists();
        select_AdditionalProductInformation.selectOptionByValue("features_and_description");
    }
    public void ThemeProductLists_API_FeatAndVar(){
        condition_ThemeSettings_tabProductLists();
        select_AdditionalProductInformation.selectOptionByValue("features_and_variations");
    }

    SelenideElement checkbox_ShowAdditionalInformationOnHover = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_content_on_hover.desktop"));
    public void ThemeProductLists_SAIOH_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_ShowAdditionalInformationOnHover.isSelected()){
            checkbox_ShowAdditionalInformationOnHover.click();
        }
    }
    public void ThemeProductLists_SAIOH_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_ShowAdditionalInformationOnHover.isSelected()){
            checkbox_ShowAdditionalInformationOnHover.click();
        }
    }

    SelenideElement checkbox_ShowBrandLogo = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_content_on_hover.desktop"));
    public void ThemeProductLists_SBL_On(){
        condition_ThemeSettings_tabProductLists();
        if(!checkbox_ShowBrandLogo.isSelected()){
            checkbox_ShowBrandLogo.click();
        }
    }
    public void ThemeProductLists_SBL_Off(){
        condition_ThemeSettings_tabProductLists();
        if(checkbox_ShowBrandLogo.isSelected()){
            checkbox_ShowBrandLogo.click();
        }
    }

    SelenideElement select_ShowYouSave = $(By.id("settings.abt__ut2.product_list.show_you_save.desktop"));
    public void ThemeProductLists_SYS_Dont(){
        condition_ThemeSettings_tabProductLists();
        select_ShowYouSave.selectOptionByValue("none");
    }
    public void ThemeProductLists_SYS_Full(){
        condition_ThemeSettings_tabProductLists();
        select_ShowYouSave.selectOptionByValue("full");
    }
    public void ThemeProductLists_SYS_Short(){
        condition_ThemeSettings_tabProductLists();
        select_ShowYouSave.selectOptionByValue("short");
    }

    SelenideElement select_ShowStandardImageGallery = $(By.id("settings.abt__ut2.product_list.products_multicolumns.show_gallery.desktop"));
    public void ThemeProductLists_SSIG_Dont(){
        condition_ThemeSettings_tabProductLists();
        select_ShowStandardImageGallery.selectOptionByValue("N");
    }
    public void ThemeProductLists_SSIG_Dots(){
        condition_ThemeSettings_tabProductLists();
        select_ShowStandardImageGallery.selectOptionByValue("points");
    }
    public void ThemeProductLists_SSIG_Arrows(){
        condition_ThemeSettings_tabProductLists();
        select_ShowStandardImageGallery.selectOptionByValue("arrows");
    }

    SelenideElement select_SwitchProductImageWhenHoveringMousePointer = $(By.id("settings.abt__ut2.product_list.products_multicolumns.enable_hover_gallery.desktop"));
    public void ThemeProductLists_SPIWHMP_Dont(){
        condition_ThemeSettings_tabProductLists();
        select_SwitchProductImageWhenHoveringMousePointer.selectOptionByValue("N");
    }
    public void ThemeProductLists_SPIWHMP_Dots(){
        condition_ThemeSettings_tabProductLists();
        select_SwitchProductImageWhenHoveringMousePointer.selectOptionByValue("points");
    }
    public void ThemeProductLists_SPIWHMP_Stripes(){
        condition_ThemeSettings_tabProductLists();
        select_SwitchProductImageWhenHoveringMousePointer.selectOptionByValue("lines");
    }
}