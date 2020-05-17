package ru.volsu.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.models.Account;
import ru.volsu.qa.ui.pagefactory.TopBar;
import ru.volsu.qa.ui.pageobject.SignUpForm;

@Slf4j
public class RegistrationNegativeTests extends BaseTest {

    @Autowired
    SignUpForm signUpForm;

    @DataProvider(name = "accountNegativeDataProvider")
    public Object[][] accountNegativeDataProvider() {
        Account accountWithAlreadyUsedEmail = new Account();
        accountWithAlreadyUsedEmail.setEmail("john.doe@yahoo.com");

        Account accountWithInvalidEmail = new Account();
        accountWithInvalidEmail.setEmail("john.doeyahoo.com");

        return new Object[][] {
                {accountWithAlreadyUsedEmail, "An df account using this email address has already been registered. Please enter a valid password or request a new one."},
                {accountWithInvalidEmail, "Invalid email address."}
        };
    }

    @Test(dataProvider = "accountNegativeDataProvider")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration with incorrect email value.")
    public void registerAccountNegativeTest(Account account, String errorMessage ) {
        TopBar topBar = PageFactory.initElements(webdriver, TopBar.class);
        topBar.signIn();

        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();

        String errorOnPage = signUpForm.getErrorMessage();

        log.info("Verify that correct error message is shown.");
        Assert.assertEquals(errorOnPage, errorMessage);
    }


}
