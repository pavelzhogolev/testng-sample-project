package ru.volsu.qa.ui.pagefactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar {

    private static final Logger log = LogManager.getLogger(TopBar.class);

    @FindBy( css = ".login" )
    private WebElement signInButton;

    public void signIn() {
        log.info("Click 'Sign in' button.");
        this.signInButton.click();
    }
}
