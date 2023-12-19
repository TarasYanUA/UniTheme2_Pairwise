import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ColorScheme extends CsCart {
    public ColorScheme(){super();}

    static SelenideElement fieldOfActiveColorScheme = $("a[id^='sw_select_'][id$='_wrap_currency']");
    static SelenideElement activeColorScheme = $x("//div[@class='language-wrap']//a[contains(text(),'CS-Cart')]");
    public static void setActiveColorScheme(){
        fieldOfActiveColorScheme.click();
        activeColorScheme.click();
        Selenide.sleep(1500);
    }
    SelenideElement tab_General = $(".nav-tabs #general");
    SelenideElement tab_ProductLists = $(".nav-tabs #product_list");


    //УСЛОВИЯ
    public void condition_ColorSchemePage_tabGeneral(){
        if(!$x("//span[@class='title__part-end'][text()='Настройки цветосхемы']").exists()) {
            button_Save.click();
            navigateTo_ColorSchemeSettings();
        }
        if(!$("#general.cm-js.active").exists()) {
            tab_General.hover().click();
        }
    }
    public void condition_ColorSchemePage_tabProductLists(){
        if(!$x("//span[@class='title__part-end'][text()='Настройки цветосхемы']").exists()) {
            button_Save.click();
            navigateTo_ColorSchemeSettings();
        }
        if(!$("#product_list.cm-js.active").exists()) {
            tab_ProductLists.hover().click();
        }
    }


    //Вкладка "Общее"
    SelenideElement select_General_RoundCornersForInterfaceElements = $((By.id("settings.abt__ut2.general.use_rounding")));
    public void ColSch_RCFIE_Dont(){
        condition_ColorSchemePage_tabGeneral();
        select_General_RoundCornersForInterfaceElements.selectOptionByValue("do_not_use");
    }
    public void ColSch_RCFIE_Little(){
        condition_ColorSchemePage_tabGeneral();
        select_General_RoundCornersForInterfaceElements.selectOptionByValue("little");
    }
    public void ColSch_RCFIE_Fully(){
        condition_ColorSchemePage_tabGeneral();
        select_General_RoundCornersForInterfaceElements.selectOptionByValue("full");
    }

    SelenideElement checkboxDisplayHeadersInCapitalLetters = $(By.id("settings.abt__ut2.general.use_titles_uppercase"));
    public void ColSch_DHICL_On(){
        condition_ColorSchemePage_tabGeneral();
        if(!checkboxDisplayHeadersInCapitalLetters.isSelected()){
            checkboxDisplayHeadersInCapitalLetters.click();
        }
    }
    public void ColSch_DHICL_Off(){
        condition_ColorSchemePage_tabGeneral();
        if(checkboxDisplayHeadersInCapitalLetters.isSelected()){
            checkboxDisplayHeadersInCapitalLetters.click();
        }
    }

    SelenideElement checkboxDisplayTextInCapitalLetters = $(By.id("settings.abt__ut2.general.buttons.use_text_uppercase"));
    public void ColSch_DTICL_On(){
        condition_ColorSchemePage_tabGeneral();
        if(!checkboxDisplayTextInCapitalLetters.isSelected()){
            checkboxDisplayTextInCapitalLetters.click();
        }
    }
    public void ColSch_DTICL_Off(){
        condition_ColorSchemePage_tabGeneral();
        if(checkboxDisplayTextInCapitalLetters.isSelected()){
            checkboxDisplayTextInCapitalLetters.click();
        }
    }


    //Вкладка "Списки товаров"
    SelenideElement select_General_FrameTypeOfProduct = $(By.id("settings.abt__ut2.product_list.show_grid_border"));
    public void ColSch_FTPG_Not(){
        condition_ColorSchemePage_tabProductLists();
        select_General_FrameTypeOfProduct.selectOptionByValue("none");
    }
    public void ColSch_FTPG_Without(){
        condition_ColorSchemePage_tabProductLists();
        select_General_FrameTypeOfProduct.selectOptionByValue("solid_without_margins");
    }
    public void ColSch_FTPG_With(){
        condition_ColorSchemePage_tabProductLists();
        select_General_FrameTypeOfProduct.selectOptionByValue("solid_with_margins");
    }

    SelenideElement checkboxAddBackgroundForProductImages = $(By.id("settings.abt__ut2.product_list.mask_images_gallery"));
    public void ColSch_ABMFPI_On(){
        condition_ColorSchemePage_tabProductLists();
        if(!checkboxAddBackgroundForProductImages.isSelected()){
            checkboxAddBackgroundForProductImages.click();
        }
    }
    public void ColSch_ABMFPI_Off(){
        condition_ColorSchemePage_tabProductLists();
        if(checkboxAddBackgroundForProductImages.isSelected()){
            checkboxAddBackgroundForProductImages.click();
        }
    }

    SelenideElement selectUseElementsAlignment = $(By.id("settings.abt__ut2.product_list.use_elements_alignment"));
    public void ColSch_UEA_Use(){
        condition_ColorSchemePage_tabProductLists();
        selectUseElementsAlignment.selectOptionByValue("use");
    }
    public void ColSch_UEA_Dont(){
        condition_ColorSchemePage_tabProductLists();
        selectUseElementsAlignment.selectOptionByValue("do_not_use");
    }

    SelenideElement checkboxExpandGridItemOnHover = $(By.id("settings.abt__ut2.product_list.extend_grid_item_on_hover"));
    public void ColSch_EGIOH_On(){
        condition_ColorSchemePage_tabProductLists();
        if(!checkboxExpandGridItemOnHover.isSelected()){
            checkboxExpandGridItemOnHover.click();
        }
    }
    public void ColSch_EGIOH_Off(){
        condition_ColorSchemePage_tabProductLists();
        if(checkboxExpandGridItemOnHover.isSelected()){
            checkboxExpandGridItemOnHover.click();
        }
    }

    SelenideElement selectFontWeightForProductName = $(By.id("settings.abt__ut2.product_list.grid-list.product_name_font_weight"));
    public void ColSch_FWFPN_Normal(){
        condition_ColorSchemePage_tabProductLists();
        selectFontWeightForProductName.selectOptionByValue("normal");
    }
    public void ColSch_FWFPN_Bold(){
        condition_ColorSchemePage_tabProductLists();
        selectFontWeightForProductName.selectOptionByValue("bold");
    }
}