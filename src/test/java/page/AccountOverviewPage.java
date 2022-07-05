package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountOverviewPage extends BasePage {

    private static final String accountsOverview = "Accounts Overview";
    private static final String tableList = "accountTable";
    private static final String textAssert = "*Balance includes deposits that may be subject to holds";
    private static final String randomAccountElement = "tbody tr:nth-child(1) td:nth-child(1) a:nth-child(1)";
    private static final String detailsTitle = "//h1[normalize-space()='Account Details']";
    private static final String goButton = "//input[@value='Go']";
    public void initialPage(){
        var accountViews = getWebElement(By.linkText(accountsOverview));
        wait.until(ExpectedConditions.elementToBeClickable(accountViews));
        accountViews.click();
    }
    public boolean checkTextAssert(){
        var accountsTable = getWebElement(By.id(tableList));
        wait.until(ExpectedConditions.visibilityOf(accountsTable));
        System.out.println(accountsTable.getText());
        return accountsTable.getText().contains(textAssert);
    }

    public void accountDetails() throws InterruptedException {
        Thread.sleep(1000);
        var getAccountDetails = getWebElement(By.cssSelector(randomAccountElement));
        wait.until(ExpectedConditions.elementToBeClickable(getAccountDetails));
        getAccountDetails.click();
    }
    public boolean checkDetailsTitle() throws InterruptedException {
        Thread.sleep(1000);
        var h1 = getWebElement(By.xpath(detailsTitle));
        wait.until(ExpectedConditions.visibilityOf(h1));
        return h1.getText().contains("Account Details");
    }
    public void accountActivityFilter(){
        var filterButton = getWebElement(By.xpath(goButton));
        filterButton.click();
    }
}
