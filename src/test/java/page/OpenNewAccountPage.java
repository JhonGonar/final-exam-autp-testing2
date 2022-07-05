package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OpenNewAccountPage extends BasePage {
    private static final String newAccountLink =  "Open New Account";
    private static final String dropDownTypeAccount =  "type";
    private static final String submitButton = "//input[@value='Open New Account']";
    private static final String successOpenedAccount = "Congratulations, your account is now open.";

    public void initialPage(){
        var openLink = getWebElement(By.linkText(newAccountLink));
        wait.until(ExpectedConditions.elementToBeClickable(openLink));
        openLink.click();
    }

    public void selectAccountType(){
        var dprAccount = getWebElement(By.id(dropDownTypeAccount));
        wait.until(ExpectedConditions.elementToBeClickable(dprAccount));
        dprAccount.click();
        var option = getWebElement(By.xpath("//option[@value='1']"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
        var openBttn = getWebElement(By.xpath(submitButton));
        openBttn.click();
    }

    public boolean checkSuccessfulText() throws InterruptedException {
        Thread.sleep(1000);
        var parentTextElement = getWebElement(By.xpath("//div[@ng-if='showResult']"));
        wait.until(ExpectedConditions.visibilityOf(parentTextElement));
        System.out.println(parentTextElement.getText());
        return parentTextElement.getText().contains(successOpenedAccount);
    }
}
