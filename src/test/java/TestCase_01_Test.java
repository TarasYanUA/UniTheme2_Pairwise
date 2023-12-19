import org.testng.annotations.Test;

public class TestCase_01_Test extends TestRunner {
    @Test
    public void checkTestCase_01(){
        CsCart csCart = new CsCart();
        ColorScheme colorScheme = new ColorScheme();
        colorScheme.ColSch_RCFIE_Dont();
        colorScheme.ColSch_FTPG_Without();
        csCart.button_Save.click();
    }
}
