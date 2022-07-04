package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenNewAccountPage extends BasePage {
    private static final String newAccountLink =  "Open New Account";

    public void initialPage(){
        var openLink = getWebElement(By.linkText(newAccountLink));
        wait.until(ExpectedConditions.elementToBeClickable(openLink));
        openLink.click();
    }
}
