package page;

import base.BasePage;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
import java.util.UUID;

import static org.openqa.selenium.By.*;


public class SignUpPage extends BasePage {

    private static final String registerLinkLocator =  "Register";
    private static final String firstNameInput = "customer.firstName";
    private static final String lastNameInput = "customer.lastName";
    private static final String addressInput = "customer.address.street";
    private static final String cityInput = "customer.address.city";
    private static final String stateInput = "customer.address.state";
    private static final String zipCodeInput = "customer.address.zipCode";
    private static final String phoneInput = "customer.phoneNumber";
    private static final String ssnInput = "customer.ssn";

    //Credentials
    private static final String usernameInput = "customer.username";
    private static final String passInput = "customer.password";
    private static final String confirmPassInput = "repeatedPassword";

    //GeneratedCredentials
    private final String usernameFaked = faker.name().username();
    private final String passwordFaked = "123";

    //Confirm register
    private static final String submitFormBttn = "input[value='Register']";

    private static final String confirmNewPageTitle = "ParaBank | Customer Created";
    private static final String successAccountCreated = "Your account was created successfully. You are now logged in.";

    /*public SignUpPage() {
        wait = new WebDriverWait(BasePage.getDriver(), Duration.ofMillis(800));
    }*/

    public void initialPage(){
        openApp();
        var registerBtn = getWebElement(new ByLinkText(registerLinkLocator));
        registerBtn.click();
    }

    public void fulfillForm(){
        var firstName = getWebElement(By.id(firstNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.sendKeys(faker.name().firstName());
        var lastName = getWebElement(By.id(lastNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(lastName));
        lastName.sendKeys(faker.name().lastName());

        var address = getWebElement(By.id(addressInput));
        wait.until(ExpectedConditions.elementToBeClickable(address));
        address.sendKeys(faker.address().streetAddress());

        var city = getWebElement(By.id(cityInput));
        wait.until(ExpectedConditions.elementToBeClickable(city));
        city.sendKeys(faker.address().city());

        var state = getWebElement(By.id(stateInput));
        wait.until(ExpectedConditions.elementToBeClickable(state));
        state.sendKeys(faker.address().state());

        var zipCode = getWebElement(By.id(zipCodeInput));
        wait.until(ExpectedConditions.elementToBeClickable(zipCode));
        zipCode.sendKeys(faker.address().zipCode());

        var phone = getWebElement(By.id(phoneInput));
        wait.until(ExpectedConditions.elementToBeClickable(phone));
        phone.sendKeys(faker.phoneNumber().phoneNumber());

        var ssn = getWebElement(By.id(ssnInput));
        wait.until(ExpectedConditions.elementToBeClickable(ssn));
        ssn.sendKeys(faker.idNumber().ssnValid());

        var username = getWebElement(By.id(usernameInput));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.sendKeys(usernameFaked);

        var pass = getWebElement(By.id(passInput));
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.sendKeys(passwordFaked);

        var confirmPass = getWebElement(By.id(confirmPassInput));
        wait.until(ExpectedConditions.elementToBeClickable(confirmPass));
        confirmPass.sendKeys(passwordFaked);

    }

    public void submit() throws InterruptedException {
        Thread.sleep(1200);
        var submitBttn = getWebElement(By.cssSelector(submitFormBttn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBttn));
        submitBttn.click();
    }
    public boolean checkSuccessfulText(){
        wait.until(ExpectedConditions.titleIs(confirmNewPageTitle));
        var parentTextElement = getWebElement(By.id("rightPanel"));
        wait.until(ExpectedConditions.visibilityOf(parentTextElement));

        return parentTextElement.getText().contains(successAccountCreated);
    }
}
