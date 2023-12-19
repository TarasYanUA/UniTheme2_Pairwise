import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestRunner {
    public static final String BASIC_URL = "https://trs.test.abt.team/4172ultru/admin.php?dispatch=settings.manage&section_id=Appearance";

    @BeforeClass
    public void openBrowser() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        Configuration.screenshots = true; //делаем скриншоты при падении
        Configuration.browserSize = "1920x1050"; //Увеличиваем размер экрана
        open(BASIC_URL);
        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    public void navigateToProductPage(){
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        //$(".cm-notification-close").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'adizero Rush Shoes')]").click();
    }
    public void shiftToRTLLanguage() {
        $("a[id*='sw_select'][id*='wrap_language']").scrollTo().click();
        $("a[data-ca-name='ar']").click();
    }
}
