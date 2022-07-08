package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import page.AccountOverviewPage;
import page.OpenNewAccountPage;
import page.SignUpPage;
import page.TransfersPage;

public class SignUpTest {

    @Test
    @DisplayName("Registro")
    void register() throws InterruptedException {
        var page = new SignUpPage();
        page.initialPage();
        page.fulfillForm();
        page.submit();
        Assertions.assertTrue(page.checkSuccessfulText());
    }
    @Test
    @DisplayName("Abrir una cuenta nueva")
    void register2() throws InterruptedException {
        var page = new OpenNewAccountPage();
        page.initialPage();
        page.selectAccountType();
        Assertions.assertTrue(page.checkSuccessfulText());
    }

    @Test
    @DisplayName("Resumen de las cuentas")
    void register3() throws InterruptedException {
        var page = new AccountOverviewPage();
        page.initialPage();
        Assertions.assertTrue(page.checkTextAssert());
    }
    @Test
    @DisplayName("Trasnferir fondos")
    void register4() throws InterruptedException {

        var page = new TransfersPage();
        page.initialPage();
        Assertions.assertTrue(page.checkSectionTitle());
        page.transferMoney();
        Assertions.assertTrue(page.checkMoneyTransfer());
    }

    @Test
    @DisplayName("Actividad de la cuenta (cada mes)")
    void register5() throws InterruptedException {
        var page = new AccountOverviewPage();
        page.initialPage();
        Assertions.assertTrue(page.checkTextAssert());
        page.accountDetails();
        Assertions.assertTrue(page.checkDetailsTitle());

    }

}
