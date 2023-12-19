import org.testng.annotations.Test;

public class TestCase_01_Test extends TestRunner {
    @Test
    public void checkTestCase_01(){
        CsCart csCart = new CsCart();
        ColorScheme colorScheme = new ColorScheme();
        colorScheme.ColSch_RCFIE_Little();
        colorScheme.ColSch_DHICL_Off();
        colorScheme.ColSch_DTICL_Off();
        colorScheme.ColSch_FTPG_Without();
        colorScheme.ColSch_ABMFPI_Off();
        colorScheme.ColSch_UEA_Use();
        colorScheme.ColSch_EGIOH_On();
        colorScheme.ColSch_FWFPN_Bold();
        csCart.button_Save.click();
    }
}