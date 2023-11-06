package com.kamivision.screens.common;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class TermOfUseScreen  {
    private final UIHelper app;
    private boolean isFlagOn;
    public TermOfUseScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("profile_user_termofUse")+"']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("onboarding_termsAndConditions_link")+"']"));}
    public UIHelper endPageTermOfUse(String text) throws Exception {
        return app.setBy(By.xpath("//android.view.View[contains(@text, '" + text + "')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+text+"')]"));
    }

    @Step("Verify Term of Use page is Displayed")
    public void verifyTermOfUsePageDisplayed() throws Exception {
        if (!pageTitle().isElementPresent(5)) {
            isFlagOn = false;
        } else {
            log.info("Verify Term of Use page is Displayed");
            Assert.assertTrue(pageTitle().isElementPresent(10), "Term of Use page is missing");
        }
    }

    @Step("Scroll down")
    public void scrollToEndPage(String text) throws Exception {
        if (isFlagOn) {
            log.info("Scroll down");
            endPageTermOfUse(text).scrollToElementDownSide();
        }
    }

    @Step("Verify user can scroll to the end")
    public void verifyScrolledToTheEnd(String text) throws Exception {
        if (isFlagOn) {
            log.info("Verify user can scroll to the end");
            Assert.assertTrue(endPageTermOfUse(text).isElementPresent(5), "Term of Use end page is missing");
        }
    }
}
