package ru.volsu.qa.ui.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class SignUpForm extends BasePage {

    private static final Logger log = LogManager.getLogger(SignUpForm.class);

    private final By formContainer = By.id("create-account_form");

    private final By emailAddressInput = By.id("email_create");

    private final By createAccountButton = By.id("SubmitCreate");

    private final By errorMessage = By.id("create_account_error");

    public void fillForm( String email ) {
        log.debug("Wait for sign up form to be shown.");
        this.waitForElementDisplayed( formContainer );

        log.info("Fill sign up form.");
        webDriver.findElement( emailAddressInput ).sendKeys( email );
    }

    public void clickCreateAccountButton() {
        log.info("Click 'Create an account' button.");
        log.debug("Click element with locator: {}", createAccountButton.toString());
        webDriver.findElement( createAccountButton ).click();
    }

    public String getErrorMessage() {
        this.waitForElementDisplayed( errorMessage );
        return webDriver.findElement( errorMessage ).getText();
    }
}
