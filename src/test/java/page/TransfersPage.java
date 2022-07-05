package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransfersPage extends BasePage {
    private static final String transferFundsLocator = "Transfer Funds";
    private static final String sectionTitle = "//h1[normalize-space()='Transfer Funds']";
    private static final String amountInput = "amount";
    private static final String selectDropdown = "toAccountId";
    private static final String transferButton = "//input[@value='Transfer']";
    private static final String finalTextCheck = "//div[@id='rightPanel']";

    public void initialPage(){
        var transferLink = getWebElement(By.linkText(transferFundsLocator));
        transferLink.click();

    }
    public boolean checkSectionTitle(){
        var h1 = getWebElement(By.xpath(sectionTitle));
        wait.until(ExpectedConditions.visibilityOf(h1));
        return h1.getText().contains(transferFundsLocator);
    }
    public void transferMoney() throws InterruptedException {
        var transferLink = getWebElement(By.linkText(transferFundsLocator));
        transferLink.click();
        var amountToTransfer = getWebElement(By.id(amountInput));
        amountToTransfer.clear();
        amountToTransfer.sendKeys("");
        Thread.sleep(1000);
        amountToTransfer.sendKeys("125");
        var toAccount = getWebElement(By.id(selectDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(toAccount));
        //wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(toAccount, By.id(selectDropdown)));
        toAccount.click();
        toAccount.sendKeys(Keys.ARROW_DOWN);
        toAccount.sendKeys(Keys.ENTER);

        var submitButton = getWebElement(By.xpath(transferButton));
        submitButton.click();

    }
    public boolean checkMoneyTransfer() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(getWebElement(By.xpath("//h1[normalize-space()='Transfer Complete!']"))));
        var titleTransactionCompleted = getWebElement(By.xpath(finalTextCheck));
        System.out.println(titleTransactionCompleted.getText());
        return titleTransactionCompleted.getText().contains("Transfer Complete!");
    }
}
