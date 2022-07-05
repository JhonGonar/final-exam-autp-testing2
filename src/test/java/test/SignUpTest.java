package test;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import page.AccountOverviewPage;
import page.OpenNewAccountPage;
import page.SignUpPage;
import page.TransfersPage;

public class SignUpTest {

    @Test
    void register() throws InterruptedException {
        var page = new SignUpPage();
        page.initialPage();
        page.fulfillForm();
        page.submit();
        Assertions.assertTrue(page.checkSuccessfulText());
    }
    @Test
    void register2() throws InterruptedException {
        var page = new OpenNewAccountPage();
        page.initialPage();
        page.selectAccountType();
        Assertions.assertTrue(page.checkSuccessfulText());
    }

    @Test
    void register3() throws InterruptedException {
        var page = new AccountOverviewPage();
        page.initialPage();
        Assertions.assertTrue(page.checkTextAssert());
    }
    @Test
    void register4() throws InterruptedException {

        var page = new TransfersPage();
        page.initialPage();
        Assertions.assertTrue(page.checkSectionTitle());
        page.transferMoney();
        Assertions.assertTrue(page.checkMoneyTransfer());
    }

    @Test
    void register5() throws InterruptedException {
        var page = new AccountOverviewPage();
        page.initialPage();
        Assertions.assertTrue(page.checkTextAssert());
        page.accountDetails();
        Assertions.assertTrue(page.checkDetailsTitle());

    }

}
