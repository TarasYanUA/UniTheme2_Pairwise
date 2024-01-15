import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class Storefront {
    public Storefront(){super();}

    SelenideElement cookie = $(".cm-btn-success");
    SelenideElement blockWithProducts = $("div.ty-mainbox-container.clearfix .ut2-gl__image");
    SelenideElement horizontalMenu_menuElectronic = $(".ty-menu__wrapper .ty-menu-item__electronics");
    private final SelenideElement horizontalMenu_menuPhones = $x("//li[contains(@class, 'ty-menu-item__electronics')]//div[@data-elem-index='3']//span");
    public void navigateToHorizontalMenu_Phones(){
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        horizontalMenu_menuElectronic.hover().click();
    }
    private final SelenideElement grid_ProductListView = $(".ty-icon.ty-icon-products-multicolumns");
    public void navigateToProductListView_Grid(){
        grid_ProductListView.click();
        $("div#ajax_loading_box[style = 'display: block;']").shouldBe(Condition.exist);
        Selenide.sleep(1500);
    }
    private final SelenideElement listWithoutOptions_ProductListView = $(".ty-icon.ty-icon-products-without-options");
    public void navigateToProductListView_ListWithoutOptions(){
        listWithoutOptions_ProductListView.click();
        $("div#ajax_loading_box[style = 'display: block;']").shouldBe(Condition.exist);
        Selenide.sleep(1500);
    }
    private final SelenideElement compactList_ProductListView = $("div[class='ut2-sorting-wrap'] span[class='ty-icon ty-icon-short-list']");
    public void navigateToProductListView_CompactList(){
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