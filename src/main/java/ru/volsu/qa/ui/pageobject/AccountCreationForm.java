package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationForm extends BasePage {

    private final By formContainer = By.id("account-creation_form");

    public boolean isFormDisplayed() {
        this.waitForElementDisplayed(formContainer);
        return true;
    }
}
