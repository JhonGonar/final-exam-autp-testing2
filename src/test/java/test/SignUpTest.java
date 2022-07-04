package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.OpenNewAccountPage;
import page.SignUpPage;

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
    void openNewAccount(){
        var page = new OpenNewAccountPage();
        page.initialPage();
    }
}
