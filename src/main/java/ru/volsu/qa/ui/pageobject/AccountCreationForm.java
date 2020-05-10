package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationForm extends BasePage {

    private By formContainer = By.id("account-creation_form");

    public AccountCreationForm(WebDriver webDriver) {
        super( webDriver );
    }

    public boolean isFormDisplayed() {
        this.waitForElementDisplayed(formContainer);
        return true;
    }
}
