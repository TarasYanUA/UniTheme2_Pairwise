import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;

public class Storefront {
    public Storefront(){super();}

    SelenideElement cookie = $(".cm-btn-success");
    SelenideElement blockWithProducts = $(".ut2-gl__body .ut2-gl__image");
    SelenideElement htcProduct = $x("//a[contains(text(), 'HTC Wildfire')]");
    SelenideElement horizontalMenu_menuElectronic = $(".ty-menu__wrapper .ty-menu-item__electronics");
    private final SelenideElement horizontalMenu_menuHTC = $x("//li[contains(@class, 'ty-menu-item__electronics')]//a[@title='HTC']");
    public void navigateToHorizontalMenu_HTC(){
        WebDriverRunner.getWebDriver().getCurrentUrl();
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        horizontalMenu_menuElectronic.hover().click();
        horizontalMenu_menuHTC.click();
        htcProduct.scrollIntoView(true).hover();
    }
    private final SelenideElement grid_ProductListView = $(".ty-icon.ty-icon-products-multicolumns");
    public void navigateToProductListView_Grid(){
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        grid_ProductListView.click();
        $("div#ajax_loading_box[style = 'display: block;']").shouldBe(Condition.exist);
        Selenide.sleep(1500);
    }
    private final SelenideElement listWithoutOptions_ProductListView = $(".ty-icon.ty-icon-products-without-options");
    public void navigateToProductListView_ListWithoutOptions(){
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        listWithoutOptions_ProductListView.click();
        $("div#ajax_loading_box[style = 'display: block;']").shouldBe(Condition.exist);
        Selenide.sleep(1500);
    }
    private final SelenideElement compactList_ProductListView = $("div[class='ut2-sorting-wrap'] span[class='ty-icon ty-icon-short-list']");
    public void navigateToProductListView_CompactList(){
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        compactList_ProductListView.click();
        $("div#ajax_loading_box[style = 'display: block;']").shouldBe(Condition.exist);
        Selenide.sleep(1500);
    }
    private final SelenideElement languageButton = $("a[id*='wrap_language']");
    private final SelenideElement languageRTL = $(".ty-select-block__list-item a[data-ca-name='ar']");
    private final SelenideElement languageRU = $(".ty-select-block__list-item a[data-ca-name='ru']");
    public void selectLanguage_RTL(){
        languageButton.hover().click();
        languageRTL.click();
        Selenide.sleep(1500);
    }
    public void selectLanguage_RU(){
        languageButton.hover().click();
        languageRU.click();
        Selenide.sleep(1500);
    }
}