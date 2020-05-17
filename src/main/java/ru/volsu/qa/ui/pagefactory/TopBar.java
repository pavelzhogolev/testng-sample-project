package ru.volsu.qa.ui.pagefactory;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class TopBar {

    @FindBy( css = ".login" )
    private WebElement signInButton;

    public void signIn() {
        log.info("Click 'Sign in' button.");
        this.signInButton.click();
    }
}
